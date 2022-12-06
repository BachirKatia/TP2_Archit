package Repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DB.DBConnection;
import Journal.IJournal;
import Package.TypePackage;
import Services.Universite;

public class UniversiteRepository implements IUniversiteRepository {
 	
	@Override
	 public Universite GetById(int universityId ,IJournal j) throws SQLException, IOException {
		
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn(); 
		Statement stmt = connect.createStatement();
		j.outPut_Msg("LogBD : d�but recherche de id universit� dans la base de donn�e");
//		
		String sql = "SELECT * FROM universite WHERE i_univ="+ universityId;
		ResultSet rs = stmt.executeQuery(sql);
		rs.next(); 
		TypePackage p=TypePackage.valueOf(rs.getString(3));
		Universite u = new Universite (rs.getInt(1),rs.getString(2),p);
		
		j.outPut_Msg("LogBD : universit� r�cup�r�e");
		
//		connect.close();
		return u;	
		
		
	}
	public int NmbLivre(Universite univ){

		if (univ.getPack() == TypePackage.Standard)
		{
			 return 10;
		}
		else if (univ.getPack() == TypePackage.Premium)
		{
			return(10*2);
		}
		return 0; 
	}

	
}
