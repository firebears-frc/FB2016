package org.firebears.commands;

import java.net.*;

import org.firebears.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.networktables.NetworkTablesJNI;

/**
 * Command to get vision processing information from the raspberry pi.
 */
public class VisionCommand extends Command {
	
	DatagramSocket dsocket;

    public VisionCommand() {
        requires(Robot.vision);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	try {
    		dsocket = new DatagramSocket();
    	}catch (Exception e) {
            System.err.println(e);
        }
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(NetworkTablesJNI.getBoolean("calibrationMode")) {
    		// Turn the value into a video stream.
			try {
				String host = "roborio-2846-frc.local";
				int port = 554;
				
				byte[] message = NetworkTablesJNI.getRaw("Image");
				
				// Get the Internet address of the specified host
				InetAddress address = InetAddress.getByName(host);
				
				// Initialize a packet with data and address & send it.
				DatagramPacket packet = new DatagramPacket(message, message.length, address, port);
				dsocket.send(packet);
			} catch (Exception e) {
				System.err.println(e);
			}
    	}else{
    		
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        dsocket.close();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
