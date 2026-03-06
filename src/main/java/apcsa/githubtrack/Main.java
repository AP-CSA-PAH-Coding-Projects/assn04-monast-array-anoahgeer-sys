package apcsa.githubtrack;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Main
{
    public static void main(String[] args)
    {
        //new lists

        //Breakfast
        ShoppingList breakfastEssentials = new ShoppingList();
        breakfastEssentials.addToEnd(new ShoppingItem("eggs", 350));
        breakfastEssentials.insertAt(0, new ShoppingItem("smoked salmon", 999));
        breakfastEssentials.addToEnd(new ShoppingItem("frozen berries", 515));
        breakfastEssentials.addToEnd(new ShoppingItem("zuchini", 275));
        breakfastEssentials.insertAt(3, new ShoppingItem("tissues", 100));
        breakfastEssentials.removeAt(3);

        //make a cart, although its not specified in instructions:
        ShoppingCart breakfastCart = new ShoppingCart("terries cart", breakfastEssentials);

        //Dorm
        ShoppingList dormRun = new ShoppingList();
        dormRun.addToEnd(new ShoppingItem("eggs", 350));
        dormRun.addToEnd(new ShoppingItem("tissues", 100));
        dormRun.addToEnd(new ShoppingItem("zuchini", 275));
        dormRun.addToEnd(new ShoppingItem("frozen berries", 515));
        dormRun.addToEnd(new ShoppingItem("smoked salmon", 999));

        //make a cart, although its not specified in instructions:
        ShoppingCart dormCart = new ShoppingCart("Johns Cart", dormRun);

        //Check if identical
        System.out.println("Are dorm list and breakfast list the same? \t" + dormRun.isIdentical(breakfastEssentials));

        //remove items from dorm run list
        dormRun.removeAt(1);
        dormRun.removeAt(4);
        
        //buy items in breakfst essentials
        breakfastEssentials.getArray()[1].buy();
        breakfastEssentials.getArray()[0].buy();

        //check completion of dorm run
        System.out.println("Is dormRun complete?\t" + dormCart.isCompleted());

        //buy all items in breakfast cart
        breakfastEssentials.goShopping();

        //return carts and check number of carts returned
        System.out.println("how many carts are returned? " + ShoppingCart.getTotalCartsReturned());
        breakfastCart.returnCart();
        dormCart.returnCart();
        System.out.println("how many carts are returned now? " + ShoppingCart.getTotalCartsReturned());

        //comparing items from the lists
        System.out.println("compare smoked salmon with frozen berries: " + breakfastEssentials.getArray()[0].compareTo(dormRun.getArray()[2]));

        //Summary:
        System.out.println("These are the items in the dorm cart:");
        for (int i = 0; i < dormRun.getSize(); i++)
        {
            System.out.println(dormRun.getArray()[i].getName());
        }

        System.out.println("These items all cost $" + dormRun.totalPrice());

    }
}