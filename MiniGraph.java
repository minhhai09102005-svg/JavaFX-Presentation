import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;   // root
import javafx.scene.layout.HBox;        // branch
import javafx.stage.Stage;

public class MiniGraph extends Application {
  @Override public void start(Stage s) {
    BorderPane root = new BorderPane();                // ROOT
    HBox topBar = new HBox(8);                         // BRANCH
    Label title = new Label("My App");                 // LEAF
    Button ok = new Button("OK"), cancel = new Button("Cancel"); // LEAFs

    topBar.getChildren().addAll(title, ok, cancel);    // leafs vào branch
    root.setTop(topBar);                               // branch vào root

    s.setScene(new Scene(root, 300, 150));             // Tạo Scene 300x150 và gắn root vào Stage
    s.setTitle("Root/Branch/Leaf");                    // Đặt tiêu đề cửa sổ
    s.show();                           // Hiển thị cửa sổ
    
    
    
    // Integer (thường) – phải tự cập nhật UI:
    Integer n = 0;
    Label lb = new Label(n.toString());
    n = n + 1;
    lb.setText(n.toString()); // tự gọi

    // IntegerProperty – UI tự cập nhật:
    IntegerProperty n2 = new SimpleIntegerProperty(0);
    Label lb2 = new Label();
    lb2.textProperty().bind(n2.asString()); // bind
    n2.set(n2.get() + 1); // lb2 đổi theo, không cần setText

  }
  public static void main(String[] a){ launch(); }      // Khởi động JavaFX runtime (gọi start)
}
