from kafka import KafkaConsumer

consumer = KafkaConsumer(
    'charge', 
    client_id="python",
    group_id='order', 
    bootstrap_servers=['kafka:9092']
)

for msg in consumer:
    print (msg)