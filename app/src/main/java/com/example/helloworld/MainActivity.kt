package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private val itemList : ListView by bind(R.id.item_list)
    private val showAppName: TextView by bind(R.id.show_app_name)
    private val data = arrayOf("關於Android Tutorial的事情",
        "一隻非常可愛的小狗狗!", "一首非常好聽的音樂！")
    private val adapter : ArrayAdapter<String>
            by lazy { ArrayAdapter(this, android.R.layout.simple_list_item_1, data) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 呼叫自己額外宣告的函式，執行所有註冊的工作
        processControllers();
        itemList.adapter = adapter
    }

    private fun processControllers() {
        // 建立點擊監聽物件
        val listener = View.OnClickListener {
            val d = AlertDialog.Builder(this@MainActivity)
            d.setTitle(R.string.app_name)
                .setMessage(R.string.about)
                .show()
        }
        // 註冊點擊監聽物件
        showAppName.setOnClickListener(listener)

        //Long click example
        // 建立點擊監聽物件
        val longListener = View.OnLongClickListener {
            val d = AlertDialog.Builder(this@MainActivity)
            d.setTitle(R.string.app_name)
                .setMessage("Long Click: ${getString(R.string.about)}")
                .show()
            false
        }
        // 註冊點擊監聽物件
        showAppName.setOnLongClickListener(longListener)

        //Item click example
        val itemListener = AdapterView.OnItemClickListener {
            // parent: 使用者操作的ListView物件
            // view: 使用者選擇的項目
            // position: 使用者選擇的項目編號，第一個是0
            // id: 在這裡沒有用途
                parent, view, position, id ->
            Toast.makeText(this@MainActivity,
                data[position], Toast.LENGTH_LONG).show()
        }
        // 註冊選單項目點擊監聽物件
        itemList.setOnItemClickListener(itemListener)

        //Item long click example
        val itemLongListener = AdapterView.OnItemLongClickListener {
            // parent: 使用者操作的ListView物件
            // view: 使用者選擇的項目
            // position: 使用者選擇的項目編號，第一個是0
            // id: 在這裡沒有用途
                parent, view, position, id ->
            Toast.makeText(this@MainActivity,
                "Long click : ${data[position]}", Toast.LENGTH_LONG).show()
            false
        }
        // 註冊選單項目長按監聽物件
        itemList.setOnItemLongClickListener(itemLongListener)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    // 函式名稱與onClick的設定一樣，參數的型態是android.view.View
    fun aboutApp(view: View) {
        // Toast.makeText : 顯示訊息框，指定三個參數
        // Context：通常指定為「this」
        // String或int：設定顯示在訊息框裡面的訊息或文字資源
        // int：設定訊息框停留在畫面的時間
        Toast.makeText(this, R.string.app_name, Toast.LENGTH_LONG).show()
    }

    // 使用者選擇所有的選單項目都會呼叫這個函式
    fun clickMenuItem(item: MenuItem) {
        // 使用參數取得使用者選擇的選單項目元件編號
        val itemId = item.getItemId()

        // 判斷該執行什麼工作，目前還沒有加入需要執行的工作
        when (itemId) {
            R.id.search_item -> {
            }
            R.id.add_item -> {
            }
            R.id.revert_item -> {
            }
            R.id.delete_item -> {
            }
        }

        // 測試用的程式碼，完成測試後記得移除
        val dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("MenuItem Test")
            .setMessage(item.getTitle())
            .setIcon(item.getIcon())
            .show()
    }


}


