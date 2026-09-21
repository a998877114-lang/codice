/**
   Un messaggio lasciato da utente che ha chiamato.
*/
public class Message
{
   /**
      Costruisce un oggetto Message.
      @param messageText il testo del messaggio
   */
   public Message(String messageText)
   {
      text = messageText;
   }

   /**
      Recupera il testo del messaggio.
      @return il testo del messaggio
   */
   public String getText()
   {
      return text;
   }

   private String text;
}
