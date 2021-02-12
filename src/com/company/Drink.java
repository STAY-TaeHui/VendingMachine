package com.company;

public abstract class Drink {
     private int price;

     abstract void taste();
     abstract void smell();
}

class Soda extends Drink {

    @Override
    void taste() {

    }

    @Override
    void smell() {

    }
}

class Coke extends Soda implements Carbonated{

    @Override
    public void carbonation() {

    }
}
interface Carbonated{

    void carbonation();
}