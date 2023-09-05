package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class userCarrotBoardFormController implements Initializable {
	Opener opener = new Opener();
	private Stage communityStage;

	public void setCommunityStage(Stage communityStage) {
		this.communityStage = communityStage;
	}

	@FXML
	ComboBox<String> combo;
	ObservableList<String> comboData;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboData = FXCollections.observableArrayList("공지사항", "1:1 문의", "자유게시판", "중고거래");
		combo.setItems(comboData);
		combo.setValue("중고거래");
	}
	
	@FXML
	private void useHandleChange(ActionEvent event) {
		if (combo.getSelectionModel().getSelectedItem() == "공지사항") {
			opener.communityFormOpen();
			communityStage.close();
		}
		if (combo.getSelectionModel().getSelectedItem() == "1:1 문의") {
			opener.userScretFormOpen();
			communityStage.close();
		}
		if (combo.getSelectionModel().getSelectedItem() == "자유게시판") {
			opener.userFreeFormOpen();
			communityStage.close();
		}
	}

}
