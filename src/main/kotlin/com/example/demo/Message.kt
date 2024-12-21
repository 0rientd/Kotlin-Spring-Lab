package com.example.demo

// data class é definido com o "data" no ínicio da declaração da classe
// Estamos definindo a estrutura de uma classe com ID podendo ser nul mas text não pode ser nulo
data class Message(val id: String?, val text: String)