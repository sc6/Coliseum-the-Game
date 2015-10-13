import java.util.Random;


public class Monster {
	
	public String name;
	public int rewardMoney;
	public int health;
	public int maxHealth;
	public int speed;
	public int attack;
	public int numRewards;
	public int score;
	
	public Item[] rewards = new Item[10];	
	
	
	public Monster(String name) {
		
		
		
		
		//initializing all lootable items
		Item WoodenSword = new Item("Wooden Sword");
		Item WoodenShield = new Item("Wooden Shield");
		Item WoodenChest = new Item("Wooden Chest");
	
		Item HardLeatherChest = new Item("Hard Leather Chest");
		
		Item StoneSword = new Item("Stone Sword");
		Item StoneShield = new Item("Stone Shield");
		Item StoneChest = new Item("Stone Chest");
		
		Item IronShield = new Item("Iron Shield");
		Item IronChest = new Item("Iron Chest");
		
		
		
		
		
		
		if(name.equals("Training Dummy")) {		
			this.maxHealth = this.health = 3;
			this.speed = 0;
			this.attack = 1;
			this.name = "Training Dummy"; 
			
			this.rewardMoney = 50; 
			this.rewards[0] = WoodenSword;
			this.rewards[1] = WoodenShield;
			this.numRewards = 2;
			
			this.score = 10;
		}
		
		
		if(name.equals("Petty Thief")) {		
			this.maxHealth = this.health = 10;
			this.speed = 1;
			this.attack = 2;
			this.name = "Petty Thief"; 
			
			this.rewardMoney = 200; 
			this.rewards[0] = WoodenChest;
			this.numRewards = 1;
			
			this.score = 25;
		}
		
		
		if(name.equals("Adult Hoodlum")) {		
			this.maxHealth = this.health = 10;
			this.speed = 2;
			this.attack = 5;
			this.name = "Adult Hoodlum"; 
			
			this.rewardMoney = 150; 
			this.rewards[0] = HardLeatherChest;
			this.numRewards = 1;
			
			this.score = 43;
		}
		
		
		if(name.equals("Rebel Slave")) {		
			this.maxHealth = this.health = 15;
			this.speed = 2;
			this.attack = 6;
			this.name = "Rebel Slave"; 
			
			this.rewardMoney = 25; 
			this.rewards[0] = StoneSword;
			this.rewards[1] = StoneShield;
			this.numRewards = 2;
			
			this.score = 51;
		}
		
		
		if(name.equals("Disgruntled Worker")) {		
			this.maxHealth = this.health = 12;
			this.speed = 1;
			this.attack = 8;
			this.name = "Disgruntled Worker"; 
			
			this.rewardMoney = 150; 
			this.rewards[0] = StoneChest;
			this.numRewards = 1;
			
			this.score = 58;
		}
		
		
		if(name.equals("Giant Vagrant")) {		
			this.maxHealth = this.health = 48;
			this.speed = 1;
			this.attack = 8;
			this.name = "Giant Vagrant"; 
			
			this.rewardMoney = 125; 
			this.rewards[0] = IronChest;
			this.rewards[1] = IronShield;
			this.numRewards = 2;
			
			this.score = 85;
		}
		
		
		
		
	}
	
	public int attack(int attackValue, int rawDefense){
		int randomIndex = attackValue / 4;
		int fluxValue = 0; 
		int damageBlocked = 0;
		
		if(randomIndex > 0) {
		Random r = new Random();
		fluxValue = r.nextInt(randomIndex);
		}
		
		damageBlocked = rawDefense/3;
		
		int damage = attackValue + fluxValue - damageBlocked;
		
		return damage;
	}

}
