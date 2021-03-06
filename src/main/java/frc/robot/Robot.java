// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package frc.robot;

import edu.wpi.first.hal.FRCNetComm.tInstances;
import edu.wpi.first.hal.FRCNetComm.tResourceType;

import java.util.ArrayList;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.helper.IUpdatesDash;
import frc.robot.subsystems.*;

//import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
//import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardLayout;
//import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;

    /**
     * The VM is configured to automatically run this class, and to call the
     * functions corresponding to each mode, as described in the TimedRobot
     * documentation. If you change the name of this class or the package after
     * creating this project, you must also update the build.properties file in 
     * the project.
     */
public class Robot extends TimedRobot {

    CommandBase autonomousCommand;
    SendableChooser<CommandBase> chooser = new SendableChooser<>();

    public static OI oi;
        public static ColorSystem colorSystem;
        public static MotorSystem motorSystem;
        public static PixySystem pixySystem;
        public static PositionSystem positionSystem;

        ArrayList<IUpdatesDash> subsystems = new ArrayList<IUpdatesDash>();

            /**
             * This function is run when the robot is first started up and should be
             * used for any initialization code.
             */
        @Override
        public void robotInit() {

            colorSystem = new ColorSystem();
            motorSystem = new MotorSystem();
            pixySystem = new PixySystem();
            positionSystem = new PositionSystem();

            subsystems.add(colorSystem);
            subsystems.add(motorSystem);

            for (IUpdatesDash dash : subsystems) {
                dash.UpdateDashboard();
            }
            

            // OI must be constructed after subsystems. If the OI creates Commands
            //(which it very likely will), subsystems are not guaranteed to be
            // constructed yet. Thus, their requires() statements may grab null
            // pointers. Bad news. Don't move it.
            oi = new OI();

            HAL.report(tResourceType.kResourceType_Framework, tInstances.kFramework_RobotBuilder);

        }

        /**
         * This function is called when the disabled button is hit.
         * You can use it to reset subsystems before shutting down.
         */
    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        CommandScheduler.getInstance().run();
    }

    @Override
    public void testInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void testPeriodic() {
        CommandScheduler.getInstance().run();
    }
}
