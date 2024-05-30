package tj.appscannertest

import tj.appscannertest.domain.models.ScanInfoUi

val problemsList = listOf(
    ScanInfoUi(id = 1, title = "Device info", description = "Show you all info about phone", buttonText = "Scan", problemsCount = 0),
    ScanInfoUi(id = 2, title = "Check for Viruses", description = "Show you all info about phone", buttonText = "Check", problemsCount = 0),
    ScanInfoUi(id = 3, title = "Calibration of sensors", description = "Show you all info about phone", buttonText = "", problemsCount = 0),
    ScanInfoUi(id = 4, title = "App monitoring", description = "Show you all info about phone", buttonText = "", problemsCount = 1),
    ScanInfoUi(id = 5, title = "AntiVirus", description = "Show you all info about phone", buttonText = "", problemsCount = 2),
    ScanInfoUi(id = 6, title = "Device Memory Information", description = "Show you all info about phone", buttonText = "", problemsCount = 3),
    ScanInfoUi(id = 7, title = "File manager", description = "Show you all info about phone", buttonText = "", problemsCount = 0),
    ScanInfoUi(id = 8, title = "Battery info", description = "Show you all info about phone", buttonText = "", problemsCount = 0),
)
