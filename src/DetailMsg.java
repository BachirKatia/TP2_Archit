import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
public class DetailMsg implements IJournal {
	


		@Override
		public void outPut_Msg (String message) {
			String simpleClassName = Thread.currentThread().getStackTrace()[2].getClassName();
		   
			Calendar calendar = Calendar.getInstance();
			
			DateFormat date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			System.out.println(message+" genere par la classe : "+simpleClassName+" - "+date.format(calendar.getTime()));



			}
	}

