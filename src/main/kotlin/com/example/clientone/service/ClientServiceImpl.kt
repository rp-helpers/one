package com.example.clientone.service

import com.example.clientone.model.ClientModel
import org.slf4j.LoggerFactory
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForObject
import reactor.core.publisher.Flux
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod


@Service
class ClientServiceImpl : ClientService {

    val log = LoggerFactory.getLogger(javaClass)

    override fun getClientFlux(): Flux<ClientModel> {
        log.info("Starting BLOCKING Controller!")
        val result = WebClient.create("http://localhost:8085/clients")
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(ClientModel::class.java)
        log.info("Exiting NON-BLOCKING Controller!")
        return result
        )


    }

    override fun getClient(): List<ClientModel>? {
//        val client = WebClient.create("http://localhost:8080"
        val restTemplate = RestTemplate()
        val fooResourceUrl = "http://localhost:8085/clients"

        return restTemplate.exchange(
                fooResourceUrl,
                HttpMethod.GET,
                null,
                object : ParameterizedTypeReference<List<ClientModel>>() {
                }).body

//        return restTemplate.getForObject(fooResourceUrl) as List<ClientModel>?
//        return restTemplate.getBody(fooResourceUrl, List<ClientModel>::class.java)
    }
}

//https://www.baeldung.com/spring-rest-template-list
//https://www.baeldung.com/spring-rest-template-list