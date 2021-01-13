package ru.fdo.bank.finrez.employeeservice.dto

import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class FireEmployeeDto(@field:NotBlank val employeeId: String,
                           @field:NotNull val dateOfDismissal: LocalDate)