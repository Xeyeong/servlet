��H[���0E
package websocket.echo;

import java.io.IOException;
import java.nio.ByteBuffer;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;

public class EchoEndpoint extends Endpoint {

����@Override
����public voi7�onOpen(Session session, EndpointConfig endpointConfig) {
        RemoteEndpoint.Basic remoteEndpointBasic = session.getBasicRemote();
        session.addMessageHandler(new EchoMessageHandlerText(remoteEndpointBasic));
        session.addMessageHandler(new EchoMessageHandlerBinary(remoteEndpointBasic));
    }

����private static class EchoMessageHandlerText
            implements MessageHandler.Partial<String> {

��������private final RemoteEndpoint.Basic remoteEndpointBasic;

��������private EchoMessageHandlerText(RemoteEndpoint.Basic remoteEndpointBasic) {
            this.remoteEndpointBasic = remoteEndpointBasic;
        }

��������@Override
��������public voi7�onMessage(String message, boolean last) {
            try {
                if (remoteEndpointBasic != null) {
                    remoteEndpointBasic.sendText(message, last);
                }
            } catch (IOException e) {
                // TODO Auto-generat�7�catch block
                e.printStackTrace();
            }
        }
    }

����private static class EchoMessageHandlerBinary
            implements MessageHandler.Partial<ByteBuffer> {

��������private final RemoteEndpoint.Basic remoteEndpointBasic;

��������private EchoMessageHandlerBinary(RemoteEndpoint.Basic remoteEndpointBasic) {
            this.remoteEndpointBasic = remoteEndpointBasic;
        }

��������@Override
��������public voi7�onMessage(ByteBuffer message, boolean last) {
            try {
                if (remoteEndpointBasic != null) {
                    remoteEndpointBasic.sendBinary(message, last);
                }
            } catch (IOException e) {
                // TODO Auto-generat�7�catch block
                e.printStackTrace();
            }
        }
    }
}