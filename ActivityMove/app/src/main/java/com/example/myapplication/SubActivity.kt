package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    // 뒤로 가기 버튼을 눌렀을 때 호출되는 메소드
    override fun onBackPressed() {
        super.onBackPressed()
        // 왼쪽으로 액티비티가 사라지는 애니메이션 설정
        overridePendingTransition(R.anim.slide_left_enter, R.anim.slide_left_exit)
    }
}