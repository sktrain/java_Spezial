package sk.train.ma_basic;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MitarbeiterTest_JUnit {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetVorname() {
		Mitarbeiter m2 = new Mitarbeiter( 1, "Stephan", "Karrer", LocalDate.of(1959,8, 14),
	              LocalDate.of(2015, 1, 1), new BigDecimal(5000));
		assertEquals("Stephan", m2.getVorname(), "Vorname passt nicht");
		//fail("Not yet implemented");
	}

	@Test
	void testSetVorname() {
		fail("Not yet implemented");
	}

}
