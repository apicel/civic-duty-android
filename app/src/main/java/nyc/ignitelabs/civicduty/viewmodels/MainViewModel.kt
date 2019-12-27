package nyc.ignitelabs.civicduty.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _greeting = MutableLiveData<String>("Hello World!")

    private val _isEditing = MutableLiveData<Boolean>(false)

    val greeting: MutableLiveData<String>
        get() = _greeting

    val isEditing: LiveData<Boolean>
        get() = _isEditing

    fun startEditing() {
        _isEditing.value = true
    }

    fun endEditing() {
        _isEditing.value = false
    }
}