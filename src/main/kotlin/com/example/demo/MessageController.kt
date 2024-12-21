package com.example.demo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

// Exemplo de request
// curl -X POST --location "http://localhost:8080" -H "Content-Type: application/json" -d "{ \"id\": \"1\", \"text\": \"Privet\!\" }"
// curl -X POST --location "http://localhost:8080" -H "Content-Type: application/json" -d "{ \"text\": \"Hello\!\" }"
@RestController
@RequestMapping("/")
class MessageController(private val service: MessageService) {
    @GetMapping
    fun listMessages() = service.findMessages()

    @PostMapping
    fun post(@RequestBody message: Message): ResponseEntity<Message> {
        val savedMessage = service.save(message)
        return ResponseEntity.created(URI("/${savedMessage.id}")).body(savedMessage)
    }

    @GetMapping("/{id}")
    fun getMessage(@PathVariable id: String): ResponseEntity<Message> = service.findMessageById(id).toResponseEntity()

    // Se a mensagem for nula (não encontrado), colocar o código de resposta para 404
    private fun Message?.toResponseEntity(): ResponseEntity<Message> = this?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
}