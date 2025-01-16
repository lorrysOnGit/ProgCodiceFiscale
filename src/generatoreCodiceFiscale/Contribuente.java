package codiceFiscale;

import java.util.LinkedList;

public class Contribuente extends Cittadino {
	//attributi
	private String codiceFiscale;
	private String campoCognome;
	private String campoNome ;
    private String campoGiorno ;
    private String campoMese;
    private String campoAnno;
    private String campoComune;
	private String carattereControllo;
	
	//costruttori
	public Contribuente(String nome,String cognome,String indirizzo,String citta,String dataNascita,String sesso,String comuneNascita,String telefono,String codiceFiscale) {
		super( nome,cognome,indirizzo, citta, dataNascita,sesso, comuneNascita, telefono);
		this.codiceFiscale=codiceFiscale;
	}
	//getter
@Override
public String getCitta() {
	return super.getCitta();
}

public String getCodiceFiscale() {
	return codiceFiscale;
	}

@Override
public String getCognome() {
	
	return super.getCognome();
}

public  String calcolaCodiceFiscale() {
    


	// Creazione di un oggetto Runnable per ciascuna funzione
    Runnable calcolaCampoCognomeRunnable = () -> { // questo è l'equivalente di creare un altra classe runnable 
    	campoCognome = calcolaCampoCognome();	//e mettere la funzione che si vuole fare nel run()
    };
    Runnable calcolaCampoNomeRunnable = () -> {
		campoNome = calcolaCampoNome();
    };
    Runnable calcolaCampoGiornoRunnable = () -> {
		campoGiorno = calcolaCampoGiorno();
    };
    Runnable calcolaCampoMeseRunnable = () -> {
		campoMese = calcolaCampoMese();
    };
    Runnable calcolaCampoAnnoRunnable = () -> {
		campoAnno = calcolaCampoAnno();
    };
    Runnable calcolaCampoComuneRunnable = () -> {
        campoComune = calcolaCampoComune();
    };
    

    // Creazione dei thread per ciascuna funzione (inizializzazione dei thread)
    Thread threadCognome = new Thread(calcolaCampoCognomeRunnable);
    Thread threadNome = new Thread(calcolaCampoNomeRunnable);
    Thread threadGiorno = new Thread(calcolaCampoGiornoRunnable);
    Thread threadMese = new Thread(calcolaCampoMeseRunnable);
    Thread threadAnno = new Thread(calcolaCampoAnnoRunnable);
    Thread threadComune = new Thread(calcolaCampoComuneRunnable);
    

    // Avvio dei thread
    threadCognome.start();
    threadNome.start();
    threadGiorno.start();
    threadMese.start();
    threadAnno.start();
    threadComune.start();
    

    // Attendere che tutti i thread completino l'esecuzione
    try {
        threadCognome.join(); // il .join() seve ad aspettare che il thread finisca prima di continuare con le altre operazioni
        threadNome.join();
        threadGiorno.join();
        threadMese.join();
        threadAnno.join();
        threadComune.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
	//calcolo quindi il carattere di controllo grazie a questo codice fiscale parziale
carattereControllo= calcolaCarattereControllo(campoCognome + campoNome + campoAnno + campoMese + campoGiorno + campoComune);
    // Concatena i campi per formare il codice fiscale completo
	
	codiceFiscale = campoCognome + campoNome + campoAnno + campoMese + campoGiorno + campoComune + carattereControllo;
	return codiceFiscale;
}


private  String calcolaCampoNome() {
	LinkedList <Character> campoNome = new LinkedList<Character>();
	int index = 0; //indica le lettere all'interno della lista

	//conta e inserisce le consonanti nella lista
	for (int i = 0; i < nome.length()&& index<4; i++) {
        char carattere = nome.charAt(i);
        if (!isVocale(carattere)) {
			index++;
			campoNome.add(carattere);
			
		}
    }
	//se ci sono piu di 3 consonanti rimuovo la seconda consonante dalla lista e ritorno la lista come stringa
	if (index > 3){

		campoNome.remove(1);

		StringBuilder stringBuilder = new StringBuilder();
        for (char carat : campoNome) {
            stringBuilder.append(carat);
        }
        
    	return stringBuilder.toString().toUpperCase();

	}
	//se ci sono esattamente 3 consonanti ritono quest'ultime 
	if (index == 3){
		StringBuilder stringBuilder = new StringBuilder();
        for (char carat : campoNome) {
            stringBuilder.append(carat);
        }
        
    	return stringBuilder.toString().toUpperCase();
	}
 //se non ci sono abbastanza alementi nella lista, scala le consonanti e prende la lettera successiva all'ultima
	for (int i = 0; i < nome.length() && index < 3; i++) {
		char carattere = nome.charAt(i);
		if (isVocale(carattere)) {
			index++;
			carattere = nome.charAt(i);
			campoNome.add(carattere);	
		}
	}
	
	//le non ci sono ancora abbastanza elementi nella lista, aggiunge alla lista una x per riempire
	while(index<3){
		index++;
		campoNome.add('X');
	}
	
	StringBuilder stringBuilder = new StringBuilder();
        for (char carat : campoNome) {
            stringBuilder.append(carat);
        }
        
    return stringBuilder.toString().toUpperCase();
}       
private  String calcolaCampoCognome() {
    char[] campoCognome = new char[3]; //array dove inseriamo i caratteri da poi ritornare

    int index = 0; //segna quanti caratteri sono all'interno del array

    // Rimuovi le vocali dal cognome e aggiungi le prime tre consonanti all'array
    for (int i = 0; i < cognome.length() && index < 3; i++) {
        char carattere = cognome.charAt(i);
        if (!isVocale(carattere)) {
            campoCognome[index++] = carattere;
        }
    }

    // Se il numero di consonanti è inferiore a 3, aggiungi le vocali nell'ordine in cui compaiono
    for (int i = 0; i < cognome.length() && index < 3; i++) {
        char carattere = cognome.charAt(i);
        if (isVocale(carattere)) {
            campoCognome[index++] = carattere;
        }
    }

    // Se il numero di caratteri è ancora inferiore a 3, aggiungi 'X'
    while (index < 3) {
        campoCognome[index++] = 'X';
    }

    return new String(campoCognome).toUpperCase();
}

// Metodo ausiliario per controllare se un carattere è una vocale
private static boolean isVocale(char carattere) {
    return carattere == 'a' || carattere == 'e' || carattere == 'i' || carattere == 'o' || carattere == 'u' ||
           carattere == 'A' || carattere == 'E' || carattere == 'I' || carattere == 'O' || carattere =='U';
}
private String calcolaCampoAnno() {
    //creo un arrai di char per contenere due caratteri
    char[] dueCifreAnno = new char [2]; 
	//dalla stringa della data di nascita prendo i due caratteri che mi servono e li metto nell'array
    dataNascita.getChars(6, 8, dueCifreAnno, 0); //i campi del getChars() sono :(indice del carattere da cui iniziare a prendere(compreso)
	//, indice dell'ultimo carattere (non compreso), luogo dove voglio inserire i caratteri, indice da cui incominciare a inserire i caratteri).
    return new String(dueCifreAnno); //ritorno l'array come una stringa
}
private String calcolaCampoMese() {
	//creo un arrai di char per contenere due caratteri
	char [] dueCifreMese = new char[2];
	//dalla stringa della data di nascita prendo i due caratteri che mi servono e li metto nell'array
	dataNascita.getChars(3, 5, dueCifreMese, 0);
	//rendo stringa l'array
	String cifreMese = new String(dueCifreMese);
	// rendo intero la stringa
	int mese = Integer.parseInt(cifreMese);
    // Array dei caratteri corrispondenti ai mesi
    char[] caratteriMese = {'A', 'B', 'C', 'D', 'E', 'H', 'L', 'M', 'P', 'R', 'S', 'T'};
    
    // Seleziona il carattere corrispondente al mese di nascita
    char carattereMese = caratteriMese[mese - 1]; // Sottrai 1 poiché gli array sono basati sull'indice 0
    
    return String.valueOf(carattereMese);// ritorna il carattere come stringa
}
private String calcolaCampoGiorno() {
	//creo un arrai di char per contenere due caratteri
	char [] dueCifreGiorno= new char[2];
	//dalla stringa della data di nascita prendo i due caratteri che mi servono e li metto nell'array
	dataNascita.getChars(0, 2, dueCifreGiorno, 0);
	//rendo stringa l'array
	String cifreGiorno = new String(dueCifreGiorno);
	// rendo intero la stringa
	int giorno = Integer.parseInt(cifreGiorno);
    // Seleziona il giorno di nascita e aggiungi 40 se il sesso è femminile
    if (sesso.equals("F")) {
        giorno += 40;
    }
    
    // Formatta il giorno con due cifre
    String campoGiorno = String.format("%02d", giorno);
    
    return campoGiorno;
}
private String calcolaCampoComune() {
	if(comuneNascita.equals("Genova")) {
		return "D969";
	}
	return "";
}
private  String calcolaCarattereControllo(String parziale) {

	int somma=0;
	String carattereControllo = ""; 

	//inizia da 1 per tale motivo : il primo ciclo (ciclo1) avrebbe un indice di uno invece che di zero, un indice zero viene contato pari nella funzione di controllo
	for(int i=1;i<16;i++) {//ci sono 15 caratteri: 1+15 = 16
		if(i%2==0) {//controllo della parità del turno
		switch(parziale.charAt(i-1)){// avendo iniziato da 1, per prendere anche il carattere a posizione 0, devo togliere 1 all'indice
		
			case 'A':
			case '0':	
				somma+=0;
				break;
				
			case 'B':
			case '1':
				somma+=1;
				break;

			case ('C'):
			case '2':
				somma+=2;
				break;

			case ('D'):
			case '3':
				somma+=3;
				break;

			case ('E'):
			case '4':
				somma+=4;
				break;

			case ('F'):
			case '5':
				somma+=5;
				break;

			case ('G'):
			case '6':
				
				somma+=6;
				break;

			case ('H'):
			case '7':
				somma+=7;
				break;

			case ('I'):
			case '8':
				somma+=8;
				break;

			case ('J'):
			case '9':
				somma+=9;
				break;

			case ('k'):
				somma+=10;
				break;

			case ('L'):
				somma+=11;
				break;

			case ('M'):
				somma+=12;
				break;

			case ('N'):
				somma+=13;
				break;

			case ('O'):
				somma+=14;
				break;

			case ('P'):
				somma+=15;
				break;

			case ('Q'):
				somma+=16;
				break;

			case ('R'):
				somma+=17;
				break;

			case ('S'):
				somma+=18;
				break;

			case ('T'):
				somma+=19;
				break;

			case ('U'):
				somma+=20;
				break;

			case ('V'):
				somma+=21;
				break;

			case ('W'):
				somma+=22;
				break;

			case ('X'):
				somma+=23;
				break;

			case ('Y'):
				somma+=24;
				break;

			case ('Z'):
				somma+=25;
				break;
			default:
			    somma+=0;
				break;
		}
		}else{
			switch(parziale.charAt(i-1)){
		
			case ('A'):
			case '0':
				
				somma=somma+1;
				break;
				
			case ('B'):
			case '1':
				
				somma=somma+0;
				break;
			case ('C'):
			case '2':
				
				somma=somma+5;
				break;
			case ('D'):
			case '3':
		
				somma=somma+7;
				break;
			case ('E'):
			case '4':
		
				somma=somma+9;
				break;
			case ('F'):
			case '5':
				somma=somma+13;
				break;
			case ('G'):
			case '6':	
				somma=somma+15;
				break;
			case ('H'):
			case '7':	
				somma=somma+17;
				break;
			case ('I'):
			case '8':
				
				somma=somma+19;
				break;
			case ('J'):
			case '9':
				
				somma=somma+21;
				break;
			case ('k'):
				
				somma=somma+2;
				break;
			case ('L'):
				
				somma=somma+4;
				break;
			case ('M'):
				
				somma=somma+18;
				break;
			case ('N'):
				
				somma=somma+20;
				break;
			case ('O'):
				
				somma=somma+11;
				break;
			case ('P'):
				
				somma=somma+3;
				break;
			case ('Q'):
				
				somma=somma+6;
				break;
			case ('R'):
			
				somma=somma+8;
				break;
			case ('S'):
				
				somma=somma+12;
				break;
			case ('T'):
				
				somma=somma+14;
				break;
			case ('U'):
				
				somma=somma+16;
				break;
			case ('V'):
				
				somma=somma+10;
				break;
			case ('W'):
				
				somma=somma+22;
				break;
			case ('X'):
				
				somma=somma+25;
				break;
			case ('Y'):
				
				somma=somma+24;
				break;
			case ('Z'):
				
				somma=somma+23;
				break;
			default:
			    somma+=0;
				break;
			}
  		}
	}
	switch(somma%26){ // calcolo per trovare il resto
	
		case 0:

		carattereControllo = "A";
			break;
			
		case 1:
			
		carattereControllo = "B";
			break;
		case 2:
			
		carattereControllo = "C";
			break;
		case 3:
	
		carattereControllo = "D";
			break;
		case 4:
	
		carattereControllo = "E";
			break;
		case 5:
	
		carattereControllo = "F";
			break;
		case 6:
			
		carattereControllo = "G";
			break;
		case 7:
			
		carattereControllo = "H";
			break;
		case 8:
			
		carattereControllo = "I";
		break;
		case 9:
			
		carattereControllo = "J";
			break;
		case 10:
			
		carattereControllo = "K";
			break;
		case 11:
			
		carattereControllo = "L";
			break;
		case 12:
			
		carattereControllo = "M";
			break;
		case 13:
			
		carattereControllo = "N";
			break;
		case 14:
			
		carattereControllo = "O";
			break;
		case 15:
			
		carattereControllo = "P";
			break;
		case 16:
			
		carattereControllo = "Q";
			break;
		case 17:
			
		carattereControllo = "R";
			break;
		case 18:
			
		carattereControllo = "S";
			break;
		case 19:
			
		carattereControllo = "T";
			break;
		case 20:
			
		carattereControllo = "U";
			break;
		case 21:
			
		carattereControllo = "V";
			break;
		case 22:
			
		carattereControllo = "W";
			break;
		case 23:
			
		carattereControllo = "X";
			break;
		case 24:
			
		carattereControllo = "Y";
			break;
		case 25:

		carattereControllo = "Z";
		break;
   }
	return carattereControllo;
		
}
public boolean checkCodicefiscale(){
	if(codiceFiscale.equals(calcolaCodiceFiscale())){
		return true;
	}
	return false;
}

}

