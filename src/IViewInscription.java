import java.awt.event.ActionListener;

import javax.swing.JButton;

public interface IViewInscription {

    public String getMatricule();

    public String getNom() ;
    public String getPrenom();
    public String getEmail() ;
    public String getMdp() ;
	public String get_id_univ() ;
	public void setactionListener(ActionListener actionListener) ;
	public void Annuler_Inscription() ;
	public void delete_info() ;
	  
	public void DisplayForm() ;
	  
	public JButton Submit() ;

		public JButton annuler() ;

		public boolean champs_validation() ;

	    public void ShowDialog(final String msg);

	    public void ShowErreur(final String msg);

}