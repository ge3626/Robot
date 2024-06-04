package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class control_solenoid extends Command{
    private Intake m_intake;

    public control_solenoid () {
        m_intake = Intake.get_instance();
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
        m_intake.solenoid_on();
    }

    @Override
    public void end(boolean interrupted) {
       m_intake.solenoid_off();
    }
}
