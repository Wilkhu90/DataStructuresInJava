import java.util.LinkedList;
abstract class Animal {
	int order;
	String name;
	
	public Animal(String n){
		name = n;
	}
	public void setOrder(int ord){
		order = ord;
	}
	public boolean is01derThan(Animal a){
		return this.order < a.getOrder();
	}
	public int getOrder(){
		return order;
	}
}
class Dog extends Animal{
	public Dog(String n){
		super(n);
	}
}

class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class Ques7{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	int order = 0;

	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if (a instanceof Dog){
			dogs.addLast((Dog) a);
		}
		else if (a instanceof Cat){
			cats.addLast((Cat)a);
		}
	}

	public Animal dequeueAny(){
		if (dogs.size() == 0){
			return dequeueCats();
		} 
		else if (cats.size() == 0){
			return dequeueDogs();
		}
 		Dog dog = dogs.peek();
 		Cat cat = cats.peek();
 		if (dog.is01derThan(cat)){
 			return dequeueDogs();
 		}
 		else{
 			return dequeueCats();
 		}
 	}


 	public Dog dequeueDogs(){
		return dogs.poll();
	}
	public Cat dequeueCats(){
		return cats.poll();
	}

	public static void main(String[] args){
		Ques7 solution = new Ques7();
		solution.enqueue(new Cat("kitty"));
		solution.enqueue(new Dog("doppy"));
		System.out.println(solution.dequeueAny().name);
	}
}

