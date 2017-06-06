package averagerdemo;

import averager.SimpleMovingAverage_Bearing;
import averager.SimpleMovingAverage_Length;
import averager.SimpleMovingAverage_Time;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Tim
 */
public class AveragerDemo {

    public static void main(String[] args) {
        int choice = 0;
        
        while (choice < 1 || choice > 3) {
            choice = getChoice();
        }

        switch (choice)
        {
            case 1:
                SMA_Length();
                break;
            case 2:
                SMA_Time();
                break;
            case 3:
                SMA_Bearing();
                break;
            default:
                System.out.println("Your choice was not recognised.");
        }
        
    }

    public static void SMA_Length() {
        ReadConsole console = new ReadConsole();

        System.out.println("Enter length of Simple Moving Average:");
        long length = console.readInt();
        SimpleMovingAverage_Length smal = new SimpleMovingAverage_Length(length);
        
        double value = 42;
        
        while (value != 0)
        {
            //obviously 0 is a valid value, but not for this demo
            System.out.println("Enter a new value, or 0 to quit:");
            value = console.readDouble();
            if (value != 0) {
                System.out.println("New moving average is " + smal.addItem(value) + "\n");
            }
        }
    }
    
    public static void SMA_Time() {
        ReadConsole console = new ReadConsole();

        System.out.println("Enter time units length of Simple Moving Average:");
        long length = console.readInt();
        SimpleMovingAverage_Time smat = new SimpleMovingAverage_Time(length);
        
        double value = 0;
        int time = 42;
        int lastTime = 0; //assumes only positive values will be entered in the demo
        
        while (time != 0)
        {
            System.out.println("Enter a new value:");
            value = console.readDouble();
            System.out.println("Enter time of new value, or 0 to quit:");
            time = console.readInt();
            if (time != 0) {
                if (time < lastTime) {
                    System.out.println("Time invalid, cannot be less than previous entry!");
                } else {
                    System.out.println("New moving average is " + smat.addItem(value, time) + "\n");
                }
            }
            lastTime = time;
        }
    }

    public static void SMA_Bearing() {
        ReadConsole console = new ReadConsole();

        System.out.println("Enter length of Simple Moving Average:");
        long length = console.readInt();
        SimpleMovingAverage_Bearing smab = new SimpleMovingAverage_Bearing(length);
        
        double value = 42;
        
        while (value != 1000)
        {
            //obviously 0 is a valid value, but not for this demo
            System.out.println("Enter a new bearing, or 1000 to quit:");
            value = console.readDouble();
            if (value != 1000) {
                System.out.println("New moving average is " + smab.addItem(value) + "\n");
            }
        }
    }

    public static int getChoice()
    {
        ReadConsole console = new ReadConsole();
        int choice;
        
        System.out.println("CHOOSE AVERAGER TO DEMO");
        System.out.println("=======================");
        System.out.println("1) Simple Moving Average - Length");
        System.out.println("2) Simple Moving Average - Time");
        System.out.println("3) Simple Moving Average - Bearing");
        
        choice = console.readInt();
        
        return choice;
    }

    
}

class ReadConsole {

    final Scanner reader = new Scanner(System.in);

    public double readDouble()
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

    public int readInt()
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