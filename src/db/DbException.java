package db;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class DbException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public DbException (String msg) {
		Alerts.showAlert("Unexpected error ocurred!", msg, null, AlertType.ERROR);
	}
	
}
