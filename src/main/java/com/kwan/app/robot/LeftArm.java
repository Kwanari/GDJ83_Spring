package com.kwan.app.robot;

import org.springframework.stereotype.Component;

@Component("lA")
public class LeftArm implements Arm {

	public void info() {
		System.out.println("왼팔");
	}
}
