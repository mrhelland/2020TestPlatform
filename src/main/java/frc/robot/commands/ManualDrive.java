// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
//import frc.robot.Robot;
import frc.robot.subsystems.DriveSystem;

/**
 *
 */
public class ManualDrive extends CommandBase {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ManualDrive() {

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        Robot.driveSystem.ResetGyro();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {

        Robot.oi.getDriverJoystick();
       
        // need help with this
		Robot.driveSystem.tankDrive(Robot.oi.getLStickY()*(-.0064*Robot.climbSystem.getclimbSystemHeight()+1.064), Robot.oi.getRStickY()*(-.0064*Robot.climbSystem.getClimbSystemHeight()+1.064));
		
        
        //SmartDashboard.putNumber("Elevator Height",Robot.climbSystem.getclimbSystemHeight());
		SmartDashboard.putNumber("Gyro", Robot.driveSystem.getAngle());
		SmartDashboard.putNumber("Encoder Distance", Robot.driveSystem.getDistanceLeft());
        SmartDashboard.putNumber("Encoder Distance", Robot.driveSystem.getDistanceRight());        
        

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
    }


}
