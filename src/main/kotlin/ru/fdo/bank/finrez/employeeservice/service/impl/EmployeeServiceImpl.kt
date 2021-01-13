package ru.fdo.bank.finrez.employeeservice.service.impl

import org.axonframework.commandhandling.gateway.CommandGateway
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import ru.fdo.bank.finrez.employeeservice.dto.ChangeOfficeDto
import ru.fdo.bank.finrez.employeeservice.dto.ChangePositionDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeNewDto
import ru.fdo.bank.finrez.employeeservice.dto.EmployeeUpdateDto
import ru.fdo.bank.finrez.employeeservice.dto.FireEmployeeDto
import ru.fdo.bank.finrez.employeeservice.service.EmployeeService
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.ChangeOfficeCommand
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.ChangePositionCommand
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.CreateEmployeeCommand
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.FireEmployeeCommand
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.UpdateEmployeeCommand
import java.util.*
import java.util.concurrent.CompletableFuture

@Service
class EmployeeServiceImpl(private val commandGateway: CommandGateway) : EmployeeService{

    private val logger: Logger = LoggerFactory.getLogger(EmployeeServiceImpl::class.java)

    override fun createEmployee(employeeNewDto: EmployeeNewDto): CompletableFuture<UUID> {
        logger.debug("triggered createEmployee: $employeeNewDto")
        return commandGateway.send(CreateEmployeeCommand(UUID.randomUUID().toString(),
                employeeNewDto.lastName,
                employeeNewDto.firstName,
                employeeNewDto.middleName,
                employeeNewDto.position,
                employeeNewDto.dateOfHiring,
                employeeNewDto.officeId))
    }

    override fun updateEmployee(employeeUpdateDto: EmployeeUpdateDto): CompletableFuture<UUID> {
        logger.debug("triggered updateEmployee: $employeeUpdateDto")
        return commandGateway.send(UpdateEmployeeCommand(employeeUpdateDto.employeeId,
                employeeUpdateDto.lastName,
                employeeUpdateDto.firstName,
                employeeUpdateDto.middleName))
    }

    override fun changeOffice(changeOfficeDto: ChangeOfficeDto): CompletableFuture<UUID> {
        logger.debug("triggered changeOffice: $changeOfficeDto")
        return commandGateway.send(ChangeOfficeCommand(changeOfficeDto.employeeId, changeOfficeDto.officeId))
    }

    override fun changePosition(changePositionDto: ChangePositionDto): CompletableFuture<UUID> {
        logger.debug("triggered changePosition: $changePositionDto")
        return commandGateway.send(ChangePositionCommand(changePositionDto.employeeId, changePositionDto.position))
    }

    override fun fireEmployee(fireEmployeeDto: FireEmployeeDto): CompletableFuture<UUID> {
        logger.debug("triggered fireEmployee: $fireEmployeeDto")
        return commandGateway.send(FireEmployeeCommand(fireEmployeeDto.employeeId, fireEmployeeDto.dateOfDismissal))
    }
}