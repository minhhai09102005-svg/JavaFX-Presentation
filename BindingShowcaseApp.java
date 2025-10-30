import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 * Demo gộp NGẮN GỌN:
 * - One-way binding:  Label <-- Slider  (Label tự đổi theo Slider)
 * - Two-way binding:  TextField <--> Slider (đồng bộ 2 phía, có NumberStringConverter)
 */
public class BindingShowcaseApp extends Application {
  @Override public void start(Stage stage) {
    // ===== ONE-WAY: Label theo Slider =====
    Slider s1 = new Slider(0, 100, 25);                 // nguồn dữ liệu (0..100)
    Label  l1 = new Label();                             // đích hiển thị
    l1.textProperty().bind(                              // ràng buộc 1 chiều
        s1.valueProperty().asString("Giá trị: %.0f")    // định dạng số nguyên
    ); // -> kéo s1 => l1 tự cập nhật, KHÔNG cần setText()

    // ===== TWO-WAY: TextField ↔ Slider =====
    Slider s2 = new Slider(0, 100, 10);                  // một nguồn/đích
    TextField tf = new TextField();                      // bên còn lại
    // ràng buộc 2 chiều với converter số <-> chuỗi:
    tf.textProperty().bindBidirectional(s2.valueProperty(), new NumberStringConverter());
    // -> gõ số vào tf => s2 đổi; kéo s2 => tf đổi (đồng bộ 2 phía)

    VBox root = new VBox(8,
        new Label("One-way: Label \u2190 Slider"),
        s1, l1,
        new Separator(),
        new Label("Two-way: TextField \u2194 Slider"),
        s2, tf
    );
    root.setPadding(new Insets(12));

    stage.setScene(new Scene(root, 360, 220));
    stage.setTitle("Property Binding: One-way & Two-way");
    stage.show();
  }

  public static void main(String[] args) { launch(args); }
}
