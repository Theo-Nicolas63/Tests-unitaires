package com.uca;

public class RomanNumber extends Number implements Comparable{
	
	private String roman;
	
	private int value;
	
	public RomanNumber(){
		//Ignored
	}
	
	public RomanNumber(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	
	public RomanNumber(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	public RomanNumber(int value, String roman){
		this.value = value;
		this.roman = roman;
	}
	
	public String getRoman(){
		return this.roman;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setRoman(String roman){
		this.roman = roman;
		this.value = RomanConverter.getNumberFromRoman(this.roman);
	}
	public void setValue(int value){
		this.value = value;
		this.roman = RomanConverter.getRomanFromNumber(this.value);
	}
	
	
	
	
	/**
	* @{inheritDoc}
	*/
	@Override
	public double doubleValue() {

		return (double) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public float floatValue() {

		return (float) this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public int intValue() {

		return this.value;
	}

	/**
	* @{inheritDoc}
	*/
	@Override
	public long longValue() {

		return (long) this.value;
	}

	@Override
	public String toString() {
	
		return this.roman;
	}

	/**
    * @{inheritDoc}
    */
	@Override
	public int compareTo(Object o) {
		
		if(o == null){
			throw new NullPointerException("L'objet a comparé est null");
		}

        if(o instanceof RomanNumber){

			RomanNumber romanCompare = (RomanNumber) o;

			if(this.value == romanCompare.getValue())

				return 0;

			if(this.value < romanCompare.getValue())

            	return -1;

			return 1;
        }
		else {
			throw new ClassCastException("L'objet a comparé n'est pas une instance de RomanNumber");
		}     
	}

	/**
    * @{inheritDoc}
    */
	@Override
    public int hashCode() {
		int hash = 31;

		hash = hash * 17 + this.roman.hashCode();
		hash = hash * 17 + Integer.hashCode(this.value);

        return hash;
    }

	/**
    * @{inheritDoc}
    */
	@Override
    public boolean equals(Object obj) {

		if(obj == null){
			throw new NullPointerException("L'objet a comparé est null");
		}

        if(obj instanceof RomanNumber){

			RomanNumber romanCompare = (RomanNumber) obj;

			if(this.value == romanCompare.getValue())

				return true;

			return false;
        }
		else {
			throw new ClassCastException("L'objet a comparé n'est pas une instance de RomanNumber");
		}     

		
	}


}