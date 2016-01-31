// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.firebears;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chassisFrontLeft;
    public static CANTalon chassisFrontRight;
    public static CANTalon chassisBackLeft;
    public static CANTalon chassisBackRight;
    public static RobotDrive chassisRobotDrive;
    public static CANTalon drawbridgeBusterAngleMotor;
    public static CANTalon defenseBusterAngleMotor;
    public static CANTalon ballGetterSideMotor;
    public static CANTalon ballGetterFrontMotor;
    public static CANTalon ballGetterAngleMotor;
    public static CANTalon shooterShootingMotor;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        
        chassisFrontLeft = new CANTalon(2);
        chassisFrontLeft.enableBrakeMode(false);
        LiveWindow.addActuator("Chassis", "FrontLeft", chassisFrontLeft);
        
        chassisFrontRight = new CANTalon(4);
        chassisFrontRight.enableBrakeMode(false);
        LiveWindow.addActuator("Chassis", "FrontRight", chassisFrontRight);
        
        chassisBackLeft = new CANTalon(3);
        chassisBackLeft.enableBrakeMode(false);

        LiveWindow.addActuator("Chassis", "BackLeft", chassisBackLeft);
        
        chassisBackRight = new CANTalon(5);
        chassisBackRight.enableBrakeMode(false);
        LiveWindow.addActuator("Chassis", "BackRight", chassisBackRight);
        
        chassisRobotDrive = new RobotDrive(chassisFrontLeft, chassisBackLeft,
              chassisFrontRight, chassisBackRight);
        
        chassisRobotDrive.setSafetyEnabled(true);
        chassisRobotDrive.setExpiration(0.1);
        chassisRobotDrive.setSensitivity(0.5);
        chassisRobotDrive.setMaxOutput(1.0);

/*        drawbridgeBusterAngleMotor = new CANTalon(10);
        LiveWindow.addActuator("DrawbridgeBuster", "AngleMotor", drawbridgeBusterAngleMotor);
        
        defenseBusterAngleMotor = new CANTalon(11);
        LiveWindow.addActuator("DefenseBuster", "AngleMotor", defenseBusterAngleMotor);
        
        ballGetterSideMotor = new CANTalon(12);
        LiveWindow.addActuator("BallGetter", "SideMotor", ballGetterSideMotor);
        
        ballGetterFrontMotor = new CANTalon(13);
        LiveWindow.addActuator("BallGetter", "FrontMotor", ballGetterFrontMotor);
        
        ballGetterAngleMotor = new CANTalon(14);
        LiveWindow.addActuator("BallGetter", "AngleMotor", ballGetterAngleMotor);
        
        shooterShootingMotor = new CANTalon(15);
        LiveWindow.addActuator("Shooter", "ShootingMotor", shooterShootingMotor);*/
        
    }
}
