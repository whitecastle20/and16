package kr.co.company.and16.Custom

import android.annotation.SuppressLint
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_ediya_custom_list.*
import kr.co.company.and16.DBManager
import kr.co.company.and16.EdiyaCustomList
import kr.co.company.and16.R
import kr.co.company.and16.RecyclerView_ediya.MyModel
import kr.co.company.and16.RecyclerView_ediya.MyRecyclerAdapter
import kr.co.company.and16.RecyclerView_ediya.MyRecyclerViewInterface

class GongchaCustomList : AppCompatActivity(), MyRecyclerViewInterface {

    // 액션바
    lateinit var actionBar : ActionBar

    val TAG: String = "로그"
    var modelList = ArrayList<MyModel>()
    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    lateinit var dbManager : DBManager
    lateinit var sqlitedb : SQLiteDatabase

    lateinit var all_tab_imageButton: ImageButton         // 전체 탭 버튼
    lateinit var starbucks_tab_imageButton: ImageButton   // 스타벅스 탭 버튼
    lateinit var ediya_tab_imageButton: ImageButton       // 이디야 탭 버튼
    lateinit var gongcha_tab_imageButton: ImageButton     // 공차 탭 버튼

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gongcha_custom_list)

        // 액션바 제목 변경
        actionBar = supportActionBar!!
        actionBar.title ="공차 커스텀메뉴"

        all_tab_imageButton = findViewById(R.id.all_tab_imageButton)
        starbucks_tab_imageButton = findViewById(R.id.starbucks_tab_imageButton)
        ediya_tab_imageButton = findViewById(R.id.ediya_tab_imageButton)
        gongcha_tab_imageButton = findViewById(R.id.gongcha_tab_imageButton)

        dbManager = DBManager(this, "gongchaMenuDB", null, 1)
        sqlitedb = dbManager.readableDatabase

        var cursor : Cursor
        cursor = sqlitedb.rawQuery("SELECT * FROM gongchaMenuDB", null) // gongchaMenuDB 모든 데이터

        var num: Int = 0
        while(cursor.moveToNext()) {

            // 현재 커서에 있는 값 변수로 받기
            var str_customMenuName = cursor.getString(cursor.getColumnIndex("customMenuName")).toString()
            var str_existingMenuName = cursor.getString(cursor.getColumnIndex("existingMenuName")).toString()
            var str_price = cursor.getString(cursor.getColumnIndex("price")).toString()
            var str_size = cursor.getString(cursor.getColumnIndex("size")).toString()
            var str_espressoShotNumber = cursor.getString(cursor.getColumnIndex("espressoShotNumber")).toString()
            var str_sugar = cursor.getString(cursor.getColumnIndex("sugar")).toString()
            var str_ice = cursor.getString(cursor.getColumnIndex("ice")).toString()
            var str_topping = cursor.getString(cursor.getColumnIndex("topping")).toString()

            var bytesImage = cursor.getBlob(cursor.getColumnIndex("customImage"))

            // 리사이클러뷰 관련 내용
            var myModel = MyModel(name = str_customMenuName, price = str_price, existmenu = str_existingMenuName, profileImage = bytesImage,msize = str_size, mtopping = str_topping,
                mespressoshotnumber = str_espressoShotNumber, msugar = str_sugar, mice = str_ice)
            this.modelList.add(myModel)
            myRecyclerAdapter = MyRecyclerAdapter(this)
            myRecyclerAdapter.submitLiist(this.modelList)
            my_recycler_view.apply {
                layoutManager = LinearLayoutManager(this@GongchaCustomList, LinearLayoutManager.VERTICAL, false)
                adapter = myRecyclerAdapter
            }
        }

        cursor.close()
        sqlitedb.close()
        dbManager.close()

        // 각 브랜드 로고 버튼을 누르면 각 브랜드의 커스텀 리스트를 보여줌
        starbucks_tab_imageButton.setOnClickListener{
            val intent = Intent(this, StarbucksCustomList::class.java)
            startActivity(intent)
        }
        ediya_tab_imageButton.setOnClickListener{
            val intent = Intent(this, EdiyaCustomList::class.java)
            startActivity(intent)
        }
        all_tab_imageButton.setOnClickListener{
            val intent = Intent(this, CustomList::class.java)
            startActivity(intent)
        }
    }

    override fun onItemClicked(position: Int) {
        var name: String? = null
        var price: String? = null
        var msize: String? = null
        var mtopping: String? = null
        var mespressoshotnumber: String? = null
        var existmenu: String? = null
        var msugar: String? = null
        var mice : String? = null

        val title: String = this.modelList[position].name ?: ""
        val mprice: String = this.modelList[position].price ?: ""
        val mSize: String = this.modelList[position].msize ?: ""
        val mTopping: String = this.modelList[position].mtopping ?: ""
        val mespressoshotNumber: String = this.modelList[position].mespressoshotnumber ?: ""
        val existMenu: String = this.modelList[position].existmenu ?: ""
        val mSugar: String = this.modelList[position].msugar ?: ""
        val mIce: String = this.modelList[position].mice ?: ""

        AlertDialog.Builder(this)
            .setTitle(title)
            .setMessage("가격 : $mprice 원\n" +
                    "기존 메뉴 : $existmenu \n" +
                    "사이즈 : $mSize\n" +
                    "에스프레소 샷 갯수 : $mespressoshotNumber \n" +
                    "당도 : $mSugar \n" +
                    "얼음 : $mIce \n" +
                    "토핑 : $mtopping")
            .setPositiveButton("확인"){ dialog, id ->
                Log.d(TAG, "다이얼로그 확인 버튼 클릭")
            }
            .show()
    }
}