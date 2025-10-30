/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author admin
 */
public class OneWayBindingDemo extends Application {
    
 @Override
    public void start(Stage stage) {
        Slider slider = new Slider(0, 100, 1);   // Thanh trượt (giá trị từ 0 → 100)
        Label label = new Label();                // Nhãn hiển thị giá trị
        label.textProperty().bind(slider.valueProperty().asString("Giá trị : %.0f")); 
        // khi slider chạy đến 1 giá trị nào thì label sẽ hiển thị giá trị đó 
        VBox root = new VBox(10, slider, label);
        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("One-way Binding Demo");
        stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
