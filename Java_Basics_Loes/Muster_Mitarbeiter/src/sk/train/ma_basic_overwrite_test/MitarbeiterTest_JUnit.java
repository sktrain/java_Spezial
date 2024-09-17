package sk.train.ma_basic_overwrite_test;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class MitarbeiterTest_JUnit {
	
	Mitarbeiter m1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		m1 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1969,8, 14),
                LocalDate.of(2015, 1, 1), new BigDecimal(5000), Geschlecht.M);
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	void testEqualsAndSame() {
		Mitarbeiter m2 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1969,8, 14),
	              LocalDate.of(2015, 1, 1), new BigDecimal(5000), Geschlecht.M);
		assertNotEquals(m2, m1, "sind gleich");
		assertNotSame(m2, m1, "sind identisch");
	}
	
	@Test
	void testpersnr() {
		Mitarbeiter m2 = new Mitarbeiter( "Stephan", "Karrer", LocalDate.of(1969,8, 14),
	              LocalDate.of(2015, 1, 1), new BigDecimal(5000), Geschlecht.M);
		assertNotEquals(m2.getPersnr(), m1.getPersnr(), "Personalnummer doppelt");
	}
	
	@Test
	void testGeschlecht() {
		assertEquals(m1.getGes().toString(), "männlich");
	}

	@Test
	void testGetVorname() {
		assertEquals("Stephan", m1.getVorname(), "Vorname passt nicht");
	}

	@Disabled
	@Test
	void testSetVorname() {
		fail("Not yet implemented");
	}
	
	//...

}
