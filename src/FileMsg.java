import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileMsg implements IJournal {

	@Override
	public void outPut_Msg (String message) throws IOException {
		Path path =Paths.get("journal.txt");
		Files.write(path,(message +"\n").getBytes(),StandardOpenOption.CREATE,StandardOpenOption.APPEND);
	}
}
