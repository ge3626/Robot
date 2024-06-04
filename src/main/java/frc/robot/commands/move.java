package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrain;

public class move extends Command {
    private final DriveTrain m_driveTrain;
    
    public move() {
        m_driveTrain = DriveTrain.get_instance();
        addRequirements(m_driveTrain);
    }

    @Override
    public void execute() {
       m_driveTrain.move();
    }

    @Override
    public void end(boolean interrupted) {
        m_driveTrain.stop();
    }
}
