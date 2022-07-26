package kr.co.company.and16.Start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kr.co.company.and16.R

class StartOnboading : AppCompatActivity() {

    // xml 변수 선언
    lateinit var StartButton: Button //시작버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_onboading)

        StartButton = findViewById(R.id.StartButton)

        // 시작하기 버튼 클릭 시 로그인 화면으로 이동
        StartButton.setOnClickListener{
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}