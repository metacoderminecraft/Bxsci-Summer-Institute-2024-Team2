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
    
    public Command runHopper(double v) {
        return runOnce(() -> hopper.setVoltage(v))
    } 


    public Command forward() { 
        return runHopper(OPERATING_VOLTS).until(hopper.brokenBeam()).andThen(runHopper(0));
        
    }
    

    public Command forward() {
        hopper.setVoltage(OPERATING_VOLTS);
        if (hopper.brokenBeam()) {
            hopper.setVoltage(0); 
        }
        return
    }
    

    public Command backward(){
        hopper.setVoltage(-1 * OPERATING_VOLTS);
        return 
    }

    public static Hopper create() {
        return Robot.isReal() ? new Hopper(new RealHopper()): new Hopper(new SimHopper());
    }

}
