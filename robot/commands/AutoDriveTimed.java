package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.*;

public class AutoDriveTimed extends CommandBase {


  private Drivetrain m_drivetrain;
  private Shooter m_shooter;
  private Timer m_timer;
  private double m_speed, m_endTime, m_speed2;

  /**
   * Creates a new AutoDriveTimed.
   */
  public AutoDriveTimed(Shooter shooter, Drivetrain drivetrain, double speed, double speed2, double endTime) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain, shooter);
    m_drivetrain = drivetrain;
    m_shooter = shooter;
    m_speed = speed;
    m_speed2 = speed2;
    m_endTime = endTime;
    m_timer = new Timer();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    while(m_timer.get() != 2.5) {
    m_drivetrain.tankDrive( m_speed,  m_speed2);
   // m_drivetrain.tankDrive(+ m_speed, m_speed2);
    
    m_drivetrain.tankDrive(m_speed, m_speed2);
    //m_drivetrain.tankDrive(+ m_speed, + m_speed2);
    
    m_drivetrain.tankDrive( m_speed,  m_speed2);
    //m_drivetrain.tankDrive(+ m_speed, + m_speed2);
    }
    m_shooter.setRightSpinMotorSpeed(-5.0);
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivetrain.tankDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_timer.get() >= m_endTime;
  }
}