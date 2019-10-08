package com.example.clientone.controller

import com.example.clientone.service.ClientService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class ClientController(private val clientService: ClientService) {

    @GetMapping("/take")
    fun getClient() = clientService.getClient()

    @GetMapping("/take/flux", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getClientMono() = clientService.getClientFlux()
}

//https://www.baeldung.com/spring-webclient-resttemplate