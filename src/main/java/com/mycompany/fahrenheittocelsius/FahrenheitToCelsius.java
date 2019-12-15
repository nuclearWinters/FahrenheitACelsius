/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fahrenheittocelsius;

/**
 *
 * @author Armando
 */

import java.util.*;
import javax.swing.*;
    import java.awt.*;
    import java.awt.event.*;
    import java.text.DecimalFormat;

    @SuppressWarnings("serial")
    public class FahrenheitToCelsius extends JFrame{
    private static final double CelsiusTOFarenheit = 9.0 / 5.0;
    private static final double FahrenheitTOCelsius = 5.0 / 9.0;
    private static final int offset = 32;
    private JLabel LFahrenheit, LCelsius; //Labels
    private JTextField TFFahrenheit, TFCelsius; //Text Fields
    private JButton BConvert; //Convert Button
    private ConvertButtonHandler ConvButtonHandler;

    public FahrenheitToCelsius() {
    setTitle("Fahrenheit a Celsius");
    Container pane = getContentPane();
    pane.setLayout(new GridLayout(1,5));

    LFahrenheit = new JLabel("Farenheit:", JLabel.CENTER);
        pane.add(LFahrenheit);
    TFFahrenheit = new JTextField();
        pane.add(TFFahrenheit);
    BConvert = new JButton("Convertir");
        pane.add(BConvert);
            ConvButtonHandler = new ConvertButtonHandler();
            BConvert.addActionListener(ConvButtonHandler);
    LCelsius = new JLabel("Celsius:", JLabel.CENTER);
        pane.add(LCelsius);
    TFCelsius = new JTextField();
        pane.add(TFCelsius);

    setSize(600, 85);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
}
 private class ConvertButtonHandler implements ActionListener{
     @Override
public void actionPerformed(final ActionEvent e) {
    double celsius = 0, fahrenheit = 0;
    DecimalFormat twoDigits = new DecimalFormat("0.00");
    if (FahrenheitToCelsius.this.TFCelsius.getText() == null || "".equals(FahrenheitToCelsius.this.TFCelsius.getText().trim())) {
        // convert from fahrenheit to celsius
        fahrenheit = Double.parseDouble(FahrenheitToCelsius.this.TFFahrenheit.getText());
        celsius = (fahrenheit - FahrenheitToCelsius.offset) *   FahrenheitToCelsius.FahrenheitTOCelsius;
        FahrenheitToCelsius.this.TFCelsius.setText(" " + twoDigits.format(celsius));
    } else if (FahrenheitToCelsius.this.TFFahrenheit.getText() == null || "".equals(FahrenheitToCelsius.this.TFFahrenheit.getText().trim())) {
           // convert from celsius to fahrenheit
           celsius = Double.parseDouble(FahrenheitToCelsius.this.TFCelsius.getText());
           fahrenheit = celsius * FahrenheitToCelsius.CelsiusTOFarenheit + FahrenheitToCelsius.offset;
           FahrenheitToCelsius.this.TFFahrenheit.setText(" " + twoDigits.format(fahrenheit));
    }
}
 }

public static void main(String[] args) {
    new FahrenheitToCelsius();
}
}

