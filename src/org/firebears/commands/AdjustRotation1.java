package org.firebears.commands;

import org.firebears.Robot;
import org.firebears.RobotMap;

public class AdjustRotation1 extends RotationCommand {

	final double offset;
	
    public AdjustRotation1() {
    	this(0.0);
    }
	
    public AdjustRotation1(double degree_offset) {
    	super(0.0);
    	offset = degree_offset;
    }
    
    @Override
	protected void initialize() {
		targetAngle = bound(RobotMap.rotation + offset);
		getPIDController().setSetpoint(0.0);
		if (RobotMap.DEBUG) System.out.println("\t # " + this);

	}
    
    @Override
    public String toString() {
    	return "AdjustRotation1()";
    }
}
