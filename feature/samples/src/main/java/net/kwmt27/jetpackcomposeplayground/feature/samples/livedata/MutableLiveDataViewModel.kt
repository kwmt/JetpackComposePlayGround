package net.kwmt27.jetpackcomposeplayground.feature.samples.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SampleMutableLiveDataViewModel : ViewModel() {
    private val _mutableLiveDataNoConstruct = MutableLiveData<String>()
    val mutableLiveDataNoConstruct: LiveData<String> = _mutableLiveDataNoConstruct
    private val _mutableLiveDataConstruct = MutableLiveData("default arg")
    val mutableLiveDataConstruct: LiveData<String> = _mutableLiveDataConstruct
}
