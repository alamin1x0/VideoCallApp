package com.developeralamin.videocallapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.developeralamin.videocallapp.databinding.ActivityMainBinding
import com.zegocloud.uikit.service.defines.ZegoUIKitUser

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userID = intent.getStringExtra("name")
        binding.textName.text = "Hello $userID"

        binding.edTargetId.addTextChangedListener {
            val targetUserId = binding.edTargetId.text.toString().trim()
            if (targetUserId.isNotEmpty()) {
                getReadyVideoCall(targetUserId)
                getReadyAudioCall(targetUserId)
            }
        }
    }

    private fun getReadyVideoCall(targetUserId: String) {
        if (targetUserId.isNotEmpty()) {
            Log.d("VideoCall1", "Setting up call with user: $targetUserId")
            binding.videoCall.setIsVideoCall(true)  // ✅ FIXED FUNCTION NAME
            binding.videoCall.setResourceID("zego_uikit_call") // Optional, ensure it's correct
            binding.videoCall.setInvitees(
                listOf(ZegoUIKitUser(targetUserId, targetUserId)) // ✅ FIXED LIST IMPLEMENTATION
            )
        } else {
            Log.d("VideoCall1", "Target user ID is empty. Skipping call setup.")
        }
    }

    private fun getReadyAudioCall(targetUserId: String) {
        if (targetUserId.isNotEmpty()) { // ✅ ADDED CHECK
            Log.d("VideoCall1", "Setting up audio call with user: $targetUserId")
            binding.audioCall.setIsVideoCall(false)  // ✅ FIXED FUNCTION NAME
            binding.audioCall.setResourceID("zego_uikit_call")
            binding.audioCall.setInvitees(
                listOf(ZegoUIKitUser(targetUserId, targetUserId)) // ✅ FIXED LIST IMPLEMENTATION
            )
        } else {
            Log.d("VideoCall1", "Target user ID is empty. Skipping audio call setup.")
        }
    }
}
