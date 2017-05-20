package averagerdemo;

import averager.SimpleMovingAverage_Length;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class AveragerDemo {

    public static void main(String[] args) {
        AveragerDemo demo = new AveragerDemo();

        System.out.println("Enter length of Simple Moving Average:");
        long length = demo.getIntFromConsole();
        SimpleMovingAverage_Length smal = new SimpleMovingAverage_Length(length);
        
        double value = 42;
        
        while (value != 0)
        {
            System.out.println("Enter a new value, or 0 to quit:");
            value = demo.getDoubleFromConsole();
            if (value != 0) {
                System.out.println("New moving average is " + smal.addItem(value) + "\n");
            }
        }
    }

    final Scanner reader = new Scanner(System.in);

    private double getDoubleFromConsole()
    {
        Double myDouble = null;
        String input;
        
        while (myDouble == null)
        {
            try
            {
                input = reader.nextLine();
                try
                {
                    myDouble = Double.parseDouble(input);
                }
                catch (Exception e)
                {
                    throw new InputMismatchException();
                }
                
                if (myDouble == null) throw new InputMismatchException();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Value did not parse, try again.");
            }
        }
        
        System.out.println();
        return (double) myDouble;
    }

    private int getIntFromConsole()
    {
        Integer myInt = null;
        String input;
        
        while (myInt == null)
        {
            try
            {
                input = reader.nextLine();
                try
                {
                    myInt = Integer.parseInt(input);
                }
                catch (Exception e)
                {
                    throw new InputMismatchException();
                }
                
                if (myInt == null) throw new InputMismatchException();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Value did not parse, try again.");
            }
        }
        
        System.out.println();
        return (int) myInt;
    }
    
}
