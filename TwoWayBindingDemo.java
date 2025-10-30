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
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author admin
 */
public class TwoWayBindingDemo extends Application {
    
    @Override
    public void start(Stage stage) {
        TextField textField = new TextField();    // Ô nhập văn bản
        Slider slider = new Slider(0, 100, 1);   // Thanh trượt

        textField.textProperty().bindBidirectional(
            slider.valueProperty(), 
            new NumberStringConverter()            // Chuyển đổi giữa số ↔ chuỗi
        );
       // khi sửa ô văn bản thì slider cũng được cập nhật  theo và ngược lại 

        VBox root = new VBox(10, slider, textField);
        stage.setScene(new Scene(root, 300, 150));
        stage.setTitle("Two-way Binding Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
