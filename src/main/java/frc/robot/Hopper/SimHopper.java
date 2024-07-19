package frc.robot.Hopper;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.SimDeviceSim;


public class SimHopper implements HopperIO {
  private final DCMotorSim motor;
  private final SimDeviceSim beam;
  public SimHopper(){
    motor = new DCMotorSim(LinearSystemId.createDCMotorSystem(1, 2), DCMotor.getNeoVortex(1), 3);
    beam = new SimDeviceSim(1);
  }
  
  @Override
  public void setVoltage(double v) {
    motor.setInputVoltage(v);
  }

  @Override
  public double getVoltage() {
    return motor.getAngularPositionRad();
  }

  @Override
  public boolean brokenBeam() {
    return beam.equals(true);
  }
}
