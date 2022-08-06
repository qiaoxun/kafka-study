# 本机 Kafka 安装地址
WSL - /home/joey/study/kafka/kafka_2.12-3.2.0
## Quick Start
https://kafka.apache.org/quickstart

## Start Kafka
### Linux
```
bin/zookeeper-server-start.sh config/zookeeper.properties

bin/kafka-server-start.sh config/server.properties
```

### Windows
1. Copy zookeeper.properties, server.properties to bin/windows
2. 在 bin/windows 目录下
   ```
   zookeeper-server-start.bat zookeeper.properties
   kafka-server-start.bat server.properties
   ```
