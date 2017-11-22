
/**
 * Realiza una serie de test para verificar las funcionalidades de
 * las clases del proyecto.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TestMailSystem
{
    // Simula un primer usuario de correo.
    private MailClient primerUsuario;
    // Simula un segundo usuario de correo.
    private MailClient segundoUsuario;
    // Simula nuestro servidor de correo.
    private MailServer grupoDServer;

    /**
     * Constructor for objects of class testMailSystem
     */
    public TestMailSystem()
    {
        grupoDServer = new MailServer();
        primerUsuario = new MailClient(grupoDServer,"Agapito");
        segundoUsuario = new MailClient(grupoDServer,"Eutanasia");
    }
    
    /**
     * Este test debe comprobar que nos de el n?mero de mensajes
     * recibidos correcto para cada usuario y 0 si no hay ningun mensaje.
     */
    public void terceraFuncionTest ()
    {
        primerUsuario.reendMailItem();
        segundoUsuario.reendMailItem();
        primerUsuario.sendMailItem("Eutanasia","hola","wololo");
        segundoUsuario.reendMailItem();
        segundoUsuario.printNextMailItem();
        primerUsuario.printNextMailItem();
        segundoUsuario.sendMailItem("Agapito","ADIOS","wolololo");
        primerUsuario.reendMailItem();
        primerUsuario.printNextMailItem();
        segundoUsuario.printNextMailItem();
    }

}