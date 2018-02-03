/**
 * @(#)Engine.java
 *
 *
 * @author 
 * @version 1.00 2011/1/6
 */
import java.util.*;
import java.awt.Point;

public class Engine {

	public static Organism[][] map;
	public static int MAP_SIZE;

    public Engine( List l, Organism[][] m, int ms) {
    	
    	// Number of times we loop through org list.
    	int LOOPS = 2;
    	
    	// Set up class wide variables
    	map 	= m;
    	MAP_SIZE = ms;
    	
    	//Instantiate a ListIterator
	    ListIterator iterator = l.listIterator();
		
		// Coord ints for calculating movements.
    	int x = -1;
    	int y = -1;
    	int nX = -1;
    	int nY = -1;
    	
    	// A single org instruction.
		int instruction;
		
		// A single org instruction payload.
		int payload;
		
		int tmpInstr;
		
		// Loop thru instructions.
		for(int i = 0; i < LOOPS; i++){
			
			// Loop over the list of orgs.
			while(iterator.hasNext()){
		    	
		    	// Get the next org in the list.
		    	Organism org = (Organism)iterator.next();
		    	
		    	// Get the orgs next instruction.
				tmpInstr = org.getNextInstruction();
	
				// Carve up the instruction in to it's parts.
				instruction = tmpInstr >> 24;
				payload		= tmpInstr << 8;
				payload		= payload  >>> 8;
				
//				System.out.println( org.getName() + " - " + instruction + " : " + payload);
//				org.dump();
				
				// Interpret instructions
				switch(instruction){
					
					// Move org up.
					case 0:
//						System.out.println( org.getName() + " wants to move up.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x;
						nY = y-1;
						
						// Exit switch.
						break;
						
					// Move org up/right.
					case 1:
//						System.out.println( org.getName() + " wants to move up/right.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x+1;
						nY = y-1;
						
						// Exit switch.
						break;
						
					// Move org move right.
					case 2:
//						System.out.println( org.getName() + " wants to move right.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x+1;
						nY = y;
						
						// Exit switch.
						break;
						
					// Move org right/down.
					case 3:
//						System.out.println( org.getName() + " wants to move right/down.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x+1;
						nY = y+1;
						
						// Exit switch.
						break;
						
					// Move org down.
					case 4:
//						System.out.println( org.getName() + " wants to move down.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x;
						nY = y+1;
						
						// Exit switch.
						break;
						
					// Move org down/left.
					case 5:
//						System.out.println( org.getName() + " wants to move down/left.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x-1;
						nY = y+1;
						
						// Exit switch.
						break;
						
					// Move org left.
					case 6:
//						System.out.println( org.getName() + " wants to move left.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x-1;
						nY = y;
						
						// Exit switch.
						break;
						
					// Move org left/up.
					case 7:
//						System.out.println( org.getName() + " wants to move left/up.");
						
						// Get current location.
						x = org.getX();
						y = org.getY();
						
						// Calculate new location.
						nX = x-1;
						nY = y-1;
						
						// Exit switch.
						break;
						
					case 8:
						break;
				}
				
				// Handle all moves instr 0-7.
				if(instruction<8){
					
					// Make sure new spot is inbounds.
					if( (nX < MAP_SIZE) && (nX >= 0) && (nY < MAP_SIZE) && (nY >= 0)){
						
						// Make sure the spot is available.
						if( emptySpot(map, nX, nY)){
//							System.out.println( "spot free");
							
							// Set the orgs new location.
							org.setLocation( new Point(nX, nY));
							
							// Update map.
							map[nX][nY] = org;
							map[x][y]	= null;
						}
					}
				}
		    } // End of while loop.
		    
		    // Reset org interator.
		    iterator = l.listIterator();
			
			// Print map every 400,001 iterations
			if( i%400001==0){
				printMap();
		    	System.out.println("---");
			}
			
			if(emptySpot(map, 0, 0)){
				System.out.println( "2,2 is free.");
			}
			if(emptySpot(map, 0,3)){
				System.out.println( "0,3 is free.");
			}
		    
		} // End of instruction loop.
    }
    
    public boolean emptySpot(Organism[][] m, int x, int y){
    	
    	if(m[x][y]==null){
    		return true;
    	}
    	
    	return false;
    }
    // Method to print out bool map.
	public static void printMap() {
		for(int y = 0; y < MAP_SIZE; y++) {
			for(int x = 0; x < MAP_SIZE; x++) {
				
				if( map[x][y] != null) {
					System.out.print( map[x][y].getName() + ((x!=(MAP_SIZE-1))?",":""));
				}else {
					System.out.print( " " + ((x!=(MAP_SIZE-1))?",":""));
				}
				
			}
			System.out.print( "\n");
		}
	}
}