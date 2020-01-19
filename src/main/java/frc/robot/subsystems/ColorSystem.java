// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3;

/**
 *
 */
public class ColorSystem extends SubsystemBase {

    private final ColorSensorV3 colorSensor = new ColorSensorV3(Constants.COLORSENSOR_I2C);

    private Color prevColor;
    private Color currentColor;
    private int consistentCount;
    private int inconsistentCount;


    public ColorSystem() {      
        prevColor = Color.kBlack;
        currentColor = Color.kWhite;
    }

    public Color getColor() {

        return currentColor;
    }

    public double getConsistency() {
        return (double)consistentCount / (double)(consistentCount + inconsistentCount);
    }

    public double getInfraRed() {
        return colorSensor.getIR();
    }

    public String getStringRGB() {
        return "R:" + colorSensor.getRed() + " G:" + colorSensor.getGreen() + " B:" + colorSensor.getBlue();
    }

    @Override
    public void periodic() {
        currentColor = colorSensor.getColor();
        prevColor = currentColor;
        isSimilar(prevColor, currentColor);
    }

    private boolean isSimilar(Color a, Color b) {
        if( Math.abs(a.red - b.red) < Constants.COLORCHANNELTOLERANCE && 
            Math.abs(a.green - b.green) < Constants.COLORCHANNELTOLERANCE &&
            Math.abs(a.blue - b.blue) < Constants.COLORCHANNELTOLERANCE ) 
        {
            consistentCount++;
            return true;
        } else {
           inconsistentCount++;
            return false;
       }
    }
}

