package den.ter.delegateadapter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import den.ter.delegateadapter.models.DiffItem
import den.ter.delegateadapter.R
import den.ter.delegateadapter.models.TextModel

class TextDelegateAdapter :
    AbsListItemAdapterDelegate<TextModel, DiffItem, TextDelegateAdapter.TextViewHolder>() {
    class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.tv)

        fun bind(item: TextModel) {
            name.text = item.getText()
        }
    }

    override fun isForViewType(
        item: DiffItem,
        items: MutableList<DiffItem>,
        position: Int
    ): Boolean {
        return item is TextModel
    }

    override fun onCreateViewHolder(parent: ViewGroup): TextViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
        return TextViewHolder(view)
    }

    override fun onBindViewHolder(
        item: TextModel,
        holder: TextViewHolder,
        payloads: MutableList<Any>
    ) {
        holder.bind(item)
    }
}