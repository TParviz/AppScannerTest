package tj.appscannertest.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import tj.appscannertest.databinding.ActivityMainBinding
import tj.appscannertest.ui.adapter.HomeSettingsAdapter

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapterSettings = HomeSettingsAdapter()
    private val alertListDialogFragment = AlertListDialogFragment()

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
        initObservers()
        if (!alertListDialogFragment.isAdded)
            alertListDialogFragment.show(this@MainActivity.supportFragmentManager)

    }

    private fun initView() = with(binding) {

        rvDeviceSettings.adapter = adapterSettings
    }

    private fun initObservers() = with(viewModel) {
        viewModelScope.launch {
            alertList.observe(this@MainActivity) { list ->
                val newList = list.filter { it.buttonText.isNotBlank() }
                adapterSettings.submitList(newList)

                val alertCountList = list.filter { it.problemsCount > 0 }.sumOf { it.problemsCount }
                binding.tvProblems.text = "$alertCountList Problems"
            }
        }
    }
}