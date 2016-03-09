package bot.Controller;

import bot.model.EthanRobot;
import lejos.utility.Delay;
import lejos.hardware.lcd.*;


public class RobotController 
{
	
	private String botMessage;
	private int xPosition;
	private int yPosition;
	private long waitTime;
	private EthanRobot ethanRobot;
		
	public RobotController()
	{
		this.botMessage = "This is ethans robot";
		this.xPosition = 50;
		this.yPosition = 50;
		this.waitTime = 4000;
		ethanRobot = new EthanRobot();
		
	}
	
	public void start()
	{
		
		LCD.drawString(botMessage, xPosition, yPosition);
		Delay.msDelay(waitTime);
		ethanRobot.driveRoom();
	}

}