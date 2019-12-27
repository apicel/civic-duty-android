package nyc.ignitelabs.civicduty.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        viewModel.isEditing.observe(this, Observer {
            if (it) {
                startEditing()
            } else {
                endEditing()
            }
        })
    }

    private fun startEditing() {
        val editGreetingFragment = EditGreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(activity_main.id, editGreetingFragment)
            addToBackStack(null)
            commit()
        }
    }

    private fun endEditing() {
        val greetingFragment = GreetingFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(activity_main.id, greetingFragment)
            addToBackStack(null)
            commit()
        }
    }
}
