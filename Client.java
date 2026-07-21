// Name: Adam Archuleta
// Date: July 2026
// Course: CSCI 2251
// Project: Networking and GUI
// Citation: Implements GUI event-driven file reading, network socket 
// transmission, and implements the required TERMINATE protocol.

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame 
{
    private JTextField enterField;
    private JTextArea displayArea;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;
    
    // Setting default local IP and arbitrary port for server connection
    private String serverIP = "127.0.0.1";
    private int port = 12345;

    // Constructor sets up the GUI
    public Client() 
    {
        super("Matrix Client");
        
        enterField = new JTextField("Enter file name (e.g., matrix3.txt)");
        enterField.addActionListener(new ActionListener() 
        {
            // Triggers when user presses Enter in the text field
            public void actionPerformed(ActionEvent event) 
            {
                processFileAndCommunicate(event.getActionCommand());
            }
        });
        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Handles file reading, network transmission, and protocol
    private void processFileAndCommunicate(String fileName) 
    {
        // Print to command prompt per instruction Step A
        System.out.println("User entered filename: " + fileName); 

        try 
        {
            // Read matrix data from file
            Scanner scanner = new Scanner(new File(fileName));
            int rows = scanner.nextInt();
            int cols = scanner.nextInt();
            
            int[][] matrix1 = new int[rows][cols];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    matrix1[r][c] = scanner.nextInt();

            int[][] matrix2 = new int[rows][cols];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    matrix2[r][c] = scanner.nextInt();
            
            scanner.close();

            // Establish connection to Server
            connection = new Socket(serverIP, port);
            output = new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input = new ObjectInputStream(connection.getInputStream());

            // Transmit matrices
            output.writeObject(matrix1);
            output.flush();
            output.writeObject(matrix2);
            output.flush();

            // Receive and display the summed solution matrix
            int[][] result = (int[][]) input.readObject();
            displayResult(result);

            // Send protocol string to safely close connection
            output.writeObject("TERMINATE");
            output.flush();

            // Close streams
            output.close();
            input.close();
            connection.close();
        } 
        catch (Exception e) 
        {
            displayArea.setText("Error: " + e.getMessage());
        }
    }

    // Formats and outputs the 2D array to the GUI textarea
    private void displayResult(int[][] matrix) 
    {
        StringBuilder sb = new StringBuilder("Result received:\n\n");
        for (int[] row : matrix) 
        {
            for (int val : row) 
            {
                sb.append(String.format("%5d", val));
            }
            sb.append("\n");
        }
        displayArea.setText(sb.toString());
    }
}