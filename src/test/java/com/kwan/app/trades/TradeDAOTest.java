package com.kwan.app.trades;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.kwan.app.DefaultTest;

public class TradeDAOTest extends DefaultTest {

	@Autowired
	private TradeDAO tradeDAO;

	private TradeDTO tradeDTO;

	@BeforeClass
	public static void beforeClass() {

	}

	@Before
	public void before() {
		this.tradeDTO = new TradeDTO();
		tradeDTO.setBank_id("1720398773806");
		tradeDTO.setDifference(2000L * -1);
	}

	// @Test
	public void addTest() throws Exception {
		int result = tradeDAO.transfer(tradeDTO);
		assertEquals(1, result);
	}

	@Test
	public void updateTest() throws Exception {
		int result = tradeDAO.updateBal(tradeDTO);
		assertNotEquals(0, result);
	}

	@After
	public void after() {
		tradeDTO = null;
	}

}
