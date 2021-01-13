package ru.fdo.bank.finrez.employeeservice.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.fdo.bank.finrez.employeeservice.dto.ChangeOfficeDto
import ru.fdo.bank.finrez.employeeservice.dto.ChangePositionDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeNewDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeUpdateDto
import ru.fdo.bank.finrez.employeeservice.dto.FireEmployeeDto
import ru.fdo.bank.finrez.employeeservice.service.EmployeeService
import java.util.*
import java.util.concurrent.CompletableFuture
import javax.validation.Valid

@RestController
@RequestMapping("/emp/cmd")
class EmployeeController(private val employeeService: EmployeeService) {

    @PostMapping("/create")
    fun createEmployee(@Valid @RequestBody employeeNewDto: EmployeeNewDto) : CompletableFuture<UUID> =
            employeeService.createEmployee(employeeNewDto)

    @PostMapping("/update")
    fun updateEmployee(@Valid @RequestBody employeeUpdateDto: EmployeeUpdateDto) : CompletableFuture<UUID> =
            employeeService.updateEmployee(employeeUpdateDto)

    @PostMapping("/office")
    fun changeOffice(@Valid @RequestBody changeOfficeDto: ChangeOfficeDto) : CompletableFuture<UUID> =
            employeeService.changeOffice(changeOfficeDto)

    @PostMapping("/position")
    fun changePosition(@Valid @RequestBody changePositionDto: ChangePositionDto) : CompletableFuture<UUID> =
            employeeService.changePosition(changePositionDto)

    @PostMapping("/fire")
    fun fireEmployee(@Valid @RequestBody fireEmployeeDto: FireEmployeeDto) : CompletableFuture<UUID> =
            employeeService.fireEmployee(fireEmployeeDto)
}