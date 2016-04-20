
import java.awt.Point;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PointStackMain {

	public static void main(String[] args) {
		
		//creates a 2D array
		char[][] array = new char[5][5];
		
		//creates an empty stack with the top being null
		LinkedStack stack = new LinkedStack();
		
		//fills the empty 2D array with dots
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				array[i][j] = '.';
			}
		}
		
		//prompts the user to input the coordinates of 5 different points
		System.out.println("Please enter the x and y coordinates of 5 different points.");
		System.out.println("The values must be within 0-4.");
		
		System.out.println("Point 1:");
		Point p1 = newPoint();
		
		System.out.println("Point 2:");
		Point p2 = newPoint();
		
		System.out.println("Point 3:");
		Point p3 = newPoint();
		
		System.out.println("Point 4:");
		Point p4 = newPoint();
		
		System.out.println("Point 5:");
		Point p5 = newPoint();
		
		//adds each new Point object to the top of the stack one by one
		stack.push(p1);
		stack.push(p2);
		stack.push(p3);
		stack.push(p4);
		stack.push(p5);
		
		//remove the point object at the top of the stack then use the coordinates of that
		//point to convert the corresponding point from the 2D array as well as surrounding 
		//points to create a cross shape
		Point rem1 = stack.pop();
		int x1Rem = (int) rem1.getX();
		int y1Rem = (int) rem1.getY();
		convertDots(x1Rem, y1Rem, '5', array);
		System.out.println("\nAfter first pop.");
		printArray(array);
		
		Point rem2 = stack.pop();
		int x2Rem = (int) rem2.getX();
		int y2Rem = (int) rem2.getY();
		convertDots(x2Rem, y2Rem, '4', array);
		System.out.println("\nAfter second pop.");
		printArray(array);
		
		Point rem3 = stack.pop();
		int x3Rem = (int) rem3.getX();
		int y3Rem = (int) rem3.getY();
		convertDots(x3Rem, y3Rem, '3', array);
		System.out.println("\nAfter third pop.");
		printArray(array);
		
		Point rem4 = stack.pop();
		int x4Rem = (int) rem4.getX();
		int y4Rem = (int) rem4.getY();
		convertDots(x4Rem, y4Rem, '2', array);
		System.out.println("\nAfter fourth pop.");
		printArray(array);
		
		Point rem5 = stack.pop();
		int x5Rem = (int) rem5.getX();
		int y5Rem = (int) rem5.getY();
		convertDots(x5Rem, y5Rem, '1', array);
		System.out.println("\nAfter final pop.");
		printArray(array);
		
	}
	
	/**
	 * Prints the contents of a 2D array
	 * 
	 * @param array the array to print
	 */
	public static void printArray(char[][] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array[i].length; j++)
			{
				System.out.print(array[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * Given an x and y coordinate and taking into consideration the boundaries of a 5 x 5 graph
	 * the the contents of the 2D array a are replaced with a char value r as well as surrounding
	 * points
	 * 
	 * @param x the x coordinate of the point
	 * @param y the y coordinate of the point 
	 * @param r the character to replace the space with
	 * @param a the 2D array containing the elements to replace with char values
	 */ 
	public static void convertDots(int y, int x, char r, char[][] a)
	{
		if (x == 0)
		{
			if (y == 0)
			{
				a[x][y] = r;
				a[x + 1][y] = r;
				a[x][y + 1] = r;
			}
			else if (y == 4)
			{
				a[x][y] = r;
				a[x][y - 1] = r;
				a[x + 1][y] = r;
			}
			else
			{
				a[x][y] = r;
				a[x + 1][y] = r;
				a[x][y + 1] = r;
				a[x][y - 1] = r;	
			}
		}
		else if (x == 4)
		{
			if (y == 0)
			{
				a[x][y] = r;
				a[x - 1][y] = r;
				a[x][y + 1] = r;
			}
			else if (y == 4)
			{
				a[x][y] = r;
				a[x][y - 1] = r;
				a[x - 1][y] = r;
			}
			else
			{
				a[x][y] = r;
				a[x][y - 1] = r;
				a[x][y + 1] = r;
				a[x - 1][y] = r;
			}
		}
		else if (x != 0 && x != 4 && y == 0)
		{
			a[x][y] = r;
			a[x - 1][y] = r;
			a[x + 1][y] = r;
			a[x][y + 1] = r;
		}
		else if (x != 0 && x != 4 && y == 4)
		{
			a[x][y] = r;
			a[x][y - 1] = r;
			a[x - 1][y] = r;
			a[x + 1][y] = r;
		}
		else
		{
			a[x][y] = r;
			a[x + 1][y] = r;
			a[x - 1][y] = r;
			a[x][y + 1] = r;
			a[x][y - 1] = r;
		}
	}
	
	/**
	 * Creates a new point validating that the point coordinate values are within 0 and 4
	 * 
	 * @return the new Point object
	 */
	public static Point newPoint()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("x: ");
		int x = 0;
		boolean xChecker = true;
		while (xChecker)
		{
			try {
				x = input.nextInt();
				
				while (x < 0 || x > 4)
				{	
					System.out.print("Pick a number from 0 - 4.");
					x = input.nextInt();
				}
				xChecker = false;
				
			} catch ( InputMismatchException im ) {

				input.next();
				System.out.println("Invalid Input. Try Again.");
			}
		}
		
		System.out.print("y: ");
		int y = 0;
		boolean yChecker = true;
		while (yChecker)
		{
			try {
				y = input.nextInt();
				
				while (y < 0 || y > 4)
				{	
					System.out.print("Pick a number from 0 - 4.");
					y = input.nextInt();
				}
				yChecker = false;
				
			} catch ( InputMismatchException im ) {

				input.next();
				System.out.println("Invalid Input. Try Again.");
			}
		}
		Point p = new Point(x, y);
		return p;

	}

}
