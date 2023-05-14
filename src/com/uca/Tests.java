package com.uca;

import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Tests {

    // test si la convertion de romain vers nombre fonctionne
	@Test
	public void testConverterRomanFromNumber(){
		
        assertThat(RomanConverter.getRomanFromNumber(4), equalTo("IV"));
        assertThat(RomanConverter.getRomanFromNumber(100), equalTo("C"));
	}

    // test si la convertion fonctionne pour toute valeur de 1 à 3999
    @Test
	public void testConverter(){
		
        String roman;

        for (int i = 1; i < 4000; i++) {
            roman = RomanConverter.getRomanFromNumber(i);
            assertThat(RomanConverter.getNumberFromRoman(roman), equalTo(i));
        }
	}
	
	//test si la méthode de convertion de nombre vers romain fonctionne
    @Test
    public void testConverterNumberFromRoman(){
        assertThat(RomanConverter.getNumberFromRoman("IV"), equalTo(4));
    }

    // test si le paramètre est bien une valeur romaine
    @Test
    public void testIsRoman(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("ATR")), instanceOf(IllegalArgumentException.class));
    }

    // test si le paramètre est bien un nombre entre 1 et 3999
    @Test 
    public void testNumberOutOfRange(){
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(4000)), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(0)), instanceOf(IllegalArgumentException.class));
    }

    // test si le paramètre est bien un nombre positif
    @Test
    public void testNegativeNumber(){
        assertThat(exceptionOf(() -> RomanConverter.getRomanFromNumber(-2)), instanceOf(IllegalArgumentException.class));
    }

    // test si il y a des répétitions de symboles
    @Test
    public void testSymbolsRepetitions(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("XXXX")), instanceOf(IllegalArgumentException.class));
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VV")), instanceOf(IllegalArgumentException.class));
    }

    // test si il y a des répétitions de paires
    @Test
    public void testPairsRepetitions(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("IVIV")), instanceOf(IllegalArgumentException.class));
    }

    // test si il y a des predecesseurs incorrectes
    @Test 
    public void testIncorrectPredecessor(){
        assertThat(exceptionOf(() -> RomanConverter.getNumberFromRoman("VIIXX")), instanceOf(IllegalArgumentException.class));
    }

    // test si la méthode compareTo fonctionne
    @Test 
    public void testCompareTo(){
        assertThat(new RomanNumber(4).compareTo(new RomanNumber(5)), lessThan(0));
        assertThat(new RomanNumber(5).compareTo(new RomanNumber(4)), greaterThan(0));
        assertThat(new RomanNumber(5).compareTo(new RomanNumber(5)), equalTo(0));
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
