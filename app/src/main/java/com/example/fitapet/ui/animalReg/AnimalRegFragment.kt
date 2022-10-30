package com.example.fitapet.ui.animalReg

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fitapet.R
import com.example.fitapet.databinding.FragmentAnimalRegBinding


class AnimalRegFragment : Fragment() {

    private var _binding: FragmentAnimalRegBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        var dogOrCat :Int = 0 // 0->dog 1->cat
        var boyOrGrl :Int = 0 // 0->boy 1->girl
        var neu :Int = 0 // 0-> 중성화x , 1->중성화  o
        var chip:Int = 0 // 0-> 외장칩 1->내장칩
        _binding = FragmentAnimalRegBinding.inflate(inflater, container, false)
        val root: View = binding.root
        //이미지 클릭 시
        binding.animalRegImgBtn01.setOnClickListener {
            Log.d("kimdo","imgbtn01click!")
            //binding.animalRegImgBtn01.isSelected=true
        }
        binding.animalRegImgBtn02.setOnClickListener {
            Log.d("kimdo","imgbtn02click!")
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
        //year SPINNER
        val year_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Year)
        )
        val Adapter_Year = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, year_items.get(0))
        binding.animalRegBirthYear.adapter=Adapter_Year
        val month_items: Array<Array<String>> = arrayOf(
            resources.getStringArray(R.array.Month)
        )
        val Adapter_month = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, month_items.get(0))
        binding.animalRegBirthMonth.adapter=Adapter_month

        binding.animalRegNextBtn.setOnClickListener {
            Log.d("kim","k = ${dogOrCat}, S = ${boyOrGrl}, neu=${neu}, chip =${chip}")
            Log.d("kim", "name = ${binding.animalRegName.text}, breed = ${binding.animalRegDogBreed.text}" +
                    "year = ${binding.animalRegBirthYear.selectedItem.toString()}" +
                    "month = ${binding.animalRegBirthMonth.selectedItem.toString()}" +
                    "weight = ${binding.animalRegBirthWeight.text}")
            if((!binding.animalRegCatBtn.isSelected && !binding.animalRegDogBtn.isSelected) ||
                (!binding.animalRegBoy.isSelected && !binding.animalRegGirl.isSelected) ||
                (!binding.animalRegNeuteringY.isSelected && !binding.animalRegNeuteringN.isSelected)||
                (binding.animalRegDogBtn.isSelected && !binding.animalRegChipIn.isSelected && !binding.animalRegChipOut.isSelected))
                {
                    Log.d("kim","anything no selected !")
                    Toast.makeText(requireContext(), "모두 선택해주세요.", Toast.LENGTH_SHORT).show()


                }
            else if((binding.animalRegName.text.isNullOrBlank()) ||
                ((binding.animalRegCatBreed.text.isNullOrBlank())&&(binding.animalRegDogBreed.text.isNullOrBlank()))||
                    binding.animalRegBirthWeight.text.isNullOrBlank())
            {
                Toast.makeText(requireContext(), "모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}