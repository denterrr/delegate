package den.ter.delegateadapter.models

data class ImageModel(
    val id: Int,
    val url: String
): DiffItem {
    override fun getId(): Long {
        return id.toLong()
    }

    override fun getHash(): Int {
        return id+url.length
    }
}