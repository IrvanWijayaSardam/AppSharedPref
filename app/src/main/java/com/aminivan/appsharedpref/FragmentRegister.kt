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
import com.aminivan.appsharedpref.databinding.FragmentRegisterBinding
import com.aminivan.appsharedpref.databinding.FragmentSpashBinding

class FragmentRegister : Fragment() {

    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedPrefs : SharedPreferences
    lateinit var loginPrefs : SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPrefs = requireContext().getSharedPreferences("datauser", Context.MODE_PRIVATE)
        loginPrefs = requireContext().getSharedPreferences("datauserlogin",Context.MODE_PRIVATE)
        binding.btnRegister.setOnClickListener(){
            if (binding.edtFullName.text.length >0 && binding.edtUsername.text.length  >0 && binding.edtPassword.text.length  >0 && binding.edtRepeatPassword.text.length  >0) {
                if (binding.edtPassword.text.toString() == binding.edtRepeatPassword.text.toString()) {
                    submitData(binding.edtUsername.text.toString(),binding.edtFullName.text.toString(),binding.edtPassword.text.toString())
                    Toast.makeText(context, "Registrasi Berhasil", Toast.LENGTH_SHORT).show()
                    gotoLogin()
                } else {
                    Toast.makeText(context, "Password dan confirmation password tidak sama !!", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(context, "Silahkan Isi Semua Data !!", Toast.LENGTH_LONG).show()
            }
        }

        binding.tvLogin.setOnClickListener(){
            gotoLogin()
        }

    }

    fun submitData(username: String, fullname: String,password: String){

        var addData = sharedPrefs.edit()
        addData.putString("username",username)
        addData.putString("fullname",fullname)
        addData.putString("password",password)
        addData.apply()

    }

    fun gotoLogin(){
        Navigation.findNavController(requireView()).navigate(R.id.action_fragmentRegister_to_fragmentLogin)
    }

}