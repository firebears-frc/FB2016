// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firebears.subsystems;

import org.firebears.RobotMap;
import org.firebears.commands.*;
import org.firebears.util.*;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 *
 */
public class Chassis extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    public final CANTalon frontLeft = RobotMap.chassisFrontLeft;
    public final CANTalon frontRight = RobotMap.chassisFrontRight;
    public final CANTalon backLeft = RobotMap.chassisBackLeft;
    public final CANTalon backRight = RobotMap.chassisBackRight;
    private final RobotDrive robotDrive = RobotMap.chassisRobotDrive;
    private final SoftFuse talonFuse = new SoftFuse(robotDrive,90,1,2);//Amp limit, holdOff time, duration time
    
   
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    

    public void drive(double x, double y){
    	double mult = talonFuse.speedFuse(frontLeft.getOutputCurrent());
    	robotDrive.arcadeDrive(-y * mult, -x * mult);
    	backRight.disable();
    }
      
    
    public void initDefaultCommand() {
        setDefaultCommand(new RobotDriveCommand());
    }
    
}

