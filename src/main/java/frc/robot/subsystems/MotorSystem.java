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
        controllerA.setIZone(kIz_B);
        controllerA.setFF(kFf_B);
        controllerB.setOutputRange(-1, 1);

        //obtain encoders from motor controllers
        speedEncoderA = motorA.getEncoder();       
        speedEncoderB = motorB.getEncoder();

        //intialize values on the SmartDashboard
        SmartDashboard.putNumber("MotorA: P Gain", kP_A);
        SmartDashboard.putNumber("MotorA: I Gain", kI_A);
        SmartDashboard.putNumber("MotorA: D Gain", kD_A);
        SmartDashboard.putNumber("MotorA: Speed Setting", speedA);

        SmartDashboard.putNumber("MotorB: P Gain", kP_B);
        SmartDashboard.putNumber("MotorB: I Gain", kI_B);
        SmartDashboard.putNumber("MotorB: D Gain", kD_B);
        SmartDashboard.putNumber("MotorB: Speed Setting", speedB);

        SmartDashboard.putNumber("MotorA: Measured Velocity", speedEncoderA.getVelocity());
        SmartDashboard.putNumber("MotorB: Measured Velocity", speedEncoderB.getVelocity());
      
    }
  
    /***
     * Motor speeds are set with regard to the MAXRPM constant
     * @param speedA A value from -1 to 1
     * @param speedB A value from -1 to 1
     */
    public void setMotorRPM(double speedA, double speedB) {
        controllerA.setReference(speedA*Constants.MAXRPM, ControlType.kVelocity);
        controllerB.setReference(speedB*Constants.MAXRPM, ControlType.kVelocity);
    }


    @Override
    public void periodic() {
        double p, i, d, speed;

        // get and update all SmartDashboard values for MotorA
        p = SmartDashboard.getNumber("MotorA: P Gain", 0);
        i = SmartDashboard.getNumber("MotorA: I Gain", 0);
        d = SmartDashboard.getNumber("MotorA: D Gain", 0);
        speed = SmartDashboard.getNumber("MotorA: Speed Setting", 0);
        
        if(p != kP_A)
            controllerA.setP(p);
        if(i != kI_A)
            controllerA.setI(i);
        if(d != kD_A)
            controllerA.setD(d);
        if(speed != speedA) speedA = speed;

        // get and update all SmartDashboard values for MotorB
        p = SmartDashboard.getNumber("MotorB: P Gain", 0);
        i = SmartDashboard.getNumber("MotorB: I Gain", 0);
        d = SmartDashboard.getNumber("MotorB: D Gain", 0);
        speed = SmartDashboard.getNumber("MotorB: Speed Setting", 0);
        if(p != kP_B)
            controllerB.setP(p);
        if(i != kI_B)
            controllerB.setI(i);
        if(d != kD_B)
            controllerB.setD(d);
        if(speed != speedB) speedB = speed;

        // update the SmartDashboard with current velocity
        SmartDashboard.putNumber("MotorA: Measured Velocity", speedEncoderA.getVelocity());
        SmartDashboard.putNumber("MotorB: Measured Velocity", speedEncoderB.getVelocity());
        
        // update the motor desired RPM
        setMotorRPM(speedA, speedB);

    }


}
