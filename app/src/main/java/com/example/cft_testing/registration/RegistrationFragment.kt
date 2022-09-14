package com.example.cft_testing.registration

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.cft_testing.R
import com.example.cft_testing.databinding.FragmentRegistrationBinding
import java.util.*

class RegistrationFragment : Fragment() {
    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dateBtn.setOnClickListener {
            calendarPicker()
        }

        binding.registerBtn.setOnClickListener {
            if (isSurnameCorrect() &&
                isNameCorrect() &&
                isDateReal() &&
                isPasswordCorrect() &&
                isPasswordConfirmed()

            ) {
                with(binding) {
                    val surname = editTextSurname.text.toString()
                    val name = editTextName.text.toString()
                    val (day, month, year) = textDate.text.split("-").map { it.toInt() }
                    val dateOfBirth = MDate(day, month, year)
                    val password = password.text.toString()
                    viewModel.registerUser(User(surname, name, dateOfBirth, password))
                }


                findNavController().navigate(R.id.greetFragment)

            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calendarPicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, mYear, monthOfYear, dayOfMonth ->
                binding.textDate.text = "$dayOfMonth-$monthOfYear-${mYear}"
            },
            year,
            month,
            day,
        )
        datePickerDialog.show()
    }

    private fun isSurnameCorrect(): Boolean {
        return if (!viewModel.isSurnameCorrect(binding.editTextSurname.text.toString())) {
            binding.editTextSurname.error = requireContext().getString(R.string.surnameCheck)
            false
        } else
            true
    }

    private fun isNameCorrect(): Boolean {
        return if (!viewModel.isNameCorrect(binding.editTextName.text.toString())) {
            binding.editTextName.error = requireContext().getString(R.string.nameCheck)
            false
        } else
            true
    }

    private fun isDateReal(): Boolean {
        return if (binding.textDate.text.contains(getString(R.string.dash))) {
            binding.textDate.clearFocus()
            val (day, month, year) = binding.textDate.text.split(getString(R.string.dash))
                .map { it.toInt() }
            val date = MDate(day, month, year)
            if (!viewModel.isDateCorrect(date)) {
                binding.textDate.error = requireContext().getString(R.string.dateCheck)
                Toast.makeText(
                    requireContext(),
                    requireContext().getString(R.string.dateCheck),
                    Toast.LENGTH_SHORT
                ).show()
                false
            } else {
                binding.textDate.error = null
                true
            }
        } else {
            binding.textDate.error = requireContext().getString(R.string.dateCheck)
            false
        }
    }


    private fun isPasswordCorrect(): Boolean {
        return if (!viewModel.isPasswordCorrect(binding.password.text.toString())) {
            binding.password.error = requireContext().getString(R.string.passwordCheck)
            false
        } else
            true
    }

    private fun isPasswordConfirmed(): Boolean {
        return if (!viewModel.isPasswordCorrect(binding.confirmPassword.text.toString())) {
            binding.confirmPassword.error =
                requireContext().getString(R.string.passwordConfirmCheck)
            false
        } else
            true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}