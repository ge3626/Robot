package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Shooter;

public class shoot extends Command {
    private final Shooter m_shooter;

    public shoot() {
        m_shooter = Shooter.get_instance();
        addRequirements(m_shooter);
    }

    @Override
    public void execute() {
         m_shooter.start_shooting();
    }

    @Override
    public void end(boolean interrupted) {
       m_shooter.stop_shooting();
    }
}
