package com.example.singletondemo

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.singletondemo.databinding.FragmentInsertSvBinding

class InsertSVFragment : Fragment() {
    private lateinit var binding: FragmentInsertSvBinding
    private val viewModel by viewModels<InsertSVViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_insert_sv, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            addStudentBtn.setOnClickListener {
                val svName = studentNameEdt.text?.trim().toString()
                val svAge = studentAgeEdt.text?.trim().toString().toIntOrNull()
                if (svAge != null && svAge in 17..99) {
                    Log.d("TAG_DB", "onViewCreated() called item = $svName; $svAge")
                    viewModel.insert(SV(name = svName, age = svAge))
                    findNavController().popBackStack()
                }
            }
        }
    }
}