package com.miguel.first;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@ActiveProfiles("homolog")
public class MiguelProjectApplicationTests {

	
	@Value("${cpf}")
	private String cpf;
	
	//@Test
	public void contextLoads() {
	}
	
	//@Test
	public void deve_validar_cpf () {
		assertEquals("04660260801", cpf);
	}

}
