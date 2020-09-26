package android.werner.mysandbox.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.werner.mysandbox.models.MainListObject
import androidx.core.content.ContextCompat
import com.thesurix.gesturerecycler.GestureAdapter
import com.thesurix.gesturerecycler.GestureViewHolder
import kotlinx.android.synthetic.main.main_list.view.*

class MainAdapter(private val clickListener: (String) -> Unit) :
    GestureAdapter<MainListObject, GestureViewHolder<MainListObject>>() {

    class MyViewHolder(view: View) :
        GestureViewHolder<MainListObject>(view) {
        override fun canDrag(): Boolean {
            return true
        }

        override fun canSwipe(): Boolean {
            return true
        }

        override fun bind(item: MainListObject) {
            itemView.tv_main_list_title.text = item.title
        }

        override fun onItemClear() {
            itemView.foreground = null
        }

        override fun onItemSelect() {
            itemView.foreground = ContextCompat.getDrawable(itemView.context, R.drawable.item_select_foreground)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): GestureViewHolder<MainListObject> {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list, parent, false)

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: GestureViewHolder<MainListObject>, position: Int) {
        holder.itemView.tv_main_list_title.text = data[position].title
        holder.itemView.setOnClickListener{
            clickListener.invoke(data[position].id)
        }
    }

    override fun getItemViewType(viewPosition: Int): Int {
        return R.layout.main_list
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = data.size

}
