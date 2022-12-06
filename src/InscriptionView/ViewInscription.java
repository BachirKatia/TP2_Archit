package InscriptionView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.IViewInscription;

public class ViewInscription extends JFrame implements IViewInscription{
	 private JFrame Jframe;
	    private JPanel Panel;
	    private JTextField Matricule;
	    private JTextField Nom;
	    private JTextField Prenom;
	    private JTextField Email;
	    private JPasswordField Mdp;
	    private JTextField UnivId;
	    private JButton Submit;
	    private JButton Annuler;
	public void Inscriptionform()
	{
		 this.Jframe = new JFrame();
		 this.setTitle("l'inscription"); 
		 Jframe.setBounds(400, 400, 500, 350);
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  Jframe.getContentPane().setLayout(null);
		  this.setSize(500,500); 
		  this.Panel = new JPanel();
		  Jframe.setContentPane(this.Panel);
	      Panel.setLayout(null);
		  //matricule  
	        JLabel LabelMatricule = new JLabel("Matricule");
	        LabelMatricule.setBounds(30, 30, 60, 20);
			
	        this.Panel.add(LabelMatricule);
	        
	        this.Matricule = new JTextField("");
	        Matricule.setBounds(170, 30, 250, 30);
	        Matricule.setColumns(15);
	        this.Panel.add(Matricule);
	        
	      //nom
	        JLabel LabelNom = new JLabel("Nom");
	        LabelNom.setBounds(30, 80, 50, 15);
	   
	        this.Panel.add(LabelNom);
	        
	        this.Nom = new JTextField("");
	        Nom.setBounds(170, 80, 250, 30);
	        Nom.setColumns(10);
	        this.Panel.add(Nom);
	       
	        //prenom 
	        JLabel LabelPrenom = new JLabel("Prénom");
	        LabelPrenom.setBounds(30, 100, 50, 15);
	            
	        this.Panel.add(LabelPrenom);
	        
	        this.Prenom = new JTextField("");
	        Prenom.setBounds(170, 100, 250, 30);
	        Prenom.setColumns(20);
	        this.Panel.add(Prenom);
	        
	        //email 
	        JLabel LabelEmail = new JLabel("Email");
	        LabelEmail.setBounds(30, 120, 50, 15);
	        this.Panel.add(LabelEmail);
	             
	        
	        this.Email = new JTextField("");
	        Email.setColumns(10);
	        Email.setBounds(184, 120, 250, 25);
	        this.Panel.add(Email);
	        
	        //MDP
	        JLabel LabelMdp = new JLabel("Mot de passe");
	        LabelMdp.setBounds(30, 140, 190, 15);
	        this.Panel.add(LabelMdp);
	        
	        this.Mdp = new JPasswordField("");
	        Mdp.setColumns(20);
	       
	        Mdp.setBounds(184, 140, 250, 25);
	        this.Panel.add(Mdp);
	        
	        //universite
	        JLabel LabelId_Univ = new JLabel("Identifiant université");
	        LabelId_Univ.setBounds(30, 160, 190, 15);
	        this.Panel.add(LabelId_Univ);
	        
	        this.UnivId = new JTextField("");
	        UnivId.setColumns(20);
	        UnivId.setBounds(184, 160, 250, 25);
	  
	        
	        this.Panel.add(UnivId);

	        //submit
			 this.Submit= new JButton("submit");
			 Submit.setBounds(270, 250, 140, 40);
			 this.Panel.add(Submit);
			 // annuler 
			 this.Annuler = new JButton("Annuler");
		     Annuler.setBounds(120, 250, 140, 40);
		     this.Panel.add(Annuler); 
		     
		     
		     this.Jframe.setVisible(true);
			 
		     
		     
	}
	@Override
		     public String getMatricule(){
		    	 return this.Matricule.getText();
		     }
	@Override
		     public String getNom() {
		         return this.Nom.getText();
		     }
	@Override
		     public String getPrenom() {
		         return this.Prenom.getText();
		     }
	@Override
		     public String getEmail() {
		         return this.Email.getText();
		     }
	@Override
		     public String getMdp() {
		         return Mdp.getText();
		     }
	@Override
		 	public String get_id_univ() {
				return UnivId.getText();
			}
	@Override
		   
			public void setactionListener(ActionListener actionListener) {


				Submit.addActionListener(actionListener);
				Annuler.addActionListener(actionListener);
			}
	@Override
			  public void Annuler_Inscription() {
			        this.Jframe.dispose();
			    }
	@Override
				public void delete_info() {
					 this.Matricule.setText("");
				        this.Nom.setText("");
				        this.Prenom.setText("");
				        this.Email.setText("");
				        this.Mdp.setText("");
				        this.UnivId.setText("");}
	@Override
				 public void DisplayForm() { 
				        this.Inscriptionform();
				        this.Jframe.setVisible(true);
				    }
	@Override
			  
			  public JButton Submit() {
					return Submit;
				}
	@Override

				public JButton annuler() {
					return Annuler;
				}
	@Override

				public boolean champs_validation() {
			        if (getMatricule().isEmpty() || getNom().isEmpty() || getPrenom().isEmpty() || getEmail().isEmpty() || getMdp().isEmpty() || get_id_univ().isEmpty()) {
			            this.ShowErreur("il faut remplir tous les champs !");
			            return false;
			        }
			        if (!this.Matricule.getText().matches("-?\\d+") || !this.UnivId.getText().matches("-?\\d+")) {
			            this.ShowErreur("les champs matricule et id universite doivent etre de format numeriques ");
			            return false;
			        }
			        return true;
			    }


			


			    public void ShowDialog(final String msg) {
			        JOptionPane.showMessageDialog(this, msg);
			    }

			    public void ShowErreur(final String msg) {
			        JOptionPane.showMessageDialog(this, msg, "Erreur", 0);
			    }

				

			    }
			


