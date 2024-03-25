public class Main {
	public static void main(String[] args) {
		Ex4();
	}

	//--------------------------------------------------------------------
	public static void Ex1() {
		int number = 587699078;
		int sum = calculatingSumOfEvenDigitInNumber(number);
		System.out.println("The sum is: " + sum);
	}

	public static int calculatingSumOfEvenDigitInNumber(int number) {
		int sum = 0;
		while (number > 0) {
			int temp = number % 10;
			if (temp % 2 == 0) {
				sum += temp;
			}
			number /= 10;
		}
		return sum;
	}

	//--------------------------------------------------------------------
	public static void Ex2() {
		String str = "I so love java script it makes me happy";
		printAllWordsContainLetterAOrBeginWithLettersJMH(str);
	}

	public static void printAllWordsContainLetterAOrBeginWithLettersJMH(String str) {
		String[] strArr = str.split(" ");
		String resForPrint = "";
		for (int i = 0; i < strArr.length; i++) {
			if (strArr[i].contains("a") || strArr[i].startsWith("j") ||
					strArr[i].startsWith("m") || strArr[i].startsWith("h")) {
				resForPrint += strArr[i] + " ";
			}
		}
		System.out.print(resForPrint);
	}

	//--------------------------------------------------------------------
	public static void Ex3() {
		int[] vec = {199, 23, 12, 234, 456, 32, 523, 786, 453, 122, 898, 543, 321, 55, 822, 900, 989, 231, 44, 88};
		sumDigitsForThreeDigitNumber(vec);//A
		evenNumbersInTheArr(vec);//B
		oddNumbersInTheArr(vec);//C
		int highestNumber = threeDigitEvenNumberSumOfDigitsIsTheHighest(vec);//D
		System.out.println("The even three-digit number whose sum of digits is the highest: " + highestNumber);
	}

	//A
	public static void sumDigitsForThreeDigitNumber(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 100 && arr[i] <= 999) {
				int threeDigitNumber = arr[i];
				int sum = sumOfDigitNumber(threeDigitNumber);
				System.out.println("The sum for " + threeDigitNumber + " is: " + sum);
			}
		}
	}

	public static int sumOfDigitNumber(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}

	//B
	public static void evenNumbersInTheArr(int[] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				counter++;
			}
		}
		System.out.println("The amount of even numbers is: " + counter);
	}

	//C
	public static void oddNumbersInTheArr(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				int temp = arr[i];
				sum += temp;
			}
		}
		System.out.println("The sum of odd numbers is: " + sum);
	}

	//D
	public static int threeDigitEvenNumberSumOfDigitsIsTheHighest(int[] arr) {
		int temp = 0;
		int sum = 0;
		int highestSum = 0;
		int highestNumber = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 100 && arr[i] <= 999) {
				temp = arr[i];
				if (temp % 2 == 0) {
					sum = sumOfDigitNumber(temp);
				}
				if (sum > highestSum) {
					highestSum = sum;
					highestNumber = temp;
				}
			}
		}
		return highestNumber;
	}

	//--------------------------------------------------------------------
	public static void Ex4() {
		int[] vec = {13, 111, 17, 1024, 23,29,31,421,293,298,300,700,12,11,9,35,149,1297,677,2};
		isPrimeNumber(vec);//A
		counterPrimeNumberInTheArr(vec);//B
		largestNumberOfIdenticalDigits(vec);//C
	}

	//A
	public static void isPrimeNumber(int[] arr) {
		String primeNumber = "";
		for (int i = 0; i < arr.length ; i++) {
			int temp = arr[i];
			if (isPrime(temp)){
				primeNumber += temp +" ";
			}
		}
		System.out.println(primeNumber);
	}
	public static boolean isPrime(int prime) {
		for (int i = 2; i * i <= prime; i++) {
			if (prime % i == 0) {
				return false;
			}
		}
		return true;
	}

	//B
	public static void counterPrimeNumberInTheArr(int[] arr){
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			int temp = arr[i];
			if (isPrime(temp)){
				counter++;
			}
		}
		System.out.println("Amount of prime number in the arr is : " + counter);
	}

	//C
	public static void largestNumberOfIdenticalDigits(int[] arr){
		String res = "";
		int maxID = 0;
		int maxIndex = 0;
		int currentID = 0;
		for (int i = 0; i < arr.length; i++) {
			res = String.valueOf(arr[i]);
			for (int j = 0; j < res.length() -1; j++) {
				if (res.charAt(j) == res.charAt(j+1)){
					maxID++;
				}
			}
			if (maxID > currentID){
				currentID = maxID;
				maxIndex = i;
			}
			maxID = 0;
		}
		System.out.println(arr[maxIndex]);
	}

	//--------------------------------------------------------------------
	public static void Ex5(){
		int num = 51;
		int digit = 6;
		int result = funcE(num,digit);
		System.out.println("Example one: " + result);
		//----------------------------------
		int num1 = 45;
		int digit1 = 7;
		int result1 = funcE(num1,digit1);
		System.out.println("Example two: " + result1);
	}
	public static int funcE(int num, int digit){
		int result;
		result = checking3ThingsAtTheSameTime(num,digit);
		if (result == 1){
			if (sumOfDigitInNumber(num) == digit){
				int highestDigit = highestDigitInTheNumber(num);
				result = digit - highestDigit;
			}else {
				result = smallNumberBetweenNumAndDigit(num,digit);
			}
		}
		return result;
	}
	public static int checking3ThingsAtTheSameTime(int num, int digit){
		if(num >= 0 && digit >= 0){
			if (num >= 10 && num <= 99){
				if (digit <= 9){
					return 1;
				}
			}
		}
		return -1;
	}
	public static int sumOfDigitInNumber(int number){
		int sum = 0;
		while (number > 0 ){
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
	public static int highestDigitInTheNumber(int number){
		int once = number%10;
		int tens = number/10;
		int highestDigit = once;
		if (tens > once){
			highestDigit = tens;
		}
		return highestDigit;
	}
	public static int smallNumberBetweenNumAndDigit(int num, int digit){
		int lowerDigit = digit;
		int once = num % 10;
		int tens = num / 10;
		if (once < digit && once < tens){
			lowerDigit = once;
		}else if (tens < digit && tens < once){
			lowerDigit = tens;
		}
		return lowerDigit;
	}
}