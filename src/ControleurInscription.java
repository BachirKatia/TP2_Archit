
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
public class ControleurInscription implements ActionListener {
	private IViewInscription vi;
	private EtudiantService Service;
	public ControleurInscription( IViewInscription viewInscription ) {

		this.vi = viewInscription;
		vi.setactionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == vi.Submit()) 
		{

				if(vi.champs_validation()) {
					try {
							if(Service.inscription(Integer.valueOf(vi.getMatricule()), vi.getNom(), vi.getPrenom(), vi.getEmail(),vi.getMdp(), Integer.valueOf(vi.get_id_univ()))) {
								vi.ShowDialog("Inscription réussie !");
								vi.delete_info();
			
							}else {
								vi.ShowErreur("Inscription non réussie !");
			
							}
					} catch (SQLException | IOException e1) {
		
								e1.printStackTrace();
					}
	
				}


	}else if(e.getSource() == vi.annuler()) {

		vi.delete_info();
	

}
		}
	}