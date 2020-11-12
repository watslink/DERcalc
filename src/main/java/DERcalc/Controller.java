package DERcalc;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;

import java.text.DecimalFormat;
import java.util.function.UnaryOperator;

public class Controller {
    public Person person;
    public TextField sizeControl;
    public TextField ageControl;
    public TextField weightControl;
    public RadioButton sexControl0;
    public RadioButton sexControl1;
    public ToggleGroup sexControl;
    public boolean sex;
    private DecimalFormat doubleFormat = new DecimalFormat("#.00");
    public Label IMC;
    public Label DERMJ;
    public Label DERkcal;

    @FXML
    public void initialize(){
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([0-9]*)")) {
                return change;
            }
            return null;
        };
        this.ageControl.setTextFormatter(
                new TextFormatter<Integer>(new IntegerStringConverter(), 0, integerFilter));

        UnaryOperator<TextFormatter.Change> doubletFilter = change -> {
            if (change.isReplaced())
                if(change.getText().matches("[^0-9]"))
                    change.setText(change.getControlText().substring(change.getRangeStart(), change.getRangeEnd()));

            if (change.isAdded()) {
                if (change.getControlText().contains(".")) {
                    if (change.getText().matches("[^0-9]")) {
                        change.setText("");
                    }
                } else if (change.getText().matches("[^0-9.]")) {
                    change.setText("");
                }
            }

            return change;
        };
        this.weightControl.setTextFormatter(
                new TextFormatter<Double>(new DoubleStringConverter(), 0.00, doubletFilter));

        this.sizeControl.setTextFormatter(
                new TextFormatter<Double>(new DoubleStringConverter(), 0.00, doubletFilter));
    }

    public void calc(MouseEvent mouseEvent) {
        if(sexControl0.isSelected()) {sex=false;}
        if(sexControl1.isSelected()) {sex=true;}
        this.person = new Person(sex, Integer.parseInt(ageControl.getText()),Double.parseDouble(weightControl.getText()),
                Double.parseDouble(sizeControl.getText()));
        this.IMC.setText(doubleFormat.format(person.getIMC()));
        this.DERMJ.setText(doubleFormat.format(person.getDERMJ()));
        this.DERkcal.setText(doubleFormat.format(person.getDERkcal()));
    }
}
