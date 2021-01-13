package ru.fdo.bank.finrez.employeeservice.dto

import javax.validation.constraints.NotBlank

data class ChangeOfficeDto(@field:NotBlank val employeeId: String,
                           @field:NotBlank val officeId: String)