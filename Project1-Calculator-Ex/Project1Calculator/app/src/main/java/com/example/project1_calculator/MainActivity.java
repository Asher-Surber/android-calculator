package com.example.project1_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // create java variables to hook up to xml
    TextView display;
    Button clear_button, pos_neg_button, percent_button, div_button, seven_button, eight_button, nine_button, mult_button, four_button, five_button, six_button, minus_button,
    one_button, two_button, three_button, plus_button, zero_button, decimal_button, equals_button;
    ArrayList<String> query;
    int ctr;    // helps manage display clearing process

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // assign xml items to java variables
        display = findViewById(R.id.display);
        clear_button = findViewById(R.id.clear_button);
        pos_neg_button = findViewById(R.id.pos_neg_button);
        percent_button = findViewById(R.id.percent_button);
        div_button = findViewById(R.id.div_button);
        seven_button = findViewById(R.id.seven_button);
        eight_button = findViewById(R.id.eight_button);
        nine_button = findViewById(R.id.nine_button);
        mult_button = findViewById(R.id.mult_button);
        four_button = findViewById(R.id.four_button);
        five_button = findViewById(R.id.five_button);
        six_button = findViewById(R.id.six_button);
        minus_button = findViewById(R.id.minus_button);
        one_button = findViewById(R.id.one_button);
        two_button = findViewById(R.id.two_button);
        three_button = findViewById(R.id.three_button);
        plus_button = findViewById(R.id.plus_button);
        zero_button = findViewById(R.id.zero_button);
        decimal_button = findViewById(R.id.decimal_button);
        equals_button = findViewById(R.id.equals_button);

        // set button listeners
        clear_button.setOnClickListener(this);
        pos_neg_button.setOnClickListener(this);
        percent_button.setOnClickListener(this);
        div_button.setOnClickListener(this);
        seven_button.setOnClickListener(this);
        eight_button.setOnClickListener(this);
        nine_button.setOnClickListener(this);
        mult_button.setOnClickListener(this);
        four_button.setOnClickListener(this);
        five_button.setOnClickListener(this);
        six_button.setOnClickListener(this);
        minus_button.setOnClickListener(this);
        one_button.setOnClickListener(this);
        two_button.setOnClickListener(this);
        three_button.setOnClickListener(this);
        plus_button.setOnClickListener(this);
        zero_button.setOnClickListener(this);
        decimal_button.setOnClickListener(this);
        equals_button.setOnClickListener(this);

        // ArrayList for storing and manipulating the individual pieces of the expression entered by the user
        query = new ArrayList<>();

        // Helps manage display clearing process
        ctr = 0;
    }

    @Override
    public void onClick(View view) {
        Log.d("onClick", "clicked");

        // clear button pressed
        if(view == findViewById(R.id.clear_button)){
            display.setText("0");
            query.clear();
            ctr = 0;    // helps manage display clearing process
        }

        // pos/neg button pressed
        if(view == findViewById(R.id.pos_neg_button)){
            if(display.getText().toString().contains("-")){                 // if already negative, remove - to make positive
                display.setText(display.getText().toString().substring(1));
            }
            else{
                /*if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                    display.setText("");
                }*/
                display.setText("-" + display.getText().toString());    // if already positive, add -  to make negative
            }
        }

        // percent button pressed
        if(view == findViewById(R.id.percent_button)){
            query.add(display.getText().toString());    // add what's currently being displayed to the query ArrayList, ie "x" where x is a number representing a percentage
            try{
                query.set(2, (((Double.parseDouble(query.get(2))) / 100) * (Double.parseDouble(query.get(0)))) + "");     // change the second operand from "x" to the result of taking x% of the first operand
                display.setText(display.getText().toString() + "%");    // change the display to show x%, keep it simple for user
            } catch(IndexOutOfBoundsException e){                       // handling non-expressions where two numbers and an operation haven't been entered, leaving query too short
                Toast.makeText(this, "Enter a full expression first", Toast.LENGTH_SHORT).show();
                query.clear();
                display.setText("0");
            }
        }

        // division button pressed
        if(view == findViewById(R.id.div_button)){
            query.add(display.getText().toString());        // add the number on the display to query
            query.add("/");     // add the operator to query
        }

        // seven button pressed
        if(view == findViewById(R.id.seven_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){      // leading zero removal if this is the first number pressed
                onNumPress();       //helps manage screen clearing process
                display.setText("7");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "7");        // add a 7 to the end of the number currently being displayed
            }
        }

        // eight button pressed
        if (view == findViewById(R.id.eight_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("8");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "8");
            }
        }

        // nine button pressed
        if (view == findViewById(R.id.nine_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("9");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "9");
            }
        }

        // multiplication button pressed
        if(view == findViewById(R.id.mult_button)){
            query.add(display.getText().toString());
            query.add("*");
        }

        // four button pressed
        if (view == findViewById(R.id.four_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("4");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "4");
            }
        }

        // five button pressed
        if (view == findViewById(R.id.five_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("5");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "5");
            }
        }

        // six button pressed
        if (view == findViewById(R.id.six_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("6");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "6");
            }
        }

        // subtraction button pressed
        if (view == findViewById(R.id.minus_button)){
            query.add(display.getText().toString());
            query.add("-");
        }

        // one button pressed
        if (view == findViewById(R.id.one_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("1");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "1");
            }
        }

        // two button pressed
        if (view == findViewById(R.id.two_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("2");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "2");
            }
        }

        // three button pressed
        if (view == findViewById(R.id.three_button)){
            if(display.getText().toString().substring(0,1).equals("0") && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("3");
            }
            else{
                onNumPress();
                display.setText(display.getText().toString() + "3");
            }
        }

        // addition button pressed
        if (view == findViewById(R.id.plus_button)){
            query.add(display.getText().toString());
            query.add("+");
        }

        // zero button pressed
        if (view == findViewById(R.id.zero_button)){
            if(display.getText().toString().charAt(0) == '0' && display.getText().toString().length() == 1){
                onNumPress();
                display.setText("0");
            }
            else {
                onNumPress();
                display.setText((display.getText().toString()) + "0");
            }
        }

        // decimal button pressed
        if (view == findViewById(R.id.decimal_button)){
            display.setText(display.getText().toString() + ".");    // add a decimal to the end of the number currently displayed. error handling for weird decimal use below
        }

        // equals button pressed
        if (view == findViewById(R.id.equals_button)){
            try {
                String text = display.getText().toString();
                if (text.contains("%")){                                // getting rid of the unnecessary "x%" part of the query, since the result is already in the arraylist
                    Log.d("PercentageRemoval", query.toString());
                }
                else{
                    query.add(text);        // add what's displayed to the query
                }
                query.add("=");             // add an equals symbol to the end of the query to help with the screen clearing process
                Log.d("EqualsClicked", query.toString());
                if (query.get(2).equals("/") || query.get(2).equals("*") || query.get(2).equals("-") || query.get(2).equals("+") || query.get(0).equals("/") || query.get(0).equals("*") || query.get(0).equals("-") || query.get(0).equals("+")) {
                    query.clear();                                                                                      //error handling for improper placement of operators
                    display.setText("0");
                    Toast.makeText(this, "Enter a valid mathematical expression", Toast.LENGTH_SHORT).show();
                } else {
                    switch (query.get(1)) {     // based on the operator, which is at index 1 of the query, evaluate the expression
                        case "/":
                            display.setText("" + Double.parseDouble(query.get(0)) / Double.parseDouble(query.get(2)));
                        query.set(0, display.getText().toString());     // set the display text to the resulting value
                        query.set(1, "");       // clear the rest of the query
                        query.set(2, "");
                            break;
                        case "*":
                            display.setText("" + Double.parseDouble(query.get(0)) * Double.parseDouble(query.get(2)));
                        query.set(0, display.getText().toString());
                        query.set(1, "");
                        query.set(2, "");
                            break;
                        case "+":
                            display.setText("" + ((Double) (Double.parseDouble(query.get(0))) + (Double.parseDouble(query.get(2)))));
                        query.set(0, display.getText().toString());
                        query.set(1, "");
                        query.set(2, "");
                            break;
                        case "-":
                            display.setText("" + (Double.parseDouble(query.get(0)) - Double.parseDouble(query.get(2))));
                        query.set(0, display.getText().toString());
                        query.set(1, "");
                        query.set(2, "");
                            break;
                        default:
                    }
                }
            }catch (NumberFormatException e){                                                                   // error handling for weird decimal usage
                        Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show();
                        query.clear();
                        display.setText("0");
            } catch (IndexOutOfBoundsException e){
                Log.d("IOoB", query.toString());
            }
        }
    }

    // determines when the display should be cleared, such as after an operation has been pressed and a number is being entered, or after equals is pressed and a new number is pressed
    public void onNumPress(){
        try {
            /*if(!query.get(0).isEmpty() && query.get(1).isEmpty() && query.get(2).isEmpty()){
                query.clear();
            }*/
            if(query.size() == 6) {     // full query, but the first half is now junk to us, only need to keep the result and the chosen operation before adding the number just pressed
                if (query.get(3).equals("=")) {
                    Log.d("OperationAfterEquals", query.toString());
                    query.set(0, query.get(4));
                    query.set(1, query.get(5));
                    query.remove(2);
                    query.remove(2);
                    query.remove(2);
                    query.remove(2);
                    display.setText("");
                    ctr--;
                }
            }
            else if (!query.get(1).isEmpty() && ctr == 0){
                display.setText("");
                ctr++;                  // alternates, so screen isn't cleared again until the second number is entered and equals is pressed
                Log.d("onNumPress", "in else if of onNumPress");
            }
        } catch(IndexOutOfBoundsException e){                           // prevent index out of bounds from crashing the app, as it won't be a problem for long
            Log.d("NumPress", "Operation not pressed yet");
        }
    }
}