package com.example.cft_testing.greeting

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cft_testing.R
import com.example.cft_testing.databinding.FragmentGreetBinding


class GreetFragment : Fragment() {

    private val viewModel by viewModels<GreetViewModel>()
    private var _binding: FragmentGreetBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.greetBtn.setOnClickListener {
            val alert: AlertDialog.Builder = AlertDialog.Builder(context)
            alert.setTitle(viewModel.greetCurrentUser())
            alert.setPositiveButton(getText(R.string.hello)) { dialog, _ ->
                dialog.dismiss()
            }
            alert.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}