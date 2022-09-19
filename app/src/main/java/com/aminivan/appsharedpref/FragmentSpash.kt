package com.aminivan.appsharedpref

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.postDelayed
import androidx.navigation.Navigation
import com.aminivan.appsharedpref.databinding.FragmentSpashBinding
import com.bumptech.glide.Glide
import java.util.logging.Handler

class FragmentSpash : Fragment() {

    lateinit var binding : FragmentSpashBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSpashBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(this)
            .load(R.drawable.socialcare)
            .into(binding.ivSplash);

        sharedPrefs = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)
        if(sharedPrefs.getString("username","").equals("")) {
            android.os.Handler(Looper.myLooper()!!).postDelayed({
                gotoLogin()
            },5000)

        } else if(sharedPrefs.getString("username","")!!.length != 0) {
            android.os.Handler(Looper.myLooper()!!).postDelayed({
                gotoHome()
            },5000)
        }

    }

    fun gotoLogin(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentSpash_to_fragmentLogin)
    }
    fun gotoHome(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentSpash_to_fragmentHome)
    }



}