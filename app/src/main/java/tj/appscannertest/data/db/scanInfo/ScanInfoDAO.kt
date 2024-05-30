package tj.appscannertest.data.db.scanInfo

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ScanInfoDAO {

    @Query("SELECT * FROM scaninfoentity ")
    suspend fun getAlerts(): List<ScanInfoEntity>

    @Query("DELETE FROM scaninfoentity;")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlert(info: ScanInfoEntity)
}