package den.ter.delegateadapter.models

class ImageModel (
    private val id: Int,
    private var imageUrl: String,
    val i: Int
): DiffItem {
    override fun getId(): Long {
        return id.toLong()
    }

    override fun getHash(): Int {
        return hashCode()
    }

    fun getUrl() : String{
        return imageUrl
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + imageUrl.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        if(other==null || javaClass!=other.javaClass) return false

        val dif = other as ImageModel
        if(id!= dif.id) return false
        return imageUrl == dif.imageUrl
    }

}