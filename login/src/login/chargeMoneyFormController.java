package login;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class chargeMoneyFormController implements Initializable {
	Opener opener = new Opener();
	@FXML
	ComboBox<String> combo;
	ObservableList<String> comboData;

	Stage myMoneyStage;

	public void setMymoneyStage(Stage myMoenyStage) {
		this.myMoneyStage = myMoenyStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		comboData = FXCollections.observableArrayList("50,000", "40,000", "30,000", "20,000", "10,000");
		combo.setItems(comboData);
		combo.setValue("금액 선택");

		combo.setStyle("-fx-font-size: 30px;");
		combo.setStyle("-fx-background-color: #fcf0d5;");
		combo.setStyle(
				"-fx-border-color: #6b4418; -fx-border-width: 2px; -fx-border-radius: 30px; -fx-background-radius: 30px;");
	}

	// 충전버튼
	public void chargeProc() {
		String money = combo.getValue();
		if(CommonService.confirmMsg(money + "원을 충전하시겠습니까?").get().equals(ButtonType.OK)){
			String[] split = money.split(",");
			money = split[0] + split[1];
			costDAO costDao = new costDAO();
			if(costDao.selectMoney(Login.getId()).equals("0")) {
				costDao.chargeUpdate(Login.getId(), money);
			} else {
				String balance = costDao.selectMoney(Login.getId());
				money = Integer.toString(Integer.parseInt(money) + Integer.parseInt(balance));
				costDao.chargeUpdate(Login.getId(), money);
			}
			CommonService.msg("충전이 완료되었습니다.");
		} else {
			CommonService.msg("충전을 취소하였습니다.");
		}
	}

	// 닫기버튼
	public void closeProc() {
		myMoneyStage.close();
	}
}
