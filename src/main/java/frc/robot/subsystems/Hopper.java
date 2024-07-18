package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;


import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.IntakePorts;

public class Hopper extends SubsystemBase {
  private final DigitalInput hopperBeamSensor = new DigitalInput(IntakePorts.intakeBeam);
  private final CANSparkMax rollerMotortwo = new CANSparkMax(IntakePorts.roller, MotorType.kBrushless);
      @Override
  public void periodic() {
    //hopper
    if (!hopperBeamSensor.get()) {
      runElev();
    }
    else if (hopperBeamSensor.get()) {
      stopElev();
    }
  }

  public void runElev() {
      rollerMotortwo.set(0.5);
  }

  public void stopElev() {
      rollerMotortwo.set(0);
  }
}
