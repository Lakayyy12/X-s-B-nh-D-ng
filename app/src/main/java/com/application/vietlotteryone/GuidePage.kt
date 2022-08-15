package com.application.vietlotteryone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GuidePage : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<Details>

    private lateinit var imageId : Array<Int>
    private lateinit var heading : Array<String>
    private lateinit var briefNews : Array<String>

    private var btnS : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guide_page)

        imageId = arrayOf(R.drawable.ic_money, R.drawable.ic_money, R.drawable.ic_money,
            R.drawable.ic_money, R.drawable.ic_money
        )
        heading = arrayOf(
            getString(R.string.gp1),
            getString(R.string.gp2),
            getString(R.string.gp3),
            getString(R.string.gp4),
            getString(R.string.gp5)
        )
        briefNews = arrayOf(
            getString(R.string.gp01),
            getString(R.string.gp02),
            getString(R.string.gp03),
            getString(R.string.gp04),
            getString(R.string.gp05),
        )
        newRecyclerView = findViewById(R.id.recyclerItems)
        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)

        newArrayList = arrayListOf<Details>()
        getUserdata()

        btnS = findViewById(R.id.btnS)
        btnS?.setOnClickListener{
            onBackPressed()
        }
    }
    private fun getUserdata() {

        for(i in imageId.indices){

            val news = Details(imageId[i], heading[i],briefNews[i])
            newArrayList.add(news)
        }
        val adapter = MyAdapter2(newArrayList)
        newRecyclerView.adapter = adapter
    }
}