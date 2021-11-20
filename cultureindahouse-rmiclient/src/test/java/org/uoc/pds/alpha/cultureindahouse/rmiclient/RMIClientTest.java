package org.uoc.pds.alpha.cultureindahouse.rmiclient;

import org.junit.jupiter.api.Test;

import javax.naming.NamingException;

public class RMIClientTest {


	@Test
	//No es la mejor manera de implementar test de esto, pero sirve
	public void test() throws NamingException {
		CategoryRMIClient client = new CategoryRMIClient();
		client.run();
	}
}
