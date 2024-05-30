package tj.appscannertest.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext

@Suppress("InjectDispatcher")
interface FlowUseCase<in Input, Output> {
    /**
     * Executes the flow on Dispatchers.IO and wraps exceptions inside it into Result
     */
    operator fun invoke(param: Input): Flow<Result<Output>> =
        execute(param)
            .catch { e -> emit(Result.failure(e)) }
            .flowOn(Dispatchers.IO)

    fun execute(param: Input): Flow<Result<Output>>
}

@Suppress("InjectDispatcher")
interface FlowOrDefaultValueUseCase<in Input, Output> {
    val useCaseDefaultValue: Output

    /**
     * Executes the flow on Dispatchers.IO and return default value in case of errors.
     */
    operator fun invoke(param: Input, defaultValue: Output = useCaseDefaultValue): Flow<Output> = execute(param)
        .catch {
            emit(defaultValue)
        }
        .flowOn(Dispatchers.IO)

    fun execute(param: Input): Flow<Output>
}

@Suppress("InjectDispatcher")
interface SuspendedUseCase<in Input, Output> {
    suspend operator fun invoke(param: Input): Output =
        withContext(Dispatchers.IO) { execute(param) }

    suspend fun execute(param: Input): Output
}