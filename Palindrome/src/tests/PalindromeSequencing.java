package tests;

public class PalindromeSequencing {
    public String palindromeSequencing(String n) {
        // handling edge case of single digit input
        if(n.length() == 1) return "" + (n.charAt(0) - '0' - 1);
        // handling edge case of 10 and 11
        if(n.equals("10") || n.equals("11")) return "9";
        
        // stores the closest and second highest multiple of 10 to the number. (ex. 123 => 10)
        int order = (int) Math.pow(10, n.length()/2); 
        
        // long value of input
        Long number = Long.valueOf(n);
        
        // mirror of the first half of the number append to the second half. (ex. 1000 => 1001)
        Long current = mirror(number);
        
        // mirror of the first half of the number after manipulations(++)
        /*
        normal case: greater = mirror(number/order*order + order + 1); (ex. 123 => 123/10*10 + 10 + 1 = 131)
        edgecase for powers of 10: greater = mirror(number/order*order + 1); (ex. 1000 => 1000/10*10 + 1 = 1001)
        */
        Long greater = mirror((number/order)*order + order + 1); 
        if(order * 10 == number && number/10 == order) greater = mirror((number/order)*order + 1);
        
        // mirror of the first half of the number after manipulations(--)
        /*
        normal case: lesser = mirror((number/order)*order - order + 1); (ex. 123 => 123/10*10 - 10 + 1 = 111)
        edgecase for powers of 10: lesser = mirror(number/order*order - 1); (ex. 1000 => 1000/10*10 - 1 = 999)
        */
        Long lesser = mirror((number/order)*order - order + 1);
        if(order * 10 == number && number/10 == order) lesser = mirror((number/order)*order - 1);
        
        // obtain the nearest value among current, greater, and lesser
        Long result = getClosest(current, greater, lesser, number);
        
        // cloest palindrome
        return result + "";
    }
    
    // append first half to second half
    private Long mirror(Long n) {
        String s = String.valueOf(n);
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length/2; i++) arr[arr.length - 1 - i] = arr[i];
        return Long.valueOf(new String(arr));
    }
    
    // obtain number's closest value between 1 greater value and 1 lesser value from number
    private Long getClosest(Long current, Long greater, Long lesser, Long number) {
        Long larger = greater;
        Long smaller = lesser;
        if(current > number) {
            larger = Math.min(current, greater); // ceiling
        } else if(current < number) {
            smaller = Math.max(current, lesser); // floor
        } 
        // return the value closest. If there's a tie, pick the lesser number
        return number - smaller <= larger - number ? smaller : larger;
    }
}
