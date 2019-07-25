package com.example.demo.util;

import com.sun.javafx.collections.MappingChange;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WebSockUtil {
    //存放当前在聊天室中的人
    public static final Map<String, Session> SESSIONMAP = new ConcurrentHashMap<>();



    //发送数据的方法:指定向某一个客户端发送消息
    public static void sendMassage(Session session,String message){
        if(session != null){
            final RemoteEndpoint.Basic basic = session.getBasicRemote();
            if (basic != null){
                try {
                    basic.sendText(message);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void sendAll(String message){
        SESSIONMAP.forEach((sessionid,session)->sendMassage(session,message));
    }

}
