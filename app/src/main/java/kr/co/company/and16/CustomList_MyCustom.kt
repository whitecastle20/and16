package kr.co.company.and16

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

// < #. 커스텀 메뉴 리스트 페이지:비공개 리스트 >

class CustomList_MyCustom : AppCompatActivity() {

    // xml 변수 선언
    lateinit var customlist_tab1_Button: Button    // 상단 탭 버튼1: 공개된 커스텀
    lateinit var customlist_tab2_Button: Button   // 상단 탭 버튼2: 나만의 커스텀

    lateinit var divide_line_imageView: ImageView   // 구분선 이미지

    lateinit var customlist_card: CardView                       // 카드뷰: 커스텀 메뉴 리스트
    lateinit var customlist_item_imageView: ImageView            // 카드뷰 제품 이미지
    lateinit var customlist_item_name_textView: TextView         // 카드뷰 제품 이름
    lateinit var customlist_item_brand_textView: TextView        // 카드뷰 제품 브랜드명
    lateinit var customlist_item_prise_textView: TextView        //카드뷰 제품 가격
    lateinit var customlist_item_mn_textView: TextView           // 카드뷰 제품 좋아요 숫자
    lateinit var customlist_item_like_imageButton: ImageButton   // 카드뷰 제품 찜 버튼

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_list_mycustom)
    }
}