
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EtudiantRepository implements IEtudiantRepository  {
	
	@Override
	public void add(Etudiant E , IJournal journal) throws SQLException, IOException
	{

		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "INSERT into etudiant values (" + E.getMatricule() + ",'" + E.getNom() + "','" + E.getPrenom() + "','" + E.getEmail() + "'," +E.getNbLivreMensuel_Autorise() + "," +E.getNbLivreEmprunte() + "," +E.getId_universite()+")";
		int rs = stmt.executeUpdate(sql);
		
		if (rs == 1){
				journal.outPut_Msg("log : ajout dans la BD r�ussi de l'�tudiant  du Matricule" + E.getMatricule());;
			}else if (rs == 0){
				journal.outPut_Msg("log : Echec de l'ajout dans la BD de l'�tudiant  du Matricule" + E.getMatricule());
			}
//		connect.close();
	 }

	@Override
	public boolean Exists(String email ,IJournal journal) throws SQLException, IOException	
	{
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where email='"+ email+"'";
		boolean rs = stmt.execute(sql);
		
		if (rs){
			journal.outPut_Msg("logBD--- :email existe dans la BD  " + email);
//			connect.close();
			return true;
			}
		journal.outPut_Msg("logBD--- : email n'existe pas " + email);	
//		connect.close();
		return false;
	}
	@Override
	public boolean Exists(int mat,IJournal journal) throws SQLException, IOException	
	{
		DBConnection BD= DBConnection.getInstance();
		Connection connect=BD.getConn();
		
		Statement stmt = connect.createStatement();
		String sql = "select * from etudiant where matricule="+ mat;
		boolean rs = stmt.execute(sql);
		
		if (rs){
			journal.outPut_Msg("logBD--- :etudiant avec ce matricule existe d�ja dans la BD  " + mat);
//			connect.close();
			return true;
			}
		journal.outPut_Msg("logBD----: etudiant avec ce matricule n'existe pas " + mat);	
//		connect.close();
		return false;
	}
	
//	public boolean VerifEmailMat(int Mat, String Email) throws SQLException, IOException	
//	{
//		return ( Exists(Email) || Exists(Mat) || Email == null || Email.length() == 0 );
//
//	}

}
