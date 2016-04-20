import java.awt.Point;
/**
 * 
 * @author gregoryabellanosa
 *
 */
public class LinkedStack {

		/** the Node at the top of the stack */
		private Node top;
		
		/**
		 * Constructs a linked stack with the top set to null
		 */
		public LinkedStack()
		{
			top = null;
		}
		
		/**
		 * Checks if the stack is empty
		 * 
		 * @return returns true or false depending on whether or not the stack is empty
		 */
		public boolean isEmpty()
		{
			return top == null;
		}
		
		/**
		 * Adds a Point object to the top of a stack
		 * 
		 * @param p the Point added to the top of the stack
		 */
		public void push(Point p)
		{
			top = new Node(p, top);
		}
		
		/**
		 * Removes the Node at the top of a stack and returns it
		 * 
		 * @return the Point object removed from the top of the stack
		 */
		public Point pop()
		{
			Point retVal = new Point(0,0);
			if (isEmpty())
			{
				System.out.println("Nothing to remove.");
			}
			else
			{
				retVal = top.getPoint();
				top = top.getNext();
			}
			return retVal;
			
		}
		
		/**
		 * Returns the Point object at the top of the stack
		 * 
		 * @return the Point object at the top of the stack
		 */
		public Point peek()
		{
			Point retVal = new Point(0,0);
			if (isEmpty())
			{
				System.out.println("Stack is empty.");
			}
			else 
			{
				retVal = top.getPoint();
			}
			return retVal;
		}
		
		/**
		 * Returns a String representation of a stack
		 * 
		 * @return the String representation of a stack
		 */
		@Override
		public String toString()
		{
			String s ="";
			Node n = top;
			while (n != null)
			{
				s = s + n.getPoint() + " ";
				n = n.getNext();
			}
			return s;
		}
}
