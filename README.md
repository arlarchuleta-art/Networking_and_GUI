# Networking and GUI Lab
- **Date:** July 21, 2026
- **Developer:** Adam Archuleta

## Project Overview
This project integrates socket communication, event-driven Graphical User Interfaces (GUIs), and concurrent multi-threading into a client-server cloud computing model. The client reads two matrices from a local text file via a GUI, transmits them over a network stream to the server, and receives the consolidated sum matrix calculated concurrently across four threads.  

## Structural Strategy
To complete this program successfully, the implementation deploys across 5 core elements:  
1. ServerStart.java - Contains the main method to instantiate and start up the Server.
2. Server.java - Core networking engine handling socket streams, thread delegation, and the TERMINATE protocol.
3. ClientStart.java - Contains the main method to instantiate and start up the Client.
4. Client.java - Event-driven Swing GUI client managing file input and network data transmission.
5. ThreadOperation.java - Concurrency worker class handling quadrant-based matrix summation.
  
## Milestone 1 Update: Core Concurrency Class Deployed
* **Component Added:** `ThreadOperation.jav`
* **Details:** Imported and integrated the multi-threaded quadrant summation logic from previous coursework

## Milestone 2 Update: Server Networking Structure 
* **DeployedComponent Added:** `Server.java`
* * **Details:** Completed the persistent server logic to receive incoming matrix data, dispatch four concurrent threads, return the solution, and honor the TERMINATE string via instanceof.  

## Timeline
- ThreadOperation uploaded: 07/15/2026-7:30AM
- Server uploaded: 07/15/2026-8:26AM

  
