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


//import frc.robot.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Utilities;
//import jdk.vm.ci.meta.Constant;
//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
//import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWMSparkMax;
//import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Ultrasonic;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class DriveSystem extends SubsystemBase {

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
    private DifferentialDrive robotDrive;
    private PIDController leftControl;
    private PIDController rightControl;
    private PIDController gyroControl;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    leftMotorA = new PWMSparkMax(Constants.FrontLeftMotorID);
    addChild("LeftMotorA",leftMotorA);
    leftMotorA.setInverted(false);
            
    leftMotorB = new PWMSparkMax(Constants.BackLeftMotorID);
    addChild("LeftMotorB",leftMotorB);
    leftMotorB.setInverted(false);
            
    leftMotors = new SpeedControllerGroup(leftMotorA, leftMotorB  );
    addChild("LeftMotors",leftMotors);

            
    rightMotorA = new PWMSparkMax(Constants.FrontRightMotorID);
    addChild("RightMotorA",rightMotorA);
    rightMotorA.setInverted(false);
            
    rightMotorB = new PWMSparkMax(Constants.BackRightMotorID);
    addChild("RightMotorB",rightMotorB);
    rightMotorB.setInverted(false);
            
    rightMotors = new SpeedControllerGroup(rightMotorA, rightMotorB  );
    addChild("RightMotors",rightMotors);

            
    leftEncoder = new Encoder(Constants.DriveLeftEncoderA, Constants.DriveLeftEncoderB, false, EncodingType.k4X);
    addChild("LeftEncoder",leftEncoder);
    leftEncoder.setDistancePerPulse(1.0);
    //leftEncoder.setPIDSourceType(PIDSourceType.kRate);
            
    rightEncoder = new Encoder(Constants.DriveRightEncoderA, Constants.DriveRightEncoderB, false, EncodingType.k4X);
    addChild("RightEncoder",rightEncoder);
    rightEncoder.setDistancePerPulse(1.0);
    //rightEncoder.setPIDSourceType(PIDSourceType.kRate);
            
    driveAccelerometer = new AnalogAccelerometer(Constants.DriveAnalogAccelerometer);
    addChild("DriveAccelerometer",driveAccelerometer);
    driveAccelerometer.setSensitivity(0.0);
    driveAccelerometer.setZero(2.5);
            
    driveGyro = new AnalogGyro(Constants.DriveAnalogGyro);
    addChild("DriveGyro",driveGyro);
    driveGyro.setSensitivity(0.007);
            
    driveDistance = new Ultrasonic(Constants.DriveDistanceUltrasonicA, Constants.DriveDistanceUltrasonicB);
    addChild("DriveDistance",driveDistance);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        robotDrive = new DifferentialDrive(leftMotors, rightMotors);
        leftControl = new PIDController(Constants.drivePID_P, Constants.drivePID_I, Constants.drivePID_D);
        rightControl = new PIDController(Constants.drivePID_P, Constants.drivePID_I, Constants.drivePID_D);
	    gyroControl = new PIDController(Constants.gyroPID_P, Constants.gyroPID_I, Constants.gyroPID_D);
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }

    public void drive() {

    
    }


    public void reverseDirection() {
		if(reverse) {
			reverse = false;
		}
		else {
			reverse = true;
		}

    public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
    }
    
    public double getAngle() {
		return driveGyro.getAngle();
	}

    public double getGyroRate() {
        return driveGyro.getRate();
    }

    public double getDistanceLeft() {
		return leftEncoder.getDistance();
    }
    
    public double getRateLeft() {
		return -leftEncoder.getRate();
    }
    
    public double getDistanceRight() {
		return rightEncoder.getDistance();
    }
    
    public double getRateRight() {
		return -rightEncoder.getRate();
    }
    
    public double getAverageDistance() {

		return (getDistanceRight() + getDistanceLeft()) / 2;
    }
    
    public void driveForwardVision(double speed){
		final double scale = .01;
		double leftSpeed;
		double rightSpeed;
		double headingError = getAngle();
		
		leftSpeed =Utilities.Clamp(Math.abs(speed) - headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
		rightSpeed = Utilities.Clamp(Math.abs(speed) + headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
		tankDrive(leftSpeed, rightSpeed);		
    }
    
    public void driveForward(double speed, double targetHeading) {
		final double scale = .01;
		double leftSpeed;
		double rightSpeed;
		double headingError = getAngle() - targetHeading;
		
		leftSpeed =Utilities.Clamp(Math.abs(speed) - headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
		rightSpeed = Utilities.Clamp(Math.abs(speed) + headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
		tankDrive(leftSpeed, rightSpeed);		
    }
    public void tankDrive(double leftSpeed, double rightSpeed) {
		if(reverse) {
            robotDrive.tankDrive(-rightSpeed, -leftSpeed);
	//	m_drive2.tankDrive(-rightSpeed, -leftSpeed); //new
        }

        public void driveBackward(double speed, double targetHeading) {
            final double scale = .01;
            double leftSpeed;
            double rightSpeed;
            double headingError = getAngle() - targetHeading;
            
            leftSpeed =Utilities.Clamp(-(speed) - headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
            rightSpeed = Utilities.Clamp(-(speed) + headingError * scale, -Constants.maxMotorSpeed, Constants.maxMotorSpeed);
            tankDrive(leftSpeed, rightSpeed);		
        }

        public void stop() {
            tankDrive(0,0);
        }
        
		else {
			robotDrive.tankDrive(leftSpeed, rightSpeed);
		//	m_drive2.tankDrive(rightSpeed, leftSpeed); //new
        }
        
        public double convertToEncoderRate(double motorSpeed) {
            return Constants.fullDriveSpeed * motorSpeed; // feet per second
        }

        public void arcadeDrive(double moveSpeed, double turnSpeed) {
            robotDrive.arcadeDrive(moveSpeed, turnSpeed);
        }

        public void arcadeDrive(double moveSpeed, double maxTurnSpeed, double targetAngle) {

            double angleInput = driveGyro.getAngle();
    
            gyroControl.setSetpoint(targetAngle);
    
            double angleOutput = Utilities.Clamp(gyroControl.Compute(angleInput), -maxTurnSpeed, maxTurnSpeed);

            robotDrive.arcadeDrive(moveSpeed, angleOutput);
    
        }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

