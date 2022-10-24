package com.example.smpp;

import com.cloudhopper.smpp.SmppServerConfiguration;
import com.cloudhopper.smpp.SmppServerHandler;
import com.cloudhopper.smpp.impl.DefaultSmppServer;
import com.cloudhopper.smpp.type.SmppChannelException;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {

    private DefaultSmppServer smppServer;

    @PostConstruct
    public void init() throws SmppChannelException {
        SmppServerConfiguration configuration = new SmppServerConfiguration();
        SmppServerHandler serverHandler = new SmppServerHandlerImpl();
        smppServer = new DefaultSmppServer(configuration, serverHandler);
        smppServer.start();
        log.info("SMPP server started");
    }

    @PreDestroy
    public void destroy() {
        smppServer.stop();
        log.info("SMPP server stopped");
    }
}
