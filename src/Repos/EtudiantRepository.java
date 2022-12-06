package Repos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DB.DBConnection;
import Journal.IJournal;
import Services.Etudiant;

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
	@Override
	public boolean VerifEmailMat(Etudiant etud ,IJournal j) throws SQLException, IOException	
	{	String  mail = etud.getEmail();
		int mat = etud.getMatricule();
		return ( Exists(mail,j) || Exists(mat,j) || mail == null || mail.length() == 0 );

	}
	  @Override
	    public ArrayList<Etudiant> getEtudiants() throws SQLException {

	    	ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();

	    	DBConnection BD= DBConnection.getInstance();
			Connection connect= BD.getConn();

			Statement stmt = connect.createStatement();
			String sql = "SELECT * FROM Etudiant";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Etudiant e = new Etudiant(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4),null,rs.getInt(7));
				etudiants.add(e);
				
			}

             
			return etudiants;
	    }

}
