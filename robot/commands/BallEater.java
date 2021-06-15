package frc.robot.commands;


//import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;


public class BallEater extends CommandBase {
  /**
   * 
   */

  public double speed = 0;
  private XboxController m_xbox;
  private Shooter m_shooter;

  public BallEater(Shooter shooter, XboxController xbox) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(shooter);
    m_shooter = shooter;
    m_xbox = xbox;
  }

  private ShuffleboardTab m_tab;

  public BallEater(ShuffleboardTab tab) {
    m_tab = tab;
    configureShuffleboardData();
  }

  private void configureShuffleboardData() {
    m_tab.add(this);    
  }

// Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    //end(true);
    /*if(m_xbox.getAButton() == true){
     speed = 2.5;
    }else{
     speed = 0;

    }*/
    if (m_xbox.getAButton() == true){
      speed = -10.0;
    }
    if (m_xbox.getBButton() == true){
    speed = 0;
    }
    if (m_xbox.getXButton() == true){
      speed = 10.0;
    }
    m_shooter.setLeftSpinMotorSpeed(speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
   
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}