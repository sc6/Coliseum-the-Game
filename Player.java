import java.util.*;

public class Player {

	public String name;
	public int money;
	public int health;
	public int maxHealth;
	public int score;
	public int speed;
	public int rawDefense;
	
	public Item[] inventory = new Item[20];
	
	public Item currentWeapon;
	public Item currentShield;
	public Item currentChest;
	public Item currentLeg;
	public Item currentHelm;
	
	
	


	public void nameGet() { //run once-- asks user for name
		Scanner nameGet = new Scanner(System.in);
		System.out.print("\nType in your name: ");
		name = nameGet.nextLine().toUpperCase();
		System.out.println("What a great name... "+name+"! I have high hopes for you.");
	}
	
	
	
	
	
	public int attack(Item i) {
		int fluxIndex = i.value / 4;
		int randomNo = 0;
		
		if(fluxIndex > 0) {
		Random r = new Random();
		randomNo = r.nextInt(fluxIndex);
		}
		
		int damage = i.value + randomNo;
		
		return damage;
	}
	
	
	
	public int nextInventorySpace() {
		for(int spaceNo = 0; spaceNo < inventory.length; spaceNo++) {
			if(inventory[spaceNo].name.equals("Empty")) {
				return spaceNo;
			}
		}
		return -1;
	}
	
	
	
	public void printInventory() { //Prints player's inventory in a chart
		System.out.println("\n=="+name+"'s Inventory==");
		System.out.println("Money:\t$"+money);
		for(int spaceNo = 0; spaceNo < inventory.length; spaceNo++) {
			System.out.print(spaceNo+1 + "\t");
			if(inventory[spaceNo].name.equals("Empty")) {
				System.out.print(" --- \n");
				continue;
			}
			System.out.print(inventory[spaceNo].name + "\t");
			System.out.println("x"+inventory[spaceNo].quantity);
		}
	}
	
	
	
	
	public int itemInArray(String item) { //Is the item present in the inventory? Returns -1 if not present. Returns spaceNo of item in inventory.
		for(int spaceNo = 0; spaceNo < inventory.length; spaceNo++) {
			if(inventory[spaceNo].name.equals(item)) {
				return spaceNo;
			}
		}
		return -1;
	}
	
	
	
	
	public void giveItem(String item, String requiredItem, int requiredNum) {
		
		if(item.equals(item)) {
			inventory[itemInArray(requiredItem)].quantity -= requiredNum; //Will not go negative
			if(nextInventorySpace() != -1) {
				inventory[nextInventorySpace()] = new Item(item);
				inventory[nextInventorySpace()].quantity = 1;
				System.out.println("You received one "+item+" and placed it in inventory space "+nextInventorySpace()+".");
			}
			
			else {
				inventory[itemInArray(requiredItem)].quantity += requiredNum;
				System.out.println("You have no room in your inventory.");
			}
		}
	} // End of .giveItem()
		
		
		
		/*
		if(item.equals("Wooden Leg Armor")) {
			inventory[itemInArray("<Wood>")].quantity -= 50; //Will not go negative
			if(nextInventorySpace() != -1) inventory[nextInventorySpace()] = new Item(item);
			else {
				inventory[itemInArray("<Wood>")].quantity += 50;
				System.out.println("You have no room in your inventory.");
			}
		}
		*/
		
		
	public void giveItemB(String item, String requiredItem, int giveNum) {    		//type used in decomposing
			
		inventory[itemInArray(requiredItem)].quantity -= 1;
		int temp = nextInventorySpace();
		if(temp != -1) {
			inventory[temp] = new Item(item);
			inventory[temp].quantity = giveNum;
			System.out.println("\nYou received "+giveNum+" "+item+" and placed it in inventory space "+nextInventorySpace()+".");
		}
		else {
			inventory[itemInArray(requiredItem)].quantity += 1;
			System.out.println("\nYou have no room in your inventory.");
			
		}	
			
	}
	
	public void equipSwap(int i) {
		Item temp = null, temp2 = inventory[i];
		if(inventory[i].type.equals("Weapon")) {
			temp = currentWeapon;
			currentWeapon = inventory[i];
			inventory[i] = temp;
		}
		
		if(inventory[i].type.equals("Shield")) {
			temp = currentShield;
			currentShield = inventory[i];
		}
		
		if(inventory[i].type.equals("Helm")) {
			temp = currentHelm;
			currentHelm = inventory[i];
		}
		
		if(inventory[i].type.equals("Chest")) {
			temp = currentChest;
			currentChest = inventory[i];
		}
		
		if(inventory[i].type.equals("Leg")) {
			temp = currentLeg;
			currentWeapon = inventory[i];
		}
		
		inventory[i] = new Item("Empty");
		
		System.out.println("\nYou successfully equip your "+temp2.name+" and throw away your worn "+temp.name+".");
	}
	
	
	public void equipPrint() {
		
		System.out.println("\n==What Are You Wearing?==");
		System.out.println("Helm:\t"+currentHelm.name+" ("+currentHelm.value+")");
		System.out.println("Chest:\t"+currentChest.name+" ("+currentChest.value+")");
		System.out.println("Leg:\t"+currentLeg.name+" ("+currentLeg.value+")");
		System.out.println("Weapon:\t"+currentWeapon.name+" ("+currentWeapon.value+")");
		System.out.println("Shield:\t"+currentShield.name+" ("+currentShield.value+")");
		
		System.out.println("\nTotal equipment value: "+ (currentHelm.value+currentChest.value+currentLeg.value+currentWeapon.value+currentShield.value));
		
	}
	
	
	
	public int alchemistIncreaseHealthCost() {
		if(health<15) return 2;
		else if(health<20) return 3;
		else if(health<25) return 6;
		else if(health<30) return 10;
		else if(health<40) return 20;
		else if(health<50) return 40;
		else if(health<70) return 70;
		else return 100;
	}
		
		
		
	public void reward(Item item) {
		int temp = nextInventorySpace();
		if(temp != -1) {
			inventory[temp] = item;
			inventory[temp].quantity++;
		}
		else {
			System.out.println("You have no room in your inventory. You leave "+item.name+" on the ground.");
		}
	}
	
	
	public void inventoryCleanUp() {
		for(int i = 0; i< this.inventory.length; i++) {
			if(this.inventory[i].quantity <= 0) {
				this.inventory[i] = new Item("Empty");
			}
		}
		
	}
		
		
		
		
	
		
		
		
		
		
		
		
	} //End of Player.java

