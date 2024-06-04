package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
    private final TalonFX m_shoot_roller;
    private final TalonFX m_elevation; //not for kitbot

    private Shooter() {
        m_shoot_roller = new TalonFX(Constants.shooter.shoot_roller_id);
        m_elevation = new TalonFX(Constants.shooter.elevation_motor_id);
    }

    public void start_shooting() {
        m_shoot_roller.set(Constants.shooter.shoot_speed);
    }
    
    public void stop_shooting() {
        m_shoot_roller.stopMotor();
    }
    
    //not for kitbot
    public void set_elevation() {
        
    }

    public void disable() {
        m_shoot_roller.stopMotor();
        m_elevation.stopMotor();
    }

    private static Shooter instance;
    public static Shooter get_instance() {
        if(instance == null) {
            return new Shooter();
        }
        return instance;
    }
}
