package frc.robot.helper;
import frc.robot.Constants;

public class PIDValues {
    public final double P;
    public final double I;
    public final double D;
    public final double Iz;
    public final double Ff;

    public PIDValues(){
        this(Constants.MOTORS_P, Constants.MOTORS_I, Constants.MOTORS_D, Constants.MOTORS_Iz, Constants.MOTORS_Ff);
    }

    public PIDValues(double P, double I, double D, double Iz, double Ff){
        this.P = P;
        this.I = I;
        this.D = D;
        this.Iz = Iz;
        this.Ff = Ff;
    }

}