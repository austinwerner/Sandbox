package android.werner.mysandbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.werner.mysandbox.ui.main.MainFragment
import androidx.navigation.Navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}