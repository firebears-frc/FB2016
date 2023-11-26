package frc.robot.drive;

import edu.wpi.first.math.util.Units;

public class Constants {
    public static final double WHEEL_RADIUS = Units.inchesToMeters(5.0);

    public static final int FRONT_LEFT_CAN_ID = 2;
    public static final int REAR_LEFT_CAN_ID = 3;
    public static final int FRONT_RIGHT_CAN_ID = 4;
    public static final int REAR_RIGHT_CAN_ID = 5;

    public static final int PEAK_CURRENT_LIMIT = 60;
    public static final int PEAK_CURRENT_DURATION = 1000;
    public static final int CONTINUOUS_CURRENT_LIMIT = 40;
}
