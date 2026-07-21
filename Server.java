// Name: Adam Archuleta
// Date: July 2026
// Course: CSCI 2251
// Project: Networking and GUI
// Citation: Implements concurrent quadrant summation across four threads,
// reads serialized matrices, and honors the TERMINATE protocol[cite: 15].

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    private ServerSocket server;
    // Port must match the client's port exactly
    private int port = 12345;

    public void runServer() 
    {
        try 
        {
            server = new ServerSocket(port, 100);
            
            // Server runs forever waiting for clients
            while (true) 
            {
                System.out.println("Waiting for connection...");
                Socket connection = server.accept();
                System.out.println("Connection received.");

                ObjectOutputStream output = new ObjectOutputStream(
                                            connection.getOutputStream());
                output.flush();
                ObjectInputStream input = new ObjectInputStream(
                                          connection.getInputStream());

                processClient(connection, input, output);
                
                output.close();
                input.close();
                connection.close();
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    private void processClient(Socket conn, ObjectInputStream input, 
                               ObjectOutputStream output) throws Exception 
    {
        // 1. Receive the two matrices from the client
        int[][] matrix1 = (int[][]) input.readObject();
        int[][] matrix2 = (int[][]) input.readObject();

        int rows = matrix1.length;
        int cols = matrix1[0].length;

        // 2. Display matrices on the Server command prompt
        System.out.println("Received Matrix 1:");
        printMatrix(matrix1);
        System.out.println("Received Matrix 2:");
        printMatrix(matrix2);

        // 3. Setup concurrent processing variables
        int[][] result = new int[rows][cols];
        int midRow = rows / 2;
        int midCol = cols / 2;

        // 4. Create four threads for the four quadrants
        ThreadOperation t1 = new ThreadOperation(matrix1, matrix2, result, 
                                                 0, midRow, 0, midCol);
        ThreadOperation t2 = new ThreadOperation(matrix1, matrix2, result, 
                                                 0, midRow, midCol, cols);
        ThreadOperation t3 = new ThreadOperation(matrix1, matrix2, result, 
                                                 midRow, rows, 0, midCol);
        ThreadOperation t4 = new ThreadOperation(matrix1, matrix2, result, 
                                                 midRow, rows, midCol, cols);

        // 5. Start and join threads to perform concurrent addition
        t1.start(); t2.start(); t3.start(); t4.start();
        t1.join(); t2.join(); t3.join(); t4.join();

        // 6. Transmit solution back to the client
        System.out.println("Sending result to client...\n");
        output.writeObject(result);
        output.flush();

        // 7. Wait for TERMINATE String using instanceof check
        Object message = input.readObject();
        if (message instanceof String) 
        {
            String command = (String) message;
            if (command.equals("TERMINATE")) 
            {
                System.out.println("Server terminated connection\n");
            }
        }
    }

    // Helper method to format and print matrices to the console
    private void printMatrix(int[][] matrix) 
    {
        for (int[] row : matrix) 
        {
            for (int val : row) 
            {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
        System.out.println();
    }
}