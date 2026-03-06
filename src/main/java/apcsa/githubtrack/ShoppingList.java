package apcsa.githubtrack;
import java.util.Arrays;

// Implement your ShoppingList class here

public class ShoppingList implements MyList
{
    private int capacity;
    private int size;
    private ShoppingItem[] items;

    //Constructor
    public ShoppingList()
    {
        capacity = 8;
        size = 0;
        items = new ShoppingItem[8];
    }

    // ArrayList functionality methods:
    public void addToEnd(ShoppingItem item) 
    {
        if (size == capacity) 
            makeCapacity(capacity + 8);

            items[size] = item;
            size++;
    }

    public void insertAt(int index, ShoppingItem item) 
    {
        //check for errors
        if (index < 0 || index > size)
        {
            System.out.println("Invalid Index!");
        }
        else
        {
            //add space if at capacity
            if (size == capacity) 
                makeCapacity(capacity + 8);
            //loop backwards through the array, moving each item forward one space, stopping on index
            for (int i = size; i >= index; i--) 
            {
                items[i + 1] = items[i];
            }
            //add item at index
            items[index] = item;
            size++;
        }
    }

    public void removeAt(int index)
    {
        //check for erros
        if (index < 0 || index > size)
            System.out.println("invald index!");
        else
            //loop through the array to replace the item at index with the one
            //next, repeating will all items (up to second last)
            for (int i = index; i < (size - 1); i++)
            {
                items[i] = items[i + 1];
            }
            //replace last item (now a copy of second last) with null, and reduce size to match.
            items[size - 1] = null;
            size--; 
    }

    public ShoppingItem getAt(int index)
    {
        //check for erros
        if (index < 0 || index > size || size == 0)
        {
            System.out.println("Invalid index!");
            return null;
        }
        //else, return item at index
        return items[index];
    }
    
    //Capacity Mehthods:
    public void makeCapacity(int minCapacity)
    {
        //Make sure the method can be implemented
        if (!(minCapacity == size || minCapacity == capacity))
        {
            //if minCapacity is less than 8, make minCapacity 8
            if (minCapacity < 8)
            {
                minCapacity = 8;
            }
            //looked up an array copy method, calling it here. Faster than creating new array, copying, then replacing.
            items = Arrays.copyOf(items, minCapacity);
            capacity = minCapacity;
        }
    }

    public void trimExcess()
    {
        makeCapacity(size);
    }

    //Shopping Methods
    public void goShopping()
    {
        //loop through all items, buy all.
        for (int i = 0; i < size; i++)
        {
            items[i].buy();
        }
    }

    public void goShopping(ShoppingList toBuy)
    {
        //loop through all items
        for (int i = 0; i < size; i++)
        {
            //nested loop to test each item:
            for (int j = 0; j < toBuy.getSize(); j++)
            {
                //test items at j index in toBuy, if equals, buy.
                if (items[i].equals(toBuy.getArray()[j]))
                    items[i].buy();
            }
        }
    }

    public double totalPrice()
    {
        double total = 0;
        //loop through, and add price to total
        for (ShoppingItem item : items)
        {
            if (item != null)
                total += item.getPrice();
        }
        return total;
    }

    public boolean isIdentical(ShoppingList other)
    {
        //test size first
        if (size != other.getSize())
            return false;

        boolean contain = false;
        //loop through items:
        for (int i = 0; i < size; i++)
        {
            contain = false;
            //nested loop, check all items in other. Record any negatives with Contain
            for (int j = 0; j < other.getSize(); j++)
            {
                if (items[i].equals(other.getArray()[j]))
                    contain = true;
            }
            //if no "hit", return false
            if (!contain)
                return false;
        }
        //if loop complete, that means there was always a hit in the nested loop, and to return true.
        return true;
    }

    //Getters:
    public int getSize()
    {
        return size;
    }
    
    public int getCapacity()
    {
        return capacity;
    }

    public ShoppingItem[] getArray()
    {
        //returns the item array
        return items;
    }
}
