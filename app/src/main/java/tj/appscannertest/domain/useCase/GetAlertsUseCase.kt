package tj.appscannertest.domain.useCase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import tj.appscannertest.domain.FlowUseCase
import tj.appscannertest.domain.MainRepository
import tj.appscannertest.domain.models.ScanInfoUi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetAlertsUseCase @Inject constructor(
    private val mainRepository: MainRepository
) {

    suspend operator fun invoke(): Flow<Result<List<ScanInfoUi>>> = flow {
        try {
            emit(Result.success(mainRepository.getAlerts()))
        } catch (exc: Throwable) {
            emit(Result.failure(exc))
        }
    }
}