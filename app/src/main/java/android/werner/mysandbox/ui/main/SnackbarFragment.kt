package android.werner.mysandbox.ui.main

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.werner.mysandbox.R
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.custom_toast.*
import kotlinx.android.synthetic.main.custom_toast.view.*
import kotlinx.android.synthetic.main.fragment_toast.*

class SnackbarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_snackbar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpButtons()
    }

    private fun setUpButtons() {
        handleButton1()
        handleButton2()
        handleButton3()
        handleButton4()
    }

    private fun handleButton1() {
        btn_snackbar1.text = "Simple Snackbar"
        btn_snackbar1.setOnClickListener {
            Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "This is a simple snackbar",
                Snackbar.LENGTH_SHORT
            ).show()
        }
    }

    private fun handleButton2() {
        btn_snackbar2.text = "Snackbar with dismiss"
        btn_snackbar2.setOnClickListener {
            val snackbar = Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "This is a dismissible snackbar",
                Snackbar.LENGTH_INDEFINITE
            )
            snackbar.setAction("Dismiss") {
                snackbar.dismiss()
            }
            snackbar.show()
        }
    }

    private fun handleButton3() {
        btn_snackbar3.text = "Orange snackbar"
        btn_snackbar3.setOnClickListener {
            val snackbar = Snackbar.make(
                requireActivity().findViewById(android.R.id.content),
                "This is an orange snackbar",
                Snackbar.LENGTH_LONG
            )
            snackbar.view.setBackgroundColor(
                ContextCompat.getColor(requireActivity(), android.R.color.holo_orange_dark)
            )
            snackbar.show()
        }
    }

    private fun handleButton4() {
        btn_snackbar4.text = "Custom Toast"
        btn_snackbar4.setOnClickListener {

        }
    }
}