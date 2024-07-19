package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.IntakePorts;

public class Hopper extends SubsystemBase {
  private AbsoluteEncoder rollerMotortwoEncoder;
  private HopperConstants hopperConstants = new HopperConstants();
  private final DigitalInput hopperBeamSensor = new DigitalInput(IntakePorts.intakeBeam);
  private final CANSparkMax rollerMotortwo = new CANSparkMax(IntakePorts.roller, MotorType.kBrushless);
  private PIDController rollerController = new PIDController(hopperConstants.kp3, hopperConstants.kd3, hopperConstants.ki3);
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

    double motorSpeed =  rollerMotortwoEncoder.getVelocity();
    double v = rollerController.calculate(motorSpeed, hopperConstants.targetSpeed.magnitude());
    rollerMotortwo.setVoltage(v);

  }

  public void stopElev() {
rollerMotortwo.set(0);
  }
}
