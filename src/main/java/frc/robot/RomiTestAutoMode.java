package frc.robot;

import org.xero1425.base.actions.InvalidActionRequest;
import org.xero1425.base.controllers.TestAutoMode;
import org.xero1425.base.tankdrive.TankDriveFollowPathAction;
import org.xero1425.base.tankdrive.TankDrivePowerAction;
import org.xero1425.base.tankdrive.TankDriveScrubCharAction;
import org.xero1425.base.tankdrive.TankDriveSubsystem;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MissingParameterException;
import org.xero1425.misc.MissingPathException;

public class RomiTestAutoMode extends TestAutoMode {
    public RomiTestAutoMode(RomiAutoController ctrl)
            throws BadParameterTypeException, MissingParameterException, InvalidActionRequest, MissingPathException {
        super(ctrl, "Romi-Test_mode") ;

        RomiRobotSubsystem romi = (RomiRobotSubsystem)ctrl.getRobot().getRobotSubsystem() ;
        TankDriveSubsystem db = romi.getDB() ;

        switch(getTestNumber()) {
            case 0:         // Drive straight, used to test and get Kv number
                addSubActionPair(db, new TankDrivePowerAction(db, getPower(), getPower(), getDuration()), true);
                break ;

            case 1:         // Rotate robot to get scrub factor
                addSubActionPair(db, new TankDriveScrubCharAction(db, getPower(), getPosition()), true);
                break ;                 

            case 2:         // Run the path follower to follow a named path
                addSubActionPair(db, new TankDriveFollowPathAction(db, getNameParam(), false), true) ;
                break ;
        }
    }
}
