package com.example.fitapet.ui.animalReg

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitapet.Cookie
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentAnimalReg02Binding
import com.example.fitapet.databinding.FragmentAnimalRegBinding
import com.example.fitapet.navfragment.MypageFragment
import com.example.fitapet.retrofit.RetrofitClient
import com.example.fitapet.retrofit.dto.Pet
import com.example.fitapet.retrofit.dto.isLikeDtoNoResult
import com.example.fitapet.retrofit.dto.registerPetDTO
import com.example.fitapet.retrofit.dto.registerPetDtoNoResult
import com.example.fitapet.retrofit.service.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class AnimalRegFragment02 : Fragment(),View.OnClickListener {
    private var _binding: FragmentAnimalReg02Binding? = null
    private val binding get() = _binding!!
    private val animalRegViewModel:AnimalRegViewModel by activityViewModels()
    lateinit var responseRegisterPet: Call<registerPetDtoNoResult>
    var survey=Array<Int>(5,{-1})
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalReg02Binding.inflate(inflater, container, false)
        val root: View = binding.root
        //부위
        binding.animalReg2PartBtn01.setOnClickListener(this)
        binding.animalReg2PartBtn02.setOnClickListener(this)
        binding.animalReg2PartBtn03.setOnClickListener(this)
        binding.animalReg2PartBtn04.setOnClickListener(this)
        binding.animalReg2PartBtn05.setOnClickListener(this)
        binding.animalReg2PartBtn06.setOnClickListener(this)
        binding.animalReg2PartBtn07.setOnClickListener(this)
        binding.animalReg2PartBtn08.setOnClickListener(this)
        //펫만남 반응
        binding.animalReg2PeoReactBtn01.setOnClickListener(this)
        binding.animalReg2PeoReactBtn02.setOnClickListener(this)
        binding.animalReg2PeoReactBtn03.setOnClickListener(this)
        binding.animalReg2PeoReactBtn04.setOnClickListener(this)
        //펫만남 반응
        binding.animalReg2PetReactBtn01.setOnClickListener(this)
        binding.animalReg2PetReactBtn02.setOnClickListener(this)
        binding.animalReg2PetReactBtn03.setOnClickListener(this)
        binding.animalReg2PetReactBtn04.setOnClickListener(this)
        //공격 유무
        binding.animalReg2AttackBtn01.setOnClickListener(this)
        binding.animalReg2AttackBtn02.setOnClickListener(this)
        //예방접종 뮤무
        binding.animalReg2VaccinBtn01.setOnClickListener(this)
        binding.animalReg2VaccinBtn02.setOnClickListener(this)



        var name=animalRegViewModel.name.toString()
        lateinit var type:String
        var species:String?
        var birth:String? = null
        lateinit var size:String
        lateinit var sex:String
        var age:String?
        lateinit var chip:String
        lateinit var neu:String
        if(animalRegViewModel.dogOrCat==0){
            type="DOG"
        }
        else{
            type="CAT"
        }
        species=animalRegViewModel.breed.toString()
        birth=animalRegViewModel.birth.toString()
        if(type=="CAT"){
            size="소/중형"
        }
        else{
            if(animalRegViewModel.weight2==0){
                size="소/중형"
            }
            else{
                size="대형"
            }
        }
        if(animalRegViewModel.boyOrGrl==0){
            sex="MALE"
        }
        else{
            sex="FEMAIL"
        }
        age=animalRegViewModel.age.toString()
        if(animalRegViewModel.chip==0){
            chip="EXTERNAL"
        }
        else{
            chip="INTERNAL"
        }
        if(animalRegViewModel.neu==0){
            neu="N"
        }
        else{
            neu="Y"
        }
        //등록 클릭시
        binding.animalRegNextBtn.setOnClickListener {
            val pet=Pet(name,type,species,birth,size,sex,age,"http://www.ikunkang.com/news/photo/202009/32320_21987_1540.jpg",chip,neu)
            Log.d("TAG11","${pet},${Cookie.userId},${binding.animalRegHosName.text.toString()},${binding.animalRegHosTel.text.toString()},${survey}")
            val registerpet=registerPetDTO(pet,Cookie.userId,binding.animalRegHosName.text.toString(),binding.animalRegHosTel.text.toString(),survey)
            responseRegisterPet=RetrofitClient.apiServer.registerPet(Cookie.userId,registerpet)
            responseRegisterPet.enqueue(object : Callback<registerPetDtoNoResult>{
                override fun onResponse(
                    call: Call<registerPetDtoNoResult>,
                    response: Response<registerPetDtoNoResult>
                ) {
                    Log.d("TAG11","success")
                    loadFragment(MypageFragment())
                }

                override fun onFailure(call: Call<registerPetDtoNoResult>, t: Throwable) {
                    Log.d("TAG11","fail: "+t)
                    loadFragment(MypageFragment())
                }

            })
        }

        return root
    }
    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }




    override fun onClick(v: View?) {
        when(v?.id){
            binding.animalReg2PartBtn01.id->{
                binding.animalReg2PartBtn01.isSelected=binding.animalReg2PartBtn01.isSelected!=true
                survey[2]=1
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn02.id->{
                binding.animalReg2PartBtn02.isSelected=binding.animalReg2PartBtn02.isSelected!=true
                survey[2]=2
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn03.id->{
                binding.animalReg2PartBtn03.isSelected=binding.animalReg2PartBtn03.isSelected!=true
                survey[2]=3
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn04.id->{
                binding.animalReg2PartBtn04.isSelected=binding.animalReg2PartBtn04.isSelected!=true
                survey[2]=4
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn05.id->{
                binding.animalReg2PartBtn05.isSelected=binding.animalReg2PartBtn05.isSelected!=true
                survey[2]=5
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn06.id->{
                binding.animalReg2PartBtn06.isSelected=binding.animalReg2PartBtn06.isSelected!=true
                survey[2]=6
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn07.id->{
                binding.animalReg2PartBtn07.isSelected=binding.animalReg2PartBtn07.isSelected!=true
                survey[2]=7
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
                binding.animalReg2PartBtn08.isSelected=false
            }
            binding.animalReg2PartBtn08.id->{
                binding.animalReg2PartBtn08.isSelected=binding.animalReg2PartBtn08.isSelected!=true
                survey[2]=8
                binding.animalReg2PartBtn02.isSelected=false
                binding.animalReg2PartBtn03.isSelected=false
                binding.animalReg2PartBtn04.isSelected=false
                binding.animalReg2PartBtn05.isSelected=false
                binding.animalReg2PartBtn06.isSelected=false
                binding.animalReg2PartBtn07.isSelected=false
                binding.animalReg2PartBtn01.isSelected=false
            }
            binding.animalReg2PeoReactBtn01.id->{
                binding.animalReg2PeoReactBtn01.isSelected=binding.animalReg2PeoReactBtn01.isSelected!=true
                survey[1]=1
                binding.animalReg2PeoReactBtn02.isSelected=false
                binding.animalReg2PeoReactBtn03.isSelected=false
                binding.animalReg2PeoReactBtn04.isSelected=false
            }
            binding.animalReg2PeoReactBtn02.id->{
                binding.animalReg2PeoReactBtn02.isSelected=binding.animalReg2PeoReactBtn02.isSelected!=true
                survey[1]=2
                binding.animalReg2PeoReactBtn01.isSelected=false
                binding.animalReg2PeoReactBtn03.isSelected=false
                binding.animalReg2PeoReactBtn04.isSelected=false
            }
            binding.animalReg2PeoReactBtn03.id->{
                binding.animalReg2PeoReactBtn03.isSelected=binding.animalReg2PeoReactBtn03.isSelected!=true
                survey[1]=3
                binding.animalReg2PeoReactBtn02.isSelected=false
                binding.animalReg2PeoReactBtn01.isSelected=false
                binding.animalReg2PeoReactBtn04.isSelected=false
            }
            binding.animalReg2PeoReactBtn04.id->{
                binding.animalReg2PeoReactBtn04.isSelected=binding.animalReg2PeoReactBtn04.isSelected!=true
                survey[1]=4
                binding.animalReg2PeoReactBtn02.isSelected=false
                binding.animalReg2PeoReactBtn03.isSelected=false
                binding.animalReg2PeoReactBtn01.isSelected=false
            }
            binding.animalReg2PetReactBtn01.id->{
                binding.animalReg2PetReactBtn01.isSelected=binding.animalReg2PetReactBtn01.isSelected!=true
                survey[0]=1
                binding.animalReg2PetReactBtn02.isSelected=false
                binding.animalReg2PetReactBtn03.isSelected=false
                binding.animalReg2PetReactBtn04.isSelected=false
            }
            binding.animalReg2PetReactBtn02.id->{
                binding.animalReg2PetReactBtn02.isSelected=binding.animalReg2PetReactBtn02.isSelected!=true
                survey[0]=2
                binding.animalReg2PetReactBtn01.isSelected=false
                binding.animalReg2PetReactBtn03.isSelected=false
                binding.animalReg2PetReactBtn04.isSelected=false
            }
            binding.animalReg2PetReactBtn03.id->{
                binding.animalReg2PetReactBtn03.isSelected=binding.animalReg2PetReactBtn03.isSelected!=true
                survey[0]=3
                binding.animalReg2PetReactBtn02.isSelected=false
                binding.animalReg2PetReactBtn01.isSelected=false
                binding.animalReg2PetReactBtn04.isSelected=false
            }
            binding.animalReg2PetReactBtn04.id->{
                binding.animalReg2PetReactBtn04.isSelected=binding.animalReg2PetReactBtn04.isSelected!=true
                survey[0]=4
                binding.animalReg2PetReactBtn02.isSelected=false
                binding.animalReg2PetReactBtn03.isSelected=false
                binding.animalReg2PetReactBtn01.isSelected=false
            }
            binding.animalReg2AttackBtn01.id->{
                binding.animalReg2AttackBtn01.isSelected=binding.animalReg2AttackBtn01.isSelected!=true
                binding.animalReg2AttackBtn02.isSelected=false
                survey[3]=1
            }
            binding.animalReg2AttackBtn02.id->{
                binding.animalReg2AttackBtn02.isSelected=binding.animalReg2AttackBtn02.isSelected!=true
                binding.animalReg2AttackBtn01.isSelected=false
                survey[3]=2
            }
            binding.animalReg2VaccinBtn01.id->{
                binding.animalReg2VaccinBtn01.isSelected=binding.animalReg2VaccinBtn01.isSelected!=true
                binding.animalReg2VaccinBtn02.isSelected=false
                survey[4]=1
            }
            binding.animalReg2VaccinBtn02.id->{
                binding.animalReg2VaccinBtn02.isSelected=binding.animalReg2VaccinBtn02.isSelected!=true
                binding.animalReg2VaccinBtn01.isSelected=false
                survey[4]=2
            }
        }
    }

}