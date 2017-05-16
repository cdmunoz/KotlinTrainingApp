package co.cdmunoz.kotlintrainingapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.recycler
import kotlinx.android.synthetic.main.view_item.view.item_image
import kotlinx.android.synthetic.main.view_item.view.item_title

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    recycler.layoutManager = GridLayoutManager(this, 2)
    recycler.adapter = ItemAdapter(getItems()) { item ->
      val intent = Intent(this, DetailActivity::class.java)
      intent.putExtra(DetailActivity.EXTRA_ID, item.id)
      startActivity(intent)
    }
  }
}

class ItemAdapter(val items: List<Item>,
    val listener: (Item) -> Unit) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

  override fun getItemCount(): Int = items.size

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.view_item))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    with(holder.itemView) {
      item_title.text = items[position].title
      item_image.loadUrl(items[position].url)
      setOnClickListener { listener(items[position]) }
    }
  }

  class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

  }
}
