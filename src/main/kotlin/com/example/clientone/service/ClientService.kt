package com.example.clientone.service

import com.example.clientone.model.ClientModel
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ClientService {
    fun getClient(): List<ClientModel>?
    fun getClientFlux(): Flux<ClientModel>
}