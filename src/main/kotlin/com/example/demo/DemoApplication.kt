package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication
// class DemoApplication // Está sendo omitido o corpo da classe "({})" já que não inclui funções ou propriedades

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
