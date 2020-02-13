package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.helper.IUpdatesDash;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 *
 */
public class MotorSystem extends SubsystemBase implements IUpdatesDash {

    private CANEncoder encoder;
    private CANSparkMax motor;

    private CANPIDController controller;
    private double kP, kI, kD, kIz, kFf, speed;

    public MotorSystem() {

        //initialize variables using default values
        kP = Constants.MOTORS_P;
        kI = Constants.MOTORS_I;
        kD = Constants.MOTORS_D;
        kIz = Constants.MOTORS_Iz;
        kFf = Constants.MOTORS_Ff;
        speed = 0;

        //initialize Motor A and all settings
        motor = new CANSparkMax(Constants.MOTORA_ID, MotorType.kBrushless);
        motor.restoreFactoryDefaults();
        motor.setInverted(false);
        controller = motor.getPIDController();
        controller.setP(kP);
        controller.setI(kI);
        controller.setD(kD);
        controller.setIZone(kIz);
        controller.setFF(kFf);
        controller.setOutputRange(-1, 1);

        //obtain encoders from motor controllers
        encoder = motor.getEncoder();       

        //intialize values on the SmartDashboard
        SmartDashboard.putNumber(Constants.DASH_P, kP);
        SmartDashboard.putNumber(Constants.DASH_I, kI);
        SmartDashboard.putNumber(Constants.DASH_D, kD);
        SmartDashboard.putNumber(Constants.DASH_SETSPEED, speed);
        SmartDashboard.putNumber(Constants.DASH_MEASUREDSPEED, encoder.getVelocity()); 
    }
  
    /***
     * Motor speeds are set with regard to the MAXRPM constant
     * @param speed A value from -1 to 1
     * @param speedB A value from -1 to 1
     */
    private void updateMotorRPM() {
        controller.setReference(speed*Constants.MAXRPM, ControlType.kVelocity);
        SmartDashboard.putNumber(Constants.DASH_SETSPEED, speed);
    }

    public void setPID(double p, double i, double d ) {
        if(p != kP) {
            kP = p;
            controller.setP(kP);   
            SmartDashboard.putNumber(Constants.DASH_P, kP); 
        }
        if(i != kI) {
            kI = i;
            controller.setI(kI);
            SmartDashboard.putNumber(Constants.DASH_I, kI);
        }
        if(d != kD) {
            kD = d;
            controller.setD(kD);
            SmartDashboard.putNumber(Constants.DASH_D, kD);
        }
    }

    public void setSpeed(double speed) {
        if(speed != this.speed) {
            this.speed = speed;
            updateMotorRPM();
        }
    }

    @Override
    public void periodic() {
        // update the SmartDashboard with current velocity
        SmartDashboard.putNumber(Constants.DASH_MEASUREDSPEED, encoder.getVelocity());  
    }

    @Override
    public void UpdateDashboard() {
        // TODO Auto-generated method stub

    }


}
