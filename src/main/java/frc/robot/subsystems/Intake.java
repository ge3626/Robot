package frc.robot.subsystems;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private final TalonFX m_roller;
    private final TalonFX m_arm;

    //Grohi setup
    private final MotionMagicVoltage m_hold_request = new MotionMagicVoltage(0).withSlot(0);
    private final VoltageOut m_zero_request = new VoltageOut(-1.4);

    private Intake() {
        m_roller = new TalonFX(Constants.intake.roller_id); 
        m_arm = new TalonFX(Constants.intake.arm_id);
    }
    
    public void spin_stow() {
        m_roller.set(Constants.intake.stow_speed);
        set_arm_down();
    }

    public void spin_spit() {
        m_roller.set(Constants.intake.spit_speed);
        set_arm_up();
    }

    public void stop_spin() {
        m_roller.stopMotor();
    }

    public void disable() {
        m_roller.stopMotor();
        m_arm.stopMotor();
    }

    //belows are not for kitbot
    public void set_zeroing() {
        m_arm.setControl(m_zero_request);
    }

    public void set_arm_pos(Rotation2d angle, double ff) {
        m_arm.setControl(m_hold_request.withPosition(angle.getRotations()).withFeedForward(ff));
    }

    public void set_arm_down() {
        set_arm_pos(Constants.intake.pos_arm_down, 0.0);
    }

    public void set_arm_up() {
        set_arm_pos(Constants.intake.pos_arm_up, 0.0);
    }


    private static Intake instance;
    public static Intake get_instance() {
        if(instance == null) {
            return new Intake();
        }
        return instance;
    }
}
