package es.upm.grise.profundizacion.exceptions;

public class IncorrectSpeedSetException extends Exception {

	public IncorrectSpeedSetException() {
		super("La velocidad establecida no es correcta");
	}

	public IncorrectSpeedSetException(String message) {
		super(message);
	}

}
