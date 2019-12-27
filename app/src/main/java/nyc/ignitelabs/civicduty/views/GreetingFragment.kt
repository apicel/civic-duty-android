package nyc.ignitelabs.civicduty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_greeting.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.viewmodels.MainViewModel

class GreetingFragment: Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_greeting, container, false)
    }

    override fun onStart() {
        super.onStart()

        viewModel.greeting.observe(this, Observer {
            address.text = it
        })

        edit_button.setOnClickListener {
            viewModel.startEditing()
        }
    }
}