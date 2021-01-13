package ru.fdo.bank.finrez.employeeservice.dto

import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class EmployeeNewDto(@field:NotBlank val lastName: String,
                          @field:NotBlank val firstName: String,
                          val middleName: String,
                          @field:NotBlank val position: String,
                          @field:NotNull val dateOfHiring: LocalDate,
                          @field:NotBlank val officeId: String)