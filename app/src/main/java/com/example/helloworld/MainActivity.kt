package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data = arrayOf("關於Android Tutorial的事情",
            "一隻非常可愛的小狗狗!", "一首非常好聽的音樂！")
        val layoutId = android.R.layout.simple_list_item_1
        val adapter = ArrayAdapter(this, layoutId, data)

        val itemList: ListView = findViewById(R.id.item_list) // find android:id from res.layout folder.
        itemList.setAdapter(adapter)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
