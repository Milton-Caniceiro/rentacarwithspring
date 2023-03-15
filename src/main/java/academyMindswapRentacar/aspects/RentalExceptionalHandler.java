package academyMindswapRentacar.aspects;


import academyMindswapRentacar.exceptions.LicensePlate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice
public class RentalExceptionalHandler {

    private static final Logger logger = LoggerFactory.getLogger(RentalExceptionalHandler.class);
    @ExceptionHandler(value = LicensePlate.class)
    public ResponseEntity<String> handleLicensePlate( Exception exception){
        logger.error("Known Exception: " + exception);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Already exist");
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<String> handleGenericException (Exception ex){
            logger.error("Unknown Exception:" + ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

