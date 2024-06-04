package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.feed;
import frc.robot.commands.move;
import frc.robot.commands.shoot;
import frc.robot.commands.spin_back;
import frc.robot.commands.spit;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;


public class RobotContainer {
  private final spit spit_command = new spit();
  private final shoot shoot_command = new shoot();
  private final feed feed_command = new feed();
  private final spin_back spin_back_command = new spin_back();
  //private final move move_command = new move();

  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    configureBindings();
  
  }

  private void configureBindings() {
   // m_driverController.leftStick().whileTrue(move_command);
    m_driverController.a().whileTrue(feed_command);
    m_driverController.y().whileTrue(shoot_command);
    m_driverController.x().whileTrue(spit_command);
    m_driverController.b().whileTrue(spin_back_command);
  }

  public Command getAutonomousCommand() {
    //returns auto command
    return null;
  }
}
