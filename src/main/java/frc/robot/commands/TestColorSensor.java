package frc.robot.commands;

import com.revrobotics.ColorSensorV3;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.Robot;

/**
 *
 */
public class TestColorSensor extends CommandBase {

    private int consistencyCount;
    private String currentColor;

    public TestColorSensor() {

    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        consistencyCount = 0;
        SmartDashboard.putNumber("Consistency:", consistencyCount);
        SmartDashboard.putString("Current Color:", currentColor);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        currentColor = Robot.colorSystem.getRGB();
        SmartDashboard.putNumber("Consistency:", consistencyCount);
        SmartDashboard.putString("Current Color:", currentColor);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Robot.motorSystem.setShooterSpeed(0, 0);
    }


}