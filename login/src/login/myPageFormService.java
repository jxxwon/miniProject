package login;

import java.rmi.activation.ActivationGroupDesc.CommandEnvironment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class myPageFormService {
	private MemberDAO memberDao;

	public myPageFormService() {
		memberDao = new MemberDAO();
	}
	
}
