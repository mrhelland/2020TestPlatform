package frc.robot.commands;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
//import frc.robot.Robot;
import frc.robot.Robot;

/**
 *
 */
public class TestMotorSpeeds extends CommandBase {

    private double speedA;
    private double speedB;

    public TestMotorSpeeds() {
        speedA = 0.0;
        speedB = 0.0;
    }

    public TestMotorSpeeds(double SpeedA, double SpeedB) {   
        speedA = SpeedA;   
        speedB = SpeedB; 
        SmartDashboard.putNumber("Motor_Speed_A", speedA);
        SmartDashboard.putNumber("Motor_Speed_B", speedB);
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
        double a,b;

        a = SmartDashboard.getNumber("Motor_Speed_A", 0);
        b = SmartDashboard.getNumber("Motor_Speed_B", 0);
        if(a != speedA) speedA = a;
        if(b != speedB) speedB = b;

        Robot.motorSystem.setMotorRPM(speedA, speedB);
        
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    public boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    public void end(boolean interrupted) {
        Robot.motorSystem.setMotorRPM(0, 0);
    }


}
