package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase{
    private final CommandXboxController m_driverController;
    private final VictorSPX m_left_front;
    private final VictorSPX m_right_front;
    private final VictorSPX m_left_rear;
    private final VictorSPX m_right_rear;
    //there could be more motors

    double drive_speed;
    double rotate_speed;
    
    private DriveTrain () {
        m_driverController = new CommandXboxController(Constants.OperatorConstants.kDriverControllerPort);
        m_left_front= new VictorSPX(Constants.drive_train.left_front_motor_id);
        m_right_front = new VictorSPX(Constants.drive_train.left_front_motor_id);
        m_right_rear = new VictorSPX(Constants.drive_train.right_rear_motor_id);
        m_left_rear = new VictorSPX(Constants.drive_train.left_rear_motor_id);

        m_left_rear.follow(m_left_front);
        m_right_rear.follow(m_right_front);

        m_right_front.setInverted(true);

        m_right_rear.setInverted(InvertType.FollowMaster);
        m_left_rear.setInverted(InvertType.FollowMaster);
    }

    @Override
    public void periodic() {
        drive_speed = m_driverController.getLeftY() * 0.5;
        rotate_speed = m_driverController.getRightX() * 0.5;
    }

    public void move() {
        m_left_front.set(VictorSPXControlMode.PercentOutput, drive_speed + rotate_speed);
        m_right_front.set(VictorSPXControlMode.PercentOutput, drive_speed - rotate_speed);
    }

    public void stop() {
        m_left_front.set(VictorSPXControlMode.PercentOutput, 0);
        m_right_front.set(VictorSPXControlMode.PercentOutput, 0);
    }

    private static DriveTrain instance;
    public static DriveTrain get_instance() {
        if(instance == null) {
            return new DriveTrain();
        }
        return instance;
    }
}
