package Main;
import java.io.IOException;
import java.sql.SQLException;

import Controller.ControleurInscription;
import InscriptionView.ViewInscription;
import Journal.DetailMsg;
import Journal.FileMsg;
import Journal.IJournal;
import Journal.MultiMsg;
import Journal.ScreenMsg;
import Repos.EtudiantRepository;
import Repos.UniversiteRepository;
import Services.EtudiantService;

public class MainAppMvc {


public static void main(String[] args) throws SQLException, IOException {
	
	
	EtudiantService serv=new EtudiantService();
	serv.setEtudRep(new EtudiantRepository());
	serv.setUnivRep(new UniversiteRepository());


	
	
	IJournal journal = new MultiMsg();

	IJournal journal1 = new DetailMsg();
	IJournal journal2 = new FileMsg();
	IJournal journal3= 	new ScreenMsg();
	
	((MultiMsg) journal).ajouter(journal1);
	((MultiMsg) journal).ajouter(journal2);
	((MultiMsg) journal).ajouter(journal3);
	


	serv.setJournal(journal);
//	serv.ajouterBonus();



	ViewInscription viewInscription = new ViewInscription();
	viewInscription.DisplayForm();
	ControleurInscription controleurInscription = new ControleurInscription(viewInscription);
}

}