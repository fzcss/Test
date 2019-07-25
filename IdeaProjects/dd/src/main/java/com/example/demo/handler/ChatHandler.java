package com.example.demo.handler;

import com.example.demo.util.WebSockUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.message.Message;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

@RestController
@ServerEndpoint("/ChatHandler/{uname}") //默认支持stomp
public class ChatHandler {
    @OnOpen //建立连接
    public void openSession(@PathParam("uname") String uname, Session session){
        String message = "欢迎" + uname+"加入群聊";
        //将当前用户放入map中
        WebSockUtil.SESSIONMAP.put(uname, session);
        //向所有人发送消息
        WebSockUtil.sendAll(message);
    }
    @OnMessage
    public void onMessage(@PathParam("uname") String uname, String message){
        message = uname+":"+message;
        WebSockUtil.sendAll(message);
    }
    @OnClose
    public void onClose(@PathParam("uname") String uname, Session session){
        WebSockUtil.SESSIONMAP.remove(uname);
        WebSockUtil.sendAll("用户:"+uname+"离开聊天室");
        try{
            session.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    @OnError
    public void onError(Session session, String message){
        
    }
}
