package com.example.smpp;

import com.cloudhopper.smpp.PduAsyncResponse;
import com.cloudhopper.smpp.impl.DefaultSmppSessionHandler;
import com.cloudhopper.smpp.pdu.PduRequest;
import com.cloudhopper.smpp.pdu.PduResponse;
import com.cloudhopper.smpp.type.RecoverablePduException;
import com.cloudhopper.smpp.type.UnrecoverablePduException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmppSessionHandlerImpl extends DefaultSmppSessionHandler {

    private final long sessionId;

    public SmppSessionHandlerImpl(long sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public void fireChannelUnexpectedlyClosed() {
        log.info("Channel unexpectedly closed");
    }

    @Override
    public PduResponse firePduRequestReceived(PduRequest pduRequest) {
        log.info("PDU request received: {}", pduRequest);

        // SubmitSm
        // принимаем сообщение, назначаем messageId, ответчаем в SubmitSmResp

        // EnquireLink
        // принимаем пинг, отвечаем EnquireLinkResp
        // !! кроме того, нужно следить за интервалами пингов на соединении

        // Unbind
        // принимаем разрыа соединения, гасим сессию

        return null;
    }

    @Override
    public void firePduRequestExpired(PduRequest pduRequest) {
        log.info("PDU request expired: {}", pduRequest);
    }

    @Override
    public void fireExpectedPduResponseReceived(PduAsyncResponse pduAsyncResponse) {
        log.info("Expected PDU response received: {}", pduAsyncResponse);
    }

    @Override
    public void fireUnexpectedPduResponseReceived(PduResponse pduResponse) {
        log.info("Unexpected PDU response received: {}", pduResponse);
    }

    @Override
    public void fireUnrecoverablePduException(UnrecoverablePduException e) {
        log.error("Unrecoverable PDU exception", e);
    }

    @Override
    public void fireRecoverablePduException(RecoverablePduException e) {
        log.error("Recoverable PDU exception", e);
    }

    @Override
    public void fireUnknownThrowable(Throwable t) {
        log.error("Unknown throwable", t);
    }
}
