package com.ahmet.gramerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmet.gramerapp.R
import com.ahmet.gramerapp.adapter.Adaptery
import com.ahmet.gramerapp.mvvm.HomeViewModel
import com.ahmet.gramerapp.preferences.LoginPref
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var viewModel:HomeViewModel
    private lateinit var adaptery:Adaptery

    lateinit var session: LoginPref
    private var selectedTopicName = ""
    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        session = LoginPref(requireContext())

        session.checkLogin()

        var user: HashMap<String, String> = session.getUserDetails()

        var username = user.get(LoginPref.key_username)

        //profilText.text = "Welcome " + name


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.refeshData()

        recyclerHome.layoutManager=GridLayoutManager(context,2)
        adaptery= Adaptery(arrayListOf())
        recyclerHome.adapter=adaptery

        observeLiveData()


/*
        hayvanLayout.setOnClickListener {
            selectedTopicName = "hayvangramer"
            hayvanLayout.setBackgroundResource(R.drawable.roun_blue)
            nesneLayout.setBackgroundResource(R.drawable.roun_back_white)

            findNavController().navigate(R.id.action_homeFragment_to_verbsFragment)
            //intent.putExtra(setData.name, Name.toString())
        }
        nesneLayout.setOnClickListener {
            selectedTopicName = "nesnegramer"
            nesneLayout.setBackgroundResource(R.drawable.roun_blue)
            hayvanLayout.setBackgroundResource(R.drawable.roun_back_white)

            findNavController().navigate(R.id.action_homeFragment_to_objectsFragment)
            //intent.putExtra(setData.name, Name.toString())
        }
 */

    }
    fun observeLiveData() {

        viewModel.home.observe(viewLifecycleOwner, Observer { home ->

            home?.let {
                adaptery.updateGramer(home.kategori)
            }
        })
    }

  /*  fun profilclick(view: View) {

        val alert = AlertDialog.Builder(requireContext())
        alert.setTitle("Loging out")
        alert.setMessage("Are you want to log out ?")
        alert.setPositiveButton("Yes") { dialog, which ->
            session.LogoutUser()
            //Restart
            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
        }
        alert.setNegativeButton("No") { dialog, which ->
        }
        alert.show()

    }

   */




}