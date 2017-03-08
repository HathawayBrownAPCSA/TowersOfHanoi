import java.util.*;
  
public class TowersOfHanoi
{
  private int numMoves;
  
  /** Constructor sets the number of moves to zero */
  public TowersOfHanoi()
  {  
    numMoves = 0;  
  }
  
  /** Moves a stack of disks.
    * @param numDisks    How many disks to move
    * @param fromStack   Stack to move the disks from
    * @param toStack     Stack to move the disks to
    * @param dummyStack  Stack used for temporary moves
    */
  public void moveDisks (int numDisks, String fromStack, String toStack, String dummyStack)
  {
    if (numDisks > 0)
    {
       moveDisks (numDisks - 1, fromStack, dummyStack, toStack);
       moveOneDisk (numDisks, fromStack, toStack);
       moveDisks (numDisks - 1, dummyStack, toStack, fromStack);
    }
  }
  
  /** Moves a single disk.
    * Precondition:  No other disks on top of current disk!
    * @param disk        Which disk to move
    * @param fromStack   Which stack to move it from
    * @param toStack     Which stack to move it to
    */  
  public void moveOneDisk (int disk, String fromStack, String toStack)
  {
    numMoves++;
    System.out.println ("Move # " + numMoves + ": disk " + disk + " from " + fromStack + " to " + toStack);
  }
  
  public static void main (String[] args)
  {  
    Scanner keyboard = new Scanner (System.in);
    System.out.println("How many disks: ");
    int disks = keyboard.nextInt();
    
    TowersOfHanoi myTowers = new TowersOfHanoi();
    System.out.println("Moving " + disks + " disks from A to B");
    myTowers.moveDisks(disks, "A", "B", "C");
    
    keyboard.close();
  }
}