package com.example.javafx54;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private NumberAxis yAxis;
    @FXML
    private LineChart LineChart;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private Label welcomeText;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        XYChart.Series<String, Double> seriesHigh = new XYChart.Series<>();
        seriesHigh.setName("High Temperature");

        seriesHigh.getData().add(new XYChart.Data<>("Jan", 28.0));
        seriesHigh.getData().add(new XYChart.Data<>("Feb", 29.0));
        seriesHigh.getData().add(new XYChart.Data<>("Mar", 31.0));

        XYChart.Series<String, Double> seriesLow = new XYChart.Series<>();
        seriesLow.setName("Low Temperature");

        seriesLow.getData().add(new XYChart.Data<>("Jan", 8.0));
        seriesLow.getData().add(new XYChart.Data<>("Feb", 9.0));
        seriesLow.getData().add(new XYChart.Data<>("Mar", 1.0));

        LineChart.getData().addAll(seriesHigh, seriesLow);

    }
}