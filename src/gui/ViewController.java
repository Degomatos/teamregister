package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import model.dao.DaoFactory;
import model.dao.JogadorDao;
import model.entities.Jogador;

public class ViewController implements Initializable{
	@FXML
	private TextField txtTeam;
	@FXML
	private TextField txtJogador1Name;
	@FXML
	private TextField txtJogador1Height;
	@FXML
	private TextField txtJogador1Age;
	@FXML
	private TextField txtJogador1Position;
	@FXML
	private TextField txtJogador2Name;
	@FXML
	private TextField txtJogador2Height;
	@FXML
	private TextField txtJogador2Age;
	@FXML
	private TextField txtJogador2Position;
	@FXML
	private ComboBox<String> comboBoxModality;
	@FXML
	private Button buttonCadastrar;
	@FXML
	private Button buttonShowAll;
	
	JogadorDao jogadorDao = DaoFactory.createJogadorDao();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		String[] modality = {"Masculino", "Feminino"};
		comboBoxModality.getItems().addAll(modality);
		Constraints.setTextFieldDouble(txtJogador1Height);
		Constraints.setTextFieldDouble(txtJogador2Height);
		Constraints.setTextFieldInteger(txtJogador1Age);
		Constraints.setTextFieldInteger(txtJogador2Age);		
	}
	
	@FXML
	private void cadastrarTime() {
		String teamName = txtTeam.getText();
		String modality = comboBoxModality.getValue();
//Jogador 1
		String name1 = txtJogador1Name.getText();
		String position1 = txtJogador1Position.getText();
		double height1 = Double.parseDouble(txtJogador1Height.getText());
		int age1 = Integer.parseInt(txtJogador1Age.getText());
//Jogador 2
		String name2 = txtJogador2Name.getText();
		String position2 = txtJogador2Position.getText();
		double height2 = Double.parseDouble(txtJogador2Height.getText());
		int age2 = Integer.parseInt(txtJogador2Age.getText());
		
		Jogador jogador1 = new Jogador(name1, height1, age1, position1, teamName, modality);
		jogadorDao.insert(jogador1);
		Jogador jogador2 = new Jogador(name2, height2, age2, position2, teamName, modality);
		jogadorDao.insert(jogador2);
		Alerts.showAlert("Confirmação", "CADASTRO REALIZADO COM SUCESSO!", null, AlertType.CONFIRMATION);
		clearTxtFields();
	}
	
	private void clearTxtFields() {
		txtTeam.setText("");
		txtJogador1Age.setText("");
		txtJogador1Height.setText("");
		txtJogador1Name.setText("");
		txtJogador1Position.setText("");
		txtJogador2Age.setText("");
		txtJogador2Height.setText("");
		txtJogador2Name.setText("");
		txtJogador2Position.setText("");
	}

	@FXML
	private void showAll() {	
		List<Jogador> list = jogadorDao.findAll();
		for(Jogador jog: list)
			System.out.println(jog);
		
		System.out.println();
		clearTxtFields();
	}

}
