package testClean;

import activities.whenDo.CreateTaskScreen;
import activities.whenDo.ListScreen;
import activities.whenDo.ToolBar;
import activities.whenDo.VentanaEmergenteEliminacion;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import session.Session;

import java.net.MalformedURLException;

public class TareaWhenDoBorrarElemento {
    CreateTaskScreen createTaskScreen= new CreateTaskScreen();
    ListScreen listScreen= new ListScreen();
    ToolBar toolBar = new ToolBar();
    VentanaEmergenteEliminacion ventanaEmergenteEliminacion = new VentanaEmergenteEliminacion();

    @Test
    public void createTaskTest() throws MalformedURLException {
        String tittle = "Tarea";
        String note = "Esta es la nota";

        listScreen.addButton.click();
        createTaskScreen.titleTextBox.setValue(tittle);
        createTaskScreen.noteTextBox.setValue(note);
        createTaskScreen.saveButton.click();

        String expectResult = tittle;
        String actualResult = listScreen.firstTaskLabel.getText();
        Assertions.assertEquals(expectResult,actualResult,"ERROR el elemento no fue creada");

        listScreen.tittleButton.click();
        toolBar.eliminar.click();
        ventanaEmergenteEliminacion.confirmarEliminar.click();

        Assertions.assertFalse(listScreen.firstTaskLabel.isControlDisplayed(), "ERROR el elemento no fue eliminado");
    }

    @AfterEach
    public void closeApp() throws MalformedURLException {
        Session.getInstance().closeSession();
    }
}
