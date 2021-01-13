package ru.fdo.bank.finrez.employeeservice.service

import ru.fdo.bank.finrez.employeeservice.dto.ChangeOfficeDto
import ru.fdo.bank.finrez.employeeservice.dto.ChangePositionDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeNewDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeUpdateDto
import ru.fdo.bank.finrez.employeeservice.dto.FireEmployeeDto
import java.util.*
import java.util.concurrent.CompletableFuture

interface EmployeeService {
    fun createEmployee(employeeNewDto: EmployeeNewDto) : CompletableFuture<UUID>
    fun updateEmployee(employeeUpdateDto: EmployeeUpdateDto) : CompletableFuture<UUID>
    fun changeOffice(changeOfficeDto: ChangeOfficeDto) : CompletableFuture<UUID>
    fun changePosition(changePositionDto: ChangePositionDto) : CompletableFuture<UUID>
    fun fireEmployee(fireEmployeeDto: FireEmployeeDto) : CompletableFuture<UUID>
}