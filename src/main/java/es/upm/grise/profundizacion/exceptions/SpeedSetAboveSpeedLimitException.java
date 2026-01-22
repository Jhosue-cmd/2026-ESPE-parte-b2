package es.upm.grise.profundizacion.exceptions;

public class SpeedSetAboveSpeedLimitException extends Exception {

	public SpeedSetAboveSpeedLimitException() {
		super("No se puede establecer una velocidad por encima del límite de velocidad");
	}

	public SpeedSetAboveSpeedLimitException(String message) {
		super(message);
	}

}
