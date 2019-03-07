package model;

import java.io.Serializable;

public class Survey implements Serializable {

    private int clientNumber, drinkType, drink, nbOfCups;

    public Survey(int clientNumber, int drinkType, int drink, int nbOfCups) {
        this.clientNumber = clientNumber;
        this.drinkType = drinkType;
        this.drink = drink;
        this.nbOfCups = nbOfCups;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public int getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(int drinkType) {
        this.drinkType = drinkType;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        drink = drink;
    }

    public int getNbOfCups() {
        return nbOfCups;
    }

    public void setNbOfCups(int nbOfCups) {
        this.nbOfCups = nbOfCups;
    }


    @Override
    public String toString() {
        String kindOfDrink = null;
        String type = null;

        switch (drinkType){

            case  1:
                 kindOfDrink = "Juice";
                 switch (drink){
                     case 1:
                         type = "Apple";
                         break;
                     case 2:
                         type = "Orange";
                         break;
                     case 3:
                         type = "Mixed";
                         break;
                 }
                break;
            case 2:
                kindOfDrink = "Lemonade";
                switch (drink){
                    case 1:
                        type = "Coca";
                        break;
                    case 2:
                        type = "Sprite";
                        break;
                    case 3:
                        type = "7-Up";
                        break;
                }
                break;
        }

        return kindOfDrink + type;
    }
}
