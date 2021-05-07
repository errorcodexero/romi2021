package frc.robot;

import org.xero1425.base.controllers.AutoController;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MissingParameterException;

public class RomiAutoController extends AutoController {
    private RomiAutoMode mode_;

    RomiAutoController(Romi robot) throws MissingParameterException, BadParameterTypeException {
        super(robot, "romi-auto") ;

        try {
            mode_ = new RomiAutoMode(this) ;
        }
        catch(Exception ex) {
            mode_ = null ;
        }

        setAutoMode(mode_) ;
    }

    public void updateAutoMode(int mode, String gamedata) {
        setAutoMode(mode_) ;
    }
}
