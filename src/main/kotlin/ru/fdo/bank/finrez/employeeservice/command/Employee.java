package ru.fdo.bank.finrez.employeeservice.command;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.ChangeOfficeCommand;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.ChangePositionCommand;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.CreateEmployeeCommand;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.FireEmployeeCommand;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.command.UpdateEmployeeCommand;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.event.EmployeeCreatedEvent;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.event.EmployeeFiredEvent;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.event.EmployeeUpdatedEvent;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.event.OfficeChangedEvent;
import ru.fdo.bank.finrez.employeeservicecommon.coreapi.event.PositionChangedEvent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Slf4j
@Aggregate
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @AggregateIdentifier
    @Column(name = "employee_id")
    private String employeeId;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "position")
    private String position;
    @Column(name = "date_of_hiring")
    private LocalDate dateOfHiring;
    @Column(name = "date_of_dismissal")
    private LocalDate dateOfDismissal;
    @Column(name = "office_id")
    private String officeId;

    public Employee(){}

    @CommandHandler
    public Employee(CreateEmployeeCommand cmd){
        log.debug("triggered CreateEmployeeCommand: {}", cmd);
        AggregateLifecycle.apply(new EmployeeCreatedEvent(cmd.getEmployeeId(),
                cmd.getLastName(),
                cmd.getFirstName(),
                cmd.getMiddleName(),
                cmd.getPosition(),
                cmd.getDateOfHiring(),
                cmd.getOfficeId()));
    }

    @CommandHandler
    public void handle(UpdateEmployeeCommand cmd){
        log.debug("triggered UpdateEmployeeCommand: {}", cmd);
        AggregateLifecycle.apply(new EmployeeUpdatedEvent(cmd.getEmployeeId(),
                cmd.getLastName(),
                cmd.getFirstName(),
                cmd.getMiddleName()));
    }

    @CommandHandler
    public void handle(ChangeOfficeCommand cmd){
        log.debug("triggered ChangeOfficeCommand: {}", cmd);
        AggregateLifecycle.apply(new OfficeChangedEvent(cmd.getEmployeeId(),
                cmd.getOfficeId()));
    }

    @CommandHandler
    public void handle(ChangePositionCommand cmd){
        log.debug("triggered ChangePositionCommand: {}", cmd);
        AggregateLifecycle.apply(new PositionChangedEvent(cmd.getEmployeeId(),
                cmd.getPosition()));
    }

    @CommandHandler
    public void handle(FireEmployeeCommand cmd){
        log.debug("triggered FireEmployeeCommand: {}", cmd);
        AggregateLifecycle.apply(new EmployeeFiredEvent(cmd.getEmployeeId(),
                cmd.getDateOfDismissal()));
    }

    @EventSourcingHandler
    public void on(EmployeeCreatedEvent event){
        log.debug("triggered EmployeeCreatedEvent: {}", event);
        this.employeeId = event.getEmployeeId();
        this.lastName = event.getLastName();
        this.firstName = event.getFirstName();
        this.middleName = event.getMiddleName();
        this.position = event.getPosition();
        this.dateOfHiring = event.getDateOfHiring();
        this.dateOfDismissal = null;
        this.officeId = event.getOfficeId();
    }

    @EventSourcingHandler
    public void on(EmployeeUpdatedEvent event){
        log.debug("triggered EmployeeUpdatedEvent: {}", event);
        this.lastName = event.getLastName();
        this.firstName = event.getFirstName();
        this.middleName = event.getMiddleName();
    }

    @EventSourcingHandler
    public void on(OfficeChangedEvent event){
        log.debug("triggered OfficeChangedEvent: {}", event);
        this.officeId = event.getOfficeId();
    }

    @EventSourcingHandler
    public void on(PositionChangedEvent event){
        log.debug("triggered PositionChangedEvent: {}", event);
        this.position = event.getPosition();
    }

    @EventSourcingHandler
    public void on(EmployeeFiredEvent event){
        log.debug("triggered EmployeeFiredEvent: {}", event);
        this.dateOfDismissal = event.getDateOfDismissal();
    }

}
