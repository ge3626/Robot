package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private final CommandXboxController m_driverController;
    private final TalonFX m_left1;
    private final TalonFX m_right1;
    //there could be more motors

    double drive_speed;
    double rotate_speed;
    
    private DriveTrain () {
        m_driverController = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
        m_left1= new TalonFX(Constants.drive_train.left_motor_id); 
        m_right1 = new TalonFX(Constants.drive_train.right_motor_id);
    }

    @Override
    public void periodic() {
        drive_speed = m_driverController.getLeftY();
        rotate_speed = m_driverController.getRightX();
    }

    public void move() {
        m_left1.set(drive_speed + rotate_speed);
        m_right1.set(drive_speed - rotate_speed);
    }

    public void stop() {
        m_left1.stopMotor();
        m_right1.stopMotor();
    }

    private static DriveTrain instance;
    public static DriveTrain get_instance() {
        if(instance == null) {
            return new DriveTrain();
        }
        return instance;
    }
}
