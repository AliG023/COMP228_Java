package com.ag.week3.lab;
import java.security.SecureRandom;

/**
 * @author Alastair Graham
 * @since 09/17/2025
 * 
 */

public class Week3_Lab {

	public static void main(String[] args) {
		int myRoll = 0;
		int reRoll = 0;
		
		myRoll = dice.rollDice();
		
	
		switch(myRoll) {
		case 7:
			System.out.println("Player Wins");
			break;
		case 11:
			System.out.println("Player Wins");
			break;
		case 15:
			System.out.println("Player Wins");
			break;
		case 21:
			System.out.println("Player Wins");
			break;
		case 10:
			System.out.println("Player Loses");
			break;
		case 12:
			System.out.println("Player Loses");
			break;
		case 13:
			System.out.println("Player Loses");
			break;
		case 19:
			System.out.println("Player Loses");
			break;
		case 20:
			System.out.println("Player Loses");
			break;
		case 22:
			System.out.println("Player Loses");
			break;
		case 23:
			System.out.println("Player Loses");
			break;
		case 24:
			System.out.println("Player Loses");
			break;
		default:
			System.out.println(myRoll +" is the new goal. Roll Again");
			reRoll = dice.rollDice();
			if(reRoll == myRoll) {
				System.out.println("Reroll Matched. Player Wins");
			}else {
				System.out.println("Reroll Doesn't Match. Player Loses");
			}
			break;
		}
	}
	
	public class dice{
		private static SecureRandom randomNumbers = new SecureRandom();
		
		public static int rollDice()
		{
		   int die1 = 1 + randomNumbers.nextInt(6);
		   int die2 = 1 + randomNumbers.nextInt(6);
		   int die3 = 1 + randomNumbers.nextInt(6);
		   int die4 = 1 + randomNumbers.nextInt(6);

		   int sum = die1 + die2 + die3 + die4;

		   System.out.printf("Player rolled %d + %d + %d + %d = %d%n", 
		      die1, die2, die3, die4, sum);

		   return sum; 
		}
	}
	

}
