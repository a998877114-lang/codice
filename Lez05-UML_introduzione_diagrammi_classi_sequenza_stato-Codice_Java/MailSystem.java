import java.util.ArrayList;

/**
   Un sistema per la gestione di caselle vocali
   (segreteria telefonica).
*/
public class MailSystem
{
   /**
      Costruisce una segreteria telefonica con un assegnato numero
      di caselle vocali
      @param mailboxCount il numero di caselle vocali
   */
   public MailSystem(int mailboxCount)
   {
      mailboxes = new ArrayList();

      // Inizializza le caselle vocali.

      for (int i = 0; i < mailboxCount; i++)
      {
         String passcode = "" + (i + 1);
         String greeting = "You have reached mailbox " + (i + 1)
            + ". \nPlease leave a message now.";
         mailboxes.add(new Mailbox(passcode, greeting));
      }
   }

   /**
      Trova una determinata casella vocale.
      @param ext il numero identificativo della casella
      @return la casella vocale trovata, oppure null se non esiste
   */
   public Mailbox findMailbox(String ext)
   {
      int i = Integer.parseInt(ext);
      if (1 <= i && i <= mailboxes.size())
         return (Mailbox) mailboxes.get(i - 1);
      else return null;
   }

   private ArrayList mailboxes;
}
