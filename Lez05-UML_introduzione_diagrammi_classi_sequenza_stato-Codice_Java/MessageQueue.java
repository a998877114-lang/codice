import java.util.ArrayList;

/**
   Un insieme di messaggi a cui si accede con modalità
   FIFO (first-in, first-out). Questa realizzazione non è
   molto efficiente; ne vedremo una migliore nel Capitolo 3.
*/
public class MessageQueue
{
   /**
      Costruisce una coda di messaggi vuota.
   */
   public MessageQueue()
   {
      queue = new ArrayList();
   }

   /**
      Elimina il messaggio che si trova all’inizio della coda.
      @return il messaggio che è stato eliminato dalla coda
   */
   public Message removeFirst()
   {
      return (Message) queue.remove(0);
   }

   /**
      Aggiunge un messaggio in fondo alla coda.
      @param newMessage il messaggio da aggiungere
   */
   public void add(Message newMessage)
   {
      queue.add(newMessage);
   }

   /**
      Recupera il numero totale di messaggi presenti nella coda.
      @return il numero totale di messaggi presenti nella coda
   */
   public int size()
   {
      return queue.size();
   }

   /**
      Recupera il messaggio che si trova all’inizio della coda.
      @return il messaggio che si trova all’inizio della coda
   */
   public Message getFirst()
   {
      return (Message) queue.get(0);
   }

   private ArrayList queue;
}
