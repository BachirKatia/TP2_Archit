import java.io.IOException;
import java.sql.SQLException;

public interface IUniversiteRepository {
	public Universite GetById(int universityId,IJournal j) throws SQLException, IOException;

	
}
