package login;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class changeInfoFormService {
private MemberDAO memberDao;
	
	public changeInfoFormService() {
		memberDao = new MemberDAO();
	}
	
	public int change(Parent changeInfoForm) {//수정할 정보 검증
		TextField nameFld = (TextField) changeInfoForm.lookup("#nameFld");
		TextField phoneFld = (TextField) changeInfoForm.lookup("#phoneFld");
		PasswordField pwFld = (PasswordField) changeInfoForm.lookup("#pwFld");
		PasswordField confirmFld = (PasswordField) changeInfoForm.lookup("#confirmFld");
		int result = 0;

		if (nameFld.getText().length() > 1) {
			String phonePattern = "^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$";
			Pattern pattern = Pattern.compile(phonePattern);
			Matcher matcher = pattern.matcher(phoneFld.getText());
			if (matcher.matches()) {
				if (pwFld.getText().length() < 10) {
					if (pwFld.getText().equals(confirmFld.getText())) {
						result = memberDao.update(Login.getId(), nameFld.getText(), phoneFld.getText(),
								pwFld.getText());
						return result;
					} else {
						CommonService.msg("비밀번호를 확인하세요.");
					}
				} else {
					CommonService.msg("비밀번호를 10자리 이하로 입력하세요.");
				}
			} else {
				CommonService.msg("핸드폰 번호는 하이픈(-)을 사용하여 입력해주세요.(010/011/016/017/018/019 가능)");
			}
		} else {
			CommonService.msg("이름은 두 자 이상 입력하세요.");
		}
		return result;
		
	}
}
