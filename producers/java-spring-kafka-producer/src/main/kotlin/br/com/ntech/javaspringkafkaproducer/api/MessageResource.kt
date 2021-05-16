package br.com.ntech.javaspringkafkaproducer.api

import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/message")
class MessageResource(
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @GetMapping("/{message}")
    fun get(@PathVariable("message") message: String): ResponseEntity<String> {
        kafkaTemplate.send("charge", message)
        return ResponseEntity.ok(message)
    }
}