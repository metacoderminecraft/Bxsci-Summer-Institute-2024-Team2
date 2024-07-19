package frc.robot.subsystems;

import static edu.wpi.first.units.Units.MetersPerSecond;

import edu.wpi.first.units.Distance;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Velocity;

public class HopperConstants {    
    Measure<Velocity<Distance>> targetSpeed = MetersPerSecond.of (30); //Adjust as needed
    double kp3 = 0;
    double kd3 = 0;
    double ki3 = 0;

}

