package org.firebears.subsystems;

import org.firebears.commands.SelectAuto;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;

public class DigitalButton extends Trigger {

	private boolean prevValue = false;

	public DigitalButton(int channel) {
		internalDigitalInput1 = new DigitalInput(channel);
	}

	public final DigitalInput internalDigitalInput1;

	@Override
	public boolean get() {
		return internalDigitalInput1.get();
	}

	public boolean valueChanged() {
		boolean newValue = this.get();
		boolean changed = (prevValue == false && newValue);
		prevValue = newValue;
		return changed;
	}
}
