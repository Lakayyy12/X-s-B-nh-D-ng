package com.application.vietlotteryone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var exit = 0

    private var btn1 : Button? = null
    private var btn2 : Button? = null

    //actionbar
    private lateinit var myModelList: ArrayList<MyModel>
    private lateinit var myAdapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            //init actionbar
            loadCards()
            //add page change listener
            viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {

                    //change title of actionbar
                    var title = myModelList[position].title
                }
                override fun onPageSelected(position: Int) {
                }
                override fun onPageScrollStateChanged(state: Int) {
                }
            })
        btn1 = findViewById(R.id.btn1)
        btn1?.setOnClickListener{
            val intent = Intent(this, GuidePage::class.java)
            startActivity(intent)}

        btn2 = findViewById(R.id.btn2)
        btn2?.setOnClickListener{
            val intent = Intent(this, AboutPage::class.java)
            startActivity(intent)}
    }
    private fun loadCards() {
        //init list
        myModelList = ArrayList()

        //add items/data to list
        myModelList.add(MyModel(
            "Trò chơi xổ số Việt Nam",
            R.string.desc1,
            R.drawable.viet))
        myModelList.add(MyModel(
            "Mega 6/45",
            R.string.desc2,
            R.drawable.viet))
        myModelList.add(MyModel(
            "Power 6/55",
            R.string.desc3,
            R.drawable.viet))
        myModelList.add(MyModel(
            "Max 3D",
            R.string.desc4,
            R.drawable.viet))
        myModelList.add(MyModel(
            "Max 4D",
            R.string.desc5,
            R.drawable.viet))
        myModelList.add(MyModel(
            "Keno",
            R.string.desc6,
            R.drawable.viet))


        //setup adapter
        myAdapter = MyAdapter(this, myModelList)

        //set adapter to viewpager
        viewPager.adapter = myAdapter

        // set default padding
        viewPager.setPadding(100,0,100,0)

    }
    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "BẤM ĐÔI ĐỂ Thoát", Toast.LENGTH_SHORT).show()
        } else {
            super.finishAffinity()
        }
    }
}