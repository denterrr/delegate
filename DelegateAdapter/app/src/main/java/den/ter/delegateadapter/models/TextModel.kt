package den.ter.delegateadapter.models

data class TextModel(
    val id: Int,
    var text: String
):DiffItem {
    override fun getId(): Long {
        return id.toLong()
    }

    override fun getHash(): Int {
        return id + text.length
    }
}