package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;
import org.xero1425.base.tankdrive.TankDriveSubsystem;

public class RomiRobotSubsystem extends RobotSubsystem {
    
    private TankDriveSubsystem db_ ;

    public RomiRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "RomiRobotSubsystem") ;

        db_ = new TankDriveSubsystem(this, "tankdrive", "tankdrive") ;
        addChild(db_) ;
    }
}
