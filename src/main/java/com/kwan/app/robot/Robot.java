package com.kwan.app.robot;

//@Component
public class Robot {

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String company;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	// @Autowired
//	@Qualifier("rA")
	private Arm rightArm;
	// Arm이란 타입이 두개, 변수명으로 찾음

//	@Autowired
//	@Qualifier("lA")
	private Arm leftArm;

	public Arm getRightArm() {
		return rightArm;
	}

	public void setRightArm(Arm rightArm) {
		this.rightArm = rightArm;
	}

	public Arm getLeftArm() {
		return leftArm;
	}

	public void setLeftArm(Arm leftArm) {
		this.leftArm = leftArm;
	}

}
