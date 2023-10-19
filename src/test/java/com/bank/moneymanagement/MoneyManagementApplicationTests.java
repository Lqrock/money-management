package com.bank.moneymanagement;

import com.bank.moneymanagement.aspect.Log;
import com.bank.moneymanagement.aspect.Transactions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MoneyManagementApplicationTests {

	@Test
	void contextLoads() {
		Transactions transactions = new Transactions();
		transactions.hi();
	}

}
