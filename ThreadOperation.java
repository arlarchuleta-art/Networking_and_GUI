// Name: Adam Archuleta
// Date: July 2026
// Course: CSCI 2251
// Project: Networking and GUI
// Citation: Reused and adapted from the previous Concurrency lab to 
// perform quadrant-based matrix summation[cite: 15].

public class ThreadOperation extends Thread 
{
    private int[][] matrixA;
    private int[][] matrixB;
    private int[][] resultMatrix;
    private int rowStart, rowEnd, colStart, colEnd;

    // Constructor assigns the specific quadrant boundaries for this thread
    public ThreadOperation(int[][] m1, int[][] m2, int[][] result, 
                           int rStart, int rEnd, int cStart, int cEnd) 
    {
        this.matrixA = m1;
        this.matrixB = m2;
        this.resultMatrix = result;
        this.rowStart = rStart;
        this.rowEnd = rEnd;
        this.colStart = cStart;
        this.colEnd = cEnd;
    }

    // Overridden run method performs the concurrent addition
    @Override
    public void run() 
    {
        for (int i = rowStart; i < rowEnd; i++) 
        {
            for (int j = colStart; j < colEnd; j++) 
            {
                resultMatrix[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
    }
}