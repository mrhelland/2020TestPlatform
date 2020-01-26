package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


/**
 *
 */
public class MotorSystem extends SubsystemBase {

    private CANEncoder speedEncoderA;
    private CANEncoder speedEncoderB;
    private CANSparkMax motorA;
    private CANSparkMax motorB;

    private CANPIDController controllerA;
    private CANPIDController controllerB;
    private double kP_A, kP_B, kI_A, kI_B, kD_A, kD_B, kIz_A, kIz_B, kFf_A, kFf_B;
    private double speedA, speedB;

    public MotorSystem() {

        //initialize variables using default values
        kP_A = kP_B = Constants.MOTORS_P;
        kI_A = kI_B = Constants.MOTORS_I;
        kD_A = kD_B = Constants.MOTORS_D;
        kIz_A = kIz_B = Constants.MOTORS_Iz;
        kFf_A = kFf_B = Constants.MOTORS_Ff;
        speedA = speedB = 0;

        //initialize Motor A and all settings
        motorA = new CANSparkMax(Constants.MOTORA_ID, MotorType.kBrushless);
        motorA.restoreFactoryDefaults();
        motorA.setInverted(false);
        controllerA = motorA.getPIDController();
        controllerA.setP(kP_A);
        controllerA.setI(kI_A);
        controllerA.setD(kD_A);
        controllerA.setIZone(kIz_A);
        controllerA.setFF(kFf_A);
        controllerA.setOutputRange(-1, 1);

        //initialize Motor B and all settings
        motorB = new CANSparkMax(Constants.MOTORB_ID, MotorType.kBrushless);
        motorB.restoreFactoryDefaults();
        motorB.setInverted(false);
        controllerB = motorB.getPIDController();
        controllerB.setP(kP_B);
        controllerB.setI(kI_B);
        controllerB.setD(kD_B);
        controllerB.setIZone(kIz_B);
        controllerB.setFF(kFf_B);
        controllerB.setOutputRange(-1, 1);

        //obtain encoders from motor controllers
        speedEncoderA = motorA.getEncoder();       
        speedEncoderB = motorB.getEncoder();

        //intialize values on the SmartDashboard
        SmartDashboard.putNumber("MotorA P Gain", kP_A);
        SmartDashboard.putNumber("MotorA I Gain", kI_A);
        SmartDashboard.putNumber("MotorA D Gain", kD_A);
        SmartDashboard.putNumber("MotorA Speed Setting", speedA);

        SmartDashboard.putNumber("MotorB P Gain", kP_B);
        SmartDashboard.putNumber("MotorB I Gain", kI_B);
        SmartDashboard.putNumber("MotorB D Gain", kD_B);
        SmartDashboard.putNumber("MotorB Speed Setting", speedB);

        SmartDashboard.putNumber("MotorA Measured Velocity", speedEncoderA.getVelocity());
        SmartDashboard.putNumber("MotorB Measured Velocity", speedEncoderB.getVelocity());
      
    }
  
    /***
     * Motor speeds are set with regard to the MAXRPM constant
     * @param speedA A value from -1 to 1
     * @param speedB A value from -1 to 1
     */
    public void updateMotorRPM() {
        controllerA.setReference(speedA*Constants.MAXRPM, ControlType.kVelocity);
        controllerB.setReference(speedB*Constants.MAXRPM, ControlType.kVelocity);
    }


    @Override
    public void periodic() {

        try {
            // get and update all SmartDashboard values for MotorA
            double p_a, i_a, d_a, speed_a;
            p_a = SmartDashboard.getNumber("MotorA P Gain", 0);
            i_a = SmartDashboard.getNumber("MotorA I Gain", 0);
            d_a = SmartDashboard.getNumber("MotorA D Gain", 0);
            speed_a = SmartDashboard.getNumber("MotorA Speed Setting", 0);
            
            if(p_a != kP_A)
                controllerA.setP(p_a);
            if(i_a != kI_A)
                controllerA.setI(i_a);
            if(d_a != kD_A)
                controllerA.setD(d_a);
            if(speed_a != speedA) 
                speedA = speed_a;
        } catch (Exception ex) {
            System.out.println("Unable to set MotorA");
        }

        try {
            // get and update all SmartDashboard values for MotorB
            double p_b, i_b, d_b, speed_b;
            p_b = SmartDashboard.getNumber("MotorB P Gain", 0);
            i_b = SmartDashboard.getNumber("MotorB I Gain", 0);
            d_b = SmartDashboard.getNumber("MotorB D Gain", 0);
            speed_b = SmartDashboard.getNumber("MotorB Speed Setting", 0);
            if(p_b != kP_B)
                controllerB.setP(p_b);
            if(i_b != kI_B)
                controllerB.setI(i_b);
            if(d_b != kD_B)
                controllerB.setD(d_b);
            if(speed_b != speedB) 
                speedB = speed_b;

        } catch (Exception ex) {
            System.out.println("Unable to set MotorB");
        }

        // update the motor desired RPM
        updateMotorRPM();

        // update the SmartDashboard with current velocity
        SmartDashboard.putNumber("MotorA Measured Velocity", speedEncoderA.getVelocity());
        SmartDashboard.putNumber("MotorB Measured Velocity", speedEncoderB.getVelocity());
        
    }


}
