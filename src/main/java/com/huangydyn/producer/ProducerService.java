package com.huangydyn.producer;

import com.huangydyn.data.MyMsg;
import com.huangydyn.configuration.Topics;
import io.github.majusko.pulsar.producer.PulsarTemplate;
import org.apache.pulsar.client.api.PulsarClientException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final PulsarTemplate<String> stringProducer;

    private final PulsarTemplate<MyMsg> classProducer;

    public ProducerService(PulsarTemplate<String> stringProducer, PulsarTemplate<MyMsg> classProducer) {
        this.stringProducer = stringProducer;
        this.classProducer = classProducer;
    }

    public void sendStringMsg(String msg) throws PulsarClientException {
        logger.info("[Produce Message] topic {} msg {}", Topics.STRING, msg);
        stringProducer.send(Topics.STRING, msg);
    }

    public void sendClassMsg(String value) throws PulsarClientException {
        var msg = new MyMsg(value);
        logger.info("[Produce Message] topic {} msg {}", Topics.CLASS, msg);
        classProducer.sendAsync(Topics.CLASS, new MyMsg("Hello World Class!"));
    }
}
