package ru.fdo.bank.finrez.employeeservice.dto

import javax.validation.constraints.NotBlank

data class EmployeeUpdateDto(@field:NotBlank val employeeId: String,
                             @field:NotBlank val lastName: String,
                             @field:NotBlank val firstName: String,
                             val middleName: String)