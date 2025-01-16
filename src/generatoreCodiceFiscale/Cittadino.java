package codiceFiscale;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;

public class Cittadino {
	
	//attributi
	
	protected String nome;
	protected String cognome;
	private String indirizzo;
	private String citta;
	protected String dataNascita;
	protected String sesso;
	protected String comuneNascita;
	private String telefono;
	
	//costruttori
	public Cittadino() {
		this.nome="";
		this.cognome="";
		this.indirizzo="";
		this.citta="";
		this.dataNascita="";
		this.sesso = "M";
		this.comuneNascita="";
		this.telefono="";
	}
	
	public Cittadino(String nome,String cognome,String indirizzo,String citta,String dataNascita,String sesso,String comuneNascita,String telefono){
		
		this.nome=nome;
		this.cognome=cognome;
		this.indirizzo=indirizzo;
		this.citta=citta;
		this.dataNascita=dataNascita;
		this.sesso=sesso;
		this.comuneNascita=comuneNascita;
		this.telefono=telefono;
	}
	//setter
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setSesso(String sesso) {
		this.sesso = sesso;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	//getter
	public String getCitta() {
		return citta;
	}
	public String getCognome() {
		return cognome;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public String getDataNascita() {
		return dataNascita;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public String getNome() {
		return nome;
	}
	public String getSesso() {
		return sesso;
	}
	public String getTelefono() {
		return telefono;
	}
	
	public void visualizzaDatiPersonali() {
		
		//normale output senza interfaccia grafica
		System.out.println("Nome: " +getNome());
		System.out.println("Cognome: " +getCognome());
		System.out.println("Indirizzo: " +getIndirizzo());
		System.out.println("Citta: " +getCitta());
		System.out.println("Data di Nascita: " +getDataNascita());
		System.out.println("Sesso: " +getSesso());
		System.out.println("Comune di Nascita: " +getComuneNascita());


		//output con interfaccia grafica

		//inizializzazione dei pannelli
		JPanel leftPanel;
		JPanel inPanel;
		JPanel topPanel;
		JPanel bottomPanel;

		//inizializzazione e creazione dei bordi
        Border bordo = BorderFactory.createLineBorder(new Color(50,100,50), 5);

		//inizializzo e specifico le caratteristiche dei vari fannelli
		leftPanel = new JPanel();//inizializzazione
        leftPanel.setLayout(new GridLayout(7,1,20,30));//seleziono il layout
        leftPanel.setSize(100,200); // specifico le misure
		leftPanel.setBackground(new Color(100,230,100)); // seleziono un colore di sfondo
		leftPanel.setBorder(bordo);
        inPanel = new JPanel();
        inPanel.setLayout(new GridLayout(7,1,20,30));
		inPanel.setBackground(new Color(100,200,100));
		inPanel.setBorder(bordo);
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,1,20,30));
        topPanel.setSize(new Dimension(200,200));
        topPanel.setBackground(new Color(30,90,30));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setSize(new Dimension(200,200));

		//creazione del frame 

		JFrame visualizzaJFrame = new JFrame(); //inizializzazione
            visualizzaJFrame.setLayout(new BorderLayout()); //seleziono il layout
            visualizzaJFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); //selezione l'operazione di uscita di default
            visualizzaJFrame.setSize(500, 500); //specifico le misure
            visualizzaJFrame.setVisible(true); //rendo visibile
            visualizzaJFrame.setResizable(false); //non voglio che si possa ridimensionare
            visualizzaJFrame.getContentPane().setBackground(new Color(50,100,50)); //inserisco un colore di backgroud
		
			//aggiungo i vari pannelli al frame
			visualizzaJFrame.add(leftPanel,BorderLayout.WEST);
			visualizzaJFrame.add(inPanel,BorderLayout.CENTER);
			visualizzaJFrame.add(topPanel,BorderLayout.NORTH);
			visualizzaJFrame.add(bottomPanel,BorderLayout.SOUTH);


		//aggiungo il contenuto ai pannelli
		leftPanel.add(new JLabel("nome: "));
        inPanel.add(new JLabel(nome));
        leftPanel.add(new JLabel("cognome: "));
        inPanel.add(new JLabel(cognome));
        leftPanel.add(new JLabel("indirizzo: "));
        inPanel.add(new JLabel(indirizzo));
        leftPanel.add(new JLabel("città: "));
        inPanel.add(new JLabel(citta));
        leftPanel.add(new JLabel("data di nascita : "));
        inPanel.add(new JLabel(dataNascita));
        leftPanel.add(new JLabel("sesso : "));
        inPanel.add(new JLabel(sesso));
        leftPanel.add(new JLabel("comune di nascita: "));
        inPanel.add(new JLabel(comuneNascita));
        
		
		
	}
	
	public void  visualizzaRecapiti() {
		
		System.out.println("Telefono: " +getTelefono());

		JFrame frameCodiceFiscale = new JFrame();
                frameCodiceFiscale.setLayout(new GridLayout(4,1 ));
                frameCodiceFiscale.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frameCodiceFiscale.setSize(750, 300);
                frameCodiceFiscale.setVisible(true);
                frameCodiceFiscale.setResizable(false);
                frameCodiceFiscale.getContentPane().setBackground(new Color(50,100,50));

                Label txt = new Label("il tuo recapito è :");
                txt.setFont(new Font("arial",Font.BOLD,40));
                txt.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(txt);
                Label TXT = new Label("numero di telefono: "+telefono);
                TXT.setFont(new Font("arial",Font.BOLD,30));
                TXT.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(TXT);
				Label TST = new Label("indirizzo : "+indirizzo);
                TST.setFont(new Font("arial",Font.BOLD,30));
                TST.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(TST);
				Label tst = new Label("CAP : 16100");
                tst.setFont(new Font("arial",Font.BOLD,30));
                tst.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(tst);  
		
	}
}
