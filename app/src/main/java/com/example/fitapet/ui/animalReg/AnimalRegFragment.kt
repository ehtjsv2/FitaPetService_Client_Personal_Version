package com.example.fitapet.ui.animalReg

import android.content.Intent
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils.replace
import android.util.Base64
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fitapet.MainActivity
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentAnimalRegBinding
import com.example.fitapet.wonjune.API_imgupload
import com.example.fitapet.wonjune.API_upload
import com.example.fitapet.wonjune.ImgResponse
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.ByteArrayOutputStream
import java.io.File


class AnimalRegFragment : Fragment() {
    val bundle = Bundle()
    private var _binding: FragmentAnimalRegBinding? = null
    var dogOrCat :Int = 0 // 0->dog 1->cat
    var boyOrGrl :Int = 0 // 0->boy 1->girl
    var neu :Int = 0 // 0-> 중성화x , 1->중성화  o
    var chip:Int = 0 // 0-> 외장칩 1->내장칩
    var weight:Int =0 //0 ->소 1->중 2->대
    var weight2:Int = 0 // 0-> 소/중 1-> 대
    var name: String? =null
    var breed: String? =null
    // This property is only valid between onCreateView and
    // onDestroyView.
    var retrofit = Retrofit.Builder()
        .baseUrl("http://118.45.212.21:8000")
        //"http://192.168.0.195:8000" 우리집
        //"http://223.39.249.247:8000" 핸드폰 핫스팟
        //"http://118.45.212.21:8000" 자취방 공용IP
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    var imgstr: String? = null
    private val binding get() = _binding!!
    private val animalRegViewModel:AnimalRegViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentAnimalRegBinding.inflate(inflater, container, false)

        val root: View = binding.root
        //이미지 클릭 시
        binding.animalRegImgBtn01.setOnClickListener {
            Log.d("kimdo","imgbtn01click!")
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(intent, 101)
            //binding.animalRegImgBtn01.isSelected=true
        }
        binding.animalRegImgBtn02.setOnClickListener {
            Log.d("kimdo","imgbtn02click!")
            var intent = Intent()
            intent.setType("image/*")
            intent.setAction(Intent.ACTION_GET_CONTENT)
            startActivityForResult(intent, 101)
        }
        //강아지버튼
        binding.animalRegDogBtn.setOnClickListener {
            dogOrCat=0
            binding.animalRegDogBtn.isSelected=binding.animalRegDogBtn.isSelected!=true
            binding.animalRegCatBtn.isSelected=false
            //칩
            binding.animalRegChipLayout.visibility=View.VISIBLE
            //견종묘종
            binding.animalRegDogBreedLayout.visibility=View.VISIBLE
            binding.animalRegCatBreedLayout.visibility=View.GONE
            //크기
            binding.animalRegWeightLayout.visibility=View.VISIBLE
            //binding.animalRegWeightLayout2.visibility=View.INVISIBLE
        }
        //고양이버튼
        binding.animalRegCatBtn.setOnClickListener {
            dogOrCat=1
            binding.animalRegCatBtn.isSelected=binding.animalRegCatBtn.isSelected!=true
            binding.animalRegDogBtn.isSelected=false
            //칩
            binding.animalRegChipLayout.visibility=View.GONE
            //견종묘종
            binding.animalRegDogBreedLayout.visibility=View.GONE
            binding.animalRegCatBreedLayout.visibility=View.VISIBLE
            //크기
            //binding.animalRegWeightLayout2.visibility=View.VISIBLE
            binding.animalRegWeightLayout.visibility=View.GONE
        }
        //남아버튼
        binding.animalRegBoy.setOnClickListener {
            boyOrGrl = 0
            binding.animalRegBoy.isSelected=binding.animalRegBoy.isSelected!=true
            binding.animalRegGirl.isSelected=false
        }
        //여아버튼
        binding.animalRegGirl.setOnClickListener {
            boyOrGrl = 1
            binding.animalRegGirl.isSelected=binding.animalRegGirl.isSelected!=true
            binding.animalRegBoy.isSelected=false
        }
        //중성화 y버튼
        binding.animalRegNeuteringY.setOnClickListener {
            neu = 1
            binding.animalRegNeuteringY.isSelected=binding.animalRegNeuteringY.isSelected!=true
            binding.animalRegNeuteringN.isSelected=false
        }
        //중성화 N버튼
        binding.animalRegNeuteringN.setOnClickListener {
            neu = 0
            binding.animalRegNeuteringN.isSelected=binding.animalRegNeuteringN.isSelected!=true
            binding.animalRegNeuteringY.isSelected=false
        }
        //외장칩 버튼
        binding.animalRegChipOut.setOnClickListener {
            chip = 0
            binding.animalRegChipOut.isSelected=binding.animalRegChipOut.isSelected!=true
            binding.animalRegChipIn.isSelected=false
        }
        //내장칩 버튼
        binding.animalRegChipIn.setOnClickListener {
            chip = 1
            binding.animalRegChipIn.isSelected=binding.animalRegChipIn.isSelected!=true
            binding.animalRegChipOut.isSelected=false
        }
        //무게 s버튼
        binding.animalRegSizeS.setOnClickListener {
            weight2 = 0
            binding.animalRegSizeS.isSelected=binding.animalRegSizeS.isSelected!=true
            //binding.animalRegSizeM.isSelected=false
            binding.animalRegSizeL.isSelected=false
        }
        //무게 m버튼
//        binding.animalRegSizeM.setOnClickListener {
//            weight = 1
//            binding.animalRegSizeM.isSelected=binding.animalRegSizeM.isSelected!=true
//            binding.animalRegSizeS.isSelected=false
//            binding.animalRegSizeL.isSelected=false
//        }
        //무게 L버튼
        binding.animalRegSizeL.setOnClickListener {
            weight2 = 1
            binding.animalRegSizeL.isSelected=binding.animalRegSizeL.isSelected!=true
            //binding.animalRegSizeM.isSelected=false
            binding.animalRegSizeS.isSelected=false
        }
//        //무게 고양이 s/m
//        binding.animalRegSize2M.setOnClickListener {
//            weight = 0
//            binding.animalRegSize2M.isSelected=binding.animalRegSize2M.isSelected!=true
//            binding.animalRegSize2L.isSelected=false
//        }
//        //무게 고양이 L
//        binding.animalRegSize2L.setOnClickListener {
//            weight = 1
//            binding.animalRegSize2L.isSelected=binding.animalRegSize2L.isSelected!=true
//            binding.animalRegSize2M.isSelected=false
//        }
        //year SPINNER
        val year_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Year)
        )
        binding
        val Adapter_Year = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, year_items.get(0))
        binding.animalRegBirthYear.adapter=Adapter_Year
        val month_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Month)
        )
        val Adapter_month = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, month_items.get(0))
        binding.animalRegBirthMonth.adapter=Adapter_month
        //다음 버튼
        binding.animalRegNextBtn.setOnClickListener {
            Log.d("kim","k = ${dogOrCat}, S = ${boyOrGrl}, neu=${neu}, chip =${chip}")
            Log.d("kim", "name = ${binding.animalRegName.text}, breed = ${binding.animalRegDogBreed.text}" +
                    "year = ${binding.animalRegBirthYear.selectedItem.toString()}" +
                    "month = ${binding.animalRegBirthMonth.selectedItem.toString()}")
            if((!binding.animalRegCatBtn.isSelected && !binding.animalRegDogBtn.isSelected) ||
                (!binding.animalRegBoy.isSelected && !binding.animalRegGirl.isSelected) ||
                (!binding.animalRegNeuteringY.isSelected && !binding.animalRegNeuteringN.isSelected)||
                (binding.animalRegDogBtn.isSelected &&
                        ((!binding.animalRegChipIn.isSelected && !binding.animalRegChipOut.isSelected) ||
                                (!binding.animalRegSizeS.isSelected && !binding.animalRegSizeL.isSelected ))))
                {
                    Log.d("kim","anything no selected !")
                    Toast.makeText(requireContext(), "모두 선택해주세요.", Toast.LENGTH_SHORT).show()


                }
            else if((binding.animalRegName.text.isNullOrBlank()) ||
                ((binding.animalRegCatBreed.text.isNullOrBlank())&&(binding.animalRegDogBreed.text.isNullOrBlank())))
            {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
            else{
                fragmentManager?.commit {
                    /*
                    var dogOrCat :Int = -1 // 0->dog 1->cat
    var boyOrGrl :Int = -1 // 0->boy 1->girl
    var neu :Int = -1 // 0-> 중성화x , 1->중성화  o
    var chip:Int = -1 // 0-> 외장칩 1->내장칩
    var weight:Int =-1 //0 ->소/중 1->대
    var weight2:Int = -1 // 0-> 소/중 1-> 대
    var name: String? =null
    var breed: String? =null
                     */
                    if(dogOrCat==0)
                        breed=binding.animalRegDogBreed.text.toString()
                    else
                        breed=binding.animalRegCatBreed.text.toString()
                    animalRegViewModel.dogOrCat=dogOrCat
                    animalRegViewModel.boyOrGrl=boyOrGrl
                    animalRegViewModel.neu=neu
                    animalRegViewModel.chip=chip
                    animalRegViewModel.weight2=weight2
                    animalRegViewModel.name=binding.animalRegName.text.toString()
                    animalRegViewModel.breed=breed
                    var month=binding.animalRegBirthMonth.selectedItem.toString()
                    var month_string:String
                    var month_split=month.split("월")
                    Log.d("TAG11","size = "+month_split.size)
                    if(month_split[0]=="10" ||month_split[0]=="11"||month_split[0]=="12"){
                        month_string=month_split[0]
                    }
                    else
                        month_string="0"+month_split[0]
                    Log.d("TAG11","size = "+month_string)
                    animalRegViewModel.birth=binding.animalRegBirthYear.selectedItem.toString()+"-"+month_string
                    animalRegViewModel.age=(2023-binding.animalRegBirthYear.selectedItem.toString().toInt()).toString()
                    val frag =  AnimalRegFragment02()
                    val bundle1=Bundle()
                    val result = bundle1.putInt("chip",chip)
                    Log.d("TAG11",result.toString())
                    frag.arguments=bundle1
                    loadFragment(frag)
                    setReorderingAllowed(true)
                }
            }
        }
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101){
            if(resultCode == AppCompatActivity.RESULT_OK){
                var fileUri = data!!.data
                var uploadService = retrofit.create(API_imgupload::class.java)
                var filePath = fileUri?.let { getabsolutelyPath(it) } //Uri주소를 파일의 실제 절대 경로로 변경
                Log.d("wonlog3", filePath!!)


                val file = File(filePath)
                val title = RequestBody.create("text/plain".toMediaTypeOrNull(), file.name)
                //val title = RequestBody.create("text/plain".toMediaTypeOrNull(), file.name)
                val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
                //val requestFile = RequestBody.create("video/*".toMediaTypeOrNull(), file)
                val body = MultipartBody.Part.createFormData("uploadedImg", file.name, requestFile)

                uploadService.sendImg(title, body).enqueue(object: Callback<ImgResponse> {
                    override fun onResponse(
                        call: Call<ImgResponse>,
                        response: Response<ImgResponse>
                    ) {
                        Log.d("wonlog", "여기들어옴")
                        var upimgstr = response.body()!!.uploadedImg
                        upimgstr = "http://118.45.212.21:8000/pets" + upimgstr
                        animalRegViewModel.ImgUrl=upimgstr
                        Log.d("wonlog2", "여기들어옴2")
                        //imgstr = upfile!!.uploadedImg
                        Log.d("TEST3", upimgstr)
                        //txtlist.append(upfile!!.id.toString() + ". " + upfile!!.title + "\n" + upfile!!.date + "\n")
                    }

                    override fun onFailure(call: Call<ImgResponse>, t: Throwable) {
                        Toast.makeText(activity, t.message, Toast.LENGTH_SHORT).show()
                        /*var dialog = AlertDialog.Builder(this@MainActivity)
                        dialog.setTitle("에러")
                        dialog.setMessage("호출실패했습니다." + t.message)
                        dialog.show()*/
                    }

                })
            }
        }
    }

    fun getabsolutelyPath(path: Uri): String{
        var proj: Array<String> = arrayOf(MediaStore.Images.Media.DATA)
        Log.d("TAG11","uri = "+path)
        var c: Cursor? = context?.contentResolver?.query(path, proj, null, null, null)
        var index = c!!.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        c!!.moveToFirst()
        var result = c.getString(index)
        return result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}

