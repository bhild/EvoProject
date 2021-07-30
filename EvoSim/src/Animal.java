import java.util.Random;

public class Animal {
	double sight,speed,reproductionChance,energyUsage,reproductionAmount;
	private boolean gotFood;
	public Animal() {
		Random rand = new Random();
		this.sight=rand.nextInt(5)+2;
		this.speed = rand.nextDouble()*5+1;
		this.reproductionChance = rand.nextDouble()*5+1;
		this.reproductionAmount = rand.nextDouble()*2+2;
		if(speed<0.01) {
			this.speed=0.01;
		}
		if(sight<1) {
			this.sight = 1;
		}
		genEnergyUse();
	}
	public Animal(double sight,double speed,double reproductionChance,double reproductionAmount) {
		this.sight=sight;
		this.speed = speed;
		this.reproductionChance = reproductionChance;
		this.reproductionAmount = reproductionAmount;
		if(speed<0.05) {
			this.speed=0.05;
		}
		if(sight<1) {
			this.sight = 1;
		}
		genEnergyUse();
	}
	private void genEnergyUse() {
		double usage= 0;
		usage+=sight*1.2;
		usage+=speed*1.25;
		usage+=reproductionChance*1.25;
		usage+=reproductionAmount*3.5;
		energyUsage=usage;
	}
	public double energyUse() {
		return energyUsage;
	}
	public void didEat(boolean t) {
		gotFood = t;
	}
	public boolean hasFood() {
		return gotFood;
	}
	public double getReproductionChance() {
		return reproductionChance;
	}
	public Animal reproduce() {
		Random rand = new Random();
		double sightL = sight+(rand.nextDouble()*2-1);
		double speedL = speed+(rand.nextDouble()*2-1);
		double reproductionChanceL = reproductionChance+rand.nextDouble()*2-1;
		double reproductionAmountL = reproductionChance+rand.nextDouble()*2-1;
		while(speed<0.01||sight<1) {
			speedL = speed+(rand.nextDouble()*2-1);
			sightL = sight+(rand.nextDouble()*2-1);
		}
		Animal child = new Animal(sightL,speedL,reproductionChanceL,reproductionAmountL);
		return child;
	}
	public void printAnimal() {
		System.out.println("sight - "+sight+"\t speed - "+speed+"\t reproductionChance - "+reproductionChance+"   \t reproductionAmount - "+reproductionAmount+"     \t energy use - " + energyUsage);
	}
	

}
