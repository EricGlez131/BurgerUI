import java.util.ArrayList;

public class Burger {
    String buns;
    ArrayList<String> cheese;
    ArrayList<String> pattie;
    ArrayList<String> garnish;


    public Burger(String buns, ArrayList<String> cheese, ArrayList<String> pattie, ArrayList<String> garnishes) {
        this.buns = buns;
        this.cheese = cheese;
        this.pattie = pattie;
        this.garnish = garnishes;
    }

    public String getPrice(){
        double pattyTotal = pattie.size() * 1.5;
        double cheeseTotal = cheese.size() * .75;
        double garnishTotal = garnish.size() * .40;
        double bunTotal = 3;

        double totalPrice = pattyTotal + cheeseTotal + garnishTotal + bunTotal;

        return String.format(
                "Patties: %s ($%.2f)\n" +
                        "Cheese: %s ($%.2f)\n" +
                        "Garnish: %s ($%.2f)\n" +
                        "Buns: %s ($%.2f)\n" +
                        "Total Price: $%.2f",
                String.join(", ", pattie), pattyTotal,
                String.join(", ", cheese), cheeseTotal,
                String.join(", ", garnish), garnishTotal,
                buns, bunTotal,
                totalPrice
        );
    }
}
