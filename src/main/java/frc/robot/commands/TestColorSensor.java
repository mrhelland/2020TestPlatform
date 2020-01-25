package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.Robot;

/**
 *
 */
public class TestColorSensor extends CommandBase {


    public TestColorSensor() {

    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        SmartDashboard.putNumber("Consistency Rate:", Robot.colorSystem.getConsistency());
        SmartDashboard.putString("Current Color:", Robot.colorSystem.getColor().toString());
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        SmartDashboard.putNumber("Consistency Rate:", Robot.colorSystem.getConsistency());
        SmartDashboard.putString("Current Color:", Robot.colorSystem.getColor().toString());
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
