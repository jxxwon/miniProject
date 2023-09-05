package login;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class costPayFormController implements Initializable {
	Stage costPayStage;
	Opener opener = new Opener();
	private costPayFormService service;
	private costDAO costDao;

	@FXML
	ComboBox<String> yearCmb;
	@FXML
	ComboBox<String> monthCmb;
	@FXML
	Button requestBtn;
	@FXML
	Button cardPayBtn;
	@FXML
	Button myPayBtn;
	@FXML
	TableView<costMonth> costPayTableView;
	@FXML
	TableColumn<costMonth, String> detailsColumn;
	@FXML
	TableColumn<costMonth, String> costsColumn;
	@FXML
	Label deadlineLb;
	@FXML
	Label monthTotalLb;
	@FXML
	Label payLb;
	@FXML
	Label unpaidLb;
	@FXML
	Label totalLb;
	@FXML
	ListView<String> bankListView;

	ObservableList<costMonth> observableList;
	
	public void setCostPayStage(Stage costPayStage) {
		this.costPayStage = costPayStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new costPayFormService();

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM");
		LocalDateTime now = LocalDateTime.now();

		yearCmb.setValue(dtf.format(now).substring(0, 4) + "년");
		yearCmb.getItems().addAll("2023년", "2022년", "2021년", "2020년", "2019년");

		monthCmb.setValue(dtf.format(now).substring(5, 7) + "월");
		monthCmb.getItems().addAll("01월", "02월", "03월", "04월", "05월", "06월", "07월", "08월", "09월", "10월", "11월", "12월");
		
		
		requestBtn.setDisable(true);
		cardPayBtn.setDisable(true);
		myPayBtn.setDisable(true);
	}

	public void selectProc() {
		String year = yearCmb.getValue().substring(0, yearCmb.getValue().length() - 1);
		String month = monthCmb.getValue().substring(0, monthCmb.getValue().length() - 1);

		CostDTO cost = service.select(year, month, Login.getId());
		if (cost == null) {
			CommonService.msg("등록된 관리비가 없습니다. 관리자에 문의하세요.");
		} else {
			observableList = FXCollections.observableArrayList();

			detailsColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
			costsColumn.setCellValueFactory(new PropertyValueFactory<>("costs"));

			observableList.add(new costMonth("일반관리비", cost.getCommonCost()));
			observableList.add(new costMonth("청소비", cost.getCleanCost()));
			observableList.add(new costMonth("경비비", cost.getSecCost()));
			observableList.add(new costMonth("승강기 유지비", cost.getElvCost()));
			observableList.add(new costMonth("난방비", cost.getHeatCost()));
			observableList.add(new costMonth("전기료", cost.getPowerCost()));
			observableList.add(new costMonth("수도료", cost.getWaterCost()));
			observableList.add(new costMonth("입주자 운영비", cost.getOperCost()));

			costPayTableView.setItems(observableList);
			
			String from = cost.getYear() +"-"+cost.getMonth()+"-10";
			SimpleDateFormat fDate = new SimpleDateFormat("yyyy-MM-dd");
			try {
				Date date = fDate.parse(from); // String 2023-06-10을 date로 변환
				Calendar cal = new GregorianCalendar(Locale.KOREA);
				cal.setTime(new Date());
				cal.setTime(date);
				cal.add(Calendar.MONTH, 1);
				SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
				String deadline = fm.format(cal.getTime());
				deadlineLb.setText(deadline);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			payLb.setText(cost.getPay());
			
			monthTotalLb.setText(cost.getTotalCost() + "원");
			
			unpaidLb.setText(service.unpaid() + "원");
			
			String total = "";
			int monthTotal = Integer.parseInt(monthTotalLb.getText().substring(0, monthTotalLb.getText().length()-1));
			int un = Integer.parseInt(unpaidLb.getText().substring(0, unpaidLb.getText().length()-1));
			total = Integer.toString(monthTotal + un);
			
			totalLb.setText(total + "원");
			
			ObservableList<String> list = FXCollections.observableArrayList();
			
			String kb = service.account(Login.getId()).get(0);
			String wr = service.account(Login.getId()).get(1);
			String nh = service.account(Login.getId()).get(2);
			String ibk = service.account(Login.getId()).get(3);
			String keb = service.account(Login.getId()).get(4);
			String sh = service.account(Login.getId()).get(5);
			
			list.add("국민은행  "+ kb + "  기업은행 " + ibk); 
			list.add("우리은행  " + wr + "  하나은행 " + keb);
			list.add("농협은행  " + nh + " 신한은행 " + sh);
			
			bankListView.setItems(list);
			
			if (payLb.getText().equals("미납")){
				requestBtn.setDisable(false);
				cardPayBtn.setDisable(false);
				myPayBtn.setDisable(false);
			}
		}
	}
	
	public void myPayProc() {
		costDao = new costDAO();
		String balance = costDao.selectMoney(Login.getId());
		String total = totalLb.getText().substring(0, totalLb.getText().length()-1);
		
		if(Integer.parseInt(balance)< Integer.parseInt(total)) {
			CommonService.msg("출금 가능한 금액이 부족합니다.");
		} else {
			if(CommonService.confirm("현재 잔액 : " + balance + "원", total + "원을 결제하시겠습니까?").getButtonData().equals(ButtonData.OK_DONE)) {
				String money = Integer.toString(Integer.parseInt(balance) - Integer.parseInt(total));
				service.myPay(money);
			} else {
				CommonService.msg("결제를 취소하였습니다.");
			}
		}
	}
	
	
	public void cardPayProc() {
		Opener opener = new Opener();
		opener.costCardFormOpen();
	}

	
	public void requestProc() {
		String year = yearCmb.getValue().substring(0, yearCmb.getValue().length()-1);
		String month = monthCmb.getValue().substring(0, monthCmb.getValue().length()-1);
		if(CommonService.confirmMsg(year + "년 " + month + "월 관리비 납부를 확인 요청하시겠습니까?").get().equals(ButtonType.OK)){
			String pay = "확인요청";
			service.request(year, month, pay);
			CommonService.msg("관리자에 납부 확인 요청하였습니다.");
		} else {
			CommonService.msg("납부 확인 요청을 취소하였습니다.");
		}
	}
	
	public void cancelProc() {
		costPayStage.close();
	}
}
