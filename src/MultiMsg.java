import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class  MultiMsg  implements IJournal {

	List<IJournal> journals = new ArrayList<IJournal>();


	@Override
	public void outPut_Msg(String message) throws IOException {
	for(IJournal journal : journals) {
		journal.outPut_Msg(message);
	}

	}

	 public void ajouter(IJournal journal){
			this.journals.add(journal);
		}
}


