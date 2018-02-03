/**
 * @(#)Organism.java
 *
 *
 * @author 
 * @version 1.00 2011/1/3
 */

import java.util.*;
import java.awt.Point;

public class Organism {

	// A string that identifies each org.
	private String orgName;
	
	// The organism's x,y location.
	private Point location;
	
	// The organism's instructions.
	private List instructions;
	
	// An iterator for the org list.
	private ListIterator listIterator;
		
	// Not used.
    public Organism() {
    }
    
    // Demo constructor.
    public Organism(String name) {
    	this( name, new Point(-1,-1), null);
    }
    
    // Constructor.
    public Organism(String name, Point loc, Integer instrs[]) {
    	
    	// Initialize instructions to blank array if instrs is undefined.
    	if(instrs == null){
    		
    		// Create blank array
    		Integer[] tmpArray = {};
    		
    		// Set instrs to blank array.
    		instrs = tmpArray;
    	}
    	
    	// Initialize the orgs name.
    	orgName = name;
    	
    	// Initialize the orgs location.
    	location = loc;
    	
    	// Initialize the orgs instruction list.
    	instructions = Arrays.asList(instrs);
    	
    	// Setup the list iterator.
    	listIterator = instructions.listIterator();
    }
    
    // Dump all org data.
    public void dump() {
 
    	System.out.println( "Organism Data");
    	System.out.println( "-Name:         " + orgName);
    	System.out.println( "-Location:     " + location.toString());
    	System.out.println( "-Instructions: " + Arrays.toString(instructions.toArray()));
    	System.out.print( "\n");
    }
    
    // Return org location.
    public Point getLocation() {
    	return location;
    }
    
    // Return org name.
    public String getName() {
    	return orgName;
    }
    
    // Returns next instruction
    public Integer getNextInstruction() {
    	
    	// If we are at the end of the list reset
    	// the list iterator.
    	if(listIterator.hasNext()==false){
    		listIterator = instructions.listIterator();
    	}
    	
    	// Return the next instruction.
    	return (Integer)listIterator.next();
    }
    
    // Reurn x coord.
    public int getX() {
    	return (int)location.getX();
    }
    
    // Reurn y coord.
    public int getY() {
    	return (int)location.getY();
    }
    
    // Reset the location.
    public void setLocation( Point l){
    	location = l;
    }
}