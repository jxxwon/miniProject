package login;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class writeFreeFormService {
private BoardDAO boardDao;
	
	public writeFreeFormService() {
		boardDao = new BoardDAO();
	}
	
	public int insert(BoardDTO boardDto) {
//		int num = boardDao.selectMaxNum();
//		boardDto.setNum(num+1);
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
//		String format = sdf.format(new Date());
//		boardDto.setWriteTime(format);
		//yyyy-MM-dd HH:mm:ss
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm");  
		LocalDateTime now = LocalDateTime.now();
		boardDto.setWriteTime(dtf.format(now));
		
		return boardDao.writeFree(boardDto);
		
	}
}
