// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private PWMSparkMax leftMotorA;
private PWMSparkMax leftMotorB;
private SpeedControllerGroup leftMotors;
private PWMSparkMax rightMotorA;
private PWMSparkMax rightMotorB;
private SpeedControllerGroup rightMotors;
private Encoder leftEncoder;
private Encoder rightEncoder;
private AnalogAccelerometer driveAccelerometer;
private AnalogGyro driveGyro;
private Ultrasonic driveDistance;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
leftMotorA = new PWMSparkMax(1);
addChild("LeftMotorA",leftMotorA);
leftMotorA.setInverted(false);
        
leftMotorB = new PWMSparkMax(2);
addChild("LeftMotorB",leftMotorB);
leftMotorB.setInverted(false);
        
leftMotors = new SpeedControllerGroup(leftMotorA, leftMotorB  );
addChild("LeftMotors",leftMotors);

        
rightMotorA = new PWMSparkMax(3);
addChild("RightMotorA",rightMotorA);
rightMotorA.setInverted(false);
        
rightMotorB = new PWMSparkMax(4);
addChild("RightMotorB",rightMotorB);
rightMotorB.setInverted(false);
        
rightMotors = new SpeedControllerGroup(rightMotorA, rightMotorB  );
addChild("RightMotors",rightMotors);

        
leftEncoder = new Encoder(2, 3, false, EncodingType.k4X);
addChild("LeftEncoder",leftEncoder);
leftEncoder.setDistancePerPulse(1.0);
leftEncoder.setPIDSourceType(PIDSourceType.kRate);
        
rightEncoder = new Encoder(4, 5, false, EncodingType.k4X);
addChild("RightEncoder",rightEncoder);
rightEncoder.setDistancePerPulse(1.0);
rightEncoder.setPIDSourceType(PIDSourceType.kRate);
        
driveAccelerometer = new AnalogAccelerometer(0);
addChild("DriveAccelerometer",driveAccelerometer);
driveAccelerometer.setSensitivity(0.0);
driveAccelerometer.setZero(2.5);
        
driveGyro = new AnalogGyro(1);
addChild("DriveGyro",driveGyro);
driveGyro.setSensitivity(0.007);
        
driveDistance = new Ultrasonic(6, 7);
addChild("DriveDistance",driveDistance);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

