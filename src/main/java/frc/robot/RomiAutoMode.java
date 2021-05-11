package frc.robot;

import org.xero1425.base.actions.Action;
import org.xero1425.base.actions.DelayAction;
import org.xero1425.base.actions.InvalidActionRequest;
import org.xero1425.base.controllers.AutoController;
import org.xero1425.base.controllers.AutoMode;
import org.xero1425.base.tankdrive.TankDrivePowerAction;
import org.xero1425.base.tankdrive.TankDriveSubsystem;

public class RomiAutoMode extends AutoMode {
    public RomiAutoMode(AutoController ctrl) throws InvalidActionRequest {
        super(ctrl, "RomiAutoMode") ;
        Action act ;
        TankDriveSubsystem db = ctrl.getRobot().getRobotSubsystem().getDB() ;

        // Drive for 2 seconds
        act = new TankDrivePowerAction(db, 0.5, 0.5, 2.0) ;
        addSubActionPair(db, act, true);

        // Delay for 1 second
        act = new DelayAction(ctrl.getRobot(), 1.0) ;
        addAction(act);

        // Drive for 2 seconds
        act = new TankDrivePowerAction(db, 0.5, 0.5, 2.0) ;       
        addSubActionPair(db, act, true);
    }
}
