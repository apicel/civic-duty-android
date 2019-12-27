package nyc.ignitelabs.civicduty.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import nyc.ignitelabs.civicduty.R
import nyc.ignitelabs.civicduty.databinding.FragmentGreetingBinding
import nyc.ignitelabs.civicduty.viewmodels.MainViewModel

class GreetingFragment: Fragment() {
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentGreetingBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_greeting, container, false)
        binding.vm = viewModel

        return binding.root
    }
}