package kr.co.company.and16.Home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import kr.co.company.and16.R

// < #. 홈 메인페이지: 랭킹 리스트(전체) >

class MainActivity : AppCompatActivity() {

    // xml 변수 선언
    lateinit var all_tab_imageButton: ImageButton         // 전체 탭 버튼
    lateinit var starbucks_tab_imageButton: ImageButton   // 스타벅스 탭 버튼
    lateinit var ediya_tab_imageButton: ImageButton       // 이디야 탭 버튼
    lateinit var gongcha_tab_imageButton: ImageButton     // 공차 탭 버튼

    lateinit var divide_line_imageView: ImageView   // 구분선 이미지

    //lateinit var ranking_first_card:CardView              // 카드뷰1: 랭킹1
    lateinit var first_item_imageView: ImageView            // 랭킹1위 제품 이미지
    lateinit var first_item_explain_textView: TextView      // 카드뷰2 설명 텍스트
    lateinit var first_item_name_textView: TextView         // 카드뷰2 제품 이름
    lateinit var first_item_brand_textView: TextView        // 카드뷰2 제품 브랜드명
    lateinit var first_item_prise_textView: TextView        //카드뷰2 제품 가격
    lateinit var first_item_mn_textView: TextView           // 카드뷰2 제품 좋아요 숫자
    lateinit var first_item_like_imageButton: ImageButton   // 카드뷰2 찜 버튼

    //lateinit var ranking_list_card:CardView              // 카드뷰2: 랭킹리스트
    lateinit var list_item_imageView: ImageView            // 카드뷰2 제품 이미지
    lateinit var list_item_name_textView: TextView         // 카드뷰2 제품 이름
    lateinit var list_item_brand_textView: TextView        // 카드뷰2 제품 브랜드명
    lateinit var list_item_prise_textView: TextView        //카드뷰2 제품 가격
    lateinit var list_item_mn_textView: TextView           // 카드뷰2 제품 좋아요 숫자
    lateinit var list_item_like_imageButton: ImageButton   // 카드뷰2 찜 버튼


    override fun onCreate(savedInstanceState: Bundle?) {

        // xml 변수 연결
        all_tab_imageButton = findViewById(R.id.all_tab_imageButton)               // 전체 탭 버튼
        starbucks_tab_imageButton = findViewById(R.id.starbucks_tab_imageButton)   // 스타벅스 탭 버튼
        ediya_tab_imageButton = findViewById(R.id.ediya_tab_imageButton)           // 이디야 탭 버튼
        gongcha_tab_imageButton = findViewById(R.id.gongcha_tab_imageButton)       // 공차 탭 버튼

        divide_line_imageView = findViewById(R.id.divide_line_imageView)   // 구분선 이미지

        first_item_imageView = findViewById(R.id.first_item_imageView)                 // 랭킹1위 제품 이미지
        first_item_explain_textView = findViewById(R.id.first_item_explain_textView)   // 카드뷰2 설명 텍스트
        first_item_name_textView = findViewById(R.id.first_item_name_textView)         // 카드뷰2 제품 이름
        first_item_brand_textView = findViewById(R.id.first_item_brand_textView)       // 카드뷰2 제품 브랜드명
        first_item_prise_textView = findViewById(R.id.first_item_prise_textView)       //카드뷰2 제품 가격
        first_item_mn_textView = findViewById(R.id.first_item_mn_textView)             // 카드뷰2 제품 좋아요 숫자
        first_item_like_imageButton = findViewById(R.id.first_item_like_imageButton)   // 카드뷰2 찜 버튼

        list_item_imageView = findViewById(R.id.list_item_imageView)                 // 카드뷰2 제품 이미지
        list_item_name_textView = findViewById(R.id.list_item_name_textView)         // 카드뷰2 제품 이름
        list_item_brand_textView = findViewById(R.id.list_item_brand_textView)       // 카드뷰2 제품 브랜드명
        list_item_prise_textView = findViewById(R.id.list_item_prise_textView)       //카드뷰2 제품 가격
        list_item_mn_textView = findViewById(R.id.list_item_mn_textView)             // 카드뷰2 제품 좋아요 숫자
        list_item_like_imageButton = findViewById(R.id.list_item_like_imageButton)   // 카드뷰2 찜 버튼



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}