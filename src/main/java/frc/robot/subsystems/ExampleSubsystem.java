// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends TimedRobot {
  private final PWMSparkMax rollerMotor1 = new PWMSparkMax(0);  
  private final PWMSparkMax rollerMotor2 = new PWMSparkMax(1);  
  private final   
  private final 


  public void Update(XboxController controller) {
    SmartDashboard.putBoolean("Button Pressed", controller.getRawButton(1));
    System.out.println("Button state: " + controller.getRawButton(1));
     if (controller.getRawButton(1)) {
      // Button is pressed and moving pivot motor to the target position
      rollerMotor1.set(0.5);
      rollerMotor2.set(0.5);

    } else {
      // Button is not pressed, turn off all motors
      rollerMotor1.set(0.0);
      rollerMotor2.set(0.0);


    }
  }
  public void 
}