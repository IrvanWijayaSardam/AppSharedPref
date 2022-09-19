package com.aminivan.appsharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.aminivan.appsharedpref.databinding.FragmentHomeBinding
import com.aminivan.appsharedpref.databinding.FragmentRegisterBinding

class FragmentHome : Fragment() {

    lateinit var binding : FragmentHomeBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        val view = binding.root
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPrefs = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.tvHello.setText("Hello, "+ sharedPrefs.getString("fullname","")
        )
        binding.btnLogout.setOnClickListener(){
            Toast.makeText(context, "Logout Berhasil", Toast.LENGTH_SHORT).show()
            clearData()
            gotoLogin()
        }
    }

    fun clearData(){
        var pref = sharedPrefs.edit()
        pref.clear()
        pref.apply()
        binding.tvHello.setText("")

    }

    fun gotoLogin(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentHome_to_fragmentLogin)
    }


}