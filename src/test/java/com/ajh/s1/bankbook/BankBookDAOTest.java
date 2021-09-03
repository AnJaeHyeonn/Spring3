package com.ajh.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ajh.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;

	// @Test
	public void getSelectTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(3);
		bankBookDTO = bankBookDAO.getSelect(bankBookDTO);

		System.out.println(bankBookDTO.getBookName());

		assertNotNull(bankBookDTO);

	}

	// @Test
	public void getListTest() {
		List<BankBookDTO> ar = bankBookDAO.getList();
		assertNotEquals(0, ar.size());

	}

	@Test
	public void setInsertTest() throws Exception {

		Random random = new Random();

		for (int i = 0; i < 200; i++) {

			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("BookName" + i);

			int rate = random.nextInt(400);
			bankBookDTO.setBookRate(rate / 100.0);

			bankBookDTO.setBookSale(random.nextInt(2));
			int result = bankBookDAO.setInsert(bankBookDTO);

			if (i % 10 == 0) {
				Thread.sleep(500);
			}
		}
		
		System.out.println("End");

	}

	// @Test
	public void setDeleteTest() {
		int result = bankBookDAO.setDelete(10000L);
		assertEquals(1, result);
	}

	// @Test
	public void setUpdateTest() {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(227L);
		bankBookDTO.setBookName("안재현");
		bankBookDTO.setBookRate(1.26);
		bankBookDTO.setBookSale(1);

		int result = bankBookDAO.setUpdate(bankBookDTO);

		assertEquals(1, result);
	}

}
