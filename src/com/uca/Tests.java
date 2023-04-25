package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {
	
	@Test
	public void testConverterRomanFromNumber(){
		
        assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(100), equalTo("C"));
	}

    @Test
	public void testConverter(){
		
        String roman;

        for (int i = 1; i < 4000; i++) {
            roman = RomanConverter.getRomanFromNumber(i);
            assertThat(RomanConverter.getNumberFromRoman(roman), equalTo(i));
        }
	}
	
	//TODO : les autres tests
    @Test
    public void testConverterNumberFromRoman(){
        assertThat(RomanConverter.getNumberFromRoman("L"), equalTo(50));
    }

    @Test
    // test si le paramètre est bien une valeur romaine
    public void testIsRoman(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("ATR")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testNumberOutOfRange(){
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testNegativeNumber(){
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testSymbolsRepetitions(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XXXX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testPairsRepetitions(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IVIV")), instanceOf(IllegalArgumentException.class));
    }

    @Test
    public void testIncorrectPredecessor(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VIIXX")), instanceOf(IllegalArgumentException.class));
    }


    //Help you to handle exception. :-)
    public static Throwable exceptionOf(Callable<?> callable) {
        try {
            callable.call();
            return null;
        } catch (Throwable t) {
            return t;
        }
    }
}
