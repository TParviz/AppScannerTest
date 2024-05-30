package tj.appscannertest.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import tj.appscannertest.domain.models.ScanInfoUi
import tj.appscannertest.domain.useCase.GetAlertsUseCase
import tj.appscannertest.domain.useCase.SaveAlertUseCase
import tj.appscannertest.problemsList
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAlertsUseCase: GetAlertsUseCase,
    private val saveAlertsUseCase: SaveAlertUseCase
) : ViewModel() {

    private val _alertList = MutableLiveData<List<ScanInfoUi>>()
    val alertList: LiveData<List<ScanInfoUi>> = _alertList

    init {
        getAlertsFromDB()
    }

    private fun addSomeAlerts() {
        viewModelScope.launch {
            problemsList.forEach {
                saveAlertsUseCase.invoke(it)
            }
            getAlertsFromDB()
        }
    }

    private fun getAlertsFromDB() {
        viewModelScope.launch {
            getAlertsUseCase().collect { result ->
                result.onFailure {
                    Log.d("TAG_GETALERTS", "error: ${it.printStackTrace()}")
                }.onSuccess { response ->
                    _alertList.value = response
                    if (response.isEmpty())
                        addSomeAlerts()
                    Log.d("TAG_GETALERTS", "response: $response")
                }
            }
        }
    }
}