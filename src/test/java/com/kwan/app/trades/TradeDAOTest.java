package com.kwan.app.trades;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TradeDAOTest {

	@Autowired
	TradeDAO tradeDAO;

	@Autowired
	TradeDTO tradeDTO;

	@Before
	public void setUp() throws Exception {

		this.tradeDTO = new TradeDTO();
		tradeDTO.setBank_id(null);
		tradeDTO.setDifference(null);
		tradeDTO.setAccount_u(null);

	}

	@Test
	public void test() {

	}

}
