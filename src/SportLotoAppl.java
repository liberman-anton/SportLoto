/**
 * generates 7 random unique numbers in the range [1,49]
 * with no array nor any collection Java class
 * @author Anton
 *
 */
public class SportLotoAppl {

	public static void main(String[] args) {
		long mask = 0;
		int randomNumber;
		int i = 0;
		while(i < 7){
			randomNumber = getRandomNumber(1, 49);
			if (getBitValue(mask, randomNumber) == 0){
				System.out.println(randomNumber);
				mask = setBitValue(mask, randomNumber, 1);
				i++;
			}
		}	
	}
	/**
	 * sets at bit with number nBit the given bitValue
	 * @param number
	 * @param nBit
	 * @param bitValue
	 * @return number value after the setting bit value
	 * if nBit or bitValue has a wrong value it returns the same number value
	 */
	public static long setBitValue(long number, int nBit, int bitValue) {
		if(!checkBitNumber(nBit) || !checkBitValue(bitValue))
			return number;
		long mask = 1L << nBit;
		if(getBitValue(number, nBit) == bitValue)
			return number;
		return (long)(number ^ mask);		
	}
	private static boolean checkBitValue(int bitValue) {
		return bitValue == 0 || bitValue == 1;
	}
	private static boolean checkBitNumber(int nBit) {
		return nBit >= 0 && nBit <= 63;
	}
	/**
	 * 
	 * @param number
	 * @param nBit
	 * @return value of bit with number nBit for the given number
	 * if nBit < 0 or nBit >63 -> -1
	 * example: number = 5 (101), nBit = 1 -> 0
	 */
	public static int getBitValue(long number, int nBit) {
		if(nBit < 0 || nBit > 63) return -1;
		number >>= nBit;
		return (int) Math.abs(number%2);
	}
	
	static public int getRandomNumber(int min, int max){
		if(max < min){
			int tmp = min;
			min = max;
			max = tmp;
		}                 
		return (int)(min + Math.random() * (max - min + 1));
	}
}
