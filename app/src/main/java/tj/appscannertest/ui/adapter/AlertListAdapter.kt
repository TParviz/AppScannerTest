package tj.appscannertest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tj.appscannertest.R
import tj.appscannertest.databinding.ItemDeviceInfoBinding
import tj.appscannertest.domain.models.ScanInfoUi

class AlertListAdapter : ListAdapter<ScanInfoUi, AlertListViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): AlertListViewHolder {
        return AlertListViewHolder(
            binding = ItemDeviceInfoBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AlertListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<ScanInfoUi>() {
            override fun areItemsTheSame(
                oldItem: ScanInfoUi,
                newItem: ScanInfoUi
            ): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: ScanInfoUi,
                newItem: ScanInfoUi
            ): Boolean =
                oldItem == newItem
        }
    }
}

class AlertListViewHolder(
    private val binding: ItemDeviceInfoBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ScanInfoUi) = with(binding) {
        tvTitle.text = item.title
        tvDescription.text = item.description

        tvWaringCount.isVisible = item.problemsCount > 0
        tvWaringCount.text = item.problemsCount.toString()

        if (item.problemsCount > 0)
            parentLayout.setBackgroundResource(R.drawable.bg_warning)
        else
            parentLayout.setBackgroundResource(R.drawable.bg_warning_none)

        when (item.id) {
            1 -> ivAlert.setImageResource(R.drawable.ic_info_rectangle)
            2 -> ivAlert.setImageResource(R.drawable.ic_virus)
            3 -> ivAlert.setImageResource(R.drawable.ic_phone_rotate)
            4 -> ivAlert.setImageResource(R.drawable.ic_object_scan)
            5 -> ivAlert.setImageResource(R.drawable.ic_virus_type)
            6 -> ivAlert.setImageResource(R.drawable.ic_library)
            7 -> ivAlert.setImageResource(R.drawable.ic_file_smile)
            8 -> ivAlert.setImageResource(R.drawable.ic_battery_full)
        }
    }
}