import java.util.*;


public class Item {
	
	public String name;
	public String description;
	public String type;
	public String decomposeInto;
	
	public int value;
	public int quantity = 0;
	public int decomposeQTY;
	
	
	public Item(String name) {
		
		//NULL
		if(name.equals("Empty")) {
			this.name = "Empty";
			this.description = "There is nothing here.";
			this.type = "null";
			this.value = 0;
			
		}
		
		
		//REAGENTS
		if(name.equals("<Wood>")) {
			this.name = "<Wood>";
			this.description = "A hunk of wood that can be crafted to create new items.";
			this.type = "Reagent";
			this.value = 0;
		}
		
		if(name.equals("<Leather>")) {
			this.name = "<Leather>";
			this.description = "A scrap of leather that can be crafted to create new items.";
			this.type = "Reagent";
			this.value = 0;
		}
		
		if(name.equals("<Stone>")) {
			this.name = "<Stone>";
			this.description = "A piece of rock that can be crafted to create new items.";
			this.type = "Reagent";
			this.value = 0;
		}
		
		if(name.equals("<Iron>")) {
			this.name = "<Iron>";
			this.description = "A pound of iron that can be smelted and forged to create new items.";
			this.type = "Reagent";
			this.value = 0;
		}
		
		
		
		
		
		//EQUIPS
		if(name.equals("Fists")) {
			this.name = "Fists";
			this.description = "The weapons you were born with.";
			this.type = "Weapon/Other";
			this.value = 1;
			
		}
		
		
		
		
		
		if(name.equals("Wooden Sword")) {
			this.name = "Wooden Sword";
			this.description = "You'll be laughed at, but at least you have a weapon to use...";
			this.type = "Weapon";
			this.value = 2;
			
			this.decomposeQTY = 15;
			this.decomposeInto = "<Wood>";
			
		}
		
		
		if(name.equals("Wooden Shield")) {
			this.name = "Wooden Shield";
			this.description = "Probably the most basic shield that you can possibly use in this game.";
			this.type = "Shield";
			this.value = 3;
			
			this.decomposeQTY = 25;
			this.decomposeInto = "<Wood>";
			
		}
		
		
		if(name.equals("Wooden Leg")) {
			this.name = "Wooden Leg Armor";
			this.description = "Peg leg...";
			this.type = "Leg";
			this.value = 3;
			
			this.decomposeQTY = 30;
			this.decomposeInto = "<Wood>";
			
		}
		
		
		if(name.equals("Wooden Chest")) {
			this.name = "Wooden Chest Armor";
			this.description = "Very heavy, but offers minimum protection.";
			this.type = "Chest";
			this.value = 4;

			this.decomposeQTY = 37;
			this.decomposeInto = "<Wood>";
			
		}
		
		
		if(name.equals("Wooden Helm")) {
			this.name = "Wooden Helm";
			this.description = "A finely crafted helmet...out of wood.";
			this.type = "Helm";
			this.value = 2;

			this.decomposeQTY = 10;
			this.decomposeInto = "<Wood>";
			
		}
		
		
		
		
		
		if(name.equals("Hard Leather Chest")) {
			this.name = "Hard Leather Chest";
			this.description = "Slightly lighter and offers minimum protection.";
			this.type = "Chest";
			this.value = 5;

			this.decomposeQTY = 37;
			this.decomposeInto = "<Leather>";
			
		}
		
		if(name.equals("Hard Leather Shield")) {
			this.name = "Hard Leather Shield";
			this.description = "Who knew a shield could be made of leather?";
			this.type = "Shield";
			this.value = 3;

			this.decomposeQTY = 25;
			this.decomposeInto = "<Leather>";
			
		}
		
		if(name.equals("Hard Leather Leg")) {
			this.name = "Hard Leather Leg";
			this.description = "These chaps feel much better than those splinter legs.";
			this.type = "Leg";
			this.value = 4;

			this.decomposeQTY = 30;
			this.decomposeInto = "<Leather>";
			
		}
		
		if(name.equals("Hard Leather Helm")) {
			this.name = "Hard Leather Helm";
			this.description = "Feels very comfortable and snug.";
			this.type = "Helm";
			this.value = 3;

			this.decomposeQTY = 10;
			this.decomposeInto = "<Leather>";
			
		}
		
		
		
		
		
		if(name.equals("Stone Helm")) {
			this.name = "Stone Helm";
			this.description = "Extremely uncomfortable and heavy.";
			this.type = "Helm";
			this.value = 4;

			this.decomposeQTY = 10;
			this.decomposeInto = "<Rock>";
			
		}
		
		if(name.equals("Stone Leg")) {
			this.name = "Stone Leg";
			this.description = "Rock hard leg armor.";
			this.type = "Leg";
			this.value = 5;

			this.decomposeQTY = 30;
			this.decomposeInto = "<Rock>";
			
		}
		
		if(name.equals("Stone Chest")) {
			this.name = "Stone Chest";
			this.description = "The heaviest thing you've ever worn in your life.";
			this.type = "Chest";
			this.value = 7;

			this.decomposeQTY = 37;
			this.decomposeInto = "<Rock>";
			
		}
		
		if(name.equals("Stone Shield")) {
			this.name = "Stone Shield";
			this.description = "A rudimentary shield chipped off of a boulder.";
			this.type = "Shield";
			this.value = 5;

			this.decomposeQTY = 25;
			this.decomposeInto = "<Rock>";
			
		}
		
		if(name.equals("Stone Sword")) {
			this.name = "Stone Sword";
			this.description = "A rudimentary shield chipped off of a boulder.";
			this.type = "Weapon";
			this.value = 4;

			this.decomposeQTY = 15;
			this.decomposeInto = "<Rock>";
			
		}
		
		
		
		if(name.equals("Iron Helm")) {
			this.name = "Iron Helm";
			this.description = "The standard helmet given to militia recruits.";
			this.type = "Helm";
			this.value = 6;

			this.decomposeQTY = 10;
			this.decomposeInto = "<Iron>";
			
		}
		
		if(name.equals("Iron Leg")) {
			this.name = "Iron Leg";
			this.description = "Hard to maneuver around with these on.";
			this.type = "Leg";
			this.value = 8;

			this.decomposeQTY = 30;
			this.decomposeInto = "<Iron>";
			
		}
		
		if(name.equals("Iron Chest")) {
			this.name = "Iron Chest";
			this.description = "The iron chest as seen on the model knights";
			this.type = "Chest";
			this.value = 10;

			this.decomposeQTY = 37;
			this.decomposeInto = "<Iron>";
			
		}
		
		if(name.equals("Iron Shield")) {
			this.name = "Iron Shield";
			this.description = "On this shield is your family's insignia.";
			this.type = "Shield";
			this.value = 8;

			this.decomposeQTY = 25;
			this.decomposeInto = "<Iron>";
			
		}
		
		if(name.equals("Iron Sword")) {
			this.name = "Iron Sword";
			this.description = "Forged by the government for the military.";
			this.type = "Weapon";
			this.value = 6;

			this.decomposeQTY = 15;
			this.decomposeInto = "<Iron>";
			
		}
		
		
		
		
		
		
		
		
		
		//ETC
		
		
		if(name.equals("Small Dead Animal")) {
			this.name = "Small Dead Animal";
			this.description = "You picked this up after killing it.";
			this.type = "Decomposable";
			this.value = 0;
			
			this.decomposeQTY = 3;
			this.decomposeInto = "<Meat>";
			
		}
		
		

		
		
		
		
	}
	

}
