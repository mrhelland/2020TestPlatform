package frc.robot.components;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANPIDController;

import edu.wpi.first.wpilibj.SpeedController;

//import edu.wpi.first.wpilibj.SpeedController;
import frc.robot.Constants;
import frc.robot.helper.PIDValues;

public class BrushlessCANMotor implements SpeedController {
    private CANSparkMax motor;
    private double value;
    private ControlType controlType;
    private double scaleValue;
    private PIDValues pidValues;

    // SpeedController speedController, SpeedController[] speedControllers
    public BrushlessCANMotor(int id) {
        this(id, Constants.MAXRPM, ControlType.kVelocity, new PIDValues());
    }

    public BrushlessCANMotor(int id, double maxScaleValue, ControlType controlType, PIDValues pid) {
        this.controlType = controlType;
        this.scaleValue = maxScaleValue;
        this.pidValues = pid;
        this.motor = new CANSparkMax(id, MotorType.kBrushless);
        this.motor.restoreFactoryDefaults();
        this.motor.setInverted(false);
        this.motor.getPIDController().setOutputRange(-1, 1);
        updatePID();
    }

    public ControlType getControlType() {
        return controlType;
    }

    public PIDValues getPIDValues() {
        return this.pidValues;
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

    public double getScale() {
        return this.scaleValue;
    }

    public void setScale(double maxScaleValue) {
        this.scaleValue = maxScaleValue;
        updateMotor();
    }

    public CANSparkMax getMotor() {
        return this.motor;
    }

    public CANPIDController getController() {
        return this.motor.getPIDController();
    }

    public CANEncoder getEncoder() {
        return motor.getEncoder();
    }

    public double getVelocity() {
        return motor.getEncoder().getVelocity();
    }

    public double getPosition() {
        return motor.getEncoder().getPosition();
    }

    /**
     * @return The current value of the motor between -1 and 1.
     */
    @Override
    public double get() {
        return this.value;
    }

    /**
     * Sets percentage value for the motor dependent on the current ControlType.
     * @param value A value between -1 and 1.
     */
    @Override
    public void set(double value) {
        this.set(value, false);
    }

    /**
     * Sets percentage value for the motor dependent on the current ControlType.
     * @param value A value between -1 and 1 that is multipled by the Scale.
     * @param forcedupdate Update the underlying motor object even if the value has not changed.
     * @see BrushlessCANMotor#getScale() BrushlessCANMotor.getScale()
     */ 
    public void set(double value, boolean forcedupdate) {
        if(value != this.value || forcedupdate) {
            this.value = value;
            updateMotor();
        }
    }

    private void updateMotor() {
        motor.getPIDController().setReference(value * this.scaleValue, this.controlType);
    }

    @Override
    public boolean getInverted() {
        return this.motor.getInverted();
    }

    @Override
    public void setInverted(boolean isInverted) {
        this.motor.setInverted(isInverted);
    }

    @Override
    public void disable() {
        this.value = 0;
        this.motor.disable();
    }

    @Override
    public void stopMotor() {
        this.value = 0;
        this.motor.stopMotor();
    }

    @Override
    public void pidWrite(double output) {
        this.motor.pidWrite(output);

    }
}