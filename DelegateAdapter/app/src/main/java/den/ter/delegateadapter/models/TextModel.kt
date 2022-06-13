package den.ter.delegateadapter.models

class TextModel(
    private val id: Int,
    private var text: String): DiffItem {
    override fun getId(): Long {
        return id.toLong()
    }

    override fun getHash(): Int {
        return hashCode()
    }

    fun getText() : String{
        return text
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + text.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other==null || javaClass!=other.javaClass) return false

        val dif = other as TextModel
        if(id!= dif.id) return false
        return text.equals(dif.text)
    }
}