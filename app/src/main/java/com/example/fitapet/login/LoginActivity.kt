package com.example.fitapet.login

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fitapet.MainActivity
import com.example.fitapet.databinding.ActivityLoginBinding
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient

class LoginActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var keyHash = Utility.getKeyHash(this)
        Log.e("Hash",keyHash)
        binding.kakaoLoginButton.setOnClickListener {
            //카카오톡 설치 여부
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                // 카카오계정으로 로그인
                UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
                    if (error != null) {
                        Log.e(ContentValues.TAG, "로그인 실패", error)
                    } else if (token != null) {
                        Log.i(ContentValues.TAG, "로그인 성공 ${token.accessToken}")
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                }
            } else {
                Log.e("로그", "카카오 로그인이 불가합니다.")
            }
        }
    }
}