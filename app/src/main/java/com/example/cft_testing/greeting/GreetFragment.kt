package com.example.cft_testing.greeting

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cft_testing.R

class GreetFragment : Fragment() {

    companion object {
        fun newInstance() = GreetFragment()
    }

    private lateinit var viewModel: GreetViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_greet, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GreetViewModel::class.java)
        // TODO: Use the ViewModel
    }

}