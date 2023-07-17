package net.kwmt27.jetpackcomposeplayground.livedata

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import net.kwmt27.jetpackcomposeplayground.R

class MutableLiveDataSampleActivity :
    AppCompatActivity(R.layout.activity_mutable_live_data_sample) {
    private val viewModel: SampleMutableLiveDataViewModel by viewModels()

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = findViewById<TextView>(R.id.textView)
        val textView2 = findViewById<TextView>(R.id.textView2)
        val text = "onCreate"
        viewModel.mutableLiveDataNoConstruct.observe(this) {
            textView.text = "$text\nMutableLiveData(no construct)"
        }
        viewModel.mutableLiveDataConstruct.observe(this) {
            textView2.text = "$text\nMutableLiveData(デフォルト引数あり)\n$it"
        }
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MutableLiveDataSampleActivity::class.java)
        }
    }
}
