package com.example.singletondemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.singletondemo.databinding.FragmentShowStudentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ShowSVFragment : Fragment() {
    private lateinit var binding: FragmentShowStudentBinding
    private val viewModel by viewModels<ShowSVViewModel>()
    private lateinit var listStudent: List<SV>
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_show_student, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getList()
        viewModel.listStudent.observe(viewLifecycleOwner) {
            var result = ""
            for (item in it)
                result += "$item \n"
            binding.listStudentTv.text = result
        }
    }

}