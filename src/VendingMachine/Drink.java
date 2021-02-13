package VendingMachine;

public abstract class Drink {
       private int price;
       private int number;

     Drink(int price,int number){
         this.price = price;
         this.number = number;
     }
    int getPrice() {
        return price;
    }
    void setPrice(int price) {
        this.price = price;
        System.out.println("Current price : " + this.price);
    }
    int getNumber() {
        return number;
    }
    void setNumber(int number) {
         this.number = number;
        System.out.println("Current number : " + this.number);
    }
     abstract void taste();
     abstract void smell();
     abstract String name();
}

class Soda extends Drink implements Carbonated{

    Soda(int price,int number){
        super(price,number);
    }

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }

    @Override
    String name() {
        return "[   Coke"+"_"+this.getPrice()+"원  ]";
    }

    @Override
    public void carbonation() {
        System.out.println("탄산이 가득~한 SODA~~~");
    }
}
class Ion extends Drink{

    Ion(int price,int number){
        super(price,number);
    }

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }

    @Override
    String name() {
        return "[ Getorade"+"_"+this.getPrice()+"원 ]";

    }

}
class Water extends Drink{

    Water(int price,int number){
        super(price,number);
    }

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }

    @Override
    String name() {
        return "[  Samdasu"+"_"+this.getPrice()+"원 ]";
    }

}
class Coffee extends Drink{

    Coffee(int price,int number){
        super(price,number);
    }

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }

    @Override
    String name() {
        return "[  Cantata"+"_"+this.getPrice()+"원  ]";
    }

}

interface Carbonated{

    void carbonation();
}