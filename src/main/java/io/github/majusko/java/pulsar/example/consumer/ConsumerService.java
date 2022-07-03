package io.github.majusko.java.pulsar.example.consumer;

import io.github.majusko.java.pulsar.example.configuration.Topics;
import io.github.majusko.java.pulsar.example.data.MyMsg;
import io.github.majusko.pulsar.annotation.PulsarConsumer;
import org.apache.pulsar.client.api.SubscriptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    private Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    // shared
    @PulsarConsumer(subscriptionName = "subscription1", topic = Topics.STRING, clazz = String.class, subscriptionType = SubscriptionType.Shared)
    public void sharedConsumer1String(String message) {
        logger.info("[Consume Message]  consumer-1 subscriptionName subscription1 topic {} message {}", Topics.STRING, message);
        if (message.equals("1")) {
            throw new RuntimeException("application unhanded msg");
        }
    }

    @PulsarConsumer(subscriptionName = "subscription1", topic = Topics.STRING, clazz = String.class, subscriptionType = SubscriptionType.Shared)
    public void sharedConsumer2String(String message) {
        logger.info("[Consume Message]  consumer-2 subscriptionName subscription1  topic {} message {}", Topics.STRING, message);
    }

    // failover
    @PulsarConsumer(subscriptionName = "subscription2", topic = Topics.STRING, clazz = String.class, subscriptionType = SubscriptionType.Failover)
    public void mainConsumerString(String message) {
        logger.info("[Consume Message]  consumer-main subscriptionName subscription2  topic {} message {}", Topics.STRING, message);
    }

    @PulsarConsumer(subscriptionName = "subscription2", topic = Topics.STRING, clazz = String.class, subscriptionType = SubscriptionType.Failover)
    public void failedOverConsumerString(String message) {
        logger.info("[Consume Message] consumer-faileover subscriptionName subscription2 topic {} message {}", Topics.STRING, message);
    }

    // class
    @PulsarConsumer(topic = Topics.CLASS, clazz = MyMsg.class)
    public void consumeClass(MyMsg message) {
        logger.info("[Consume Message] topic {} message {}", Topics.CLASS, message.getData());
    }
}
