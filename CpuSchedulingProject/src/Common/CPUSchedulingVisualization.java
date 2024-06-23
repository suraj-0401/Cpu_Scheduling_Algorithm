package Common;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.BarChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CPUSchedulingVisualization extends Application {

    private static Process[] processes;
    private static String algorithmName;

    public static void setProcesses(Process[] processes) {
        CPUSchedulingVisualization.processes = processes;
    }

    public static void setAlgorithmName(String algorithmName) {
        CPUSchedulingVisualization.algorithmName = algorithmName;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("CPU Scheduling Visualization - " + algorithmName);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Process ID");
        yAxis.setLabel("Time");

        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("CPU Scheduling - " + algorithmName);

        XYChart.Series<String, Number> waitingTimeSeries = new XYChart.Series<>();
        waitingTimeSeries.setName("Waiting Time");

        XYChart.Series<String, Number> turnaroundTimeSeries = new XYChart.Series<>();
        turnaroundTimeSeries.setName("Turnaround Time");

        for (Process process : processes) {
            waitingTimeSeries.getData().add(new XYChart.Data<>(String.valueOf(process.getProcessId()), process.getWaitingTime()));
            turnaroundTimeSeries.getData().add(new XYChart.Data<>(String.valueOf(process.getProcessId()), process.getTurnAroundTime()));
        }

        barChart.getData().addAll(waitingTimeSeries, turnaroundTimeSeries);

        VBox vbox = new VBox(barChart);
        Scene scene = new Scene(vbox, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void displayProcessChart(Process process) {
        Stage stage = new Stage();
        stage.setTitle("CPU Scheduling Visualization - " + algorithmName);

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Process ID");
        yAxis.setLabel("Time");

        final BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("CPU Scheduling - " + algorithmName);

        XYChart.Series<String, Number> waitingTimeSeries = new XYChart.Series<>();
        waitingTimeSeries.setName("Waiting Time");

        XYChart.Series<String, Number> turnaroundTimeSeries = new XYChart.Series<>();
        turnaroundTimeSeries.setName("Turnaround Time");

        waitingTimeSeries.getData().add(new XYChart.Data<>(String.valueOf(process.getProcessId()), process.getWaitingTime()));
        turnaroundTimeSeries.getData().add(new XYChart.Data<>(String.valueOf(process.getProcessId()), process.getTurnAroundTime()));

        barChart.getData().addAll(waitingTimeSeries, turnaroundTimeSeries);

        VBox vbox = new VBox(barChart);
        Scene scene = new Scene(vbox, 400, 300);

        stage.setScene(scene);
        stage.showAndWait();
    }
}
