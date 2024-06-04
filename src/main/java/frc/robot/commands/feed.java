package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class feed extends Command{
    private final Intake m_intake;
    
    public feed() {
        m_intake = Intake.get_instance();
        addRequirements(m_intake);
    }

    @Override
    public void execute() {
         m_intake.spin_stow();
    }

    @Override
    public void end(boolean interrupted) {
       m_intake.stop_spin();
    }
}
