package tj.appscannertest.domain.useCase

import tj.appscannertest.domain.MainRepository
import tj.appscannertest.domain.models.ScanInfoUi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SaveAlertUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {
    suspend operator fun invoke(info: ScanInfoUi) {
        mainRepository.saveAlert(info)
    }
}