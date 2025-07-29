package proj1;

import java.util.ArrayList;

enum CrustType {
    Plain,
    Butter,
    Garlic,
    GarlicButter,
    Cheese
}

enum SizeType {
    Small,
    Medium,
    Large,
    XLarge,
    XXLarge,
    Party
}

public class Pizza implements Comparable<Pizza> {
    private CrustType crust;
    private ArrayList<String> toppings;
    private SizeType size;

    public Pizza() {
        this.crust = CrustType.Plain;
        this.toppings = new ArrayList<>();
        this.size = SizeType.Small;
    }

    public Pizza(CrustType crust, ArrayList<String> toppings, SizeType size) {
        this.crust = crust;
        this.toppings = new ArrayList<>(toppings);
        this.size = size;
}

//setters and getters
public CrustType getCrust() {
    return crust;
}

public void setCrust(CrustType crust) {
    this.crust = crust;
}

public ArrayList<String> getToppings() {
    return new ArrayList<>(toppings);
}

public void setToppings(ArrayList<String> toppings) {
    this.toppings = new ArrayList<>(toppings);
}

public SizeType getSize() {
    return size;
}

public void setSize(SizeType size) {
    this.size = size;
}

//addtopping
public void addTopping(String topping) {
    this.toppings.add(topping);
}

@Override
public String toString() {
    String result = "This pizza has a " + crust + " crust and the following toppings:\n";
    if (toppings.isEmpty()) {
        result += "none";
    } else {
        for (String topping : toppings) {
            result += topping + "\n";
        }
    }
    return result;
}

//equals

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Pizza other = (Pizza) obj;
        return this.crust == other.crust && 
               this.size == other.size &&
               this.toppings.equals(other.toppings);
    }

//compares to

@Override
public int compareTo(Pizza other) {
    int thisToppingCount = this.toppings.size();
    int otherToppingCount = other.toppings.size();

    if (thisToppingCount < otherToppingCount) {
        return -1;
    } else if (thisToppingCount > otherToppingCount) {
        return 1;
    } else {
        //same number of toppings 
        int thiscrustrank = crustrank(this.crust);
        int othercrustrank = crustrank(other.crust);

        if (thiscrustrank < othercrustrank) {
            return -1;
        } else if (thiscrustrank > othercrustrank) {
            return 1;
        } else {
            return 0;
        }
    }
}


private int crustrank(CrustType crust) {
    switch (crust) {
        case Cheese: return 5;
        case GarlicButter: return 4;
        case Garlic: return 3;
        case Butter: return 2;
        case Plain: return 1;
        default: return 0;
    }
}
}
