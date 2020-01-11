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
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
//import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class BallSystem extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private Encoder ballSpeedEncoder;
private Spark ballMotorA;
private Spark ballMotorB;
private Spark queMotor;
private SpeedControllerGroup ballShootMotors;
private Spark trackMotor;
private Spark intakeMotor;
private DigitalInput ballLimit;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // Initialize your subsystem here
    public BallSystem() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        super(new PIDController(1.0, 0.0, 0.0));

        getController().setTolerance(Constants.ballPIDTolerance);
        SendableRegistry.setName(getController(), "BallSystem", "Name");//change name

        //SendableRegistry.add(getController());//what is a parent? Do i need to add a child?

        //SendableRegistry.add(getController(), "controller");

        //super("BallSystem", 1.0, 0.0, 0.0); //super??

        // getPIDController().setContinuous(false);
        // getPIDController().setName("BallSystem", "PIDSubsystem Controller");
        // addChild(getPIDController());
        // addChild(getController());
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        ballSpeedEncoder = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("BallSpeedEncoder",ballSpeedEncoder);
        ballSpeedEncoder.setDistancePerPulse(1.0);
        ballSpeedEncoder.setPIDSourceType(PIDSourceType.kRate);
                
        ballMotorA = new Spark(Constants.BallShooterTopMotorID);
        addChild("BallMotorA",ballMotorA);
        ballMotorA.setInverted(false);
                
        ballMotorB = new Spark(6);
        addChild("BallMotorB",ballMotorB);
        ballMotorB.setInverted(true);
                
        queMotor = new Spark(9);
        addChild("QueMotor",queMotor);
        queMotor.setInverted(false);
                
        ballShootMotors = new SpeedControllerGroup(ballMotorA, ballMotorB , queMotor );
        addChild("BallShootMotors",ballShootMotors);

                
        trackMotor = new Spark(7);
        addChild("TrackMotor",trackMotor);
        trackMotor.setInverted(false);
                
        intakeMotor = new Spark(0);
        addChild("IntakeMotor",intakeMotor);
        intakeMotor.setInverted(false);
                
        ballLimit = new DigitalInput(10);
        addChild("BallLimit",ballLimit);

        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    @Override
    public double getMeasurement() {
        return ballSpeedEncoder.getRate();
    }

    // @Override
    // public double returnPIDInput() {
    //     // Return your input value for the PID loop
    //     // e.g. a sensor, like a potentiometer:
    //     // yourPot.getAverageVoltage() / kYourMaxVoltage;

    //     // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    //     return ballSpeedEncoder.pidGet();

    //     // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    // }

    @Override
    public void useOutput(double output, double setpoint) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        ballShootMotors.pidWrite(output);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

}
