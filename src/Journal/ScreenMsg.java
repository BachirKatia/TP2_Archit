package Journal;

public class ScreenMsg implements IJournal{

	@Override
	public void outPut_Msg (String message) {
		System.out.println(message);
	}
}
