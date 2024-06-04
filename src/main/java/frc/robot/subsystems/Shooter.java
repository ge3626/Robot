package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private final VictorSPX m_roller1;
    private final VictorSPX m_roller2;
    private final VictorSPX m_elevation; //not for kitbot

    private Shooter() {
        m_roller1 = new VictorSPX(Constants.shooter.roller_1);
        m_roller2 = new VictorSPX(Constants.shooter.roller_2);
        m_elevation = new VictorSPX(Constants.shooter.elevation_motor_id);
    }

    public void start_shooting() {
        m_roller1.set(VictorSPXControlMode.PercentOutput, Constants.shooter.shoot_speed);
        m_roller2.set(VictorSPXControlMode.PercentOutput, Constants.shooter.shoot_speed);
    }
    
    public void stop_shooting() {
        m_roller1.set(VictorSPXControlMode.PercentOutput, 0);
        m_roller2.set(VictorSPXControlMode.PercentOutput, 0);
    }
    
    //not for kitbot
    public void set_elevation() {
        
    }

    public void disable() {
        m_roller1.set(VictorSPXControlMode.PercentOutput, 0);
        m_roller2.set(VictorSPXControlMode.PercentOutput, 0);
        m_elevation.set(VictorSPXControlMode.PercentOutput, 0);
    }

    private static Shooter instance;
    public static Shooter get_instance() {
        if(instance == null) {
            return new Shooter();
        }
        return instance;
    }
}
