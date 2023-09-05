package login;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class replyFormController implements Initializable {
	replyFormService service;
	BoardDAO dao = new BoardDAO();
	BoardDTO dto;

	public void setBoardDto(BoardDTO dto) {
		this.dto = dto;
	}

	Stage replyStage;

	public void setReplyStage(Stage replyStage) {
		this.replyStage = replyStage;
	}

	@FXML
	TableView<replyDTO> tableView;
	@FXML
	TableColumn<replyDTO, String> replyCol;
	@FXML
	TableColumn<replyDTO, String> writerCol;
	@FXML
	TableColumn<replyDTO, String> numCol;
	@FXML
	TableColumn<replyDTO, String> writeTimeCol;

	ObservableList<replyDTO> observableList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		service = new replyFormService();
		
	}
	
	//댓글 목록
	@FXML
	void tableTouch(MouseEvent event) {
		observableList = FXCollections.observableArrayList();

		replyCol.setCellValueFactory(new PropertyValueFactory<>("reply"));
		writerCol.setCellValueFactory(new PropertyValueFactory<>("writer"));
		numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
		writeTimeCol.setCellValueFactory(new PropertyValueFactory<>("writeTime"));

		Collection<replyDTO> list = dao.replyViewAll(dto);
		if (list == null) {
			CommonService.msg("등록된 게시글이 없습니다.");

		} else {
			observableList.addAll(list);
			tableView.setItems(observableList);
		}
	}
	@FXML
	TextArea replyFld;

	// 댓글 작성
	public void writeReply() {
		replyDTO replyDto = new replyDTO();
		replyDto.setTitle(dto.getTitle());// 글의 제목
		replyDto.setContent(dto.getContent());// 글의 내용
		replyDto.setWriter(Login.getId());// 댓글 작성자
		replyDto.setReply(replyFld.getText());// 작성한 댓글

		if (replyDto.getReply().isEmpty()) {
			CommonService.msg("내용을 입력하세요.");
		} else {
			int result = service.writeReply(replyDto);
			if (result == 1) {
				Collection<replyDTO> all = dao.replyViewAll(dto);
				observableList = FXCollections.observableArrayList(all);
				tableView.setItems(observableList);
			}
		}

	}

	@FXML
	Button writeBtn;
	@FXML
	Button changeBtn;
	@FXML
	Button deleteBtn;

	// 선택한 행 필드에 보여주기
	@FXML
	void tableClick(MouseEvent event) {
		replyDTO dto = tableView.getSelectionModel().getSelectedItem();
//		replyFld.setText(dto.getReply());
		
		writeBtn.setDisable(true);
		if(!dto.getWriter().equals(Login.getId())) {
			deleteBtn.setDisable(true);
		}
	}
	
	public void deleteProc(ActionEvent event) {
		if (tableView.getSelectionModel().isEmpty()) {
			CommonService.msg("삭제할 데이터를 선택하세요.");
			return;
		}
		
		ButtonType btnType = CommonService.confirm("확인", "정말로 삭제하시겠습니까?");
		if (btnType == ButtonType.OK) {
			replyDTO replyDto = tableView.getSelectionModel().getSelectedItem();

			dao.myReplyDelete(replyDto);
			CommonService.msg("삭제되었습니다.");
			
			Collection<replyDTO> all = dao.replyViewAll(dto);
			observableList = FXCollections.observableArrayList(all);
			tableView.setItems(observableList);
		} else {
			CommonService.msg("취소했습니다.");
		}
	}
	/*
	 * public void deleteProc(ActionEvent event) {
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
			mySecretStage.close();
		} else {
			CommonService.msg("취소했습니다.");
		}
	}*/
}
