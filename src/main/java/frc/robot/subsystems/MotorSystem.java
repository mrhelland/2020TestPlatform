package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.EncoderType;
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
    private double kP_A, kP_B, kI_A, kI_B, kD_A, kD_B;

    public MotorSystem() {
        kP_A = kP_B = Constants.MOTORS_P;
        kI_A = kI_B = Constants.MOTORS_I;
        kD_A = kD_B = Constants.MOTORS_D;

                
        motorA = new CANSparkMax(Constants.MOTORA_ID, MotorType.kBrushless);
        motorA.restoreFactoryDefaults();
        motorA.setInverted(false);
        controllerA = motorA.getPIDController();
        controllerA.setP(kP_A);
        controllerA.setI(kI_A);
        controllerA.setD(kD_A);
        controllerA.setOutputRange(-1, 1);
        SmartDashboard.putNumber("MotorA: P Gain", kP_A);
        SmartDashboard.putNumber("MotorA: I Gain", kI_A);
        SmartDashboard.putNumber("MotorA: D Gain", kD_A);

        speedEncoderA = motorA.getEncoder();
        SmartDashboard.putNumber("MotorA: Velocity", speedEncoderA.getVelocity());

                
        motorB = new CANSparkMax(Constants.MOTORB_ID, MotorType.kBrushless);
        motorB.restoreFactoryDefaults();
        motorB.setInverted(false);
        controllerB = motorB.getPIDController();
        controllerB.setP(kP_B);
        controllerB.setI(kI_B);
        controllerB.setD(kD_B);
        controllerB.setOutputRange(-1, 1);
        SmartDashboard.putNumber("MotorB: P Gain", kP_B);
        SmartDashboard.putNumber("MotorB: I Gain", kI_B);
        SmartDashboard.putNumber("MotorB: D Gain", kD_B);

        
        speedEncoderB = motorB.getEncoder();
        SmartDashboard.putNumber("MotorB: Velocity", speedEncoderB.getVelocity());
                  
    }
  
    public void setMotorSpeed(double speedA, double speedB) {
        controllerA.setReference(speedA, ControlType.kVelocity);
        controllerA.setReference(speedA, ControlType.kVelocity);
    }

    @Override
    public void periodic() {
        double p, i, d;

        p = SmartDashboard.getNumber("MotorA: P Gain", 0);
        i = SmartDashboard.getNumber("MotorA: I Gain", 0);
        d = SmartDashboard.getNumber("MotorA: D Gain", 0);
        if(p != kP_A)
            controllerA.setP(p);
        if(i != kI_A)
            controllerA.setI(i);
        if(d != kD_A)
            controllerA.setI(d);

        p = SmartDashboard.getNumber("MotorB: P Gain", 0);
        i = SmartDashboard.getNumber("MotorB: I Gain", 0);
        d = SmartDashboard.getNumber("MotorB: D Gain", 0);
        if(p != kP_B)
            controllerB.setP(p);
        if(i != kI_B)
            controllerB.setI(i);
        if(d != kD_B)
            controllerB.setI(d);

        SmartDashboard.putNumber("MotorA: Velocity", speedEncoderA.getVelocity());
        SmartDashboard.putNumber("MotorB: Velocity", speedEncoderB.getVelocity());

    }



}
