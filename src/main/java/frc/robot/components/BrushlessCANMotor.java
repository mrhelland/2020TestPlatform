package frc.robot.components;

import java.util.ResourceBundle.Control;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

import com.revrobotics.CANPIDController;

//import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.Constants;
import frc.robot.helper.PIDValues;

public class BrushlessCANMotor implements SpeedController {
    // private CANEncoder encoder;
    // private SpeedController speedCont;
    private CANSparkMax motor;
    // private CANPIDController controller;
    private double value;
    private ControlType controlType;
    private double maxvalue;
    private PIDValues pidValues;

    // SpeedController speedController, SpeedController[] speedControllers
    public BrushlessCANMotor(int id) {
        this(id, Constants.MAXRPM, ControlType.kVelocity, new PIDValues());
    }

    public BrushlessCANMotor(int id, double maxvalue, ControlType controlType, PIDValues pid) {
        this.controlType = controlType;
        this.maxvalue = maxvalue;
        this.pidValues = pid;
        this.motor = new CANSparkMax(id, MotorType.kBrushless);
        this.motor.restoreFactoryDefaults();
        this.motor.setInverted(false);
        this.motor.getPIDController().setOutputRange(-1, 1);
        updatePID();
    }

    public double getValue() {
        return value;
    }

    public ControlType getControlType() {
        return controlType;
    }

    public void setPID(PIDValues pid) {
        this.pidValues = pid;
        updatePID();
    }

    private void updatePID() {
        CANPIDController controller = motor.getPIDController();
        controller.setP(pidValues.P);
        controller.setI(pidValues.I);
        controller.setD(pidValues.D);
        controller.setIZone(pidValues.Iz);
        controller.setFF(pidValues.Ff);
    }

    public PIDValues getPIDValues() {
        return this.pidValues;
    }


    public CANEncoder getEncoder() {
        return motor.getEncoder();
    }

    public CANSparkMax getMotor() {
        return this.motor;
    }

    public CANPIDController getController() {
        return this.motor.getPIDController();
    }

    @Override
    public void set(double value) {
        this.set(value, false);
    }

    public void set(double value, boolean forcedupdate) {
        if(value != this.value || forcedupdate) {
            this.value = value;
            updateValue();
        }
    }

    private void updateValue() {
        motor.getPIDController().setReference(value * this.maxvalue, this.controlType);
    }

    @Override
    public double get() {
        return this.value;
    }

    @Override
    public void setInverted(boolean isInverted) {
        this.motor.setInverted(isInverted);
    }

    @Override
    public boolean getInverted() {
        return this.motor.getInverted();
    }

    @Override
    public void disable() {
        this.motor.disable();

    }

    @Override
    public void stopMotor() {
        this.motor.stopMotor();
    }

    @Override
    public void pidWrite(double output) {
        this.motor.pidWrite(output);

    }
}