package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
    private final CANSparkMax motor = new CANSparkMax(7,MotorType.kBrushless);
    private double power;
    private final DigitalInput input = new DigitalInput (0);
    private final DigitalInput limit = new DigitalInput (5);

    public Shooter () {
        if input.get() = false {
            turnOn();
        }
        
        else {
          turnOff();                            
        }
    }
    
    public void turnOn(){
        motor.set(power);
    }

    public void turnOff(){
        motor.set(0);
    }

    public void Overshoot() {
        power -= 0.001;
    }

    public void UnderShoot() {
        power += 0.001;
    }

    public void Record() {
        System.out.println(power);
    }
;
    public void periodic (){

    }
}
