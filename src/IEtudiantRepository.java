import java.io.IOException;
import java.sql.SQLException;

public interface IEtudiantRepository {
	public void add(Etudiant E )throws SQLException, IOException;
	public boolean Exists(String email)throws SQLException, IOException;
	public boolean Exists(int mat )throws SQLException, IOException;

}
