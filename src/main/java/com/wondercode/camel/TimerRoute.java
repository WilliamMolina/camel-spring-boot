package com.wondercode.camel;

import org.apache.camel.builder.RouteBuilder;

import org.springframework.stereotype.Component;

@Component
public class TimerRoute extends RouteBuilder {

	public static final String ROUTE_NAME = "TIMER_ROUTE";
	public static final String ROUTE_NAME2 = "TIMER_ROUTE2";

	@Override
	public void configure() throws Exception {
		from("timer:initial//start?period=1000").routeId(ROUTE_NAME).setBody()
				.simple("Hello World Camel fired at ${header.firedTime}").to("log:executed");
		from("timer:initial//start?period=2000").routeId(ROUTE_NAME2).setBody()
		.simple("Hello World Camel 2 fired at ${header.firedTime}").to("log:executed");
	}

}
