package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

/**
    화면이 최초 실행 되었을 때 호출되는 액티비티
    기본적으로 뷰바인딩을 사용
    뷰바인딩을 사용하려면 build.gradle 에서

    buildFeatures {
        viewBinding true
    }

    위의 내용 추가 할 것
 */


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        // SubActivity.kt 이동
        this.binding.button01.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
            // 오른쪽으로 액티비티가 사라지는 애니메이션 설정
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        }

        // https://www.naver.com 이동
        this.binding.button02.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.naver.com"))
            startActivity(intent)
        }

        // 카카오톡 이동
        this.binding.button03.setOnClickListener {
            try {
                val packageName = "com.kakao.talk"
                // 패키지 정보를 얻기 위해 사용
                val intent = packageManager.getLaunchIntentForPackage(packageName)
                startActivity(intent)
                // 패키지 정보를 참조할 수 없는 경우 null 반환 NPE 발생. (NullPointException)
            } catch (e: Exception) {
                val url = "market://details?id=${packageName}"
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(i)
            }
        }
    }
}