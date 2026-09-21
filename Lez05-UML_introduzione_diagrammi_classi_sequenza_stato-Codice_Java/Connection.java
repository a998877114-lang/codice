/**
   Connette un telefono al sistema di segreteria telefonica.
   Questa classe serve a tenere traccia dello stato di una
   connessione, poiché il telefono, per se stesso, è soltanto
   una sorgente di singole pressioni di tasti.
*/
public class Connection
{
   /**
      Costruisce un oggetto di tipo Connection.
      @param s un oggetto di tipo MailSystem
      @param p un oggetto di tipo Telephone
   */
   public Connection(MailSystem s, Telephone p)
   {
      system = s;
      phone = p;
      resetConnection();
   }

   /**
      Risponde alla pressione di un tasto sulla tastiera da parte
      dell’utente
      @param key il tasto premuto dall’utente
   */
   public void dial(String key)
   {
      if (state == CONNECTED)
         connect(key);
      else if (state == RECORDING)
         login(key);
      else if (state == CHANGE_PASSCODE)
         changePasscode(key);
      else if (state == CHANGE_GREETING)
         changeGreeting(key);
      else if (state == MAILBOX_MENU)
         mailboxMenu(key);
      else if (state == MESSAGE_MENU)
         messageMenu(key);
   }

   /**
      Registra un messaggio vocale.
      @param voice il messaggio vocale pronunciato dall’utente
   */
   public void record(String voice)
   {
      if (state == RECORDING || state == CHANGE_GREETING)
         currentRecording += voice;
   }

   /**
      L’utente riaggancia la cornetta telefonica.
   */
   public void hangup()
   {
      if (state == RECORDING)
         currentMailbox.addMessage(new Message(currentRecording));
      resetConnection();
   }

   /**
      Riporta la connessione al proprio stato iniziale e chiede
      all’utente di digitare un numero identificativo di una casella
      vocale
   */
   private void resetConnection()
   {
      currentRecording = "";
      accumulatedKeys = "";
      state = CONNECTED;
      phone.speak(INITIAL_PROMPT);
   }

   /**
      Cerca di mettere in collegamento l’utente con la casella vocale
      specificata.
      @param key il tasto premuto dall’utente
   */
   private void connect(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox = system.findMailbox(accumulatedKeys);
         if (currentMailbox != null)
         {
            state = RECORDING;
            phone.speak(currentMailbox.getGreeting());
         }
         else
            phone.speak("Incorrect mailbox number. Try again!");
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Cerca di autenticare l’utente per l’accesso.
      @param key il tasto premuto dall’utente
   */
   private void login(String key)
   {
      if (key.equals("#"))
      {
         if (currentMailbox.checkPasscode(accumulatedKeys))
         {
            state = MAILBOX_MENU;
            phone.speak(MAILBOX_MENU_TEXT);
         }
         else
            phone.speak("Incorrect passcode. Try again!");
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Modifica il codice d’accesso.
      @param key il tasto premuto dall’utente
   */
   private void changePasscode(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setPasscode(accumulatedKeys);
         state = MAILBOX_MENU;
         phone.speak(MAILBOX_MENU_TEXT);
         accumulatedKeys = "";
      }
      else
         accumulatedKeys += key;
   }

   /**
      Modifica il messaggio di saluto.
      @param key il tasto premuto dall’utente
   */
   private void changeGreeting(String key)
   {
      if (key.equals("#"))
      {
         currentMailbox.setGreeting(currentRecording);
         currentRecording = "";
         state = MAILBOX_MENU;
         phone.speak(MAILBOX_MENU_TEXT);
      }
   }

   /**
      Risponde alla scelta effettuata dall’utente nel menu
      della casella vocale.
      @param key il tasto premuto dall’utente
   */
   private void mailboxMenu(String key)
   {
      if (key.equals("1"))
      {
         state = MESSAGE_MENU;
         phone.speak(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("2"))
      {
         state = CHANGE_PASSCODE;
         phone.speak("Enter new passcode followed by the # key");
      }
      else if (key.equals("3"))
      {
         state = CHANGE_GREETING;
         phone.speak("Record your greeting, then press the # key");
      }
   }

   /**
      Risponde alla scelta effettuata dall’utente nel menu
      per i messaggi.
      @param key il tasto premuto dall’utente
   */
   private void messageMenu(String key)
   {
      if (key.equals("1"))
      {
         String output = "";
         Message m = currentMailbox.getCurrentMessage();
         if (m == null) output += "No messages." + "\n";
         else output += m.getText() + "\n";
         output += MESSAGE_MENU_TEXT;
         phone.speak(output);
      }
      else if (key.equals("2"))
      {
         currentMailbox.saveCurrentMessage();
         phone.speak(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("3"))
      {
         currentMailbox.removeCurrentMessage();
         phone.speak(MESSAGE_MENU_TEXT);
      }
      else if (key.equals("4"))
      {
         state = MAILBOX_MENU;
         phone.speak(MAILBOX_MENU_TEXT);
      }
   }

   private MailSystem system;
   private Mailbox currentMailbox;
   private String currentRecording;
   private String accumulatedKeys;
   private Telephone phone;
   private int state;

   private static final int DISCONNECTED = 0;
   private static final int CONNECTED = 1;
   private static final int RECORDING = 2;
   private static final int MAILBOX_MENU = 3;
   private static final int MESSAGE_MENU = 4;
   private static final int CHANGE_PASSCODE = 5;
   private static final int CHANGE_GREETING = 6;

   private static final String INITIAL_PROMPT = 
      "Enter mailbox number followed by #";      
   private static final String MAILBOX_MENU_TEXT = 
      "Enter 1 to listen to your messages\n"
      + "Enter 2 to change your passcode\n"
      + "Enter 3 to change your greeting";
   private static final String MESSAGE_MENU_TEXT = 
      "Enter 1 to listen to the current message\n"
      + "Enter 2 to save the current message\n"
      + "Enter 3 to delete the current message\n"
      + "Enter 4 to return to the main menu";
}
