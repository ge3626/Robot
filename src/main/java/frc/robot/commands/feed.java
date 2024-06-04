package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Intake;

public class feed extends Command{
    private final Intake m_intake;

    Timer time = new Timer();
    
    public feed() {
        m_intake = Intake.get_instance();
        addRequirements(m_intake);
    }

    @Override
    public void initialize() {
        m_intake.set_zeroing();
    }

    @Override
    public void execute() {
        if(time.get() < 3) {
            m_intake.spin_stow();
        }
    }

    @Override
    public void end(boolean interrupted) {
       m_intake.stop_spin();
    }

    @Override
    public boolean isFinished() {
        return time.get() > 4;
    }
}
