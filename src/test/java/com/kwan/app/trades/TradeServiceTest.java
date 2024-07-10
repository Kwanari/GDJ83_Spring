package com.kwan.app.trades;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class TradeServiceTest extends DefaultTest {

	@Autowired
	private TradeService tradeService;

	@Test
	public void transferTest() throws Exception {
		tradeService.transfer(null);

		System.out.println("종료");

	}

}
