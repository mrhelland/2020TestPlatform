/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.I2C;
/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    // PWM Channels
    public static int MOTORA_ID = 0;
    public static int MOTORB_ID = 1;

    // I2C Ports
    public final static I2C.Port COLORSENSOR_I2C = I2C.Port.kOnboard;

    // Defined Constants
    public static double MOTORS_P = 1.0;
    public static double MOTORS_I = 0.0;
    public static double MOTORS_D = 0.0;

    public final static double COLORCHANNELTOLERANCE = 0.1;


    public static boolean LIMIT_PRESSED = true;
    public static boolean LIMIT_NOTPRESSED = false;

    public static final double controllerDeadZone = .1;

}
