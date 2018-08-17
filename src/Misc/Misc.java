package Misc;

public class Misc {

    public static void main(String[] args){

    }

    public static boolean areEqualByThreeDecimalPlaces(double first, double second) {

        int firstInt = (int) (first * 1000);
        int secondInt = (int) (second * 1000);

        if(firstInt == secondInt) {
            return true;
        }
        else {
            return false;
        }

    }

    public static void printYearsAndDays(long minutes) {

        long years;
        long days;
        long yearInSeconds = 525600;

        if(minutes < 0) {
            System.out.println("Invalid Value");
        }
        else {
            years = (minutes / yearInSeconds);
            long secondsLeft = minutes - (years * yearInSeconds);
            days = secondsLeft / (60 * 24);

            System.out.println(minutes + " min = " + years + " y and " + days + " d");
        }
    }

    public static boolean isCatPlaying(boolean summer, int temperature) {
        if(summer && temperature <= 45 && temperature >= 25){
            return true;
        }
        else if(!summer && temperature <= 35 && temperature >= 25) {
            return true;
        }
        else {
            return false;
        }
    }


    public static boolean isLeapYear(int year) {

        if (year < 1 || year > 9999) {
            return false;
        }
        else if (((year % 4 == 0) && (year % 100 != 0)) || year % 400 == 0) {
            return true;
        }
        else {
            return false;
        }

    }

    public static int getDaysInMonth(int month, int year) {
        if(month < 1 || month > 12){
            return -1;
        }
        if(year < 1 || year > 9999){
            return -1;
        }

        switch(month){
            case(1):
                return 31;
            case(2):
                return (isLeapYear(year) ? 29 : 28);
            case(3):
                return 31;
            case(4):
                return 30;
            case(5):
                return 31;
            case(6):
                return 30;
            case(7):
                return 31;
            case(8):
                return 31;
            case(9):
                return 30;
            case(10):
                return 31;
            case(11):
                return 30;
            case(12):
                return 31;
            default:
                return -1;
        }

    }

    public static boolean isPalindrome(int number){
        int reverse = 0;
        int tempNumber = Math.abs(number);

        while(tempNumber > 0) {
            int lastDigit = tempNumber % 10;
            reverse = reverse * 10;
            reverse += lastDigit;
            tempNumber = tempNumber / 10;
        }

        if(reverse == Math.abs(number)){
            return true;
        }
        else {
            return false;
        }
    }

    public static int sumFirstAndLastDigit(int number) {
        if(number < 0){
            return -1;
        }

        int sum = 0;
        sum = sum + (number % 10);
        while(number > 9){
            number /= 10;
        }
        sum = sum + number;
        return sum;
    }

    public static int getEvenDigitSum(int number) {
        if(number < 0){
            return -1;
        }

        int sum = 0;
        int lastDigit;
        while(number > 0) {
            lastDigit = number % 10;
            if (lastDigit % 2 == 0) {
                sum += lastDigit;
            }
            number /= 10;
        }

        return sum;
    }

    public static boolean hasSharedDigit(int firstNum, int secondNum) {
        boolean flag = false;
        if(firstNum < 10 || firstNum > 99 || secondNum < 10 || secondNum > 99){
            return flag;
        }

        while(firstNum > 0){
            int firstNumDigit = firstNum % 10;
            firstNum /= 10;
            while(secondNum > 0){
                int secondNumDigit = secondNum % 10;
                secondNum /= 10;
                if(firstNumDigit == secondNumDigit) return true;
            }
        }
        return false;

    }

    public static boolean hasSameLastDigit(int x, int y, int z) {
        if(x < 10 || x > 1000 || y < 10 || y > 1000 || z < 10 || z > 1000){
            return false;
        }

        int firstX = x % 10;
        int firstY = y % 10;
        int firstZ = z % 10;

        if(firstX == firstY || firstX == firstZ || firstY == firstZ){
            return true;
        }
        else{
            return false;
        }
    }

    public static int getGreatestCommonDivisor(int first, int second) {

        if(first < 10 || second < 10){
            return -1;
        }

        // Get the largest possible divisor (the smallest of the ints)
        int min = first < second ? first : second;
        int maxDivisor = 0;

        for(int divisor = 1; divisor <= min; divisor++){
            if(first % divisor == 0 && second % divisor == 0){
                maxDivisor = divisor;
            }
        }
        return maxDivisor;
    }

    public static void printFactors(int number){

        if(number < 1){
            System.out.println("Invalid Value");
        }

        for(int factor = 1; factor <= number; factor++){
            if(number % factor == 0){
                System.out.print(factor + " ");
            }
        }

    }

    public static boolean isPerfectNumber(int number){

        if(number < 1) return false;

        int sum = 0;
        for(int factor = 1; factor <= number / 2; factor++){
            if(number % factor == 0){
                sum += factor;
            }
        }
        return number == sum ? true : false;
    }

    public static void numberToWords(int number){

        if(number < 0){
            System.out.println("Invalid Value");
        }

        int reversedNumber = reverse(number);
        int additionalZeros = getDigitCount(number) - getDigitCount(reversedNumber);

        while(reversedNumber > 0) {
            int digit = (reversedNumber % 10);
            reversedNumber /= 10;
            switch(digit){
                case(0):
                    System.out.println("Zero");
                    break;
                case(1):
                    System.out.println("One");
                    break;
                case(2):
                    System.out.println("Two");
                    break;
                case(3):
                    System.out.println("Three");
                    break;
                case(4):
                    System.out.println("Four");
                    break;
                case(5):
                    System.out.println("Five");
                    break;
                case(6):
                    System.out.println("Six");
                    break;
                case(7):
                    System.out.println("Seven");
                    break;
                case(8):
                    System.out.println("Eight");
                    break;
                case(9):
                    System.out.println("Nine");
                    break;
                default:
                    System.out.println("NOTHING");
                    break;
            }
        }
        while(additionalZeros > 0) {
            System.out.println("Zero");
            additionalZeros--;
        }
    }

    public static int reverse(int number) {
        int newNumber = 0;

        //So works with negatives
        while(number != 0) {
            newNumber += (number % 10);
            number /= 10;
            newNumber *= 10;
        }
        newNumber /= 10;
        return newNumber;
    }

    public static int getDigitCount(int number){

        if(number < 0) {
            return -1;
        }

        if(number == 0 ){
            return 1;
        }

        int count = 0;
        while(number > 0) {
            number /= 10;
            count++;
        }

        return count;

    }


       // Returns whether or not the amount of available bags which hold
       // set amounts of weight can be arranged to contain the given amount of
       // goal weight.

    public static boolean canPack(int bigCount, int smallCount, int goal) {

        int bigWeight = 5;
        int smallWeight = 1;
        int maxBigWeight = bigCount * bigWeight;
        int maxSmallWeight = smallCount * smallWeight;

        // Invalid Inputs
        if(bigCount < 0 || smallCount < 0 || goal < 0){
            return false;
        }


        if((maxBigWeight + maxSmallWeight) < goal){
            return false;
        }

        // If we can do it with 1 lbs bags
        if(goal <= maxSmallWeight) {
            return true;
        }

        // If after using all big bags, the small suffice
        int remainderMaxBigWeight = (goal % maxBigWeight);
        if(remainderMaxBigWeight <= maxSmallWeight){
            return true;
        }

        // If the big bags alone work, latter condition to prevent a 5 lbs bag working for 4 lbs
        if((goal / bigWeight) <= bigCount && (goal % bigWeight) == 0){
            return true;
        }

        // If we can use some big bags and throw in some small to finish it off
        for(int i = 0; i < bigCount; i++) {
            int currentWeight = bigWeight * i;
            int remainderWeight = 0;
            if(currentWeight < goal){
                remainderWeight = goal - currentWeight;
                if(remainderWeight <= maxSmallWeight) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int getLargestPrime(int number) {
        if(number <= 1) {
            return -1;
        }
        // Start at the top, work down, first find a denominator, then determine if its a prime
        // By working at the top, the first we find is the largest
        for(int i = number; i > 0; i--) {
            if(number % i == 0){

                int counter = 2; // start at 2 (everything is divisible by 1)
                while(true) {
                    // If counter iterates up to = i then i is prime
                    if(counter >= i){
                        return i;
                    }
                    // If its not a prime move on
                    else if(i % counter == 0) {
                        break;
                    }
                    else {
                        counter++;
                    }
                }
            }
        }
        return -1;
    }

    public static void printSquareStar(int number){
        if(number < 5){
            System.out.println("Invalid Value");
        }
        else {
            for (int i = 1; i <= number; i++) {
                for (int j = 1; j <= number; j++) {
                    // First or last row
                    if (i == 1 || i == number) {
                        System.out.print("*");
                    }
                    //First or last column
                    else if (j == 1 || j == number) {
                        System.out.print("*");
                    }
                    // Row equals column
                    else if (j == i) {
                        System.out.print("*");
                    }
                    // Column equals rowCount - currentRow + 1(where currentRow is current row number)
                    else if (j == (number - i) + 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                // Newline means a new row
                System.out.println();
            }
        }
    }


}
