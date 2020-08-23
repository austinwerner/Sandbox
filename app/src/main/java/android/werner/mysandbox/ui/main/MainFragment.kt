package android.werner.mysandbox.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.werner.mysandbox.models.MainListObject
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        viewManager = LinearLayoutManager(requireContext())

        val myDataset = listOf(MainListObject("thing1","Toasts"), MainListObject("thing2", "Other THing"))
        viewAdapter = MainAdapter(
            myDataset,
            clickListener = { id -> handleItemClicked(id) }
        )

        recyclerView = rv_main_feed.apply {
            setHasFixedSize(true)
            layoutManager = viewManager

            val divider = DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
            addItemDecoration(divider)

            adapter = viewAdapter
        }
    }

    private fun handleItemClicked(id: String) {
        Log.d("WERNER", "id = $id")
    }
}