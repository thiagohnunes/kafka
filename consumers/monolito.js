const express = require('express')
const server = express()

const groupId = "monolito"
const topic = "charge"

const { Kafka } = require('kafkajs')

const kafka = new Kafka({
  clientId: 'consumidor001',
  brokers: ['kafka:9092']
})

const consumer = kafka.consumer({ groupId: groupId })

const consume = async () => {
	// first, we wait for the client to connect and subscribe to the given topic
	await consumer.connect()
	await consumer.subscribe({ topic: topic })
	await consumer.run({
		// this function is called every time the consumer gets a new message
		eachMessage: ({ message }) => {
			// here, we just log the message to the standard output
			console.log(`${groupId} - received message: ${message.value}`)
		},
	})
}

consume()