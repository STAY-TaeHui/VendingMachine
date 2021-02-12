package VendingMachine;

public abstract class Drink {
       int price;
       int number;

     Drink(int price,int number){
         this.price = price;
         this.number = number;
     }

    abstract int getPrice();
    abstract void setPrice(int price);
    abstract int getNumber();
     abstract void setNumber(int number);
     abstract void taste();
     abstract void smell();
}

class Soda extends Drink {

    Soda(int price,int number){
        super(price,number);
    }

    @Override
    int getPrice() {
        return price;
    }


    @Override
    void setPrice(int price) {
        this.price = price;
        System.out.println("Current price : " + this.price);
    }

    @Override
    int getNumber() {
        return number;
    }

    @Override
    void setNumber(int number) {

    }

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }

}

interface Carbonated{

    void carbonation();
}