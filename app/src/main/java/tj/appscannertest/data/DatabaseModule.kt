package tj.appscannertest.data

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tj.appscannertest.data.db.AppDatabase
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): AppDatabase =
        Room.databaseBuilder(application, AppDatabase::class.java, "tableScan.db")
            .build()
}