package com.example.fitapet.ui.animalReg

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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
            binding.animalRegBoy.isSelected=binding.animalRegBoy.isSelected!=true
            binding.animalRegGirl.isSelected=false
        }
        //여아버튼
        binding.animalRegGirl.setOnClickListener {
            binding.animalRegGirl.isSelected=binding.animalRegGirl.isSelected!=true
            binding.animalRegBoy.isSelected=false
        }
        //중성화 y버튼
        binding.animalRegNeuteringY.setOnClickListener {
            binding.animalRegNeuteringY.isSelected=binding.animalRegNeuteringY.isSelected!=true
            binding.animalRegNeuteringN.isSelected=false
        }
        //중성화 N버튼
        binding.animalRegNeuteringN.setOnClickListener {
            binding.animalRegNeuteringN.isSelected=binding.animalRegNeuteringN.isSelected!=true
            binding.animalRegNeuteringY.isSelected=false
        }
        //외장칩 버튼
        binding.animalRegChipOut.setOnClickListener {
            binding.animalRegChipOut.isSelected=binding.animalRegChipOut.isSelected!=true
            binding.animalRegChipIn.isSelected=false
        }
        //내장칩 버튼
        binding.animalRegChipIn.setOnClickListener {
            binding.animalRegChipIn.isSelected=binding.animalRegChipIn.isSelected!=true
            binding.animalRegChipOut.isSelected=false
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}