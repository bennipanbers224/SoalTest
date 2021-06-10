package com.example.fundtasticstest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager.VERTICAL
import com.example.fundtasticstest.Models.Data
import com.example.fundtasticstest.main.AdapterInterface
import com.example.fundtasticstest.main.DataAdapter
import com.example.fundtasticstest.main.MainViewModel
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        linearLayoutManager = LinearLayoutManager(this)
        saham_list.layoutManager = linearLayoutManager
        saham_list.hasFixedSize()

        getData()

    }

    private fun getData(){
        val mViewModel  = ViewModelProvider(this).get(MainViewModel::class.java)
        mViewModel.getData()?.observe(this, Observer<List<Data>>{
            listData ->
            saham_list.adapter = DataAdapter(this, listData as ArrayList<Data>, object : AdapterInterface{
                override fun click(pos: Int) {
                    Toast.makeText(applicationContext, "Item $pos Clicked", Toast.LENGTH_LONG).show()
                }

            })
        })
    }



}
