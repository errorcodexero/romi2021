package frc.robot;

import org.xero1425.base.actions.Action;
import org.xero1425.base.actions.DelayAction;
import org.xero1425.base.actions.InvalidActionRequest;
import org.xero1425.base.controllers.AutoController;
import org.xero1425.base.controllers.AutoMode;
import org.xero1425.base.tankdrive.TankDriveFollowPathAction;
import org.xero1425.base.tankdrive.TankDriveSubsystem;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MissingParameterException;
import org.xero1425.misc.MissingPathException;

public class RomiAutoMode extends AutoMode {
    public RomiAutoMode(AutoController ctrl)
            throws InvalidActionRequest, MissingPathException, BadParameterTypeException, MissingParameterException {
        super(ctrl, "RomiAutoMode") ;
        Action act ;

        TankDriveSubsystem db = ctrl.getRobot().getRobotSubsystem().getDB() ;

        act = new DelayAction(ctrl.getRobot(), 6.0) ;
        addAction(act);

        act = new TankDriveFollowPathAction(db, "TestRomi_Straight", false) ;
        addSubActionPair(db, act, true);
    }
}
