package den.ter.delegateadapter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import den.ter.delegateadapter.models.DiffItem
import den.ter.delegateadapter.models.ImageModel
import den.ter.delegateadapter.models.TextModel
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var rv: RecyclerView
    lateinit var adapter: DiffList
    var curList = ArrayList<DiffItem>()
    lateinit var btn: Button

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = DiffList(applicationContext)
        rv = findViewById(R.id.list)
        rv.adapter= adapter
        rv.layoutManager = LinearLayoutManager(this)

        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
            adapter.items = addItem()
            adapter.notifyDataSetChanged()
        }
    }

    override fun onStart() {
        super.onStart()
        adapter.items = getItems()
    }

    private fun getItems(): List<DiffItem>{
        val list2 = ArrayList<DiffItem>()
        list2.add(TextModel(0,"text1"))
        list2.add(TextModel(1,"text2"))
        list2.add(TextModel(2,"text3"))
        list2.add(ImageModel(3,"https://www.wallpaperflare.com/static/204/345/205/cat-grass-lie-down-striped-wallpaper.jpg"))
        list2.add(TextModel(4,"text4"))
        list2.shuffle()
        curList = list2
        return curList
    }

    private fun addItem() : List<DiffItem>{
        val list2 = curList
        list2.add(TextModel(5,"Text5"))
        curList = list2
        return curList
    }


}