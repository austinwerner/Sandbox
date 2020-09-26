package android.werner.mysandbox.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.werner.mysandbox.Util.SNACKBAR_ID
import android.werner.mysandbox.Util.TOAST_ID
import android.werner.mysandbox.models.MainListObject
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.thesurix.gesturerecycler.DefaultItemClickListener
import com.thesurix.gesturerecycler.GestureAdapter
import com.thesurix.gesturerecycler.GestureManager
import com.thesurix.gesturerecycler.RecyclerItemTouchListener
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var gestureManager: GestureManager


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

        val viewAdapter = MainAdapter(
            clickListener = { id -> handleItemClicked(id) }
        )

        viewAdapter.data = viewModel.getData() as MutableList<MainListObject>

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

        recyclerView.addOnItemTouchListener(RecyclerItemTouchListener(object : DefaultItemClickListener<MainListObject>() {

            override fun onItemClick(item: MainListObject, position: Int): Boolean {
                Snackbar.make(view!!, "Click event on the $position position", Snackbar.LENGTH_SHORT).show()
                return true
            }

            override fun onItemLongPress(item: MainListObject, position: Int) {
                Snackbar.make(view!!, "Long press event on the $position position", Snackbar.LENGTH_SHORT).show()
            }

            override fun onDoubleTap(item: MainListObject, position: Int): Boolean {
                Snackbar.make(view!!, "Double tap event on the $position position", Snackbar.LENGTH_SHORT).show()
                return true
            }
        }))

        gestureManager = GestureManager.Builder(recyclerView)
            .setSwipeEnabled(true)
            .setLongPressDragEnabled(true)
            .setSwipeFlags(ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)
            .setDragFlags(ItemTouchHelper.UP or ItemTouchHelper.DOWN)
            .build()

        viewAdapter.setDataChangeListener(object : GestureAdapter.OnDataChangeListener<MainListObject> {
            override fun onItemRemoved(item: MainListObject, position: Int, direction: Int) {
                Snackbar.make(view!!, "Month removed from position $position ", Snackbar.LENGTH_SHORT).show()
            }

            override fun onItemReorder(item: MainListObject, fromPos: Int, toPos: Int) {
                Snackbar.make(view!!, "Month moved from position $fromPos to $toPos", Snackbar.LENGTH_SHORT).show()
            }
        })
    }

    private fun handleItemClicked(id: String) {
        val navId = when (id) {
            TOAST_ID -> {
                R.id.actionMainToToast
            }
            SNACKBAR_ID -> {
                R.id.actionMainToSnackbar
            }
            else -> return // Don't navigate
        }
        findNavController().navigate(navId)
    }
}