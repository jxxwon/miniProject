package login;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class userFreeBoardFormController implements Initializable {
	Opener opener = new Opener();
	BoardDAO dao = new BoardDAO();
	private Stage communityStage;

	public void setCommunityStage(Stage communityStage) {
		this.communityStage = communityStage;
	}

	@FXML
	ComboBox<String> combo;
	ObservableList<String> comboData;

	@FXML
	TableView<BoardDTO> tableView;
	@FXML
	TableColumn<BoardDTO, Integer> numCol;
	@FXML
	TableColumn<BoardDTO, String> titleCol;
	@FXML
	TableColumn<BoardDTO, String> contentCol;
	@FXML
	TableColumn<BoardDTO, String> writeTimeCol;
	@FXML
	TableColumn<BoardDTO, String> writerCol;
	@FXML
	TableColumn<BoardDTO, Integer> hitsCol;
	@FXML
	TableColumn<BoardDTO, Integer> likesCol;
	ObservableList<BoardDTO> observableList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		// combobox
		comboData = FXCollections.observableArrayList("공지사항", "1:1 문의", "자유게시판", "중고거래");
		combo.setItems(comboData);
		combo.setValue("자유게시판");
		
		combo.setStyle("-fx-font-size: 15px;");
		combo.setStyle("-fx-background-color: #fcf0d5;");
		combo.setStyle("-fx-border-color: #6b4418; -fx-border-width: 2px; -fx-border-radius: 30px; -fx-background-radius: 30px;");

		// tableview에 데이터 보여주기
		observableList = FXCollections.observableArrayList();

		numCol.setCellValueFactory(new PropertyValueFactory<>("num"));
		titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
		contentCol.setCellValueFactory(new PropertyValueFactory<>("content"));
		writeTimeCol.setCellValueFactory(new PropertyValueFactory<>("writeTime"));
		writerCol.setCellValueFactory(new PropertyValueFactory<>("writer"));
		hitsCol.setCellValueFactory(new PropertyValueFactory<>("hits"));
		likesCol.setCellValueFactory(new PropertyValueFactory<>("likes"));

		Collection<BoardDTO> list = dao.freeViewAll();

		observableList.addAll(list);
		tableView.setItems(observableList);

	}

	// combobox 데이터 선택시 화면 바뀜
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
		if (combo.getSelectionModel().getSelectedItem() == "중고거래") {
			opener.userCarrotBoardFormOpen();
			communityStage.close();
		}
	}

	// 글쓰기 버튼 누르면 새창 뜨게
	public void writeFreeProc() {
		opener.wrtieFreeFormOpen();

	}

	@FXML
	ImageView search;
	@FXML
	TextField searchFld;

	@FXML
	public void searchProc(MouseEvent event) {
		Collection<BoardDTO> search = dao.searchFree(searchFld.getText());
		if (search == null || search.isEmpty()) {
			CommonService.msg("검색하신 결과가 없습니다.");
		} else {
			observableList = FXCollections.observableArrayList(search);
			tableView.setItems(observableList);
		}
	}

	// 선택한 행 새창에 띄우기
	BoardDTO dto;
	@FXML
	void tableClick(MouseEvent event) {
		// 행 선택했을 때
		dto = tableView.getSelectionModel().getSelectedItem();
		if (event.getClickCount() > 1) {
			dao.updateHits(dto.getNum()); //db에 조회수 증가 
//			board.setHit(board.getHit()+1);
//			dto.setHits(dto.getHits());
			opener.viewFreeFormOpen(dto);
		}
	}

}
