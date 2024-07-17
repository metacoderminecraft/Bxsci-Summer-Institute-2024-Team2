// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.IntakePorts;

  //intake roller
public class Intake extends SubsystemBase {
    private final CANSparkMax pivotMotor = new CANSparkMax(IntakePorts.pivot, MotorType.kBrushless);
    private final DigitalInput hopperBeamSensor = new DigitalInput(IntakePorts.intakeBeam);
    private final CANSparkMax rollerMotor = new CANSparkMax(IntakePorts.roller, MotorType.kBrushless);
    private Encoder pivotEncoder;
    private double targetDegrees = -60.0; // Adjust as needed


    @Override
    public void periodic() {
        double motorDegrees = pivotMotor.getEncoder().getPosition();

        if (intake.runIntake();) { //when 
            while (motorDegrees > targetDegrees) {
                pivotMotor.set(-0.5); // Move motor down
                motorDegrees = pivotMotor.getEncoder().getPosition(); // Update position
            }
            pivotMotor.set(0); // Stop motor once condition is met
            rollerMotor.set(0); // Stop roller motor
        } else {
            while (motorDegrees > targetDegrees) {
                pivotMotor.set(-0.5); // Move motor down
                motorDegrees = pivotMotor.getEncoder().getPosition(); // Update position
            }
            pivotMotor.set(0); // Stop motor once condition is met
            rollerMotor.set(0.5); // Start roller motor
        }
    }

  public void intake() {
    
  }
}

