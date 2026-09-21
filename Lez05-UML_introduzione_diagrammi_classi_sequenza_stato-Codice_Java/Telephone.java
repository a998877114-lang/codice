import java.io.BufferedReader;
import java.io.IOException;

/**
   Un telefono che simula la ricezione della pressione di tasti su
   una tastiera telefonica e della voce umana, e produce in uscita
   la simulazione di un testo pronunciato.
*/
public class Telephone
{
   /**
      Costruisce un telefono.
      @param aReader il flusso di caratteri in ingresso da cui il
                     telefono deve acquisire dati
   */
   public Telephone(BufferedReader aReader)
   {
      reader = aReader;
   }

   /**
      Emette un messaggio su System.out.
      @param output il testo che verrà "pronunciato"
   */
   public void speak(String output)
   {
      System.out.println(output);
   }

   /**
      Legge continuamente dati introdotti in ingresso dall’utente
      e li trasferisce ai metodi dial, record o hangup dell’oggetto
      Connection.
      @param c la connessione che connette questo telefono alla
               segreteria telefonica
   */
   public void run(Connection c) throws IOException
   {
      boolean more = true;
      while (more)
      {
         String input = reader.readLine();
         if (input == null) return;
         if (input.equalsIgnoreCase("H"))
            c.hangup();
         else if (input.equalsIgnoreCase("Q"))
            more = false;
         else if (input.length() == 1 
            && "1234567890#".indexOf(input) >= 0)
            c.dial(input);
         else            
            c.record(input);
      }
   }

   private BufferedReader reader;
}
