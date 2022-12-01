package com.example.fitapet.ui.reservation.petList

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.DatePicker
import android.widget.TimePicker
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentReservation01Binding
import com.example.fitapet.navfragment.HomeFragment
import com.example.fitapet.ui.reservation.CustomMinDialog
import java.text.DecimalFormat
import java.util.*


class Reservation01Fragment : Fragment(){
    //onCreate
    private var _binding: FragmentReservation01Binding? = null
    private val binding get() = _binding!!
    var price:Int = 0
    var pickup:Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val today = GregorianCalendar()
        val year: Int = today.get(Calendar.YEAR)
        val month: Int = today.get(Calendar.MONTH)
        val date: Int = today.get(Calendar.DATE)
        _binding = FragmentReservation01Binding.inflate(inflater,container,false)
        //날짜 받기
        binding.reservation01SelectDayBtn.setOnClickListener{
            binding.reservation01SelectDayBtn.isSelected=binding.reservation01SelectDayBtn.isSelected!=true
            val dlg = DatePickerDialog(requireContext(), object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    Log.d("kim","${year}년 ${month+1}월 ${dayOfMonth}일")
                    binding.reservation01SelectDayBtn.text="${month+1}월 ${dayOfMonth}일"
                    binding.reservation01SelectDayBtn.isSelected=false
                }
            }, year, month, date)
            dlg.show()
        }
        val mHour: Int = today.get(Calendar.HOUR_OF_DAY)
        val mMinute: Int = today.get(Calendar.MINUTE)
//        var ampm: String="오전"
        //시간받기
        binding.reservation01SelectTimeBtn.setOnClickListener {
            binding.reservation01SelectTimeBtn.isSelected=binding.reservation01SelectTimeBtn.isSelected!=true
            val timedlg = TimePickerDialog(requireContext(),android.R.style.Theme_Holo_Light_Dialog_NoActionBar,object : TimePickerDialog.OnTimeSetListener{
                override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
                    Log.d("timeCheck",""+p1)

                    binding.reservation01SelectTimeBtn.text="${p1}시 ${p2}분"
                    binding.reservation01SelectTimeBtn.isSelected=false
                    binding.reservation01Arrow.visibility=View.VISIBLE
                    binding.reservation01SelectTimeBtn02.visibility=View.VISIBLE
                }

            },mHour,mMinute,false)
            timedlg.setTitle("돌봄시작시간");
            timedlg.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent);
            timedlg.show()
        }
        //몇분할건지 받기
        binding.reservation01SelectTimeBtn02.setOnClickListener {
            val dialog = CustomMinDialog(requireContext())
            dialog.showDialog()

            dialog.setOnClickListener(object : CustomMinDialog.OnDialogClickListener {
                override fun onClicked(str: String)
                {
                    binding.reservation01SelectTimeBtn02.text = "시작시간으로부터 ${str}분"
                    if(str.toInt()==30){
                        price = 15000
                    }
                    else if(str.toInt()==60){
                        price = 21000
                    }
                    else{
                        price = 21000+(str.toInt()/30)*8000
                    }
                    val t_dec_up = DecimalFormat("#,###")
                    var money=price+pickup+(SM_dog_count*5000)+(L_dog_count*10000)+(cat_count*5000)
                    if(SM_dog_count+L_dog_count+ cat_count==2){
                        money=money/100*80
                    }
                    else if(SM_dog_count+L_dog_count+ cat_count==3)
                    {
                        money=money/100*60
                    }
                    val money_text = t_dec_up.format(money)

                    binding.reservation01Price.text=money_text+" 원"

                }

            })
        }
        //픽업여부받기
        binding.reservation01PickupBtnY.setOnClickListener {
            binding.reservation01PickupBtnY.isSelected=binding.reservation01PickupBtnY.isSelected!=true
            binding.reservation01PickupBtnN.isSelected=false
            pickup=5000
            val t_dec_up = DecimalFormat("#,###")
            val money=price+pickup
            val money_text = t_dec_up.format(money)
            binding.reservation01Price.text="총 금액 : "+money_text+" 원"
        }
        binding.reservation01PickupBtnN.setOnClickListener {
            binding.reservation01PickupBtnN.isSelected=binding.reservation01PickupBtnN.isSelected!=true
            binding.reservation01PickupBtnY.isSelected=false
            pickup=0
            val t_dec_up = DecimalFormat("#,###")
            val money=price+pickup
            val money_text = t_dec_up.format(money)
            binding.reservation01Price.text="총 금액 : "+money_text+" 원"
        }
        //edit text focus풀기
        binding.reservation01ParentLayout.setOnTouchListener(OnTouchListener { v, event ->
            hideKeyboard()
            binding.reservation01RequestEditText.clearFocus()
            false
        })
        return binding.root
    }
    private fun hideKeyboard() {
        if (requireActivity() != null && requireActivity().currentFocus != null) {
            // 프래그먼트기 때문에 getActivity() 사용
            val inputManager: InputMethodManager =
                requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputManager.hideSoftInputFromWindow(
                requireActivity().currentFocus!!.windowToken,
                InputMethodManager.HIDE_NOT_ALWAYS
            )
        }
        binding.reservation01NextBtn.setOnClickListener {
            loadFragment(HomeFragment())
        }
    }
    private fun loadFragment(fragment: Fragment){
        Log.d("clickTest","click!->"+fragment.tag)
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    companion object{
        var L_dog_count :Int = 0
        var SM_dog_count :Int = 0
        var cat_count :Int = 0
    }
}