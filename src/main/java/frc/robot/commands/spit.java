package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class spit extends Command {
    private final Intake m_intake;
    private final Shooter m_shooter;

    public spit() {
        m_intake = Intake.get_instance();
        m_shooter = Shooter.get_instance();
        addRequirements(m_intake, m_shooter);
    }

    @Override
    public void execute() {
        m_intake.spin_spit();
    }

    @Override
    public void end(boolean interrupted) {
        m_intake.stop_spin();
    }
}