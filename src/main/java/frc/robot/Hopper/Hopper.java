package frc.robot.Hopper;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.Hopper.RealHopper;
import frc.robot.Hopper.SimHopper;
import static frc.robot.Hopper.HopperConstants.*;

public class Hopper extends SubsystemBase {
    private final HopperIO hopper;

    public Hopper(HopperIO hopper){
        this.hopper = hopper;
        
    }

    public Command forward() {
        hopper.setVoltage(OPERATING_VOLTS);
        if (hopper.brokenBeam()) {
            hopper.setVoltage(0); 
        }
    }
    

    public Command backward(){
        hopper.setVoltage(-1 * OPERATING_VOLTS);
    }

    public static Hopper create() {
        return Robot.isReal() ? new Hopper(new RealHopper()): new Hopper(new SimHopper());
    }

}
