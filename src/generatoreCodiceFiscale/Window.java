package codiceFiscale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window extends JFrame implements ActionListener {

    GraphicsDevice graphicsDevice = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

    JButton visualizzaButton;
    JButton dimenticatoCodiceFiscaleButton;
    JButton getCodiceFiscaleButton;
    JButton recapiti;

    JTextField nameTextField;
    JTextField surnameTextField;
    JTextField addresTextField;
    JTextField cittaTextField;
    JTextField comuneTextField;
    JTextField dataNascitaTextField;
    JTextField sexTextField;
    JTextField numeroTelefonoTextField;
    JTextField codiceFiscaleTextField;

    JTextField nameTextField2;
    JTextField sexTextField2;
    JTextField surnameTextField2;
    JTextField comuneTextField2;
    JTextField dataNascitaTextField2;

    JPanel leftPanel;
    JPanel inPanel;
    JPanel topPanel;
    JPanel bottomPanel;

    public Window(){

        //specifico le caratteristiche della finestra
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1080, 720);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(50,100,50));
        
        //inizializzo e specifico le caratteristiche dei pannelli
        leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(9,1,2,2));
        leftPanel.setSize(300,200);
        inPanel = new JPanel();
        inPanel.setLayout(new GridLayout(9,1,2,2));
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setSize(new Dimension(200,200));
        topPanel.setBackground(new Color(50,150,200));
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.setSize(new Dimension(200,200));

        //inizializzo e specifico le caratteristiche delle aree di testo
        nameTextField = new JTextField();
        surnameTextField = new JTextField();
        addresTextField = new JTextField();
        cittaTextField = new JTextField();
        comuneTextField = new JTextField();
        dataNascitaTextField = new JTextField("gg/mm/aa ");
        sexTextField = new JTextField("F/M");
        numeroTelefonoTextField = new JTextField();
        codiceFiscaleTextField = new JTextField();

        nameTextField.setPreferredSize(new Dimension(750, 30));
        surnameTextField.setPreferredSize(new Dimension(750, 30));
        addresTextField.setPreferredSize(new Dimension(750, 30));
        cittaTextField.setPreferredSize(new Dimension(750, 30));
        comuneTextField.setPreferredSize(new Dimension(750, 30));
        dataNascitaTextField.setPreferredSize(new Dimension(750, 30));
        sexTextField.setPreferredSize(new Dimension(750, 30));
        numeroTelefonoTextField.setPreferredSize(new Dimension(750, 30));
        codiceFiscaleTextField.setPreferredSize(new Dimension(750, 30));


        //aggiungo alla finestra tutti gli elementi 
        this.add(leftPanel,BorderLayout.WEST);
        this.add(inPanel,BorderLayout.CENTER);
        this.add(topPanel,BorderLayout.NORTH);
        this.add(bottomPanel,BorderLayout.SOUTH);
        leftPanel.add(new JLabel("cognome: "));
        inPanel.add(surnameTextField);
        leftPanel.add(new JLabel("nome: "));
        inPanel.add(nameTextField);
        leftPanel.add(new JLabel("indirizzo: "));
        inPanel.add(addresTextField);
        leftPanel.add(new JLabel("citta: "));
        inPanel.add(cittaTextField);
        leftPanel.add(new JLabel("comune: "));
        inPanel.add(comuneTextField);
        leftPanel.add(new JLabel("data di nascita : "));
        inPanel.add(dataNascitaTextField);
        leftPanel.add(new JLabel("sesso : "));
        inPanel.add(sexTextField);
        leftPanel.add(new JLabel("numero di telefono: "));
        inPanel.add(numeroTelefonoTextField);
        leftPanel.add(new JLabel("codice fiscale: "));
        inPanel.add(codiceFiscaleTextField);

        //inizializzo e specifico le caratteristiche dei bottoni
        visualizzaButton = new JButton("Visualizza dati personali");
        visualizzaButton.setPreferredSize(new Dimension(300,30));
        visualizzaButton.addActionListener(this);
        visualizzaButton.setSize(new Dimension(200,150));
        getCodiceFiscaleButton = new JButton("ottieni il codice fiscale");
        getCodiceFiscaleButton.setPreferredSize(new Dimension(300,30));
        getCodiceFiscaleButton.addActionListener(this);
        getCodiceFiscaleButton.setSize(new Dimension(200,150));
        dimenticatoCodiceFiscaleButton = new JButton("dimenticato il codice fiscale?");
        dimenticatoCodiceFiscaleButton.setPreferredSize(new Dimension(300,30));
        dimenticatoCodiceFiscaleButton.addActionListener(this);
        dimenticatoCodiceFiscaleButton.setSize(new Dimension(200,150));
        recapiti = new JButton("visualizza recapiti");
        recapiti.setPreferredSize(new Dimension(300,30));
        recapiti.addActionListener(this);
        recapiti.setSize(new Dimension(200,150));
        //aggiungo i bottoni alla finestra
        bottomPanel.add(dimenticatoCodiceFiscaleButton);
        bottomPanel.add(visualizzaButton);
        bottomPanel.add(recapiti);
        //inizializzo e specifico le caratteristiche di un label per il titolo della pagina
        Label titolo = new Label("PROGETTO CODICE FISCALE");
        titolo.setFont(new Font("Montserrat",Font.BOLD,50));
        titolo.setForeground(new Color(10,10,10));
        // aggiunco il label alla finestra
        topPanel.add(titolo); 

        this.setVisible(true);  //rendo visibile la finestra
    }
    //cosa succede se viene premuto un bottone
    @Override
    public void actionPerformed(ActionEvent e) {
        //si controlla quale bottone e stato premuto 
        if(e.getSource()==visualizzaButton){//si eseguono le istruzioni di conseguenza
            //creo un oggetto cittadino e lo costruisco attraverso il contenuto delle aree di testo
            Cittadino cittadino = new Cittadino(nameTextField.getText(), surnameTextField.getText(), addresTextField.getText(), cittaTextField.getText(), dataNascitaTextField.getText(), sexTextField.getText(),comuneTextField.getText(), numeroTelefonoTextField.getText());
            cittadino.visualizzaDatiPersonali();
        }
        if(e.getSource()==recapiti){
            Cittadino cittadino = new Cittadino(nameTextField.getText(), surnameTextField.getText(), addresTextField.getText(), cittaTextField.getText(), dataNascitaTextField.getText(), sexTextField.getText(),comuneTextField.getText(), numeroTelefonoTextField.getText());
            cittadino.visualizzaRecapiti();
        }
        if(e.getSource()==dimenticatoCodiceFiscaleButton){

            JFrame frameCodiceFiscale = new JFrame();

            JPanel leftPanel2;
            JPanel inPanel2;
            JPanel topPanel2;
            JPanel bottomPanel2;

            

            frameCodiceFiscale.setLayout(new BorderLayout());
            frameCodiceFiscale.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            frameCodiceFiscale.setSize(500, 500);
            frameCodiceFiscale.setVisible(true);
            frameCodiceFiscale.setResizable(false);
            frameCodiceFiscale.getContentPane().setBackground(new Color(50,100,50));
            
            leftPanel2 = new JPanel();
            leftPanel2.setLayout(new GridLayout(5,1,2,2));
            leftPanel2.setSize(300,200);
            inPanel2 = new JPanel();
            inPanel2.setLayout(new GridLayout(5,1,2,2));
            topPanel2 = new JPanel();
            topPanel2.setLayout(new GridLayout(1,1,2,2));
            topPanel2.setSize(new Dimension(200,200));
            topPanel2.setBackground(new Color(30,90,30));
            bottomPanel2 = new JPanel();
            bottomPanel2.setLayout(new FlowLayout());
            bottomPanel2.setSize(new Dimension(200,200));
    
    
            nameTextField2 = new JTextField(nameTextField.getText());
            surnameTextField2= new JTextField(surnameTextField.getText());
            comuneTextField2 = new JTextField(comuneTextField.getText());
            dataNascitaTextField2 = new JTextField(dataNascitaTextField.getText());
            sexTextField2 = new JTextField(sexTextField.getText());
    
            nameTextField2.setPreferredSize(new Dimension(750, 30));
            surnameTextField2.setPreferredSize(new Dimension(750, 30));
            comuneTextField2.setPreferredSize(new Dimension(750, 30));
            dataNascitaTextField2.setPreferredSize(new Dimension(750, 30));
            sexTextField2.setPreferredSize(new Dimension(750, 30));

            frameCodiceFiscale.add(leftPanel2,BorderLayout.WEST);
            frameCodiceFiscale.add(inPanel2,BorderLayout.CENTER);
            frameCodiceFiscale.add(topPanel2,BorderLayout.NORTH);
            frameCodiceFiscale.add(bottomPanel2,BorderLayout.SOUTH);
            leftPanel2.add(new JLabel("cognome: "));
            inPanel2.add(surnameTextField2);
            leftPanel2.add(new JLabel("nome: "));
            inPanel2.add(nameTextField2);
            leftPanel2.add(new JLabel("comune: "));
            inPanel2.add(comuneTextField2);
            leftPanel2.add(new JLabel("data di nascita : "));
            inPanel2.add(dataNascitaTextField2);
            leftPanel2.add(new JLabel("sesso : "));
            inPanel2.add(sexTextField2);
            bottomPanel2.add(getCodiceFiscaleButton);
        }
        if(e.getSource()==getCodiceFiscaleButton){

            String data = dataNascitaTextField2.getText();
            boolean openWindow = true; //creo un booleano dove dico se si puo apri9re la finestra 

            //controllo degli errori sulla data di nascita
            for(int i = 0; i<8; i++){
                if((i+1)%3!=0){
                    char charat = data.charAt(i);
                    if(charat != '1' && charat != '2' && charat != '3' && charat != '4' && charat != '5' &&
                    charat != '6' && charat != '7' && charat != '8' && charat != '9' && charat != '0'){
                        openWindow= false; // salvo in un booleano il fatto che c'è un arrore e che il calcolo del codice fiscale è impossibile

                        //apro una pagina di errore
                        JFrame errore = new JFrame();
                        errore.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                        errore.setLayout(new FlowLayout());
                        errore.setVisible(true);
                        errore.setSize(graphicsDevice.getDisplayMode().getWidth(), graphicsDevice.getDisplayMode().getHeight());
                        
                        errore.getContentPane().setBackground(new Color(200,100,100));
                        Label txt = new Label("ERRORE, LA DATA DI NASCITA è SCRITTA INCORRETTAMENTE,");
                        Label tst = new Label(" PREGO DI RISCRIVERE IN GG/MM/AA ES.15/08/05  , GRAZIE.");
                        txt.setFont(new Font("arial",Font.PLAIN,40));
                        tst.setFont(new Font("arial",Font.PLAIN,40));
                        txt.setForeground(new Color(100,10,20));
                        tst.setForeground(new Color(100,10,20));
                        errore.add(txt);
                        errore.add(tst);

                        break;

                    }
                }

            }
            //controllo degli errori sul campo del comune di nascita
            if (comuneTextField2.getText().equals("Genova")==false){

                openWindow= false; 

                //apro una pagina di errore
                JFrame errore = new JFrame();
                errore.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                errore.setLayout(new FlowLayout());
                errore.setVisible(true);
                errore.setSize(graphicsDevice.getDisplayMode().getWidth(), graphicsDevice.getDisplayMode().getHeight());
                
                errore.getContentPane().setBackground(new Color(200,100,100));
                Label txt = new Label("ERRORE, IL COMUNE SELEZIONATO NON è PRESENTE NEL DATABASE,");
                Label tst = new Label(" PER ORA è PRESENTE SOLO IL COMUNE DI Genova ");
                Label trt = new Label(" QUEST'ULTIMO DEVE ESSERE SCRITTO CON LA MAIUSCOLA , GRAZIE.");
                txt.setFont(new Font("arial",Font.PLAIN,40));
                tst.setFont(new Font("arial",Font.PLAIN,40));
                trt.setFont(new Font("arial",Font.PLAIN,40));
                txt.setForeground(new Color(100,10,20));
                tst.setForeground(new Color(100,10,20));
                trt.setForeground(new Color(100,10,20));
                errore.add(txt);
                errore.add(tst);
                errore.add(trt);
            }

            // controllo errori nel campo sesso

            if(!sexTextField2.getText().equals("M")&&sexTextField2.getText().equals("F")== false){

                openWindow= false; 

                //apro una pagina di errore
                JFrame errore = new JFrame();
                errore.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                errore.setLayout(new FlowLayout());
                errore.setVisible(true);
                errore.setSize(graphicsDevice.getDisplayMode().getWidth(), graphicsDevice.getDisplayMode().getHeight());
                
                errore.getContentPane().setBackground(new Color(200,100,100));
                Label txt = new Label("ERRORE, IL SESSO PUò ESSERE SOLO \"F\" o \"M\",");
                Label tst = new Label(" PERFAVORE INSERIRE SOLO UNA DI QUESTA OPZIONI, GRAZIE ");
                txt.setFont(new Font("arial",Font.PLAIN,40));
                tst.setFont(new Font("arial",Font.PLAIN,40));
                txt.setForeground(new Color(100,10,20));
                tst.setForeground(new Color(100,10,20));
                errore.add(txt);
                errore.add(tst);
            }

            if(openWindow==true){ //se non ci sono stati errori si potrà calcolare il codice fiscale e mostrarlo in una finestra

                //costrusco un oggetto contribuente utilizzando i campi di testo
               Contribuente contribuente = new Contribuente(nameTextField2.getText(),surnameTextField2.getText(),"","",dataNascitaTextField2.getText(),sexTextField2.getText(),comuneTextField2.getText(),"","");
               //calcolo il codice fiscale
               contribuente.calcolaCodiceFiscale();

                //creo una finestra per visualizzare il codice fiscale
                JFrame frameCodiceFiscale = new JFrame();
                frameCodiceFiscale.setLayout(new FlowLayout());
                frameCodiceFiscale.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frameCodiceFiscale.setSize(500, 150);
                frameCodiceFiscale.setVisible(true);
                frameCodiceFiscale.setResizable(false);
                frameCodiceFiscale.getContentPane().setBackground(new Color(50,100,50));

                Label txt = new Label("il tuo codice fiscale è :");
                txt.setFont(new Font("arial",Font.PLAIN,30));
                txt.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(txt);
                Label TXT = new Label(contribuente.getCodiceFiscale());
                TXT.setFont(new Font("arial",Font.BOLD,30));
                TXT.setForeground(new Color(10,10,10));
                frameCodiceFiscale.add(TXT); 
            }
            
        }
    }
}