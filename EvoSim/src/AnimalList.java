import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class AnimalList {
	private Animal[] animals = new Animal[100];
	private ArrayList<Animal> animalAL = new ArrayList<Animal>();
	double ePF = 60;
	public AnimalList() {
		for(int i = 0;i<100;i++) {
			animalAL.add(new Animal());
		}
	}
	public void cull() {
		ArrayList<Animal> animalAL = new ArrayList<Animal>();
		int j = 0;
		Random r = new Random();
		for(int i = 0;i<this.animalAL.size();i++) {
			if(this.animalAL.get(i).hasFood()&&ePF>this.animalAL.get(i).energyUse()) {
				if(r.nextDouble()*this.animalAL.get(i).reproductionChance>=1) {
					animalAL.add(this.animalAL.get(i));
				}
			}
		}
		this.animalAL=animalAL;
	}
	public void cullInvialbe() {
		ArrayList<Animal> animalAL = new ArrayList<Animal>();
		for(int i = 0;i<this.animalAL.size();i++) {
			if(ePF<this.animalAL.get(i).energyUse()) {
				animalAL.add(this.animalAL.get(i));
			}
			else if(this.animalAL.get(i).speed<0.05||this.animalAL.get(i).sight<1) {
				animalAL.add(this.animalAL.get(i));
			}
		}
		this.animalAL=animalAL;
	}
	public void reproduce() {
		sort();
		cull();
		 ArrayList<Animal> animalAL = new ArrayList<Animal>();
		for(int i = 0;i<this.animalAL.size();i++) {
			for(double j=0;j<2*this.animalAL.get(i).reproductionAmount;j++) {
				animalAL.add(this.animalAL.get(i).reproduce());
			}
		}
		cullInvialbe();
		this.animalAL = animalAL;
		
	}
	public void sort() {
		//bubbleSortArrayList(); 
		Collections.shuffle(animalAL);
		double devancy = 0;
		int eatCount = 0;
		for(int i = 0;i<animalAL.size()/2&&eatCount<100;i++) {
			if(eatCount>10&&eatCount<75) {
				devancy+=.05;
				if(Math.random()>=devancy/animalAL.get(i).sight) {
					animalAL.get(i).didEat(true);eatCount++;
				}
			}else if(i>50){
				if(Math.random()>=devancy/animalAL.get(i).sight) {
					animalAL.get(i).didEat(true);eatCount++;
				}
				
			}else {
				animalAL.get(i).didEat(true);eatCount++;
			}
			if(eatCount==50) {
				devancy=0.3;
			}
		}
		Random r = new Random();
		int eatCountC = eatCount;
		for(int i = 0;i<animalAL.size();i++) {
			/*if(Math.random()*animalAL.get(i).speed<r.nextInt(5)*((animalAL.get(i).hasFood())?2:0.5)) {
				if(animalAL.get(i).hasFood()) {
					eatCount--;
				}else {
					eatCount++;
				}
				if(eatCountC>eatCount) {
					animalAL.get(i).didEat(!animalAL.get(i).hasFood());
				}else {
					if(animalAL.get(i).hasFood()) {
						eatCount++;
					}else {
						eatCount--;
					}
				}
			}*/
			if(animalAL.get(i).hasFood()&&Math.random()*animalAL.get(i).speed<r.nextInt(5)*2) {
				animalAL.get(i).didEat(false);
			}
		}
	}
	public void bubbleSortArrayList() {
		Animal temp;
	    boolean sorted = false;

	    while (!sorted) {
	        sorted = true;
	        for (int i = 0; i < animalAL.size()-1; i++) {
	            if (animalAL.get(i).energyUsage < animalAL.get(i + 1).energyUsage) {
	                temp = animalAL.get(i);
	                animalAL.set(i, animalAL.get(i + 1));
	                animalAL.set(i + 1, temp);
	                sorted = false;
	            }
	        }
	    }
	}
	public int size() {
		return animalAL.size();
	}
	/*public Animal[] getList() {
		return animals;
	}*/
	public ArrayList<Animal> getList() {
		return animalAL;
	}
}
