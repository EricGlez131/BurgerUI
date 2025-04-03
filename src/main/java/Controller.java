import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class controller {
    @FXML private CheckBox beef, chicken, impossible, veggie;
    @FXML private CheckBox american, swiss, cheddar, pepperjack;
    @FXML private TextField chooseCheese;
    @FXML private CheckBox tomato, onion, lettuce, pickle, bacon, guac, egg;
    @FXML private TextField chooseGarnish;
    @FXML private ListView<String> cheeseList, pattyList, garnishList;
    @FXML private ComboBox<String> burgerComboBox;


    @FXML
    protected void handleSubmit(ActionEvent actionEvent) {
        ArrayList<String> patties = new ArrayList<>();
        if (beef.isSelected()) patties.add("Beef");
        if (chicken.isSelected()) patties.add("Chicken");
        if (impossible.isSelected()) patties.add("Impossible");
        if (veggie.isSelected()) patties.add("Veggie");

        ArrayList<String> garnishes = new ArrayList<>();
        if (tomato.isSelected()) garnishes.add("Tomato");
        if (onion.isSelected()) garnishes.add("Onion");
        if (lettuce.isSelected()) garnishes.add("Lettuce");
        if (pickle.isSelected()) garnishes.add("Pickle");
        if (bacon.isSelected()) garnishes.add("Bacon");
        if (guac.isSelected()) garnishes.add("Guac");
        if (egg.isSelected()) garnishes.add("Egg");
        if (!chooseGarnish.getText().isEmpty()) garnishes.add(chooseGarnish.getText());

        ArrayList<String> cheeses = new ArrayList<>();
        if (american.isSelected()) cheeses.add("American");
        if (swiss.isSelected()) cheeses.add("Swiss");
        if (cheddar.isSelected()) cheeses.add("Cheddar");
        if (pepperjack.isSelected()) cheeses.add("Pepperjack");
        if (!chooseCheese.getText().isEmpty()) cheeses.add(chooseCheese.getText());


        String selectedBun = burgerComboBox.getValue();
        if (selectedBun == null) selectedBun = "Default Bun";

        Burger burger = new Burger(selectedBun, cheeses, patties, garnishes);
        System.out.println("Burger Created: " + burger);


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Submitted");
        alert.setHeaderText("Your burger has been created!");
        alert.setContentText("Burger Details: \n" + burger + "\n" + burger.getPrice());
        alert.showAndWait();

        resetGUI();


    }

    protected void resetGUI() {
        beef.setSelected(false);
        chicken.setSelected(false);
        impossible.setSelected(false);
        veggie.setSelected(false);
        american.setSelected(false);
        swiss.setSelected(false);
        cheddar.setSelected(false);
        pepperjack.setSelected(false);
        tomato.setSelected(false);
        onion.setSelected(false);
        lettuce.setSelected(false);
        pickle.setSelected(false);
        bacon.setSelected(false);
        guac.setSelected(false);
        egg.setSelected(false);


        chooseCheese.clear();
        chooseGarnish.clear();


        burgerComboBox.setValue(null);
    }

    @FXML
    protected void listButton(){
        Alert burgersList = new Alert(Alert.AlertType.INFORMATION);
        burgersList.setTitle("Burgers");
        StringBuilder burgerDetails = new StringBuilder();

        List<Burger> allObjects = Burger.getAllInstances();
        StringBuilder burgerNames = new StringBuilder();
        for (Burger burger : Burger.burgers ){
            burgerNames.append(burger);
            burgerNames.append("\n");
        }
        burgersList.setContentText(burgerNames.toString());
        burgersList.showAndWait();
    }
}