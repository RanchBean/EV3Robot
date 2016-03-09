package bot.model;

import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.chassis.Chassis;
import lejos.robotics.chassis.Wheel;
import lejos.robotics.chassis.WheeledChassis;
import lejos.robotics.navigation.MovePilot;
import lejos.utility.Delay;


public class EthanRobot 
{
	private String botMessage;
	
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private MovePilot ethanPilot;
	private EV3UltrasonicSensor distanceSensor;
	private float [] ultrasonicSamples;
	
	public EthanRobot()
	{
		this.botMessage = "This is ethans robot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
		distanceSensor = new EV3UltrasonicSensor(LocalEV3.get().getPort("S1"));
		ultrasonicSensor
		setupPilot();
		
	}
	public void driveRoom()
	{
		ultrasonicSamples = new float[distanceSensor.sampleSize()];
		distanceSensor.fetchSample(ultrasonicSamples, 0);
		if(ultrasonicSamples[0] < 3)
		displayMessage("DriveRoom");
		ethanPilot.travel(254.00);
	}
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		LCD.clear();
		
		
	}
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
		LCD.clear();
	}
	
	private void setupPilot()
	{
		Wheel leftWheel = WheeledChassis.modelWheel(Motor.A, 43.2).offset(-72);
		Wheel rightWheel = WheeledChassis.modelWheel(Motor.B, 43.2).offset(72);
		Chassis baseChassis = new WheeledChassis(new Wheel [] {leftWheel, rightWheel}, WheeledChassis.TYPE_DIFFERENTIAL);
		ethanPilot = new MovePilot(baseChassis);
	}
	
	private void dance()
	{
		//Motor.A.rotateTo();
		//Motor.B.rotateTo();
		Delay.msDelay(waitTime);
	}
	private void drive()
	{
		displayMessage("Drive");
		Motor.A.forward();
		Motor.B.forward();
		Delay.msDelay(waitTime + 5000);
	}
}
