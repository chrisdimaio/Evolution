/**
 * @(#)Evolution.java
 *
 *
 * @author 
 * @version 1.00 2011/1/3
 */

import java.util.*;
import java.awt.Point;

public class Evolution {

	public static int MAP_SIZE;
	
	public static int ORG_COUNT;

    public Evolution() {
    }
    
    public static void main(String[] args) {

		MAP_SIZE 	= 5;
		ORG_COUNT 	= 1;

		// Create a list to hold our orgs.
	    List ls = new LinkedList();

		System.out.print( "Building map...");
		Organism[][] map = new Organism[MAP_SIZE][MAP_SIZE];
		System.out.println( "Map built!");
			
		Random rand = new Random((System.currentTimeMillis() / 1000L));

		System.out.print( "Populating list");

		// Create organisms.
		for(int i = 0; i < ORG_COUNT; i++){
			
			// Make a new organism.
//			Organism orgA =  new Organism( "X", randomFreePoint(map),
//				new Integer[]{rand.nextInt(2147483647),rand.nextInt(2147483647),rand.nextInt(2147483647)});

//			Organism orgA =  new Organism( "" + (char)(65 + i), randomFreePoint(map),
//				new Integer[]{rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,
//					rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,rand.nextInt(7)<<24,});

			Organism orgA =  new Organism( "X", new Point(1,1),
				new Integer[]{10,10,10,10});
				
				
			// Add it to the list.
			ls.add(orgA);
			
			// Put it on the map.
			map[orgA.getX()][orgA.getY()] = orgA;
			
			if( (i % 10)==0 ){
				System.out.print( ".");
			}
		}
		
		System.out.println("List populated");

//		printMap(map, MAP_SIZE);
		
		// Create an engine to work on list.
		Engine engineOne = new Engine(ls,map,MAP_SIZE);
		
//		printMap(map, MAP_SIZE);
	}
  
	// Method to print out bool map.
	public static void printMap( Organism[][] map, int size) {
		for(int y = 0; y < size; y++) {
			for(int x = 0; x < size; x++) {
				
				if( map[x][y] != null) {
					System.out.print( map[x][y].getName() + ((x!=(size-1))?",":""));
				}else {
					System.out.print( " " + ((x!=(size-1))?",":""));
				}
				
			}
			System.out.print( "\n");
		}
	}
	
	public static Point randomFreePoint( Organism[][] m) {
		
		// Random number generator. Seeded with time.
		Random rand = new Random((System.currentTimeMillis() / 1000L));
		
		int rX = rand.nextInt(MAP_SIZE);
		int rY = rand.nextInt(MAP_SIZE);
		
		// Loop until we find a free point.
		while( m[rX][rY]!=null){
			
			// Reset x and y.
			rX = rand.nextInt(MAP_SIZE);
			rY = rand.nextInt(MAP_SIZE);
		}
		
		return new Point (rX,rY);
	}
}
