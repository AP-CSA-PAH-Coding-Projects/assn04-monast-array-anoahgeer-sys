package apcsa.githubtrack;

public class ShoppingItem
{
    // Implement your ShoppingItem class here
    String name;
    int price;
    boolean sold;

    //Contsructor:
    public ShoppingItem(String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public void buy()
    {
        sold = true;
    }

    public boolean equals(ShoppingItem other)
    {
        //test
        if (name.equals(other.getName()) && price == other.getPrice()*100)
            return true;
        return false;
    }

    public double compareTo(ShoppingItem other)
    {
        //Check name
        if(!name.equals(other.getName()))
            System.out.println("Error: Different items!");
        //Return Difference
        return (price - 100*other.getPrice());
    }

    //getters:
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return (double)price/100;
    }

    public boolean isSold()
{
    return sold;
}

}
