package tj.appscannertest.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import tj.appscannertest.domain.useCase.GetAlertsUseCase
import tj.appscannertest.domain.useCase.SaveAlertUseCase
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object UseCaseCommon {

    @Singleton
    @Provides
    fun provideGetAlertsUseCase(mainRepository: MainRepository) =
        GetAlertsUseCase(mainRepository)

    @Singleton
    @Provides
    fun provideSaveAlertUseCase(mainRepository: MainRepository) =
        SaveAlertUseCase(mainRepository)
}