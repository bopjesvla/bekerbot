import java.util.ArrayList;
import java.util.concurrent.Callable;

import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.NXTRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.Pose;

public class Control {
	private boolean goalReached = false;
//	private HeadControl hc;
//	private ColorControl ccl;
//	private ColorControl ccr;
	private PoseControl mc;
	private GyroControl gc;
	
	private int orientation = 0;
	
	ArrayList<Pose> junctions = new ArrayList<Pose>(); 
	
	public Control() throws Exception {
		System.out.println("Hello, World");
        
//        hc = new HeadControl(SensorPort.S2);
//        ccl = new ColorControl(SensorPort.S3);
//        ccr = new ColorControl(SensorPort.S4);
        gc = new GyroControl(SensorPort.S2);
        mc = new PoseControl(new EV3LargeRegulatedMotor(MotorPort.A), new EV3LargeRegulatedMotor(MotorPort.B), new EV3LargeRegulatedMotor(MotorPort.D), gc);
        
        //color.rotateTo(0);
        
//        mc.followStraightLineTwoSensors(ccl, ccr, (float)0.30, new Callable<Boolean>() {
//        	public Boolean call() {
//        		return true;
//        	}
//        });
        
        
        // draaitest
        
        /*for (int j=0; j < 10; j++) {
        	mc.move(50, -50);
        	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	mc.move(-50, 50);
        	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println(gc.getLastSample());
        }*/
        //
        // mc.turnTo(120);
        /*mc.turnTo(80, 100, new Callable<Boolean>() {
        	public Boolean call() {
        		return true;
        	}
        });*/
        
        while(true)
        {
        	System.out.println(-gc.getAvgSample());
        	Thread.yield();
        }
        
        /*head.close();
        left.close();
        right.close();*/
	}
//	public boolean followStraightLine(SensorControl sc, float sThreshold) {
//		int t = 0;
//		boolean goleft = false;
//		
//		mc.move(100, 100);
//		
//		while (t < 10000) {
//			if(sc.getAvgSample() < sThreshold && goleft) {
//				mc.move(20, 100);
//				goleft = false;
//				t = 0;
//			}
//			else if (sc.getAvgSample() > sThreshold && !goleft) {
//				mc.move(100, 20);
//				goleft = true;
//				t = 0;
//			}
//			
//			//System.out.println( sc.getAvgSample() );
//			t += 1;
//		}
//		
//		mc.move(0, 0);
//		return goleft;
//	}
	public int getCardinal(int angle) {
		char directions[] = {'N', 'E', 'S', 'W'};
		int g = angle + 45;
		
		while (g < 0)
			g += 360;
		
		return (int)(g%360)/90;
	}
	public int getAngleFromCardinal(int card) {
		
		while (card < 0)
			card += 4;
		
		return (int)(card%4)*90;
	}
	public void detectJunctions() {
		
	}
}
