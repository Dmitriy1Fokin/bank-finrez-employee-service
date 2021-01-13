package ru.fdo.bank.finrez.employeeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
open class EmployeeServiceApplication

fun main(args: Array<String>) {
    runApplication<EmployeeServiceApplication>(*args)
}
