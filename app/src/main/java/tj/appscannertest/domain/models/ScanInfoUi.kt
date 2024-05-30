package tj.appscannertest.domain.models

import tj.appscannertest.data.db.scanInfo.ScanInfoEntity

data class ScanInfoUi(
    val id: Int,
    val title: String,
    val description: String,
    val buttonText: String,
    val problemsCount: Int = 0
)

fun ScanInfoUi.toEntity(): ScanInfoEntity {
    return ScanInfoEntity(
        id = id,
        title = title,
        description = description,
        buttonText = buttonText,
        problemsCount = problemsCount
    )
}

fun ScanInfoEntity.toUi(): ScanInfoUi {
    return ScanInfoUi(
        id = id,
        title = title,
        description = description,
        buttonText = buttonText,
        problemsCount = problemsCount
    )
}