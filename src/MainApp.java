
public class MainApp {

	public static void main(String[] args) {
	
		
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
		
		
		
		
		try {
			serv.inscription(13, "katia", "bachir", "ktia@gmail.com","xxxx", 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
