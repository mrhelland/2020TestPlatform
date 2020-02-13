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
import frc.robot.helper.IUpdatesDash;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 *
 */
public class PositionSystem extends SubsystemBase implements IUpdatesDash{

    AnalogPotentiometer pot;


    public PositionSystem() {      
        pot = new AnalogPotentiometer(Constants.CLIMBERPOTID);
    }



  
    @Override
    public void periodic() {

    }

    public double getPosition() {
        return pot.get() * Constants.POTENTIOMETERTOINCHES;
    }

    @Override
    public void UpdateDashboard() {
        // TODO Auto-generated method stub

    }

}

