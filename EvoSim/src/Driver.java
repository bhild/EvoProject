import java.util.ArrayList;

public class Driver {
	public static void main(String[] args) {
		AnimalList a = new AnimalList();
		for(int i = 0;i<1000&&a.size()>0;i++) {
			a.reproduce();
			if(i==0||i%((double)i/10)==0) {				
				//System.out.print(i+" ");
				System.out.print(a.size()+" ");
			}
			if(i%200==0&&i!=0) {
				System.out.println();
			}
		}
		System.out.println("\n");
		a.sort();
		a.cull();
		a.bubbleSortArrayList();
		ArrayList<Animal> a1 = a.getList();
		
		for(int i = 0;i<a1.size();i++) {
			System.out.print(i+"\t");
			a1.get(i).printAnimal();
		}
	}

}
