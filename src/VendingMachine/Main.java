package VendingMachine;

public class Main {
    public static void main(String[] args) {
	// write your code here
     Drink coke = new Soda(2000,50);
        System.out.println(coke.getPrice());
        System.out.println(coke.getNumber());

        Drink sprite = new Soda(1800,30);
        System.out.println(sprite.getPrice());
        System.out.println(sprite.getNumber());


    }
}
