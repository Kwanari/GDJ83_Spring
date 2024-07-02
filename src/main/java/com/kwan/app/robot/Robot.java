package com.kwan.app.robot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	@Autowired
	@Qualifier("rA")
	private Arm rightArm;
	// Arm이란 타입이 두개, 변수명으로 찾음

	@Autowired
	@Qualifier("lA")
	private Arm leftArm;

	public Arm getrA() {
		return rA;
	}

	public void setrA(Arm rA) {
		this.rA = rA;
	}

	public Arm getlA() {
		return lA;
	}

	public void setlA(Arm lA) {
		this.lA = lA;
	}

}
