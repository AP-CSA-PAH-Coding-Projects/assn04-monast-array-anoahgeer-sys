package apcsa.githubtrack;

public class ShoppingCart
{
    private ShoppingList list;
    private String name;
    private boolean copmleted;
    // I figured to keep track of all the carts use a static method.
    public static int returnedNum;
    // boolean to track weather returned to prevent repeat
    private boolean returned = false;

    //Constructors:
    public ShoppingCart(String name, ShoppingList list)
    //first constructor if shoppinglist provided
    {
        this.list = list;
        this.name = name;
    }

    public ShoppingCart(String name)
    //second consturctor if list not provided
    {
        list = new ShoppingList();
        this.name = name;
    }

    public boolean isCompleted()
    {
        //loop through all items using enhanced for loop, if not sold return false
        for (ShoppingItem item : list.getArray())
        {
            if (item != null)
                if (!item.isSold())
                    return false;
        }
        //if no hits through the loop, return true
        return true;
    }

    public void returnCart()
    {
        //check if list is complete and if it hasnt been returned yet
        if (isCompleted() && returned == false)
        {
            returnedNum++;
            returned = true;
        }
    }

    //accesors
    public ShoppingList getList()
    {
        return list;
    }
    public String getName()
    {
        return name;
    }
    public boolean getCompleted()
    {
        return copmleted;
    }
    public static int getTotalCartsReturned()
    {
        return returnedNum;
    }
}
