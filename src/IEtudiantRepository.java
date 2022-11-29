import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IEtudiantRepository {
	public void add(Etudiant E , IJournal journal)throws SQLException, IOException;
	public boolean Exists(String email, IJournal journal)throws SQLException, IOException;
	public boolean Exists(int mat, IJournal journal )throws SQLException, IOException;
	public boolean VerifEmailMat(Etudiant stud, IJournal j) throws SQLException, IOException;
	public ArrayList<Etudiant> getEtudiants() throws SQLException;

}
