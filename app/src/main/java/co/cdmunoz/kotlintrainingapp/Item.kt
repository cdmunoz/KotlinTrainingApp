package co.cdmunoz.kotlintrainingapp

fun getItems(): List<Item> {
    return (10..19).map { Item(it.toLong(), "Image $it", "https://picsum.photos/400/400/?image=$it") }
}

data class Item(val id: Long, val title: String, val url: String)