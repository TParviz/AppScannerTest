package tj.appscannertest.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tj.appscannertest.data.db.AppDatabase
import tj.appscannertest.domain.MainRepository
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(appDatabase: AppDatabase) = MainRepository(appDatabase)
}