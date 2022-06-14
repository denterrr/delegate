package den.ter.delegateadapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import den.ter.delegateadapter.adapters.ImageDelegateAdapter
import den.ter.delegateadapter.adapters.TextDelegateAdapter
import den.ter.delegateadapter.models.DiffItem

class DiffList(cont:Context) : AsyncListDifferDelegationAdapter<DiffItem>(MyDiffUtil()) {

    init {
        delegatesManager
            .addDelegate(TextDelegateAdapter())
            .addDelegate(ImageDelegateAdapter(context = cont))
    }
    class MyDiffUtil: DiffUtil.ItemCallback<DiffItem>() {
        override fun areItemsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
            return oldItem.getId() == newItem.getId()
        }

        override fun areContentsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
            return oldItem.getHash() == newItem.getHash()
        }

    }

}