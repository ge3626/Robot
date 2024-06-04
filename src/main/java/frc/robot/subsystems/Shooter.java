package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private final VictorSPX m_intake_conveyor;
    private final TalonSRX master_shooter;
    private final VictorSPX slave_shooter;
    
    private Shooter() {
        m_intake_conveyor = new VictorSPX(Constants.intake.conveyor_motor_id);
        master_shooter = new TalonSRX(Constants.shooter.master_shooter_id);
        slave_shooter = new VictorSPX(Constants.shooter.slave_shooter_id);

        slave_shooter.follow(master_shooter);
        slave_shooter.setInverted(true);
    }

    public void start_shooting() {
       m_intake_conveyor.set(VictorSPXControlMode.PercentOutput, Constants.shooter.shoot_speed);
       master_shooter.set(TalonSRXControlMode.PercentOutput, Constants.shooter.shoot_speed);
       slave_shooter.set(VictorSPXControlMode.PercentOutput, Constants.shooter.shoot_speed);
    }
    
    public void stop_shooting() {
        m_intake_conveyor.set(VictorSPXControlMode.PercentOutput, 0);
        master_shooter.set(TalonSRXControlMode.PercentOutput, 0);
        slave_shooter.set(VictorSPXControlMode.PercentOutput, 0);
    }

    private static Shooter instance;
    public static Shooter get_instance() {
        if(instance == null) {
            return new Shooter();
        }
        return instance;
    }
}
