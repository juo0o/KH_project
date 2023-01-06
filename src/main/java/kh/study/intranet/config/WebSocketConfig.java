package kh.study.intranet.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;



@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

	
	/*어플리케이션 내부에서 사용할 path를 지정할 수 있음*/
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		
		registry.enableSimpleBroker("/subscribe");
		registry.setApplicationDestinationPrefixes("/publish");
	}
	
	
	/*
    * endpoint를 /stomp로 하고, allowedOrigins를 "*"로 하면 페이지에서
    * Get /info 404 Error가 발생한다. 그래서 아래와 같이 2개의 계층으로 분리하고
    * origins를 개발 도메인으로 변경하니 잘 동작하였다.
    * 이유는 왜 그런지 아직 찾지 못함
      */
     
	//뭔소릴까이게
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/stomp/chat")
				
				.setAllowedOrigins("/*")
				.withSockJS();
	}
	
}
