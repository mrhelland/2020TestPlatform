package frc.robot.helper;
import frc.robot.Constants;

public class PIDValues {
    private double pValue;
    private double iValue;
    private double dValue;
    private double izValue;
    private double ffValue;

    public PIDValues(){
        this(Constants.MOTORS_P, Constants.MOTORS_I, Constants.MOTORS_D, Constants.MOTORS_Iz, Constants.MOTORS_Ff);
    }
    public PIDValues(double[] pidarray){
        this(pidarray[0], pidarray[1], pidarray[2], pidarray[3], pidarray[4]);
    }
    public PIDValues(double P, double I, double D, double Iz, double Ff){
        this.pValue = P;
        this.iValue = I;
        this.dValue = D;
        this.izValue = Iz;
        this.ffValue = Ff;
    }

    public double[] toArray(){
        double[] result = {this.pValue, this.iValue, this.dValue, this.izValue, this.ffValue};
        return result;
    }

    public double P(){
        return this.pValue;
    }
    public double I(){
        return this.iValue;
    }
    public double D(){
        return this.dValue;
    }
    public double Iz(){
        return this.izValue;
    }
    public double Ff(){
        return this.ffValue;
    }
}