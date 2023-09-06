package com.example.taskmanager.task_fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.R
import com.example.taskmanager.databinding.LoginFragmentBinding


class LoginFragment : Fragment(R.layout.login_fragment) {

    private lateinit var username: String
    private lateinit var password: String
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            checkLogin()
        }
    }

    private fun checkLogin() {
        username = binding.usernameEditText.editableText.toString()
        password = binding.passwordEditText.editableText.toString()

        if (username == "root" && password == "root") {
//             navigate to tasks
            val action = LoginFragmentDirections.actionLoginToMainFragment()
            findNavController().navigate(action)
        } else {
            Toast.makeText(context, "Invalid login!!!", Toast.LENGTH_SHORT).show()
            binding.usernameEditText.setText("")
            binding.passwordEditText.setText("")
        }
    }
}