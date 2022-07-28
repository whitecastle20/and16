package kr.co.company.and16.MenuReg

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kr.co.company.and16.R
import kr.co.company.and16.Start.Login

// < #. 커스텀 메뉴 작성 페이지2: 공차 커스텀 메뉴 >

class GongchaMenu_write : AppCompatActivity() {

    // 변수 선언
    lateinit var custom_public_radioButton : RadioButton //레시피 공개
    lateinit var custom_private_radioButton : RadioButton //레시피 비공개

    lateinit var custom_name_EditText : EditText

    lateinit var custom_basemenu_spinner : Spinner

    lateinit var custom_prise_EditText : EditText

    lateinit var custom_size1_radioButton : RadioButton
    lateinit var custom_size2_radioButton : RadioButton

    lateinit var custom_shotnum_plus_button : Button
    lateinit var custom_shotnum_sub_button : Button
    lateinit var custom_shotnum_textView : TextView
    lateinit var output_text : TextView

    lateinit var custom_suger_seekBar : SeekBar

    lateinit var custom_ice_seekBar : SeekBar

    lateinit var custom_topping1_radioButton : CheckBox
    lateinit var custom_topping2_radioButton : CheckBox
    lateinit var custom_topping3_radioButton : CheckBox
    lateinit var custom_topping4_radioButton : CheckBox
    lateinit var custom_topping5_radioButton : CheckBox
    lateinit var custom_topping6_radioButton : CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gongcha_menu_write)

        custom_basemenu_spinner = findViewById(R.id.custom_basemenu_spinner)

        custom_shotnum_plus_button = findViewById(R.id.custom_shotnum_plus_button)
        custom_shotnum_sub_button = findViewById(R.id.custom_shotnum_sub_button)
        custom_shotnum_textView = findViewById(R.id.custom_shotnum_textView)
        output_text = findViewById<TextView>(R.id.custom_shotnum_textView)
        var custom_shotnum_textView = 0 // 샷 개수는 0에서 가감


        // 베이스 메뉴 선택 - 스피너
        ArrayAdapter.createFromResource(
            this,
            R.array.gongcha_menu,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            custom_basemenu_spinner.adapter = adapter
        }

        // 샷 개수 감소 버튼
        custom_shotnum_sub_button.setOnClickListener {
            custom_shotnum_textView--
            output_text.setText(custom_shotnum_textView.toString())
        }
        // 샷 개수 증가 버튼
        custom_shotnum_plus_button.setOnClickListener {
            custom_shotnum_textView++
            output_text.setText(custom_shotnum_textView.toString())
        }
    }

}