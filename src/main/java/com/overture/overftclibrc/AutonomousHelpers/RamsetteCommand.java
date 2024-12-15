package com.overture.overftclibrc.AutonomousHelpers;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.controller.wpilibcontroller.RamseteController;
import com.arcrobotics.ftclib.geometry.Pose2d;
import com.arcrobotics.ftclib.kinematics.wpilibkinematics.ChassisSpeeds;
import com.arcrobotics.ftclib.trajectory.Trajectory;
import com.arcrobotics.ftclib.util.Timing.Timer;

import java.util.concurrent.TimeUnit;

public class RamsetteCommand extends CommandBase {
    private final RamseteController controller;
    private final Trajectory trajectory;
    private final Timer timer;

    // Interface to abstract chassis dependencies
    public interface ChassisInterface {
        void setSpeed(double linearVelocity, double angularVelocity);
        Pose2d getPose(); // Replace with appropriate Pose class
    }

    private final ChassisInterface chassisInterface;

    // Constructor
    public RamsetteCommand(ChassisInterface chassisInterface, Trajectory trajectory) {
        this.chassisInterface = chassisInterface;
        this.trajectory = trajectory;

        controller = new RamseteController(10.0, 0.70);
        timer = new Timer((long) trajectory.getTotalTimeSeconds() * 1000, TimeUnit.MILLISECONDS);
    }

    @Override
    public void initialize() {
        timer.start();
    }

    @Override
    public void execute() {
        Trajectory.State desiredState = trajectory.sample(timer.elapsedTime() / 1000.0);
        ChassisSpeeds desiredSpeeds = controller.calculate(chassisInterface.getPose(), desiredState);
        chassisInterface.setSpeed(desiredSpeeds.vxMetersPerSecond, desiredSpeeds.omegaRadiansPerSecond);
    }

    @Override
    public void end(boolean interrupted) {
        chassisInterface.setSpeed(0, 0);
    }

    @Override
    public boolean isFinished() {
        return timer.done();
    }
}
