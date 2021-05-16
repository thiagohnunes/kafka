from kafka import KafkaProducer
from kafka.errors import KafkaError

import time
  
producer = KafkaProducer(bootstrap_servers=['kafka:9092'])

future = producer.send('charge', b'MESSAGE PYTHON')

try:
    record_metadata = future.get(timeout=10)
except KafkaError:
    # Decide what to do if produce request failed...
    log.exception()
    pass

# Successful result returns assigned partition and offset
print (record_metadata.topic)
print (record_metadata.partition)
print (record_metadata.offset)