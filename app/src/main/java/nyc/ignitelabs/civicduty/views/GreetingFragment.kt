package nyc.ignitelabs.civicduty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import nyc.ignitelabs.civicduty.databinding.FragmentGreetingBinding
import nyc.ignitelabs.civicduty.viewmodels.MainViewModel

class GreetingFragment: Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentGreetingBinding.inflate(inflater, container, false).apply {
            vm = viewModel
            lifecycleOwner = this@GreetingFragment
        }.root
    }
}