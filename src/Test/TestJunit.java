package Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Journal.DetailMsg;
import Journal.FileMsg;
import Journal.IJournal;
import Journal.MultiMsg;
import Journal.ScreenMsg;
import Repos.EtudiantRepository;
import Repos.UniversiteRepository;
import Services.EtudiantService;

class TestJunit {

	EtudiantService serv;
	@BeforeEach
	void init() throws Exception {
		serv=new EtudiantService();
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
	}

	@Test
	void test() throws SQLException, IOException{
	
		

        
	boolean b = serv.inscription(20, "katia", "bachir", "brkatia@gmail.com","xxxxxxxx", 1);
	

		assertEquals(true,b);


	}

}