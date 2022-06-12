package com.ahmet.gramerapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ahmet.gramerapp.R
import com.ahmet.gramerapp.adapter.AdapteryTest
import com.ahmet.gramerapp.mvvm.ObjectViewModel
import kotlinx.android.synthetic.main.fragment_objects.*

class ObjectsFragment : Fragment() {

    private lateinit var viewModel: ObjectViewModel
    private lateinit var adaptery2: AdapteryTest
    private var gelenid = ""


    private var selectedTest = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_objects, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*
        arguments?.let {
            gelenid=ObjectsFragmentArgs.fromBundle(it).uId
        }

 */



        viewModel = ViewModelProvider(this).get(ObjectViewModel::class.java)

        viewModel.resreshTest()

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        adaptery2 = AdapteryTest(arrayListOf())
        recyclerView.adapter = adaptery2

        observeLiveTest()


    }

    fun observeLiveTest() {



        viewModel.test.observe(viewLifecycleOwner, Observer { tests ->
            tests?.let {

                adaptery2.updateTest(tests.test)
            }
        })
    }


}