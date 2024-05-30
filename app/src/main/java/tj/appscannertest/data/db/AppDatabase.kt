package tj.appscannertest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import tj.appscannertest.data.db.scanInfo.ScanInfoDAO
import tj.appscannertest.data.db.scanInfo.ScanInfoEntity

@Database(
    entities = [ScanInfoEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scanInfoDao(): ScanInfoDAO
}