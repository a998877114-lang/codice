import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
   Questo programma collauda la segreteria telefonica, usando
   un solo telefono che comunica con il programma attraverso
   i flussi System.in e System.out.
*/
public class MailSystemTest
{
   public static void main(String[] args) throws IOException
   {
      MailSystem system = new MailSystem(MAILBOX_COUNT);
      BufferedReader console = new BufferedReader(
         new InputStreamReader(System.in));

      Telephone p = new Telephone(console);
      Connection c = new Connection(system, p);
      p.run(c);
   }

   private static final int MAILBOX_COUNT = 20;
}
