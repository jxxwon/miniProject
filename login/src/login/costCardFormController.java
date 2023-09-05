package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class costCardFormController implements Initializable {
	@FXML
	Label myPayBalanceLb;
	@FXML
	WebView cardWebView;

	private costDAO costDao = new costDAO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		myPayBalanceLb.setText(costDao.selectMoney(Login.getId()));

		WebEngine engine = cardWebView.getEngine();
		String url = "file:///C:/javas/miniProject/miniProject/src/login/card.html";
		engine.executeScript("alert('asd');");
		engine.load(url);
	}

	public void cancelProc() {
		Opener.costPayStageClose();
	}

}
