package net.kwmt27.jetpackcomposeplayground.livedata

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.kwmt27.jetpackcomposeplayground.R

class MutableLiveDataSampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mutable_live_data_sample)
    }

    companion object {
        fun createIntent(context: Context): Intent {
            return Intent(context, MutableLiveDataSampleActivity::class.java)
        }
    }
}
