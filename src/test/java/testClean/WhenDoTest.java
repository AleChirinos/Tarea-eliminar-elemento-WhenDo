package testClean;

import activities.whenDo.CreateTaskScreen;
import activities.whenDo.ListScreen;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class WhenDoTest {
    CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    ListScreen listScreen= new ListScreen();

    @Test
    public void createTaskTest() throws MalformedURLException {
        String tittle = "Tarea";

        listScreen.addButton.click();
        createTaskScreen.titleTextBox.setValue(tittle);
        createTaskScreen.saveButton.click();

        String expectResult = tittle;
        String actualResult = listScreen.firstTaskLabel.getText();
        Assertions.assertEquals(expectResult,actualResult,"ERROR la tarea no fue creada");
    }

    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
