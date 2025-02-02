package com.developeralamin.videocallapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.developeralamin.videocallapp.databinding.ActivityLoginBinding
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallService
import com.zegocloud.uikit.prebuilt.call.invite.ZegoUIKitPrebuiltCallInvitationConfig

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginNow.setOnClickListener {
            if (binding.edtLogin.text.toString().isNotEmpty()) {

                val userID = binding.edtLogin.text.toString()
                val callInvitationConfig = ZegoUIKitPrebuiltCallInvitationConfig()
                try {
                    ZegoUIKitPrebuiltCallService.init(
                        application,
                        114875314,
                        "b5f07160f4d207938947ab92f7bf47751f2aef9f5b9e391aa88d7eca780659c0",
                        userID,
                        userID,
                        callInvitationConfig
                    )
                    Log.d("ZegoInit", "ZegoUIKitPrebuiltCallService initialized successfully")
                } catch (e: Exception) {
                    Log.e("ZegoInit", "Error initializing Zego: ${e.message}")
                }

                startActivity(
                    Intent(this, MainActivity::class.java).putExtra(
                        "name",
                        userID
                    )
                )
            }
        }


    }
}