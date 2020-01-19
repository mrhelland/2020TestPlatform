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

    //Motor Testing
    public static double MOTORS_P = 1.0;
    public static double MOTORS_I = 0.0;
    public static double MOTOR_D = 0.0;
    public static double MOTOR_ENCODER_MULTIPLIER = 1.0;

    //Booleans, Integers, and Values

    
    //Motors                                        Motor #s 0, 1, 2, 3, 4, 5, 6, 7,
    public static int MOTORA_ID = 1;
    public static int MOTORB_ID = 2;


    //Sensors                                       Sensor #s 0, 1, 2
    public static int BallLimitID = 0;
    public static int BallSpeedEncoderAID = 1;
    public static int BallSpeedEncoderBID = 2;
    public final static I2C.Port COLORSENSOR_I2C = I2C.Port.kOnboard;

    //Sensors                                       Sensor #s 3, 4
    public static int MaxHeightLimitID = 3;
    public static int MinHeightLimitID = 4;

    //Booleans
    public static boolean LIMIT_PRESSED = true;
    public static boolean LIMIT_NOTPRESSED = false;
    
 
    /*----------ControlPanelSystem----------*/
    
    //Booleans, Integers, and Values


    //Motors                                        Motor #s 9, 10, 11
    public static int RotatoPotatoID = 9;

    //Sensors                                       Sensor #s 5
    public static int ColorSensorID = 2;
    public static int RotateEncoderAID = 20;
    public static int RotateEncoderBID = 21;

    /*----------DriveSystem----------*/

    //Booleans, Integers, and Values
    public static final double maxMotorSpeed = 0.95;
    public static final double fullDriveSpeed = 8;

    //Motors                                        Motor #s 12, 13, 14, 15
    public static int FrontLeftMotorID = 12;
    public static int BackLeftMotorID = 13;
    public static int FrontRightMotorID = 14;
    public static int BackRightMotorID = 15;

    //Sensors                                       Sensor #s 6, 7, 8, 9, 10, 11, 12, 13
    public static int DriveLeftEncoderA = 6;
    public static int DriveLeftEncoderB = 7;
    public static int DriveRightEncoderA = 8;
    public static int DriveRightEncoderB = 9;
    //public static int DriveBuiltInAccelerometer = 10;
    // public static int DriveAnalogGyro = 11;
    public static int DriveDistanceUltrasonicA = 10;
    public static int DriveDistanceUltrasonicB = 11;

    //PID
    public static int drivePID_P;
    public static int drivePID_I;
    public static int drivePID_D;
    public static int gyroPID_P;
    public static int gyroPID_I;
    public static int gyroPID_D;

    public static final double controllerDeadZone = .1;

}
