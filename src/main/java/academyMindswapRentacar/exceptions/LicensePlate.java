package academyMindswapRentacar.exceptions;

public class LicensePlate extends RuntimeException{
    public LicensePlate (String sameLicensePlate){
        super(sameLicensePlate);

    }
}
