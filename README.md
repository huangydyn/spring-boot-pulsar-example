Spring Boot Pulsar Example

# docker运行pulsar
```
docker run -it -p 6650:6650  -p 8080:8080  apachepulsar/pulsar:2.10.0 bin/pulsar standalone
```

# api调用
```
 curl "localhost:8081/string?value=1"
```

# 参考
- https://github.com/majusko/pulsar-java-spring-boot-starter
