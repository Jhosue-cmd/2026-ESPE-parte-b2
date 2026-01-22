package es.upm.grise.profunduzacion.cruiseController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.upm.grise.profundizacion.cruiseControl.CruiseControl;
import es.upm.grise.profundizacion.cruiseControl.Speedometer;
import es.upm.grise.profundizacion.exceptions.IncorrectSpeedSetException;
import es.upm.grise.profundizacion.exceptions.SpeedSetAboveSpeedLimitException;

class CruiseControlTest {

	private CruiseControl cruiseControl;
	private Speedometer speedometer;

	@BeforeEach
	void setUp() {
		speedometer = new Speedometer();
		cruiseControl = new CruiseControl(speedometer);
	}

	//  Tests para valores válidos 

	@Test
	void setSpeedSet_withPositiveValue_setsSpeedCorrectly() throws Exception {
		cruiseControl.setSpeedSet(40);
		assertEquals(40, cruiseControl.getSpeedSet());
	}

	@Test
	void setSpeedSet_withMinimumPositiveValue_setsSpeedCorrectly() throws Exception {
		cruiseControl.setSpeedSet(3);
		assertEquals(3, cruiseControl.getSpeedSet());
	}

	@Test
	void setSpeedSet_withSpeedLimitSet_andSpeedSetBelowLimit_setsSpeedCorrectly() throws Exception {
		cruiseControl.setSpeedLimit(100);
		cruiseControl.setSpeedSet(93);
		assertEquals(93, cruiseControl.getSpeedSet());
	}

	@Test
	void setSpeedSet_withSpeedLimitSet_andSpeedSetEqualsLimit_setsSpeedCorrectly() throws Exception {
		cruiseControl.setSpeedLimit(100);
		cruiseControl.setSpeedSet(100);
		assertEquals(100, cruiseControl.getSpeedSet());
	}

	//  Tests para IncorrectSpeedSetException 

	@Test
	void setSpeedSet_withZero_throwsIncorrectSpeedSetException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(0);
		});
	}

	@Test
	void setSpeedSet_withNegativeValue_throwsIncorrectSpeedSetException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(-1);
		});
	}

	@Test
	void setSpeedSet_withLargeNegativeValue_throwsIncorrectSpeedSetException() {
		assertThrows(IncorrectSpeedSetException.class, () -> {
			cruiseControl.setSpeedSet(-55);
		});
	}

	// Tests para SpeedSetAboveSpeedLimitException 

	@Test
	void setSpeedSet_aboveSpeedLimit_throwsSpeedSetAboveSpeedLimitException() {
		cruiseControl.setSpeedLimit(100);
		assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {
			cruiseControl.setSpeedSet(126);
		});
	}

	@Test
	void setSpeedSet_muchAboveSpeedLimit_throwsSpeedSetAboveSpeedLimitException() {
		cruiseControl.setSpeedLimit(233);
		assertThrows(SpeedSetAboveSpeedLimitException.class, () -> {
			cruiseControl.setSpeedSet(234);
		});
	}

	// Tests sin speedLimit establecido 

	@Test
	void setSpeedSet_withoutSpeedLimit_acceptsAnyPositiveValue() throws Exception {
		cruiseControl.setSpeedSet(865);
		assertEquals(865, cruiseControl.getSpeedSet());
	}

}