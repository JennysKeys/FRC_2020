package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.RobotContainer;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Limelight;

import java.util.HashSet;
import java.util.Set;

public class TargetAiming implements Command {
    Set<Subsystem> subsystems;
    Drivetrain drivetrain;
    double leftPower, rightPower, turningOffset, distanceOffset;
    double turningkP = 0.006;
    double distancekP = 0.02;
    double allowedDistanceError = 20;

    public TargetAiming(Drivetrain drivetrain) {
        subsystems = new HashSet<Subsystem>();
        this.drivetrain = drivetrain;
        subsystems.add(RobotContainer.drivetrain);
    }

    public void execute() {
        if (RobotContainer.limelight.hasTarget()) {
            turningOffset = RobotContainer.limelight.getXOffset();
            distanceOffset = allowedDistanceError - RobotContainer.limelight.getYOffset();
            leftPower = (distanceOffset * distancekP) + (turningOffset * turningkP);
            rightPower = (distanceOffset * distancekP) - (turningOffset * turningkP);
            drivetrain.getLeftTransmission().getMaster().set(leftPower);
            drivetrain.getRightTransmission().getMaster().set(rightPower);
        }
    }

    @Override
    public Set<Subsystem> getRequirements() {
        return subsystems;
    }
}
