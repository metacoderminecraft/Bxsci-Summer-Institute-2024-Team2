package frc.robot.Hopper;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;



public class RealHopper extends SubsystemBase implements HopperIO {
    private final CANSparkMax motor;
    private final DigitalInput beamBreak;
    
    public RealHopper() {
        motor = new CANSparkMax(0, MotorType.kBrushless);
        beamBreak = new DigitalInput(0);
    }
    @Override
    public void setVoltage(double v) {
        motor.setVoltage(v);
    }

    @Override
    public double getVoltage() {
        return motor.getBusVoltage();
    }

    @Override
    public boolean brokenBeam() {
        return beamBreak.equals(true);
    }
}
