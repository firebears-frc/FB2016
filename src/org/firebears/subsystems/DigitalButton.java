package org.firebears.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class DigitalButton extends Trigger{

	
	public DigitalButton(int channel){
		internalDigitalInput1 = new DigitalInput(channel);
	}
	public final DigitalInput internalDigitalInput1;
	

	@Override
	public boolean get() {
		
		return internalDigitalInput1.get();
	}

}
