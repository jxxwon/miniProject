package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class myMoneyFormController implements Initializable {
	Stage myMoneyStage;
	Opener opener = new Opener();
	
	public void setMyMoneyStage(Stage myMoneyStage) {
		this.myMoneyStage = myMoneyStage;
	}
	
	@FXML Label idLabel;
	@FXML Label moneyLabel;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		idLabel.setText(Login.getId());
		//잔액 조회
		costDAO costDao = new costDAO();
		String money = "0";
		if(costDao.money(Login.getId()) != null) {
			money = costDao.money(Login.getId());
		}
		
		moneyLabel.setText(money);
	}

	// 충전하기 버튼
	public void chargeProc() {
		opener.chargeMoenyFormOpen();
	}

	// 닫기 버튼
	public void closeProc() {
		myMoneyStage.close();
	}

}
