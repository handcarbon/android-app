package eu.vonamor.learning.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import eu.vonamor.learning.network.OperatorApi
import eu.vonamor.learning.network.Status
import kotlinx.coroutines.launch

enum class ApiStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<ApiStatus>()

    // The external immutable LiveData for the request status
    val status: LiveData<ApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _data = MutableLiveData<Status>()

    // The external LiveData interface to the property is immutable, so only this class can modify
    val data: LiveData<Status> = _data


    val entryId = MutableLiveData<String>()
    fun data(e: String) {
        entryId.value = e
    }

    init {
        getStatus()
    }

    private fun getStatus() {
        viewModelScope.launch {
            try {
                _data.value = OperatorApi.retrofitService.getStatus()
                _status.value = ApiStatus.DONE
            } catch (e: Exception) {
                _status.value = ApiStatus.ERROR
                //_data.value =
            }
        }
    }
}