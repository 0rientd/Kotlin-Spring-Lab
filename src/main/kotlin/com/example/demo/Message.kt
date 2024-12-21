package com.example.demo

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

// data class é definido com o "data" no ínicio da declaração da classe
// Estamos definindo a estrutura de uma classe com ID podendo ser nul mas text não pode ser nulo
@Table("MESSAGES")
data class Message(val text: String, @Id val id: String? = null )