package ro.orange.service2.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import java.util.Date;

import static java.lang.Float.isNaN;

public class CNPValidator
        implements ConstraintValidator<CNP, String> {

    private int length;
    private int nonDigit;

    @Override
    public void initialize(CNP value) {
        this.length = value.length();
        this.nonDigit = value.nonDigit();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext ctx) {
        if (value.length() < length) {
            return false;
        }
        int tempNonDigit = 0;
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isDigit(value.charAt(i))) {
                tempNonDigit++;
            }
        }
        if (tempNonDigit != this.nonDigit) {
            return false;
        }

        if (!isCNPValid(value)) {
            return false;
        }
        return true;
    }

   //Cod luat de pe stackoverflow
    private boolean isCNPValid( String cnpValue ) {
        int i=0 , year=0 , hashResult=0;
        int [] cnp = new int [13];
        int [] hashTable = {2,7,9,1,4,6,3,5,8,2,7,9};
        if( cnpValue.toCharArray().length != 13 ) {
            return false;
        }
        for( i = 0 ; i < 13 ; i++ ) {
            cnp[i] = Integer.parseInt(""+cnpValue.charAt(i), 10);
            if( isNaN( cnp[i] ) ) { return false; }
            if( i < 12 ) { hashResult = hashResult + ( cnp[i] * hashTable[i] ); }
        }
        hashResult = hashResult % 11;
        if( hashResult == 10 ) { hashResult = 1; }
        year = (cnp[1]*10)+cnp[2];
        switch( cnp[0] ) {
            case 1  : case 2 : { year += 1900; } break;
            case 3  : case 4 : { year += 1800; } break;
            case 5  : case 6 : { year += 2000; } break;
            case 7  : case 8 : case 9 : { year += 2000; if( year > ( Integer.parseInt(""+ new Date().getYear() , 10 ) - 14 ) ) { year -= 100; } } break;
            default : { return false; }
        }
        if( year < 1800 || year > 2099 ) { return false; }
        return ( cnp[12] == hashResult );
    }
}