package frc.robot;

import org.xero1425.base.controllers.AutoController;
import org.xero1425.misc.BadParameterTypeException;
import org.xero1425.misc.MessageLogger;
import org.xero1425.misc.MessageType;
import org.xero1425.misc.MissingParameterException;

public class RomiAutoController extends AutoController {
    private RomiAutoMode mode_;
    private RomiTestAutoMode test_mode_ ;

    RomiAutoController(Romi robot) throws MissingParameterException, BadParameterTypeException {
        super(robot, "romi-auto") ;

        try {
            mode_ = new RomiAutoMode(this) ;
        }
        catch(MissingParameterException ex) {
            MessageLogger logger = robot.getMessageLogger() ;
            logger.startMessage(MessageType.Error) ;
            logger.add("Missing parameter '" + ex.getParameter() + "' creating automode")  ;
            logger.endMessage();
        }
        catch(Exception ex) {
            MessageLogger logger = robot.getMessageLogger() ;
            logger.startMessage(MessageType.Error) ;
            logger.add("Exception thrown creating automode - " + ex.toString()) ;
            logger.endMessage();

            mode_ = null ;
            test_mode_ = null ;
        }

        try {
            test_mode_ = new RomiTestAutoMode(this) ;
        }
        catch(MissingParameterException ex) {
            MessageLogger logger = robot.getMessageLogger() ;
            logger.startMessage(MessageType.Error) ;
            logger.add("Missing parameter '" + ex.getParameter() + "' creating test automode")  ;
            logger.endMessage();
        }
        catch(Exception ex) {
            MessageLogger logger = robot.getMessageLogger() ;
            logger.startMessage(MessageType.Error) ;
            logger.add("Exception thrown creating test automode - " + ex.toString()) ;
            logger.endMessage();

            mode_ = null ;
            test_mode_ = null ;
        }

        updateAutoMode(0, "");
    }

    public void updateAutoMode(int mode, String gamedata) {
        if (isTestMode()) {
            setAutoMode(test_mode_) ;
        }
        else {
            setAutoMode(mode_) ;
        }
    }
}
