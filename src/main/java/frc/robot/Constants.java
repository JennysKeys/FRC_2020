/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorMatch;
import edu.wpi.first.wpilibj.util.Color;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class Robot{
        public static final int ENCODER_COUNT = 42;
        public static final double RAMP_RATE = 0.3;

    }
    public final class Drivetrain{
        public final class Left{
            public static final int MASTER = 4;
            public static final int SLAVE_ONE = 3;
            public static final int SLAVE_TWO = 5;
        }
        public final class Right{
            public static final int MASTER = 1;
            public static final int SLAVE_ONE = 2;
            public static final int SLAVE_TWO = 6;
        }
    }
    public static final class ColorSensor{
        public static final Color kBlueTarget = ColorMatch.makeColor(0.143, 0.427, 0.429);
        public static final Color kGreenTarget = ColorMatch.makeColor(0.197, 0.561, 0.240);
        public static final Color kRedTarget = ColorMatch.makeColor(0.413, 0.378, 0.162);
        public static final Color kYellowTarget = ColorMatch.makeColor(0.361, 0.524, 0.113);
    }

    public final class Odometry{
        public static final double MAX_VELOCITY = 10;
        public static final double MAX_VELOCITY_SIDE = 0;
        public static final double ANGULAR_VELOCITY = 0;
        public static final double ROBOT_WIDTH = 28;
        public static final double kSTATIC = 0;
        public static final double kVELOCITY = 7;
        public static final double kACCELERATION = 5;
        public static final double MAX_VOLTAGE = 10;
    }
}
