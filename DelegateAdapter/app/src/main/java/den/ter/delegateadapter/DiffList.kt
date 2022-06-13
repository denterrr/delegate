package den.ter.delegateadapter

import android.content.Context
import androidx.recyclerview.widget.DiffUtil
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import den.ter.delegateadapter.adapters.ImageDelegateAdapter
import den.ter.delegateadapter.adapters.TextDelegateAdapter
import den.ter.delegateadapter.models.DiffItem

class DiffList(cont:Context) : AsyncListDifferDelegationAdapter<DiffItem>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<DiffItem> =
            object : DiffUtil.ItemCallback<DiffItem>() {
                override fun areItemsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                    return oldItem.getId() == newItem.getId()
                }

                override fun areContentsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                    return oldItem.getHash() == newItem.getHash()
                }

            }
    }

    init {
        delegatesManager
            .addDelegate(TextDelegateAdapter())
            .addDelegate(ImageDelegateAdapter(context = cont))
    }
    private val DIFF_CALLBACK: DiffUtil.ItemCallback<DiffItem> =
        object : DiffUtil.ItemCallback<DiffItem>() {
            override fun areItemsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                return oldItem.getId() == newItem.getId()
            }

            override fun areContentsTheSame(oldItem: DiffItem, newItem: DiffItem): Boolean {
                return oldItem.getHash() == newItem.getHash()
            }

        }

}