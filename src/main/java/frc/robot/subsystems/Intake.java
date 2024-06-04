package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
    private final VictorSPX m_intake_motor;
    private final VictorSPX m_conveyor_motor;

    private Intake() {
        m_intake_motor = new VictorSPX(Constants.intake.intake_roller_id); 
        m_conveyor_motor = new VictorSPX(Constants.intake.conveyor_motor_id);
    }
    
    public void spin_stow() {
        m_intake_motor.set(VictorSPXControlMode.PercentOutput, Constants.intake.stow_speed);
        m_conveyor_motor.set(VictorSPXControlMode.PercentOutput, Constants.intake.stow_speed);
        set_arm_down();
    }

    public void spin_spit() {
        m_intake_motor.set(VictorSPXControlMode.PercentOutput, Constants.intake.spit_speed);
        m_conveyor_motor.set(VictorSPXControlMode.PercentOutput, Constants.intake.spit_speed);
        set_arm_up();
    }

    public void stop_spin() {
        m_intake_motor.set(VictorSPXControlMode.PercentOutput, 0);
        m_conveyor_motor.set(VictorSPXControlMode.PercentOutput, 0);
    }

    public void spin_back() {
        m_intake_motor.set(VictorSPXControlMode.PercentOutput, -Constants.intake.spit_speed);
        m_conveyor_motor.set(VictorSPXControlMode.PercentOutput, -Constants.intake.spit_speed);
    }

    public void disable() {
        m_intake_motor.set(VictorSPXControlMode.PercentOutput, 0);
        m_conveyor_motor.set(VictorSPXControlMode.PercentOutput, 0);
    }

    //belows are not for kitbot
    public void set_zeroing() {
       //m_arm.setControl(m_zero_request);
    }

    public void set_arm_pos(Rotation2d angle, double ff) {
       // m_arm.setControl(m_hold_request.withPosition(angle.getRotations()).withFeedForward(ff));
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
