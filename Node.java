import java.awt.Point;
/**
 * 
 * @author Gregory Abellanosa <gregoryabellanosa@gmail.com>
 *
 */
public class Node {

	/** Point object stored in a Node */
	private Point point;
	/** the next Node */
	private Node next;
	
	/**
	 * Constructs a Node holding a Point object with the next Node being null
	 * 
	 * @param p the Point object to be placed within the Node
	 */
	public Node(Point p) //is this needed
	{
		point = p;
		next = null;
	}
	
	/**
	 * Constructs a Node object with a specified Point object to store and a specified
	 * next Node
	 * 
	 * @param p the Point object to be placed within the Node
	 * @param n the next Node
	 */
	public Node(Point p, Node n)
	{
		point = p;
		next = n;
	}
	
	/**
	 * Returns the next Node
	 * 
	 * @return the next Node
	 */
	public Node getNext()
	{
		return next;
	}
	
	/**
	 * Returns the Point object in a Node
	 * 
	 * @return the Point object in the Node
	 */
	public Point getPoint()
	{
		return point;
	}
	
	/*
	public void setNext(Node n)
	{
		next = n;
	}
	
	public void setPoint(Point p)
	{
		point = p;
	}*/
	
}
	
