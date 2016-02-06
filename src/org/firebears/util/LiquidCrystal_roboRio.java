package org.firebears.util;

import edu.wpi.first.wpilibj.I2C;

/**
 * Java interface similar to the Arduino's <tt>LiquidCrystal</tt> library,
 * but running on a National Instrument's roboRIO and connecting through I2C.
 *
 * @see https://www.arduino.cc/en/Reference/LiquidCrystal
 * @see https://bitbucket.org/fmalpartida/new-liquidcrystal/wiki/Home
 * @see https://github.com/RaiderRobotics/FRC-LCD-Display
 */
public class LiquidCrystal_roboRio implements LiquidCrystal {

	// LCD Commands
	protected static final int LCD_CLEARDISPLAY = 0x01;
	protected static final int LCD_RETURNHOME = 0x02;
	protected static final int LCD_ENTRYMODESET = 0x04;
	protected static final int LCD_DISPLAYCONTROL = 0x08;
	protected static final int LCD_CURSORSHIFT = 0x10;
	protected static final int LCD_FUNCTIONSET = 0x20;
	protected static final int LCD_SETCGRAMADDR = 0x40;
	protected static final int LCD_SETDDRAMADDR = 0x80;

	// Flags for display on/off control
	protected static final int LCD_DISPLAYON = 0x04;
	protected static final int LCD_DISPLAYOFF = 0x00;
	protected static final int LCD_CURSORON = 0x02;
	protected static final int LCD_CURSOROFF = 0x00;
	protected static final int LCD_BLINKON = 0x01;
	protected static final int LCD_BLINKOFF = 0x00;

	// Flags for display entry mode
	// private static final int LCD_ENTRYRIGHT = 0x00;
	protected static final int LCD_ENTRYLEFT = 0x02;
	protected static final int LCD_ENTRYSHIFTINCREMENT = 0x01;
	protected static final int LCD_ENTRYSHIFTDECREMENT = 0x00;

	// Flags for display/cursor shift
	protected static final int LCD_DISPLAYMOVE = 0x08;
	protected static final int LCD_CURSORMOVE = 0x00;
	protected static final int LCD_MOVERIGHT = 0x04;
	protected static final int LCD_MOVELEFT = 0x00;

	// flags for function set
	protected static final int LCD_8BITMODE = 0x10;
	protected static final int LCD_4BITMODE = 0x00;
	protected static final int LCD_2LINE = 0x08; // for 2 or 4 lines actualy
	protected static final int LCD_1LINE = 0x00;
	protected static final int LCD_5x10DOTS = 0x04; // seldom used!!
	protected static final int LCD_5x8DOTS = 0x00;

	// flags for backlight control
	protected static final int LCD_BACKLIGHT = 0x08;
	protected static final int LCD_NOBACKLIGHT = 0x00;

	// bitmasks for register control
	protected static final int En = 0b00000100; // Enable bit
	protected static final int Rw = 0b00000010; // Read/Write bit
	protected static final int Rs = 0b00000001; // Register select bit

	private I2C lcdDisplay;
	private int numLines = 4;
	private int numColumns = 20;
	private final int i2cAddress;

	public LiquidCrystal_roboRio(int i2cAddress) { // 0x3F

		this.i2cAddress = i2cAddress;
	}

	/**
	 * Sleep, but ignoring {@link InterruptedException}.
	 */
	private void delayMilliseconds(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Write the command to I2C, 4 bits at a time
	 */
	protected void command(int data) {
		write4bits(data & 0xF0);
		write4bits((data << 4) & 0xF0);
	}

	private void strobe(int data) {
		lcdDisplay.write(0, data | En | LCD_BACKLIGHT);
		delayMilliseconds(1);
		lcdDisplay.write(0, (data & ~En) | LCD_BACKLIGHT);
		delayMilliseconds(1);
	}

	private void write4bits(int data) {
		lcdDisplay.write(0, data | LCD_BACKLIGHT);
		strobe(data);
	}

	// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	@Override
	public void begin(int numColumns, int numLines) {
		this.numColumns = numColumns;
		this.numLines = numLines;
		if (lcdDisplay == null) {
			lcdDisplay = new I2C(I2C.Port.kOnboard, i2cAddress);
			command(0x03);
			command(0x03);
			command(0x03);
			command(0x02);
			command(LCD_FUNCTIONSET | LCD_2LINE | LCD_5x8DOTS | LCD_4BITMODE);
			command(LCD_DISPLAYCONTROL | LCD_DISPLAYON);
			command(LCD_CLEARDISPLAY);
			command(LCD_ENTRYMODESET | LCD_ENTRYLEFT);
			delayMilliseconds(10);
		}
	}

	@Override
	public void clear() {
		command(LCD_CLEARDISPLAY);
		delayMilliseconds(2);
	}

	@Override
	public void home() {
		command(LCD_RETURNHOME);
		delayMilliseconds(2);
	}

	@Override
	public void setCursor(int col, int row) {
		int row_offsets[] = { 0x00, 0x40, 0x14, 0x54 };
		if (row > numLines) {
			row = numLines - 1; // we count rows starting w/0
		}
		command(LCD_SETDDRAMADDR | (col + row_offsets[row]));
	}

	@Override
	public void print(String message) {
		if (message.length() > numColumns) {
			message = message.substring(0, numColumns);
		}

		for (int i = 0; i < message.length(); i++) {
			write(message.charAt(i));
		}
	}

	/**
	 * This is for writing a character, 4 bits at a time
	 */
	@Override
	public void write(int character) {
		write4bits(Rs | (character & 0xF0));
		write4bits(Rs | ((character << 4) & 0xF0));
	}

	public void print(String message, int row) {
		switch (row) {
		case 1:
			command(0x80);
			break;
		case 2:
			command(0xC0);
			break;
		case 3:
			command(0x94);
			break;
		case 4:
			command(0xD4);
			break;
		default:
			return; // invalid line number does nothing.
		}
		print(message);
	}
}
