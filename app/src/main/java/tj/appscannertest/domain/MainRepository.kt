package tj.appscannertest.domain

import tj.appscannertest.data.db.AppDatabase
import tj.appscannertest.domain.models.ScanInfoUi
import tj.appscannertest.domain.models.toEntity
import tj.appscannertest.domain.models.toUi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(
    private val appDatabase: AppDatabase
) {
    suspend fun saveAlert(info: ScanInfoUi) {
        appDatabase.scanInfoDao().insertAlert(info.toEntity())
    }

    suspend fun getAlerts(): List<ScanInfoUi> {
        return appDatabase.scanInfoDao().getAlerts().map { it.toUi() }
    }

    suspend fun deleteSearchHistory() {
        appDatabase.scanInfoDao().deleteAll()
    }
}