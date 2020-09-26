package android.werner.mysandbox.ui.main

import android.werner.mysandbox.Util.*
import android.werner.mysandbox.models.MainListObject
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun getData(): List<MainListObject> {
        return listOf(
            MainListObject(TOAST_ID),
            MainListObject(SNACKBAR_ID)
        )
    }
}