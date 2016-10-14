package is.ru.stringcalculator;

import java.util.List;
import java.util.ArrayList;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(",|\n");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
        	if(toInt(number) <= 1000) {
		    	total += toInt(number);
		    }
		}
		return total;
    }

    private static int negativeNumbers(String message)
    {
    	int negativeNumber = 0;
        String[] numbers = splitNumbers(message);
        List<Integer> negativeNumbers = new ArrayList<>();
        for(String number : numbers)
        {
            negativeNumber = toInt(number);
            if(negativeNumber < 0)
            {
                negativeNumbers.add(negativeNumber);
            }
        }
        if(!negativeNumbers.isEmpty())
        {
            throw new IllegalArgumentException("Negatives not allowed: "+ negativeNumbers.toString());
        }
        return 1;
    }
}