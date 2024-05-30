package tj.appscannertest.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tj.appscannertest.R
import tj.appscannertest.databinding.ItemDeviceSettingsBinding
import tj.appscannertest.domain.models.ScanInfoUi

class HomeSettingsAdapter : ListAdapter<ScanInfoUi, HomeSettingsViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeSettingsViewHolder {
        return HomeSettingsViewHolder(
            binding = ItemDeviceSettingsBinding.inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeSettingsViewHolder, position: Int) {
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

class HomeSettingsViewHolder(
    private val binding: ItemDeviceSettingsBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ScanInfoUi) = with(binding) {
        tvTitle.text = item.title
        tvDescription.text = item.description
        btnAction.text = item.buttonText

        when (item.id) {
            1 -> ivDeviceItem.setImageResource(R.drawable.ic_device)
            2 -> ivDeviceItem.setImageResource(R.drawable.ic_virus)
        }
    }
}