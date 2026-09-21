/**
   Una casella vocale contiene messaggi che possono essere elencati,
   salvati o eliminati.
*/
public class Mailbox
{
   /**
      Crea un oggetto di tipo Mailbox.
      @param aPasscode codice numerico d’accesso
      @param aGreeting stringa contenente il messaggio di saluto
   */
   public Mailbox(String aPasscode, String aGreeting)
   {
      passcode = aPasscode;
      greeting = aGreeting;
      newMessages = new MessageQueue();
      keptMessages = new MessageQueue();
   }

   /**
      Verifica la correttezza del codice d’accesso.
      @param aPasscode un codice d’accesso da verificare
      @return true se il codice ricevuto è uguale al codice d’accesso
                   della casella vocale
   */
   public boolean checkPasscode(String aPasscode)
   {
      return aPasscode.equals(passcode);
   }

   /**
      Aggiunge un messaggio alla casella vocale.
      @param aMessage il messaggio da aggiungere
   */
   public void addMessage(Message aMessage)
   {
      newMessages.add(aMessage);
   }

   /**
      Recupera il messaggio corrente.
      @return il messaggio corrente
   */
   public Message getCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.getFirst();
      else if (keptMessages.size() > 0)
         return keptMessages.getFirst();
      else
         return null;
   }

   /**
      Elimina dalla casella vocale il messaggio corrente.
      @return il messaggio appena eliminato
   */
   public Message removeCurrentMessage()
   {
      if (newMessages.size() > 0)
         return newMessages.removeFirst();
      else if (keptMessages.size() > 0)
         return keptMessages.removeFirst();
      else
         return null;
   }

   /**
      Salva il messaggio corrente
   */
   public void saveCurrentMessage()
   {
      Message m = removeCurrentMessage();
      if (m != null)
         keptMessages.add(m);
   }

   /**
      Modifica il messaggio di saluto della casella vocale.
      @param newGreeting il nuovo messaggio di saluto
   */
   public void setGreeting(String newGreeting)
   {
      greeting = newGreeting;
   }

   /**
      Modifica il codice d’accesso della casella vocale.
      @param newPasscode il nuovo codice d’accesso
   */
   public void setPasscode(String newPasscode)
   {
      passcode = newPasscode;
   }

   /**
      Recupera il messaggio di saluto della casella vocale.
      @return il messaggio di saluto
   */
   public String getGreeting()
   {
      return greeting;
   }

   private MessageQueue newMessages;
   private MessageQueue keptMessages;
   private String greeting;
   private String passcode;
}
