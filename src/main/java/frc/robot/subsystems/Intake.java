// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Intake extends TimedRobot {
  private final PWMSparkMax rollerMotor1 = new PWMSparkMax(0);  
  private final PWMSparkMax rollerMotor2 = new PWMSparkMax(1);  
  private final PWMSparkMax rollerMotor3 = new PWMSparkMax(2);  

  private final DigitalInput beambreakone = new DigitalInput(3);
  private final DigitalInput beambreaktwo = new DigitalInput(4);
  
  private boolean conveyon = false;

  public void teleopPeriodic() {
    updateBeamBreak();
  }

  public void updateBeamBreak() {
    if (!beambreakone.get()) {
      conveyon = true;
    }
    if (!beambreaktwo.get() && conveyon) {
      conveyon = false;
    }
    if (conveyon == true) {
      rollerMotor1.set(0.5);
      rollerMotor2.set(0.5);
      rollerMotor3.set(0.5);
    } else {
      rollerMotor1.set(0);
      rollerMotor2.set(0);
      rollerMotor3.set(0);
    }
  }
}
