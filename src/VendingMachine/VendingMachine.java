package VendingMachine;

import java.util.InputMismatchException;
import java.util.Scanner;
public class VendingMachine {
    private static final int HUNDRED = 100;
    private static final int FHUNDRED = 500;
    private static final int THOUSAND = 1000;
    private static final int FTHOUSAND = 5000;
    private static final int SELECT_DRINK = 1;
    private static final int MANAGER_LOGIN = 2;
    Scanner sc ;
    Money_Manage moneyManage;
    Product_Manage productManage;
    private int coin_choice; //기계에 투입된 금액
    private int currentmoney;

    VendingMachine(){
        sc= new Scanner(System.in);
        moneyManage = new Money_Manage(500,100);
        productManage = new Product_Manage();
    }
    public void menuChoice(){
        int menu;
        System.out.println("*************************");
        System.out.println("******             ******");
        System.out.println("*****  자판기 시스템  *****");
        System.out.println("******             ******");
        System.out.println("*************************");

        System.out.println("메뉴를 선택해 주세요.");
        System.out.println("1. 음료선택   2. 관리자 로그인");

        try {
                menu = sc.nextInt();
                while(!(menu == SELECT_DRINK || menu == MANAGER_LOGIN)){
                    System.out.println("1번과 2번중에 선택해주세요.");
                    menu=sc.nextInt();
                }
                menuControler(menu);

        }
        catch(InputMismatchException e){
            System.out.println("원인 : "+e.toString());
            System.out.println("올바른 값을 입력해주세요.");
//            throw e;
        }
        catch(Exception e){
            System.out.println("원인 : "+e.toString());
            System.out.println("올바른 값을 입력해주세요.");
//            throw e;
        }
    }
    private void menuControler(int menu){
        switch (menu){
            case SELECT_DRINK:{
                //여기서 음료 배열 출력
                productManage.printName();
                insertCoin();
                //반환
                choiceDrink();

                break;
            }
            case MANAGER_LOGIN:{
                System.out.println("비밀번호를 입력해주세요.");
                break;
            }
        }
    }

    private void choiceDrink() {
        System.out.println("음료의 번호를 입력해주세요.");

    }

    private void insertCoin(){
        System.out.println("금액을 투입해주세요.\n[ 1. 100원   2. 500원   3. 1000원   4. 5000원]");
        System.out.println("금액 투입을 그만하려면 0을 눌러주세요.");
       loop: while(true) {
            try {
                coin_choice = sc.nextInt();
                while (!(coin_choice >= 0 && coin_choice <= 4)) {
                    System.out.println("정해진 단위만 입력 가능합니다. 단위에 맞게 다시 입력해주세요.");
                    coin_choice = sc.nextInt();
                }
                switch (coin_choice) {
                    case 0:{
                        if(currentmoney<500){
                            System.out.println("금액이 모자랍니다. 더 투입해주세요!!!");
                            continue loop;
                        }
                        System.out.println("금액 투입을 멈춥니다.");
                        System.out.printf("투입한 총 금액은 %d원 입니다.\n",currentmoney);
                        break loop;
                    }
                    case 1: {
                        currentmoney +=  HUNDRED;
                        moneyManage.setCount_100();
                        break;
                    }
                    case 2: {
                        currentmoney +=  FHUNDRED;
                        moneyManage.setCount_500();
                        break;
                    }
                    case 3: {
                        currentmoney +=  THOUSAND;
                        moneyManage.setCount_1000();
                        break;
                    }
                    case 4: {
                        currentmoney +=  FTHOUSAND;
                        moneyManage.setCount_5000();
                        break;
                    }
                }
                System.out.printf("현재 투입한 금액은 : %d원 입니다.\n", currentmoney);


            } catch (InputMismatchException e) {
                System.out.println("원인 : " + e.toString());
                System.out.println("올바른 값을 입력해주세요.");
            }
        }
    }

}

class Money_Manage{
    private static final int HUNDRED = 100;
    private static final int FHUNDRED = 500;
    private static final int THOUSAND = 1000;
    private static final int FTHOUSAND = 5000;
    private int count_100;
    private int count_500;
    private int count_1000;
    private int count_5000;

    Money_Manage(int count_100, int count_500){
        this.count_100 = count_100;
        this.count_500 = count_500;
        System.out.printf("초기 잔액은 %d원 입니다.\n",this.count_100*HUNDRED + this.count_500*FHUNDRED);
    }
     void setCount_100(){
        this.count_100++;
    }
    void setCount_500(){
        this.count_500++;
    }
    void setCount_1000(){
        this.count_1000++;
    }
    void setCount_5000(){
        this.count_5000++;
    }
    void totalMoney(){
        System.out.printf("현재 기계에 있는 총 금액은 %d원 입니다."
                ,count_100*HUNDRED + count_500*FHUNDRED + count_1000*THOUSAND + count_5000*FTHOUSAND
                );
    }
}
class Product_Manage{
    private Drink[][] drinks;
    Product_Manage(){
         drinks = new Drink[4][4];
        for(int i=0; i<drinks.length; i++){
            for(int j=0; j<drinks[i].length; j++){
                switch (i){
                    case 0:{
                        drinks[i][j] = new Soda(2000,10);
                        break;
                    }
                    case 1:{
                        drinks[i][j] = new Ion(1500,10);
                        break;

                    }case 2:{
                        drinks[i][j] = new Water(1000,10);
                        break;

                    }case 3: {
                        drinks[i][j] = new Coffee(500, 10);
                        break;
                    }
                }

            }
        }

    }
    void printName(){
        for(Drink[] d : drinks){
            for(Drink drink : d){
                System.out.print(drink.name());
            }
            System.out.println();
        }

    }


}
class User{
    private int umoney;
    User(int umoney){
        this.umoney = umoney;
    }
    void getUmoney(){
        System.out.println(this.umoney);
    }
}