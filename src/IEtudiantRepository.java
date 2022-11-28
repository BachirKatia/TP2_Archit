import java.io.IOException;
import java.sql.SQLException;

public interface IEtudiantRepository {
	public void add(Etudiant E , IJournal journal)throws SQLException, IOException;
	public boolean Exists(String email, IJournal journal)throws SQLException, IOException;
	public boolean Exists(int mat, IJournal journal )throws SQLException, IOException;

}
