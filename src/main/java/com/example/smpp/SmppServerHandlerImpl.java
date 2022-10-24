package com.example.smpp;

import com.cloudhopper.smpp.SmppServerHandler;
import com.cloudhopper.smpp.SmppServerSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;
import com.cloudhopper.smpp.pdu.BaseBind;
import com.cloudhopper.smpp.pdu.BaseBindResp;
import com.cloudhopper.smpp.type.SmppProcessingException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmppServerHandlerImpl implements SmppServerHandler {
    @Override
    public void sessionBindRequested(Long sessionId,
                                     SmppSessionConfiguration smppSessionConfiguration,
                                     BaseBind baseBind) throws SmppProcessingException {
        log.info("Bind request received: {}", baseBind);
        // Аутентификация и сохранение сессии и  инфромации о кленте
    }

    @Override
    public void sessionCreated(Long sessionId,
                               SmppServerSession smppServerSession,
                               BaseBindResp baseBindResp) throws SmppProcessingException {
        log.info("Session created: {}", sessionId);
        smppServerSession.serverReady(new SmppSessionHandlerImpl(sessionId));
    }

    @Override
    public void sessionDestroyed(Long sessionId,
                                 SmppServerSession smppServerSession) {
        log.info("Session destroyed: {}", sessionId);
    }
}
