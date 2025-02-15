package frc.robot.subsystems.intake.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.intake.Intake;
import frc.robot.subsystems.misc.IRSensor;


public class UseIntake extends CommandBase {
    private Intake intake;
    private IRSensor irSensor;
    private double intakeMotorPower, transferMotorPower;

    public UseIntake(Intake intake, IRSensor irSensor, double intakeMotorPower, double transferMotorPower){
        this.intakeMotorPower = intakeMotorPower;
        this.transferMotorPower = transferMotorPower;
        addRequirements(intake);
        this.intake = intake;
        this.irSensor = irSensor;
    }

    @Override
    public void execute(){
        if(intake.isStale()) {
            intake.getIntakeMotor().set(ControlMode.PercentOutput, 0);
        } else {
            intake.getIntakeMotor().set(ControlMode.PercentOutput, intakeMotorPower);
        }
        if(irSensor.isThreeBallsIn()) {
            intake.getTransferMotor().set(ControlMode.PercentOutput, 0);
        } else {
            intake.getTransferMotor().set(ControlMode.PercentOutput, transferMotorPower);
        }
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        intake.getIntakeMotor().set(ControlMode.PercentOutput, 0);
        intake.getTransferMotor().set(ControlMode.PercentOutput, 0);
    }
}
