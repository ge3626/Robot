package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class spin_back extends Command{
    private final Intake m_intake;

    public spin_back() {
        m_intake = Intake.get_instance();
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
        m_intake.spin_back();
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.stop_spin();
    }
}
