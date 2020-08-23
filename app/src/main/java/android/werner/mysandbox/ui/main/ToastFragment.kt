package android.werner.mysandbox.ui.main

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.custom_toast.view.*
import kotlinx.android.synthetic.main.fragment_toast.*

class ToastFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toast, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpButtons()
    }

    private fun setUpButtons() {
        handleShortToast()
        handleTopToast()
        handleLeftToast()
        handleCustomToast()
    }

    private fun handleShortToast() {
        btn_toast1.text = "Short Toast"
        btn_toast1.setOnClickListener {
            val text = "This is a short toast message!"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(requireContext(), text, duration)
            toast.show()
        }
    }

    private fun handleTopToast() {
        btn_toast2.text = "Top Toast"
        btn_toast2.setOnClickListener {
            val text = "This toast is on the top"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(requireContext(), text, duration)
            toast.setGravity(Gravity.TOP, 0, 0)
            toast.show()
        }
    }

    private fun handleLeftToast() {
        btn_toast3.text = "Left Toast"
        btn_toast3.setOnClickListener {
            val text = "This toast is on the left"
            val duration = Toast.LENGTH_SHORT
            val toast = Toast.makeText(requireContext(), text, duration)
            toast.setGravity(Gravity.LEFT, 0, 0)
            toast.show()
        }
    }

    private fun handleCustomToast() {
        btn_toast4.text = "Custom Toast"
        btn_toast4.setOnClickListener {
            val layout = layoutInflater.inflate(R.layout.custom_toast, custom_toast_container)
            layout.tv_toast_title.text = "A custom toast woohoo!"
            with (Toast(requireActivity().applicationContext)) {
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }
    }
}