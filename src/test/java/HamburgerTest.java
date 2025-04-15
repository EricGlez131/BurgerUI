import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HamburgerTest {

    @Test
    public void testNum1() {
        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("cheddar");

        ArrayList<String> pattie = new ArrayList<>();
        pattie.add("beef");

        ArrayList<String> garnish = new ArrayList<>();
        garnish.add("lettuce");

        Burger burger = new Burger("Sesame", cheese, pattie, garnish);

        String originalText = burger.getPrice();
        double origPrice = extractTotal(originalText);

        pattie.add("chicken");

        String newText = burger.getPrice();
        double newPrice = extractTotal(newText);

        assertEquals(1.5, newPrice - origPrice, 0.001);
    }

    //check that the total price of a pizza matches the sum of its crust, sauce and toppings.
    @Test
    public void testNum2() {
        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("cheddar");

        ArrayList<String> pattie = new ArrayList<>();
        pattie.add("beef");

        ArrayList<String> garnish = new ArrayList<>();
        garnish.add("lettuce");

        Burger burger = new Burger("Sesame", cheese, pattie, garnish);

        String originalText = burger.getPrice();
        double origPrice = extractTotal(originalText);

        //checks if the total price is the correct amount in this case i added the amount of everything in the burger to
        // be 5.65 with all four items
        assertEquals(5.65, origPrice,0.001);
    }

    //check that the total price of the order is increased by the right amount after assembling a pizza
    @Test
    public void testNum3() {

        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("cheddar");
        ArrayList<String> pattie = new ArrayList<>();
        pattie.add("beef");
        pattie.add("chicken");
        ArrayList<String> garnish = new ArrayList<>();
        garnish.add("lettuce");
        garnish.add("tomato");

        Burger burger = new Burger("Sesame", cheese, pattie, garnish);
        String originalText = burger.getPrice();
        double total = extractTotal(originalText);

        assertEquals(7.55, total, 0.001);
    }


    @Test
    public void testNum4() {
        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("Cheddar");

        ArrayList<String> pattie = new ArrayList<>();
        pattie.add("Beef");
        pattie.add("Turkey");

        ArrayList<String> garnish = new ArrayList<>();
        garnish.add("Lettuce");
        garnish.add("Tomato");

        String bunType = "Brioche";

        Burger burger = new Burger(bunType, cheese, pattie, garnish);

        double expectedTotal = (cheese.size() * 0.75) +
                (pattie.size() * 1.50) +
                (garnish.size() * 0.40) +
                3.00;


        String priceText = burger.getPrice();
        double actualTotal = extractTotal(priceText);


        assertEquals(expectedTotal, actualTotal, 0.001);
    }

    @Test
    public void testNum5() {
        ArrayList<String> cheese = new ArrayList<>();
        cheese.add("Cheddar");
        ArrayList<String> pattie = new ArrayList<>();
        pattie.add("Beef");
        pattie.add("Turkey");
        ArrayList<String> garnish = new ArrayList<>();
        garnish.add("Lettuce");
        garnish.add("Tomato");
        garnish.add("Onion");


        Burger burger1 = new Burger("Brioche", cheese, pattie, garnish);
        Burger burger2 = new Burger("Brioche", cheese, pattie, garnish);

        assertEquals(15.9, burger1.getTotalPriceInDecimal() + burger2.getTotalPriceInDecimal(), 0.001);
    }

    // This is a class that helps extract the total price
    private double extractTotal(String priceText) {
        String[] lines = priceText.split("\n");
        for (String line : lines) {
            if (line.startsWith("Total Price:")) {
                return Double.parseDouble(line.replace("Total Price: $", "").trim());
            }
        }
        throw new IllegalStateException("Total price not found");
    }
}
