

import lejos.hardware.port.Port;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;

public class ColorControl extends SensorControl {
	public ColorControl(Port port) {
		super(port);
		
		EV3ColorSensor eyes = new EV3ColorSensor(SensorPort.S1);
		distance = eyes.getMode("Red");
		sample = new float[distance.sampleSize()];
	}
}