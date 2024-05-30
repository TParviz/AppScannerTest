package tj.appscannertest.ui

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import tj.appscannertest.databinding.AlertListFragmentBinding
import tj.appscannertest.ui.adapter.AlertListAdapter

@AndroidEntryPoint
class AlertListDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: AlertListFragmentBinding
    private val viewModel: MainViewModel by viewModels()

    private val adapterAlerts = AlertListAdapter()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = BottomSheetDialog(requireContext(), theme)
        dialog.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val parentLayout = bottomSheetDialog
                .findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            parentLayout?.let { parent ->
                BottomSheetBehavior.from(parent).apply {
                    state = BottomSheetBehavior.STATE_COLLAPSED
                    peekHeight = 600
                    isCancelable = false
                    maxHeight = 1600
                }
            }
        }
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = AlertListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeViewModel()
        initViews()
    }

    private fun initViews() = with(binding) {
        rvAlerts.adapter = adapterAlerts

    }

    private fun observeViewModel() = with(viewModel) {
        alertList.observe(viewLifecycleOwner) {
            adapterAlerts.submitList(it)
        }
    }

    fun show(childFragmentManager: FragmentManager) {
        show(childFragmentManager, "AlertListDialogFragment")
    }
}