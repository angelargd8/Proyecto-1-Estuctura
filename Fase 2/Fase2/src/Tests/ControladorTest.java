package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CControlador.Lector;

class ControladorTest {

	@Test
	void menuTest() {
		
		Lector lector = new Lector();
		lector.menu();
		
	}

	
	
}
