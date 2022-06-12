package com.ahmet.gramerapp.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ahmet.gramerapp.R
import com.ahmet.gramerapp.preferences.LoginPref
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {
    lateinit var session: LoginPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        session = LoginPref(requireContext())
        if (session.isLoggedIn()) {
            findNavController().navigate(R.id.action_firstFragment_to_homeFragment)
        }

        button.setOnClickListener {
            var username = input.text.toString().trim()
            //var email=inputemail.text.toString().trim()

            if (username.isEmpty()) {

                button.isEnabled
            } else {

                session.createLoginSession(username)
                val action=FirstFragmentDirections.actionFirstFragmentToHomeFragment()
                Navigation.findNavController(view).navigate(action)
            }
        }


    }


}