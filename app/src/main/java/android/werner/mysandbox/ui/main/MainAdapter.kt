package android.werner.mysandbox.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.werner.mysandbox.models.MainListObject
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_list.view.*

class MainAdapter(private val myDataset: List<MainListObject>,
    private val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<MainAdapter.MyViewHolder>() {

    class MyViewHolder(val view: View) :
        RecyclerView.ViewHolder(view)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_list, parent, false)

        return MyViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.view.tv_main_list_title.text = myDataset[position].title
        holder.view.setOnClickListener{
            clickListener.invoke(myDataset[position].id)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size

}
