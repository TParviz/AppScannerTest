package tj.appscannertest.data.db.scanInfo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ScanInfoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val buttonText: String,
    val problemsCount: Int
)