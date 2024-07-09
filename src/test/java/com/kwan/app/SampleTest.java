package com.kwan.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest extends DefaultTest {

	@AfterClass
	public static void afterAll() {

		System.out.println("=======afterall=======");
	}

	@BeforeClass
	public static void beforeAll() {

		System.out.println("=======beforeall=======");

	}

	@Test
	public void t1() {

		System.out.println("t1");
		fail("t1 실패");

	}

	@Test
	public void t2() {

		System.out.println("t2");
		assertEquals(0, 0);

	}

	@Before
	public void before() {

		System.out.println("=======before=======");

	}

	@org.junit.After
	public void After() {

		System.out.println("======After=======");

	}

}
