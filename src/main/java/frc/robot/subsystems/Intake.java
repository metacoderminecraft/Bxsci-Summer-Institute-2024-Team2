// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports.IntakePorts;

  //intake roller
public class Intake extends SubsystemBase {
    
    private IntakeConstants intakeConstants = new IntakeConstants();
    private final CANSparkMax pivotMotor = new CANSparkMax(IntakePorts.pivot, MotorType.kBrushless);
    private final DigitalInput hopperBeamSensor = new DigitalInput(IntakePorts.intakeBeam);
    private final CANSparkMax rollerMotor = new CANSparkMax(IntakePorts.roller, MotorType.kBrushless);
    private Encoder pivotEncoder;
    private PIDController pivotController = new PIDController(intakeConstants.kp1,intakeConstants.kd1,intakeConstants.ki1); //it gives the change in radians
    private PIDController rollerController = new PIDController(intakeConstants.kp2, intakeConstants.kd2, intakeConstants.ki2);


    public void setPosition() { //
        double motorDegrees = pivotMotor.getEncoder().getPosition();
        double v = pivotController.calculate(motorDegrees, intakeConstants.targetDegrees.magnitude());
        pivotMotor.setVoltage(v);
    }


    public void setRoller(){
        double motorSpeed = pivotMotor.getEncoder().getVelocity();
        double v = rollerController.calculate(motorSpeed, intakeConstants.targetSpeed.magnitude());
        rollerMotor.setVoltage(v);


    @Override
    public void periodic() {
        setPosition();
        }
    }
}