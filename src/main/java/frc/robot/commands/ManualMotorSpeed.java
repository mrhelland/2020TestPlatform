package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
//import frc.robot.Robot;
import frc.robot.Robot;

/**
 *
 */
public class ManualMotorSpeed extends CommandBase {

    private double speed;

    public ManualMotorSpeed() {
        speed = 0.0;
    }

    public ManualMotorSpeed(double Speed) {   
        speed = Speed;   
        SmartDashboard.putNumber(Constants.DASH_SETSPEED, speed);
    }

    // Called just before this Command runs the first time
    @Override
    public void initialize() {
        // SmartDashboard.putNumber("Top_Motor_Speed", topSpeed);
        // SmartDashboard.putNumber("Bottom_Motor_Speed", bottomSpeed);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    public void execute() {
        double a;

        a = SmartDashboard.getNumber(Constants.DASH_SETSPEED, 0);
        if(a != speed) 
            speed = a;

        Robot.motorSystem.setSpeed(speed);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Robot.motorSystem.setSpeed(0);
    }


}
