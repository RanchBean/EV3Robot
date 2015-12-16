package bot.model;

import bot.Controller.RobotController;
import lejos.utility.Delay;
import lejos.hardware.lcd.*;

public class EthanRobot 
{
	private String botMessage;
	
	private int xPosition;
	private int yPosition;
	private long waitTime;
	
	public EthanRobot()
	{
		this.botMessage = "This is ethans robot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		
	}
	public void driveRoom()
	{
		displayMessage("DriveRoom");
	}
	private void displayMessage()
	{
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		
		EthanRobot.driveRoom();
	}
	private void displayMessage(String message)
	{
		LCD.drawString(message, xPosition, yPosition);
		Delay.msDelay(waitTime);
	}

}
