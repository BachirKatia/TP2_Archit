package Services;
import java.io.IOException; 
import Repos.UniversiteRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Journal.IJournal;
import Journal.ScreenMsg;
import Repos.IEtudiantRepository;
import Repos.IUniversiteRepository;
public class EtudiantService {
	
	private IEtudiantRepository StudRep;
	private IUniversiteRepository UnivRep;
	private IJournal j;
	
 
	public void setEtudRep(IEtudiantRepository StudRep) {
		this.StudRep = StudRep;
	}
	public void setUnivRep(IUniversiteRepository UnivRep) {
		this.UnivRep = UnivRep;
	}
	public void setJournal(IJournal j) {
		this.j = j;
	}
	public IJournal getJournal() {
		return this.j;
	}
//	public void setStudent(Etudiant stud) {
//		this.stud = stud;
//	}
	
	public boolean inscription ( int matricule, String nom, String prenom, String email,String pwd, int id_universite) throws SQLException, IOException	
	{
		
	    Etudiant stud = new Etudiant(matricule, nom, prenom, email,pwd,id_universite);
	    Universite univ=UnivRep.GetById(id_universite ,j);
	    
	    j.outPut_Msg("Log: d�but de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
	    
		if (StudRep.VerifEmailMat(stud,j))
	    {	return false;	}
	    
		
	  
	    int nmbDeLiver = ((UniversiteRepository)UnivRep).NmbLivre(UnivRep.GetById(stud.getId_universite(),j));
		stud.setNbLivreMensuel_Autorise(nmbDeLiver);                   
	     
		 StudRep.add(stud ,j);
		 j.outPut_Msg("Log: Fin de l'op�ration d'ajout de l'�tudiant avec matricule "+matricule);
		 return true;
	    
		
	}
	public void ajouterBonus() throws SQLException, IOException {
		ArrayList<Etudiant> etudiants = StudRep.getEtudiants();

		for(Etudiant e : etudiants) {
		
			Universite univ = UnivRep.GetById(e.getId_universite(), new ScreenMsg());
			e.Bonus(univ);
		}
	}
	
	
	 

public ArrayList<Etudiant> GetEtudiantParUniversitye()
{
    //...
	return new ArrayList<>(4);
}

public ArrayList<Etudiant> GetEtudiatparLivreEmprunte()
{
    //...
	return new ArrayList<>(4);
	
}


	
}
