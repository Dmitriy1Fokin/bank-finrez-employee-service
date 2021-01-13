package ru.fdo.bank.finrez.employeeservice.dto

import javax.validation.constraints.NotBlank

data class ChangePositionDto(@field:NotBlank val employeeId: String,
                             @field:NotBlank val position: String)