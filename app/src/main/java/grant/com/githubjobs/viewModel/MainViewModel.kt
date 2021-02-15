package grant.com.githubjobs.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import grant.com.githubjobs.model.Job
import grant.com.githubjobs.remote.JobRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel(){
    private val _jobs = MutableLiveData<List<Job>>()
    val jobs :LiveData<List<Job>> = _jobs

    private val _description = MutableLiveData<String>()
    val description:LiveData<String> get()= _description

    private val _location = MutableLiveData<String>()
    val location:LiveData<String> get()= _location

    fun getJobs() {
        viewModelScope.launch(Dispatchers.IO) { _jobs.postValue(JobRepo.getJobs()) }
    }
    fun getJobsByDescription(description : String) {
        viewModelScope.launch(Dispatchers.IO) { _jobs.postValue(JobRepo.getJobsByDescription(description)) }
    }
    fun getJobsByLocation(location:String) {
        viewModelScope.launch(Dispatchers.IO) { _jobs.postValue(JobRepo.getJobsByLocation(location)) }
    }
    fun getJobsByDescriptionAndLocation(description: String, location: String) {
        viewModelScope.launch(Dispatchers.IO) { _jobs.postValue(JobRepo.getJobs(description, location)) }
    }

    fun setJob(description: String, location: String) {
        if(description.isNullOrBlank()){
            _description.value = ""
        }else{
            _description.value = description
        }
        if(location.isNullOrBlank()){
            _location.value = ""
        }else{
            _location.value = location
        }
    }
}