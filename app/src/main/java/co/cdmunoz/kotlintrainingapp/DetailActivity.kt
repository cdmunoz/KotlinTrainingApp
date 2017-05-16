package co.cdmunoz.kotlintrainingapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.item_image
import kotlinx.android.synthetic.main.activity_detail.item_title

class DetailActivity : AppCompatActivity() {

  companion object {
    val EXTRA_ID = "DetailActivity:id"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    val id = intent.getLongExtra(EXTRA_ID, -1)
    val item = getItems().firstOrNull { it.id == id }

    if (null != item) {
      item_image.loadUrl(item.url)
      item_title.text = item.title
    }
  }
}
