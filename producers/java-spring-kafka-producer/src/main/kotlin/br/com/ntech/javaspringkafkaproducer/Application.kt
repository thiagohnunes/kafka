package br.com.ntech.javaspringkafkaproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@EnableKafka
@SpringBootApplication
class JavaSpringKafkaProducerApplication

fun main(args: Array<String>) {
    runApplication<JavaSpringKafkaProducerApplication>(*args)
}
