package nyc.ignitelabs.civicduty.views

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_edit_greeting.*
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.viewmodels.MainViewModel

class EditGreetingFragment: Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_edit_greeting, container, false)
    }

    override fun onStart() {
        super.onStart()

        address_edit.text = Editable.Factory.getInstance().newEditable(viewModel.greeting.value)

        save_button.setOnClickListener {
            viewModel.setGreeting(address_edit.text.toString())
        }
    }
}