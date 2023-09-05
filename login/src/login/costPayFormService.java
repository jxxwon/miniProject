package login;

import java.util.ArrayList;

public class costPayFormService {
	private costDAO costDao = new costDAO();

	public CostDTO select(String year, String month, String id) {
		String complex = id.substring(0, 3);
		String unit = id.substring(4, 7);
		return costDao.selectForUpdate(year, month, complex, unit);
	}

	public ArrayList<String> account(String id) {
		return costDao.selectAccount(id);
	}

	public void request(String year, String month, String pay) {
		costDao.updatePay(Login.getId(), year, month, pay);
	}

	public String unpaid() {
		if (costDao.unpaid(Login.getId()) != null) {
			return costDao.unpaid(Login.getId());
		} else {
			return "0";
		}
	}
	
	public void myPay(String money) { // 미납금 없을 때
		costDao.chargeUpdate(Login.getId(), money);
		costDao.myPayUpdate(Login.getId());
		CommonService.msg("결제가 완료되었습니다.");
	}
}
