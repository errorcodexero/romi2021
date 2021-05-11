package frc.robot;

import org.xero1425.base.Subsystem;
import org.xero1425.base.oi.OISubsystem;
import org.xero1425.base.oi.TankDriveGamepad;
import org.xero1425.base.tankdrive.TankDriveSubsystem;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MessageLogger;
import org.xero1425.misc.MessageType;
import org.xero1425.misc.MissingParameterException;

public class RomiOISubsystem extends OISubsystem {
    private TankDriveGamepad gp_ ;

    public final static String SubsystemName = "romioi";
    private final static String DriverGamepadHIDIndexName = "hw:driverstation:hid:driver";

    public RomiOISubsystem(Subsystem parent, TankDriveSubsystem db) {
        super(parent, SubsystemName) ;

        MessageLogger logger = getRobot().getMessageLogger() ;
        int index;

        try {
            index = getRobot().getSettingsParser().get(DriverGamepadHIDIndexName).getInteger();
        } catch (BadParameterTypeException e) {
            logger.startMessage(MessageType.Error) ;
            logger.add("parameter ").addQuoted(DriverGamepadHIDIndexName) ;
            logger.add(" exists, but is not an integer").endMessage();
            index = -1 ;
        } catch (MissingParameterException e) {
            logger.startMessage(MessageType.Error) ;
            logger.add("parameter ").addQuoted(DriverGamepadHIDIndexName) ;
            logger.add(" does not exist").endMessage();
            index = -1 ;            
        }
        
        if (index != -1) {
            try {
                gp_ = new TankDriveGamepad(this, index, db) ;
                addHIDDevice(gp_);
            }
            catch(Exception ex) {
                logger.startMessage(MessageType.Error) ;
                logger.add("driver gamepad HID device was not created ").endMessage();
            }
        }
    }
   
    public TankDriveGamepad getGamepad() {
        return gp_ ;
    }
}
