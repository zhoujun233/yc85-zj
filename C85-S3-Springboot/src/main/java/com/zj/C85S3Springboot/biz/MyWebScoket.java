package com.zj.C85S3Springboot.biz;

import java.io.IOException;
import java.util.Hashtable;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@ServerEndpoint(value = "/websocket/{id}")
@Component
public class MyWebScoket {
	
	private static Hashtable<String, Session>
	websocketMap=new Hashtable<>();
	
	@OnOpen//连接建立成功调用的方法
	public void onOpen(@PathParam("id")String id,Session session) {
		//Hashtable(线程安全)    HashMap(线程不安全)
		System.out.println(id+"连接成功");
		websocketMap.put(id, session);
		
	}

	@OnClose//连接关闭调用的方法
	public void onClose(Session session) {
		
		
	}
	
	@OnMessage//接收到客户端消息后调用的方法
	public void onMessage(String message,Session session) throws IOException {
		//
		String ss[]=message.split(":");
		String id=ss[0];
		//String msg=ss[1];
		String msger=ss[1];
		String msg=ss[2];
		
		Session targetSession =websocketMap.get(id);
		
		if(targetSession!=null) {//id+":"+
			targetSession.getBasicRemote().sendText(msger+":"+msg);
		}else {
			System.out.println(id+"不在线");
		}
		
	}
	
	@Scheduled(cron = "0 */2 * * * ?")//每两分钟执行一次
	public void luckyou() throws IOException {
		for(Session session:websocketMap.values()) {
			session.getBasicRemote().sendText("系统:祝你好运");
		}
	}
}
