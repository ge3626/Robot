package frc.robot;

import edu.wpi.first.math.geometry.Rotation2d;

public final class Constants {
//TODO: set constants
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public final class drive_train {
    public static final int left_front_motor_id = 4;
    public static final int right_front_motor_id = 3;
    public static final int left_rear_motor_id = 5;
    public static final int right_rear_motor_id = 6;
  }

  public final class intake {
    public static final int roller_id = 7;
    public static final int arm_id = 1;
    public static final double stow_speed = -0.8;
    public static final double spit_speed = 0.8;
    public static final Rotation2d pos_arm_up = Rotation2d.fromDegrees(35);
    public static final Rotation2d pos_arm_down = Rotation2d.fromDegrees(0);
  }

  public final class shooter {
    public static final int shoot_roller_id = 2;
    public static final int elevation_motor_id = 2;
    public static final double shoot_speed = 1;
  }
}
