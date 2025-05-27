package com.example.javafx52;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private BarChart BarChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private Label welcomeText;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create a data series object
        XYChart.Series<String, Double> series2020 = new XYChart.Series<>();
        XYChart.Series<String, Double> series2021 = new XYChart.Series<>();

        // set name for this series
        series2020.setName("2020");
        series2020.setName("2021");


        // set data to this series
        series2020.getData().add(new XYChart.Data<>("Jan", 200.3));
        series2020.getData().add(new XYChart.Data<>("Feb", 200.2));
        series2020.getData().add(new XYChart.Data<>("Mar", 200.1));

        series2021.getData().add(new XYChart.Data<>("Jan", 400.3));
        series2021.getData().add(new XYChart.Data<>("Feb", 600.2));
        series2021.getData().add(new XYChart.Data<>("Mar", 800.1));


        // add XYChart series to the BarChart object
        BarChart.getData().addAll(series2020, series2021);
    }
}