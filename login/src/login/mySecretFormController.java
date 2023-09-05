package login;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class mySecretFormController implements Initializable {
	@FXML
	TableView<BoardDTO> tableView;
	@FXML
	TableColumn<BoardDTO, String> numCol;
	@FXML
	TableColumn<BoardDTO, String> titleCol;
	@FXML
	TableColumn<BoardDTO, String> contentCol;
	@FXML
	TableColumn<BoardDTO, String> writeTimeCol;
	@FXML
	TableColumn<BoardDTO, String> commentsCol;

	BoardDTO dto;
	BoardDAO dao = new BoardDAO();

	ObservableList<BoardDTO> observableList;
	Stage mySecretStage;

	public void setMySecretStage(Stage mySecretStage) {
		this.mySecretStage = mySecretStage;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		observableList = FXCollections.observableArrayList();

		numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
		writeTimeCol.setCellValueFactory(new PropertyValueFactory<>("writeTime"));
		commentsCol.setCellValueFactory(new PropertyValueFactory<>("comments"));

//		BoardDAO dao = new BoardDAO();
		Collection<BoardDTO> list = dao.mySecretViewAll();
		if (list == null) {
			CommonService.msg("등록하신 1:1문의가 없습니다.");
		} else {
			observableList.addAll(list);
			tableView.setItems(observableList);
		}

//		tableView.setFixedCellSize(33);//행 높이
//		numCol.setStyle("-fx-pref-height: 70px;");//헤더 높이
//		numCol.setStyle("-fx-alignment: CENTER;");//
//		numCol.setStyle("-fx-font-size:14px;");
//	    tableView.setStyle("-fx-font-size:14px;"); 전체 폰트 크기 
	}

	public ButtonType confirm(String head, String msg) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.setTitle("확인");
		confirm.setHeaderText(head);
		confirm.setContentText(msg);
		return confirm.showAndWait().get();
	}

	public void deleteProc(ActionEvent event) {
		if (tableView.getSelectionModel().isEmpty()) {
			CommonService.msg("삭제할 데이터를 선택하세요.");
			return;
		}

//		BoardDTO board = new BoardDTO(num, title, content, writer, writeTime, hits, likes);
		ButtonType btnType = confirm("확인", "정말로 삭제하시겠습니까?");
		if (btnType == ButtonType.OK) {
			BoardDTO mySecret = tableView.getSelectionModel().getSelectedItem();

			dao.mySecretdelete(mySecret);
			CommonService.msg("삭제되었습니다.");

			Collection<BoardDTO> all = dao.mySecretViewAll();
			observableList = FXCollections.observableArrayList(all);
			tableView.setItems(observableList);
		} else {
			CommonService.msg("취소했습니다.");
		}
	}

	@FXML
	TextField titleFld;
	@FXML
	TextArea contentFld;
	@FXML
	Label writeTime;

	// 선택한 행 필드에 보여주기
	@FXML
	void tableClick(MouseEvent event) {
		if (!tableView.getSelectionModel().isEmpty()) {

			dto = tableView.getSelectionModel().getSelectedItem();

			titleFld.setText(dto.getTitle());
			contentFld.setText(dto.getContent());
			writeTime.setText(dto.getWriteTime());
		} else {

		}
	}

	// 수정버튼 클릭시 실행
	@SuppressWarnings("unlikely-arg-type")
	@FXML
	void modClick(ActionEvent event) {
		if (tableView.getSelectionModel().isEmpty()) {
			CommonService.alert("확인", "수정할 데이터를 선택한 후 사용하세요.");
			return;
		} else {
			BoardDTO dto = tableView.getSelectionModel().getSelectedItem();
			if (dto.getTitle().equals(titleFld.getText()) && dto.getContent().equals(contentFld.getText())) {
				CommonService.alert("확인", "수정된 내용이 없습니다.");
			} else {

				ButtonType btnType = CommonService.confirm("확인", "수정하시겠습니까?");
				if (btnType == ButtonType.OK) {
					dto.setTitle(titleFld.getText());
					dto.setContent(contentFld.getText());
					int result = dao.mySecretUpdate(dto);
					if (result == 1) {
						CommonService.msg("수정되었습니다.");

						Collection<BoardDTO> all = dao.mySecretViewAll();
						observableList = FXCollections.observableArrayList(all);
						tableView.setItems(observableList);

					} else {
						CommonService.msg("취소했습니다.");
					}
				}
			}
		}
	}

	// 답변보기 눌렀을 때 실행할 메서드
	@FXML
	void viewComment(MouseEvent event) {
		if (tableView.getSelectionModel().isEmpty()) {
			CommonService.alert("확인", " 데이터를 선택한 후 사용하세요.");
			return;
		} else {
			BoardDTO dto = new BoardDTO();
			dto = tableView.getSelectionModel().getSelectedItem();
			titleFld.setText("관리자입니다.");

			if (dto.getComments() == null) {
				contentFld.setText("죄송합니다. 아직 답변 전입니다. \n조금만 더 기다려 주세요.");
			} else {
				contentFld.setText(dto.getComments());
			}
		}
	}
}
