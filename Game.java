// Coliseum by Steve Chang


import java.util.*;

public class Game {
	
	static Scanner kbReader = new Scanner(System.in);
	
	


	
	
	
	
	
	
	
	
	
	/*              *
	 *     MENU     *
	 *              */
	
	public static void menu(Player PlayerOne) {
		
		PlayerOne.inventoryCleanUp();
		
		System.out.println("\n==Menu==");
		System.out.println("= "+PlayerOne.name+" - $"+PlayerOne.money+" - Health: "+PlayerOne.health+" - Score: "+PlayerOne.score);
		System.out.println("[1] Go fight!");
		System.out.println("[2] Visit the blacksmith");
		System.out.println("[3] Go to alchemist");
		System.out.println("[4] Go through belongings");
		
		Scanner menuOption = new Scanner(System.in);
		System.out.print("= What do you do next?: ");
		int menuChoice = menuOption.nextInt();
		
		if(menuChoice == 1) {
			assignment(PlayerOne);
		}
		
		if(menuChoice == 2) {
			smithy(PlayerOne);
		}
		
		if(menuChoice == 3) {
			alchemist(PlayerOne);
		}	
		
		if(menuChoice == 4) {
			management(PlayerOne);
		}
		
		if(menuChoice < 1 || menuChoice > 4) {
		}
	}
	
	
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	/*                  *
	 *   MONSTER        *
	 *   SELECTION      */
	
	public static void assignment(Player PlayerOne){
		System.out.println("\n=You are given the options: ");
		
		
		System.out.println("[1] Training Dummy");
		System.out.println("[2] Petty Thief");
		System.out.println("[3] Adult Hoodlum");
		System.out.println("[4] Rebel Slave");
		System.out.println("[5] Disgruntled Worker");
		System.out.println("[6] Giant Vagrant");
		
		
		
		Scanner fightMenu = new Scanner(System.in);
		System.out.print("=Who would you like to fight?: ");
		String fightMenuChoice = fightMenu.nextLine();
		
		
		
		
		
		
		
		
		
		
		if(fightMenuChoice.equalsIgnoreCase("1")) {
			Monster TrainingDummy = new Monster("Training Dummy");
			fight(TrainingDummy, PlayerOne);
		}
		
		if(fightMenuChoice.equalsIgnoreCase("2")) {
			Monster PettyThief = new Monster("Petty Thief");
			fight(PettyThief, PlayerOne);
		}
		
		if(fightMenuChoice.equalsIgnoreCase("3")) {
			Monster AdultHoodlum = new Monster("Adult Hoodlum");
			fight(AdultHoodlum, PlayerOne);
		}
		
		if(fightMenuChoice.equalsIgnoreCase("4")) {
			Monster RebelSlave = new Monster("Rebel Slave");
			fight(RebelSlave, PlayerOne);
		}
		
		if(fightMenuChoice.equalsIgnoreCase("5")) {
			Monster DisgruntledWorker = new Monster("Disgruntled Worker");
			fight(DisgruntledWorker, PlayerOne);
		}
		
		if(fightMenuChoice.equalsIgnoreCase("6")) {
			Monster GiantVagrant = new Monster("Giant Vagrant");
			fight(GiantVagrant, PlayerOne);
		}
		
		
		
		
		
		
		
		
		
		
		
	}

	
	/*                  *
	 *     FIGHT        *
	 *                  */
	
	public static void fight(Monster m, Player p) {
		
		int prevHit;
		
		
		
		System.out.println("\n==Fight!==");
		
		if(p.speed >= m.speed) System.out.println("You are quicker than "+m.name+" so you deal the first blow! ("+p.name+"'s "+p.speed+" beats "+m.name+"'s "+m.speed+")");
		
		
		if(p.speed < m.speed) {
			System.out.println(m.name+" was quicker than you, so it deals the first blow! ("+m.name+"'s ??? beats "+p.name+"'s "+p.speed+")");
			
			prevHit = m.attack(m.attack, p.rawDefense);
			p.health -= prevHit;
			System.out.println(m.name+" hits you for "+prevHit+". You have "+p.health+" health left.");
			//System.out.println(m.name+" ["+m.health+"/ "+m.maxHealth+"] deals "+prevHit+" damage."); Rewrite
		}
		
		
		while(p.health > 0 || m.health > 0) {
			
			prevHit = p.attack(p.currentWeapon);
			m.health -= prevHit;
			System.out.println("You hit "+m.name+" and deal "+prevHit+" damage with your "+p.currentWeapon.name+". "+m.name+" has "+m.health+" health left.");
			
			
			if(m.health <= 0) break;
			
			prevHit = m.attack(m.attack, p.rawDefense);
			p.health -= prevHit;
			System.out.println(m.name+" hits you for "+prevHit+". You have "+p.health+" health left.");
			
			if(p.health <= 0) break;
		}
		
		//Death Sequence
		if(p.health <= 0) {
			System.out.println("\n= You have lost in battle against "+m.name+". You, however, are later revived by the local priest.");
			System.out.println("= He says to you, 'Be careful next time!'");
			kbReader.nextLine();
		}
		
		//Victory Rewards System
		if(m.health <=0) {
			System.out.println("\n= You are victorious against "+m.name+".");
			System.out.println("= Your rewards are: ");
			System.out.println("   + $"+m.rewardMoney);
			
			for(int i = 0; i < m.numRewards; i++)
				System.out.println("   + "+m.rewards[i].name);
			
			
			p.money += m.rewardMoney;
			p.score += m.score;
			
			for(int i = 0; i < m.numRewards; i++) {
				if(p.itemInArray(m.rewards[i].name) == -1) {
					p.reward(m.rewards[i]); //makes room for reward in inventory.
				}
				else {
					p.inventory[p.itemInArray(m.rewards[i].name)].quantity++; //increases quantity if item already exists.
				}
			}
			
			kbReader.nextLine();
			
		}//end of victory rewards system
		
		
		//Health reset
		
		p.health = p.maxHealth;

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*                  *
	 *     Smithy       *
	 *                  */
	
	
	public static void smithy(Player PlayerOne) {
		System.out.println("\n==Ye Ole Smithy==");
		
		System.out.println("[1] Forge a weapon");
		System.out.println("[2] Decompose goods");
		System.out.println("[3] View inventory");
		
		System.out.print("What would you like to do?: ");
		String choice = kbReader.nextLine();
		
		if(choice.equals("1")) {
			forge(PlayerOne);
		}
		
		
		if(choice.equals("2")) {
			decompose(PlayerOne);
		}
		
		
		if(choice.equals("3")) {
			PlayerOne.printInventory();
		}
		
		if(choice.equals("4")) {
			
		}
	}
	
	
	
	public static void forge(Player PlayerOne) {
		
		System.out.println("\n==The Forge==");
		System.out.println("[1] Make Wooden goods (Requires <Wood>)");
		//System.out.println("[2] Make Steel goods (Requires <Steel>)");
		
		System.out.print("What would you like to do?: ");
		String choice = kbReader.nextLine();
		
		
		//Wood
		if(choice.equals("1")) {
			System.out.println("\n[1] Create Wooden Sword (35x <Wood>)");
			System.out.println("[2] Create Wooden Leg Armor (50x <Wood>)");
			System.out.println("[3] Create Wooden Chest Armor (65x <Wood>)");
			System.out.println("[4] Create Wooden Helm (45x <Wood>)");
			
			System.out.print("What would you like to do?: ");
			String choiceTwo = kbReader.nextLine();
			
			if(choiceTwo.equals("1")) {
				if(PlayerOne.itemInArray("<Wood>") != -1 && PlayerOne.inventory[PlayerOne.itemInArray("<Wood>")].quantity >= 35) {
					PlayerOne.giveItem("Wooden Sword", "<Wood>", 35);
				}
				else {
					System.out.println("[Error] You don't have room in inventory or not enough materials.");
				}
			}
			
			if(choiceTwo.equals("2")) {
				if(PlayerOne.itemInArray("<Wood>") != -1 && PlayerOne.inventory[PlayerOne.itemInArray("<Wood>")].quantity >= 50) {
					PlayerOne.giveItem("Wooden Leg Armor", "<Wood>", 50);
				}
				else {
					System.out.println("[Error] You don't have room in inventory or not enough materials.");
				}
			}
			
			if(choiceTwo.equals("3")) {
				if(PlayerOne.itemInArray("<Wood>") != -1 && PlayerOne.inventory[PlayerOne.itemInArray("<Wood>")].quantity >= 65) {
					PlayerOne.giveItem("Wooden Chest Armor", "<Wood>", 65); 
				}
				else {
					System.out.println("[Error] You don't have room in inventory or not enough materials.");
				}
			}
			
			
			if(choiceTwo.equals("4")) {
				if(PlayerOne.itemInArray("<Wood>") != -1 && PlayerOne.inventory[PlayerOne.itemInArray("<Wood>")].quantity >= 45) {
					PlayerOne.giveItem("Wooden Helm", "<Wood>", 45);
				}
				else {
					System.out.println("[Error] You don't have room in inventory or not enough materials.");
				}
			}	
		} //End of Wood
		
		
		
		//Steel
		//End of Steel
	} //End of forge
		
		
	
	
		
		
	public static void decompose(Player PlayerOne) {
	
		System.out.println("\n==Decompose Menu==");

		for(int i = 0; i<PlayerOne.inventory.length; i++) {
			if(PlayerOne.inventory[i].type.equals("Weapon") || PlayerOne.inventory[i].type.equals("Shield") || PlayerOne.inventory[i].type.equals("Leg") || PlayerOne.inventory[i].type.equals("Chest") || PlayerOne.inventory[i].type.equals("Helm") || PlayerOne.inventory[i].type.equals("Decomposable")) {
				System.out.println("[" +(i+1)+ "] Decompose " +PlayerOne.inventory[i].name+ " into " + PlayerOne.inventory[i].decomposeQTY + " " + PlayerOne.inventory[i].decomposeInto);
			}
			else if(PlayerOne.inventory[i].name.equals("Empty")) {
				System.out.print("");
			}
			else {
				System.out.println("[" +(i+1)+ "] Cannot decompose " +PlayerOne.inventory[i].name+ " into anything.");
			}
		}
		
		System.out.print("What would you like to do?: ");
		String choice = kbReader.nextLine();
		
		if(choice.equals("-1")) return;
		
		int decomposeMenuChoiceInt = Integer.parseInt(choice) - 1;
		
		if(PlayerOne.itemInArray(PlayerOne.inventory[decomposeMenuChoiceInt].decomposeInto) == -1) {
			PlayerOne.giveItemB(PlayerOne.inventory[decomposeMenuChoiceInt].decomposeInto, PlayerOne.inventory[decomposeMenuChoiceInt].name, PlayerOne.inventory[decomposeMenuChoiceInt].decomposeQTY);
		}
		else {
			//take the 1 of the equipment away
			PlayerOne.inventory[PlayerOne.itemInArray(PlayerOne.inventory[decomposeMenuChoiceInt].name)].quantity--;
			//give decomposeInto x DecomposeQTY
			PlayerOne.inventory[PlayerOne.itemInArray(PlayerOne.inventory[decomposeMenuChoiceInt].decomposeInto)].quantity+=PlayerOne.inventory[decomposeMenuChoiceInt].decomposeQTY;
		}
		
		
			
	} //End of decompose
	
	
	
	
	
	
	
	
	
	
	
	
	/*                  *
	 *     Alchemist    *
	 *                  */
	
	
	public static void alchemist(Player PlayerOne) {
		
		System.out.println("\n==The Alchemist==");
		System.out.println("[1] View inventory");
		System.out.println("[2] Pay "+PlayerOne.alchemistIncreaseHealthCost()+" scores to increase health by 1");
		
		System.out.print("\nWhat would you like to do?: ");
		String choice = kbReader.nextLine();
		
		if(choice.equals("1")) {
			PlayerOne.printInventory();
		}
		if(choice.equals("2")) {
			if(PlayerOne.score >= PlayerOne.alchemistIncreaseHealthCost()) {
				PlayerOne.score -= PlayerOne.alchemistIncreaseHealthCost();
				PlayerOne.health++;
				PlayerOne.maxHealth++;
			}
			else {
				System.out.println("You don't have "+PlayerOne.alchemistIncreaseHealthCost()+" scores to spend!");
			}
		}
		if(choice.equals("3")) {
			
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*                  *
	 *     Management   *
	 *                  */
	
	
	
	
	
		
	public static void management(Player PlayerOne) {	
	
		System.out.println("\n==Rummaging Through==");
		
		System.out.println("[1] View inventory");
		System.out.println("[2] Manage equipment");
		System.out.println("[3] View equipment");
		
		System.out.print("What would you like to do?: ");
		
		int choice = kbReader.nextInt();
		
		if(choice == 1) {
			PlayerOne.printInventory();
		}
		
		if(choice == 2) {
			manageEquips(PlayerOne);
			kbReader.nextLine();
		}
		
		if(choice == 3) {
			PlayerOne.equipPrint();
			kbReader.nextLine();
		}
		
		
		
		
	}//end of management
		
		
		
	
	
	public static void manageEquips(Player PlayerOne) {
		
		System.out.println("\n==What To Wear?==");
		
		for(int i = 0; i<PlayerOne.inventory.length; i++) {
			if(PlayerOne.inventory[i].type.equals("Weapon")) {
				System.out.println("[" +(i+1)+ "] Equip " +PlayerOne.inventory[i].name+ " (" +PlayerOne.inventory[i].value+ ") and replace your " +PlayerOne.currentWeapon.name + " (" +PlayerOne.currentWeapon.value+ ")");
			}
			if(PlayerOne.inventory[i].type.equals("Shield")) {
				System.out.println("[" +(i+1)+ "] Equip " +PlayerOne.inventory[i].name+ " (" +PlayerOne.inventory[i].value+ ") and replace your " +PlayerOne.currentShield.name + " (" +PlayerOne.currentShield.value+ ")");
			}
			if(PlayerOne.inventory[i].type.equals("Leg")) {
				System.out.println("[" +(i+1)+ "] Equip " +PlayerOne.inventory[i].name+ " (" +PlayerOne.inventory[i].value+ ") and replace your " +PlayerOne.currentLeg.name + " (" +PlayerOne.currentLeg.value+ ")");
			}
			if(PlayerOne.inventory[i].type.equals("Chest")) {
				System.out.println("[" +(i+1)+ "] Equip " +PlayerOne.inventory[i].name+ " (" +PlayerOne.inventory[i].value+ ") and replace your " +PlayerOne.currentChest.name + " (" +PlayerOne.currentChest.value+ ")");
			}
			if(PlayerOne.inventory[i].type.equals("Helm")) {
				System.out.println("[" +(i+1)+ "] Equip " +PlayerOne.inventory[i].name+ " (" +PlayerOne.inventory[i].value+ ") and replace your " +PlayerOne.currentHelm.name + " (" +PlayerOne.currentHelm.value+ ")");
			}
			if(i == PlayerOne.inventory.length-1) {
				System.out.println("Press [-1] to return to menu.");
			}
		}
			
			System.out.print("\nWhat would you like to do?: ");
			int choice = kbReader.nextInt();
			
			PlayerOne.equipSwap(choice-1);

		
		
		
	} //end of manageEquips
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*                  *
	 *      MAIN        *
	 *                  */
	
	
	public static void main(String [] args) {
		
		// Game version
		String version = "0.8 (80% done)";
		
		// Player One Field Initialization
		System.out.println("Running Coliseum version "+version+" <Created by Steve Chang>");		
		System.out.println("Creating new character...");
		
		Player PlayerOne = new Player();
		PlayerOne.nameGet();
		PlayerOne.health = 10;
		PlayerOne.maxHealth = 10;
		PlayerOne.score = 0;
		PlayerOne.speed = 1;
		PlayerOne.currentWeapon = new Item("Fists");
		PlayerOne.currentShield = new Item("Empty");
		PlayerOne.currentLeg = new Item("Empty");
		PlayerOne.currentHelm = new Item("Empty");
		PlayerOne.currentChest = new Item("Empty");
		
		boolean win = false;
		
		for(int i = 0; i < PlayerOne.inventory.length; i++) {
			PlayerOne.inventory[i] = new Item("Empty"); // Inventory initialization
		}
		
		
		kbReader.nextLine();
		
		System.out.println("\nHow to play:");
		System.out.println("= You are a gladiator and you choose to fight for glory and riches. Take");
		System.out.println("= assignments, make armor and weapons, and make enough money to be hailed");
		System.out.println("= a champion. Be careful, some of your opponents will be well-trained...");
		
		kbReader.nextLine();
		
		
		while(!win) menu(PlayerOne);
		
		
		
	}

}
