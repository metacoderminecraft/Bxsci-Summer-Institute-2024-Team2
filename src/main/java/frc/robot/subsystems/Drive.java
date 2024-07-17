package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase{  
    private final CANSparkMax m_leftLeader = new CANSparkMax(DriveConstants.kleftMotor1Port, MotorType.kBrushless);
    private final CANSparkMax m_leftfollower = new CANSparkMax(DriveConstants.kleftMotor2Port, MotorType.kBrushless);
    
    private final CANSparkMax m_rightLeader = new CANSparkMax(DriveConstants.krightMotor1Port, MotorType.kBrushless);
    private final CANSparkMax m_rightfollower = new CANSparkMax(DriveConstants.krightMotor2Port, MotorType.kBrushless);
    
    public Drive() {
        m_rightfollower.follow(m_rightLeader);
        m_leftfollower.follow(m_leftLeader);
    }
    public void drive(double leftSpeed, double rightSpeed){
     m_leftLeader.set(leftSpeed);
     m_rightLeader.set(rightSpeed);
    }
}