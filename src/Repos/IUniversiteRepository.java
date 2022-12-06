package Repos;
import java.io.IOException;
import java.sql.SQLException;

import Journal.IJournal;
import Services.Universite;

public interface IUniversiteRepository {
	public Universite GetById(int universityId,IJournal j) throws SQLException, IOException;

	
}
