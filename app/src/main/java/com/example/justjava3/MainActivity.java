package com.example.justjava3;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        order(quantity * 5);
    }




    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void order(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        message = "Add whipped cream? " + hasWhip() + "\nAdd chocolate? " + hasChocolate() + "\nQuantity: " + quantity + "\nTotal: $" + (quantity * 5) + "\nThank you!";
        displayMessage(message);
    }


    public void increment(View view){
        quantity++;
        display(quantity);

    }

    public void decrement(View view){
        quantity--;
        display(quantity);
    }

    public void displayMessage(String message)
    {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }



    public boolean hasWhip()
    {
        boolean hasWhip = false;

        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whippedcream_checkbox);
        if (whippedCreamCheckbox.isChecked())
            hasWhip = true;

          return hasWhip;
    }

    public boolean hasChocolate()
    {
        boolean hasChocolate = false;
        CheckBox chocolateCheckbox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        if (chocolateCheckbox.isChecked())
            hasChocolate = true;

        return hasChocolate;
    }
}


