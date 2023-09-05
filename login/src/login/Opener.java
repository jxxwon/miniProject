package login;

import java.io.IOException;
import java.util.Collection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Opener {
	private Stage primaryStage;

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	private Stage regStage;
	private Parent regForm;

	public void regFormOpen() {// 회원가입창 새로열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("regForm.fxml"));

		regStage = new Stage();
		try {
			regForm = loader.load();
			RegController regCon = loader.getController();
			regCon.setRegStage(regStage);
			regCon.setRegForm(regForm);

			regStage.setScene(new Scene(regForm));
			regStage.setTitle("회원가입 화면");
			regStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void adminFormOpen() {// 기존 로그인창에 관리자창 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("adminForm.fxml"));

		Parent adminForm;
		try {
			adminForm = loader.load();
			primaryStage.setScene(new Scene(adminForm));
			primaryStage.setTitle("관리자 화면");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage userManageStage;
	private Parent userManageForm;

	public void userManageFormOpen() {// 관리자창에 회원관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userManageForm.fxml"));
		userManageStage = new Stage();

		try {
			userManageForm = loader.load();
			userManageStage.setScene(new Scene(userManageForm));
			userManageStage.setTitle("관리자 화면 - 회원관리");
			userManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage allMemberStage;
	private Parent allMemberForm;

	public void allMemberFormOpen() {// 관리자창 -> 회원관리 -> 회원조회
		FXMLLoader loader = new FXMLLoader(getClass().getResource("allMemberForm.fxml"));
		allMemberStage = new Stage();

		try {
			allMemberForm = loader.load();
			allMemberStage.setScene(new Scene(allMemberForm));
			allMemberStage.setTitle("관리자 화면 - 회원관리 - 회원조회");
			allMemberStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage DisMemberStage;
	private Parent DisMemberForm;

	public void DisMemberFormOpen() {// 관리자창 -> 회원관리 -> 입주민 승인
		FXMLLoader loader = new FXMLLoader(getClass().getResource("DisMemberForm.fxml"));
		DisMemberStage = new Stage();

		try {
			DisMemberForm = loader.load();
			DisMemberStage.setScene(new Scene(DisMemberForm));
			DisMemberStage.setTitle("관리자 화면 - 회원관리 - 입주민 승인");
			DisMemberStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage deleteMemberStage;
	private Parent deleteMemberForm;

	public void deleteMemberFormOpen() {// 관리자창 -> 회원관리 -> 탈퇴 회원
		FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteMemberForm.fxml"));
		deleteMemberStage = new Stage();

		try {
			deleteMemberForm = loader.load();
			deleteMemberStage.setScene(new Scene(deleteMemberForm));
			deleteMemberStage.setTitle("관리자 화면 - 회원관리 - 탈퇴 회원");
			deleteMemberStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage boardManageStage;
	private Parent boardManageForm;

	public void boardManageFormOpen() {// 관리자창에 게시판관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("boardManageForm.fxml"));
		boardManageStage = new Stage();

		try {
			boardManageForm = loader.load();
			boardManageStage.setScene(new Scene(boardManageForm));
			boardManageStage.setTitle("관리자 화면 - 게시판관리");
			boardManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Stage costManageStage;
	private Parent costManageForm;

	public void costManageFormOpen() {// 관리자창에 관리비관리 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costManageForm.fxml"));
		costManageStage = new Stage();

		try {
			costManageForm = loader.load();
			costManageStage.setScene(new Scene(costManageForm));
			costManageStage.setTitle("관리자 화면 - 관리비관리");
			costManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void costSelectFormOpen() {// 관리비관리에 관리비 조회 화면 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costSelectForm.fxml"));
		costManageStage = new Stage();

		try {
			Parent costSelectForm = loader.load();

			costManageStage.setScene(new Scene(costSelectForm));
			costManageStage.setTitle("관리비관리 - 관리비 조회");
			costManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void costUpdateFormOpen(CostDTO cost) { // 관리비 수정 화면 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costUpdateForm.fxml"));
		costManageStage = new Stage();

		try {
			Parent costUpdateForm = loader.load();
			ComboBox<String> yearCmb = (ComboBox<String>) costUpdateForm.lookup("#yearCmb");
			yearCmb.setValue(cost.getYear() + "년");
			ComboBox<String> monthCmb = (ComboBox<String>) costUpdateForm.lookup("#monthCmb");
			monthCmb.setValue(cost.getMonth() + "월");
			ComboBox<String> complexCmb = (ComboBox<String>) costUpdateForm.lookup("#complexCmb");
			complexCmb.setValue(cost.getId().substring(0,3) + "동");
			ComboBox<String> unitCmb = (ComboBox<String>) costUpdateForm.lookup("#unitCmb");
			unitCmb.setValue(cost.getId().substring(4,7) + "호");
			costManageStage.setScene(new Scene(costUpdateForm));
			costManageStage.setTitle("관리비관리 - 관리비 수정");
			costManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void costManageStageClose() {
		CommonService.windowClose(costManageStage);
	}

	public void costRegFormOpen() {// 관리비관리에 세대별관리비내역등록 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costRegForm.fxml"));
		costManageStage = new Stage();

		try {
			Parent costRegForm = loader.load();

			costManageStage.setScene(new Scene(costRegForm));
			costManageStage.setTitle("관리비관리 - 세대별관리비내역등록");
			costManageStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void costUnpaidFormOpen() { // 미납금관리 화면 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costUnpaidForm.fxml"));
		costManageStage = new Stage();
		
		try {
			Parent costUnpaidForm = loader.load();
			
			costManageStage.setScene(new Scene(costUnpaidForm));
			costManageStage.setTitle("관리비관리 - 미납금관리");
			costManageStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void userFormOpen() {// 기존 로그인 창에 유저창 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userForm.fxml"));

		Parent userForm;
		try {
			userForm = loader.load();
			Label id = (Label) userForm.lookup("#id");
			id.setText(Login.getId() + "호");

			primaryStage.setScene(new Scene(userForm));
			primaryStage.setTitle("입주민 화면");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Stage myPageStage;
	private Parent myPageForm;
	public void myPageFormOpen() {// 마이페이지창 새로 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myPageForm.fxml"));
		myPageStage = new Stage();

		try {
			myPageForm = loader.load();

			myPageStage.setScene(new Scene(myPageForm));
			myPageStage.setTitle("마이페이지");
			myPageStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Stage communityStage = new Stage();
	private Parent communityForm;
	public void communityFormOpen() {// 커뮤니티창 새로 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("communityForm.fxml"));
		try {
			communityForm = loader.load();

//			ComboBox<String> combo = (ComboBox<String>) communityForm.lookup("#combo");
//			combo.getItems().addAll("공지사항", "1:1문의", "자유게시판", "중고거래");

			communityFormController commnutinyCon = loader.getController();
			commnutinyCon.setCommunityStage(communityStage);

			communityStage.setScene(new Scene(communityForm));
			communityStage.setTitle("공지사항");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// 공지사항 창에서 콤보박스-1:1문의 선택하면 열리는 창
	private Parent userSecretBoardForm;

	public void userScretFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userSecretBoardForm.fxml"));
		try {
			userSecretBoardForm = loader.load();

			userSecretFormController userSecretBoardCon = loader.getController();
			userSecretBoardCon.setCommunityStage(communityStage);

			communityStage.setScene(new Scene(userSecretBoardForm));
			communityStage.setTitle("1:1 문의");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 1:1 문의하기 버튼 클릭시 새창으로 
	private Parent writeSecretForm;
	private Stage writeSecretStage = new Stage();
	public void writeSecretFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("writeSecretForm.fxml"));
		try {
			writeSecretForm = loader.load();

			writeSecretFormController userSecretFormCon = loader.getController();
			userSecretFormCon.setwriteSecretStage(writeSecretStage);

			writeSecretStage.setScene(new Scene(writeSecretForm));
			writeSecretStage.setTitle("1:1 문의");
			writeSecretStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 내 문의 보기 - > 새창으로
	private Stage mySecretStage = new Stage();
	private Parent mySecretForm;

	public void mySecretFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mySecretForm.fxml"));
		try {
			mySecretForm = loader.load();

			mySecretFormController mySecretFormCon = loader.getController();
			mySecretFormCon.setMySecretStage(mySecretStage);

			mySecretStage.setScene(new Scene(mySecretForm));
			mySecretStage.setTitle("나의 1:1 문의");
			mySecretStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Parent userFreeBoardForm;
	public void userFreeFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userFreeBoardForm.fxml"));
		try {
			userFreeBoardForm = loader.load();

			userFreeBoardFormController userFreeBoardCon = loader.getController();
			userFreeBoardCon.setCommunityStage(communityStage);

			communityStage.setScene(new Scene(userFreeBoardForm));
			communityStage.setTitle("자유게시판");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//자유게시판 글쓰기 -> 새창 열기
	private Parent wrtieFreeForm;
	private Stage wrtieFreeStage = new Stage();
	public void wrtieFreeFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("writeFreeForm.fxml"));
		try {
			wrtieFreeForm = loader.load();

			writeFreeFormController writeFreeFormCon = loader.getController();
			writeFreeFormCon.setWriteFreeStage(wrtieFreeStage);

			wrtieFreeStage.setScene(new Scene(wrtieFreeForm));
			wrtieFreeStage.setTitle("자유게시판 글쓰기");
			wrtieFreeStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//게시글 보기
	private Parent viewFreeForm;
	private Stage viewFreeStage = new Stage();
	BoardDTO boardDto;
	public void viewFreeFormOpen(BoardDTO dto) {
		this.boardDto = dto;
		FXMLLoader loader = new FXMLLoader(getClass().getResource("viewFreeForm.fxml"));
		try {
			viewFreeForm = loader.load();
			viewFreeFormController viewFreeFormCon = loader.getController();
			viewFreeFormCon.setBoarDto(dto);
//			viewFreeFormCon.setViewFreeForm(viewFreeForm);
			viewFreeFormCon.setViewFreeStage(viewFreeStage);

			Label writerLabel = (Label) viewFreeForm.lookup("#writerLabel");
			Label hitsLabel = (Label) viewFreeForm.lookup("#hitsLabel");
			TextField titleFld = (TextField) viewFreeForm.lookup("#titleFld");
			TextArea contentFld = (TextArea) viewFreeForm.lookup("#contentFld");
			Label writeTimeLabel = (Label) viewFreeForm.lookup("#writeTimeLabel");
			Label likesLabel = (Label) viewFreeForm.lookup("#likesLabel");

			writerLabel.setText(dto.getWriter());

			dto.setHits(dto.getHits() + 1);
			hitsLabel.setText(String.valueOf(dto.getHits()));

			titleFld.setText(dto.getTitle());
			contentFld.setText(dto.getContent());
			writeTimeLabel.setText(dto.getWriteTime());
			writerLabel.setText(dto.getWriter());
			likesLabel.setText(String.valueOf(dto.getLikes()));
			
			//내가 쓴 글이 아니면 수정/삭제 못하도록
			if (!dto.getWriter().equals(Login.getId())) {
				titleFld.setEditable(false);
				contentFld.setEditable(false);
			}
			
			Button changeBtn = (Button) viewFreeForm.lookup("#changeBtn");
			Button deleteBtn = (Button) viewFreeForm.lookup("#deleteBtn");
			if (!dto.getWriter().equals(Login.getId())) {
				changeBtn.setDisable(true);
				deleteBtn.setDisable(true);
			}
			
			//댓글수 세팅
			BoardDAO dao = new BoardDAO();
			int num = dao.replyNum(dto);
			Label replyLabel = (Label) viewFreeForm.lookup("#replyLabel");
			replyLabel.setText(String.valueOf(num));
			
			viewFreeStage.setScene(new Scene(viewFreeForm));
			viewFreeStage.setTitle("자유게시글");
			viewFreeStage.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//자유게시판 댓글 보기
	private Parent replyForm;
	private Stage replyStage = new Stage();
	public void replyFormOpen(BoardDTO dto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("replyForm.fxml"));
		try {
			replyForm = loader.load();

			replyFormController replyFormCon = loader.getController();
			replyFormCon.setBoardDto(dto);
			replyFormCon.setReplyStage(replyStage);
			
			replyStage.setScene(new Scene(replyForm));
			replyStage.setTitle("댓글 보기");
			replyStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Parent userCarrotBoardForm;
	public void userCarrotBoardFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("userCarrotBoardForm.fxml"));
		try {
			userCarrotBoardForm = loader.load();

			userCarrotBoardFormController userCarrotBoardCon = loader.getController();
			userCarrotBoardCon.setCommunityStage(communityStage);

			communityStage.setScene(new Scene(userCarrotBoardForm));
			communityStage.setTitle("중고거래");
			communityStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//마이페이지에서 지갑 눌렀을 떄
	private Stage myMoneyStage = new Stage();
	private Parent myMoneyForm;
	public void myMoneyFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("myMoneyForm.fxml"));

		try {
			myMoneyForm = loader.load();
			myMoneyFormController myMoneyFormCon = loader.getController();
			myMoneyFormCon.setMyMoneyStage(myMoneyStage);

			myMoneyStage.setScene(new Scene(myMoneyForm));
			myMoneyStage.setTitle("마이 머니");
			myMoneyStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//지갑 - 충전 눌렀을 떄
	private Parent chargeMoenyForm;
	public void chargeMoenyFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("chargeMoneyForm.fxml"));

		try {
			chargeMoenyForm = loader.load();
			chargeMoneyFormController chargeMoneyFormCon = loader.getController();
			chargeMoneyFormCon.setMymoneyStage(myMoneyStage);

			myMoneyStage.setScene(new Scene(chargeMoenyForm));
			myMoneyStage.setTitle("충전하기");
			myMoneyStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	private Stage checkPwStage = new Stage();
	private Parent checkPwForm;
	public void checkPwFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("checkPwForm.fxml"));

		try {
			checkPwForm = loader.load();
			checkPwFormController checkPwFormCon = loader.getController();
			checkPwFormCon.setcheckPwStage(checkPwStage);

			checkPwStage.setScene(new Scene(checkPwForm));
			checkPwStage.setTitle("비밀번호 확인");
			checkPwStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void changeInfoFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("changeInfoForm.fxml"));
		// 비밀번호 확인 창(기존창)에서 확인버튼 누르면 회원정보 수정창 열기
		Parent changeInfoForm;
		try {
			changeInfoForm = loader.load();
			changeInfoFormController changeInfoCon = loader.getController();
			changeInfoCon.setChangeInfoForm(changeInfoForm);
			changeInfoCon.setChangeInfoStage(checkPwStage);

			checkPwStage.setScene(new Scene(changeInfoForm));
			checkPwStage.setTitle("회원 정보 수정");
			checkPwStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Parent activityForm;
	private Stage activityStage;

	public void activityFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("activityForm.fxml"));
		activityStage = new Stage();

		try {
			activityForm = loader.load();

			activityStage.setScene(new Scene(activityForm));
			activityStage.setTitle("활동내역");
			activityStage.show();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Parent costViewForm;
	private Stage costViewStage = new Stage();

	public void costViewFormOpen() {// 월별 관리비 조회 창 뜨게 (기본)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costViewForm.fxml"));
		try {
			costViewForm = loader.load();
			costViewFormController costViewFormCon = loader.getController();
			costViewFormCon.setCostViewStage(costViewStage);
			costViewStage.setScene(new Scene(costViewForm));
			costViewStage.setTitle("월별 관리비 조회");
			costViewStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Parent costViewForm2;

	public void costViewForm2Open() {// 이번달 관리비 조회 창 뜨게 (변경)
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costViewForm2.fxml"));
		try {
			costViewForm2 = loader.load();
			costViewForm2Controller costViewForm2Con = loader.getController();
			costViewForm2Con.setCostViewStage(costViewStage);
			costViewStage.setScene(new Scene(costViewForm2));
			costViewStage.setTitle("이번달 관리비 조회");
			costViewStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Stage costPayStage = new Stage();
	private Parent costPayForm;
	public void costPayFormOpen() { //관리비 결제 화면
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costPayForm.fxml"));
		
		try {
			costPayForm = loader.load();
			costPayFormController costPayFormCon = loader.getController();
			costPayFormCon.setCostPayStage(costPayStage);
			
			costPayStage.setScene(new Scene(costPayForm));
			costPayStage.setTitle("관리비 결제");
			costPayStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Parent costCardForm;
	public void costCardFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("costCardForm.fxml"));
		costPayStage = new Stage();
		
		try {
			costCardForm = loader.load();
			costPayStage.setScene(new Scene(costCardForm));
			costPayStage.setTitle("관리비 결제 - 카드 결제");
			costPayStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void costPayStageClose() {
		CommonService.windowClose(costPayStage);
	}

	@FXML
	private Parent anounceManageForm;
	private Stage anounceManageStage;

	public void anounceManageFormOpen() { // 공지사항 관리 폼 열기
		FXMLLoader loader = new FXMLLoader(getClass().getResource("anounceManageForm.fxml"));
		anounceManageStage = new Stage();

		try {
			anounceManageForm = loader.load();
			anounceManageStage.setScene(new Scene(anounceManageForm));
			anounceManageStage.setTitle("공지사항 관리");
			anounceManageStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Parent secretManageForm;
	private Stage secretManageStage;

	public void secretManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("secretManageForm.fxml"));
		secretManageStage = new Stage();

		try {
			secretManageForm = loader.load();
			secretManageStage.setScene(new Scene(secretManageForm));
			secretManageStage.setTitle("1:1문의 관리");
			secretManageStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Parent freeManageForm;
	private Stage freeManageStage;
	public void freeManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("freeManageForm.fxml"));
		freeManageStage = new Stage();

		try {
			freeManageForm = loader.load();
			freeManageStage.setScene(new Scene(freeManageForm));
			freeManageStage.setTitle("자유게시판 관리");
			freeManageStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Parent carrotManageForm;
	private Stage carrotManageStage;

	public void carrotManageFormOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("carrotManageForm.fxml"));
		carrotManageStage = new Stage();

		try {
			carrotManageForm = loader.load();
			carrotManageStage.setScene(new Scene(carrotManageForm));
			carrotManageStage.setTitle("중고거래 관리");
			carrotManageStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}