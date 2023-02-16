package com.miguel.project;

//import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Value;

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
//		assertEquals("04660260801", cpf);
	}

}
