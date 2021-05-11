package frc.robot;

import org.xero1425.base.RobotSubsystem;
import org.xero1425.base.XeroRobot;
import org.xero1425.base.oi.OISubsystem;
import org.xero1425.base.tankdrive.TankDriveSubsystem;

public class RomiRobotSubsystem extends RobotSubsystem {
    public RomiRobotSubsystem(XeroRobot robot) throws Exception {
        super(robot, "RomiRobotSubsystem") ;

        TankDriveSubsystem db = new TankDriveSubsystem(this, "tankdrive", "tankdrive") ;
        addChild(db) ;
        addChild(new OISubsystem(this, "droidoi", db)) ;
    }
}
