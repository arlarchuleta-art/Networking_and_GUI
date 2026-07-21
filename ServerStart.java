// Name: Adam Archuleta
// Date: July 2026
// Course: CSCI 2251
// Project: Networking and GUI
// Citation: Baseline server initialization class.

public class ServerStart 
{
    public static void main(String[] args) 
    {
        Server application = new Server();
        // Server will loop infinitely waiting for connections
        application.runServer();
    }
}