��H[���0E�| �7�to the Apache Software Foundation (ASF) under one or moreH[���contributor lE�| � agreements.  See the NOTICE file distribut�7�withH[���this work for additional information regarding�copyright ownership.H[���The ASF lE�| �s�this file to You under the Apache 0E�| �, Version 2.0H[���(the "0E�| �"); you may not use�this file except in�compliance�withH[���the 0E�| �.  You may obtain�a�copy of�the 0E�| � atH[��H[�������http://www.apache.org/lE�| �s/LICENSE-2.0H[��H[���Unless requir�7�by applicable law or agree7�to in�writing, softwareH[���distribut�7�under the 0E�| � is distribut�7�on an "AS IS" BASIS,H[���WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.H[���See the 0E�| � for the specific language governing�permissions andH[���limitations�under the 0E�| �.H[��/
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
