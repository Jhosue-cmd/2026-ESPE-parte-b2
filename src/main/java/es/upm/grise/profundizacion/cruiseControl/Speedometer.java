package es.upm.grise.profundizacion.cruiseControl;

public class Speedometer {
	
	// Please notice the difference between the class diagram and this implementation
	// The reason is to facilitate unit testing
	
	int currentSpeed;
	
	void setCurrentSpeed(int currentSpeed) {
		
		this.currentSpeed = currentSpeed;
		
	}

	public int getCurrentSpeed() {
		
		return currentSpeed;
		
	}

}
