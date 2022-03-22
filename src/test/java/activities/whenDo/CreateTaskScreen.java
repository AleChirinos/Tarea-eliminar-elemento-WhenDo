package activities.whenDo;

import controles.Button;
import controles.TextBox;
import org.openqa.selenium.By;

public class CreateTaskScreen {
    public TextBox titleTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextTitle"));
    public TextBox noteTextBox = new TextBox(By.id("com.vrproductiveapps.whendo:id/noteTextNotes"));
    public Button saveButton= new Button(By.id("com.vrproductiveapps.whendo:id/saveItem"));
}
