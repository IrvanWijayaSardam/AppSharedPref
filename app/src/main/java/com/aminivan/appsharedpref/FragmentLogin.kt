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
import com.aminivan.appsharedpref.databinding.FragmentLoginBinding
import com.aminivan.appsharedpref.databinding.FragmentSpashBinding

class FragmentLogin : Fragment() {

    lateinit var binding : FragmentLoginBinding
    lateinit var sharedPrefs : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)

        binding.tvGotoRegister.setOnClickListener(){
            gotoRegister()
        }
        binding.btnLogin.setOnClickListener(){
            checkData(binding.edtUsername.text.toString(),binding.edtPasswordLogin.text.toString())
        }
    }

    fun checkData(username : String, password: String){
        if(binding.edtUsername.text.length == 0 && binding.edtUsername.text.length == 0) {
            Toast.makeText(context, "Isi Semua Field Yang Tersedia", Toast.LENGTH_SHORT).show()
        } else {
            if(sharedPrefs.getString("username","") == username && sharedPrefs.getString("password","") == password){
                gotoHome()
            } else {
                Toast.makeText(context, "Username / Password Salah", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun gotoHome(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentLogin_to_fragmentHome)
    }

    fun gotoRegister(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentLogin_to_fragmentRegister)
    }


}