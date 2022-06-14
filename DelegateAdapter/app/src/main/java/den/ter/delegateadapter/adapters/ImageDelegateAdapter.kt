package den.ter.delegateadapter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import den.ter.delegateadapter.models.DiffItem
import den.ter.delegateadapter.models.ImageModel
import den.ter.delegateadapter.R

class ImageDelegateAdapter(val context:Context) :
    AbsListItemAdapterDelegate<ImageModel, DiffItem, ImageDelegateAdapter.ImageViewHolder>() {
    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var iv: ImageView = view.findViewById(R.id.iv)

        fun bind(item: ImageModel, context2:Context) {
            Glide.with(context2)
                .load(item.url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .error(R.drawable.ic_launcher_foreground)
                .into(iv)
        }
    }

    override fun isForViewType(
        item: DiffItem,
        items: MutableList<DiffItem>,
        position: Int
    ): Boolean {
        return item is ImageModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }



    override fun onBindViewHolder(
        item: ImageModel,
        holder: ImageViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item, context)
    }
}