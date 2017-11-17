/**
 * A class to model a simple email client. The client is run by a
 * particular user, and sends and retrieves mail via a particular server.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MailClient
{
    // The server used for sending and receiving.
    private MailServer server;
    // The user running this client.
    private String user;
    //almacena re + el asunto
    private String asunto;
     // dar las gracias por su mensaje.
    private String mensaje;




    /**
     * Create a mail client run by user and attached to the given server.
     */
    public MailClient(MailServer server, String user)
    {
        this.server = server;
        this.user = user;
    }

    /**
     * Return the next mail item (if any) for this user.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }

    /**
     * Print the next mail item (if any) for this user to the text 
     * terminal.
     */
    public void printNextMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        if(item == null) {
            System.out.println("No new mail.");
        }
        else {
            item.print();
        }
    }

    /**
     * Send the given message to the given recipient via
     * the attached mail server.
     * @param to The intended recipient.
     * @param message The text of the message to be sent.
     */
    public void sendMailItem(String to,String asunto,String message)
    {
        MailItem item = new MailItem(user, to,asunto, message);
        server.post(item);
    }
    
    /**
     *si hay un mensaje nuevo lo descarga y manda un mensaje al emisor del mismo dando gracias
     */
     public void reendMailItem()
    {
        MailItem item = server.getNextMailItem(user);
        asunto = "re: " + item.getasunto();
        mensaje = "gracias por su mensaje\n" + item.getMessage();
       if(item == null) {
            System.out.println("No new mail.");
        }
        else {
           
        sendMailItem(item.getFrom(),asunto, mensaje);
        server.post(item);
       }
    }
    
}
