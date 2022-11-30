server port = 8081

### How to set up and run Kafka
1. Download kafka from https://kafka.apache.org/downloads
    1. Start the ZooKeeper service
       #### Windows:
            .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties

       #### Mac:
           bin/zookeeper-server-start.sh config/zookeeper.properties
    2. Start the Kafka broker service
       #### Windows:
              ./bin/kafka-server-start.bat ./config/server.properties

       #### Mac:
              bin/kafka-server-start.sh config/server.properties