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
* **Details:** Completed the persistent server logic to receive incoming matrix data, dispatch four concurrent threads, return the solution, and honor the TERMINATE string via instanceof.  

## Milestone 3 Update: Server Entry Point Deployed
* **Component Added:** `ServerStart.java`
* **Details:** Implemented the main driver class to instantiate and run the server in an infinite loop waiting for client connections

## Milestone 4 Update: Client GUI & File Parsing Deployed
* **Component Added:** `Client.java`
* **Details:** Developed the Swing GUI text field and text area interface, adding file-reading functionality to parse two matrices and transmit them over sockets.

## Milestone 5 Update: Client Integration & Testing Log
* **Components Added:**  `ClientStart.java`, Test Execution Log
* **Validation Status:**  TESTING PHASE INITIALIZED
* **Details:**  Created the client start driver, completed all five required classes, and prepared the environment for active local compilation and verification testing via Command Prompt.

## Milestone 6 Update: Test Data Integration
* **Components Added:** `matrix.txt` (and associated test files)
* **Details:** Brought in the verified matrix text files from the previous lab to serve as input for the client-side file-reading text field during testing.

## Milestone 7 Update: Test Execution Files & Verification Logs
* **Components Added:** Test execution logs and verification screenshots (`Tets 1.png`, `Tets 2.png`, `Tets 3.png`)
* **Validation Status:** SUCCESSFUL MULTI-TEST VERIFICATION
* **Details:** Uploaded the complete visual proof of test execution. The screenshots document successful sequential processing of `matrix3.txt`, `matrix1.txt`, and `matrix2.txt`, verifying that the GUI, socket transmission, multithreaded quadrant summation, and TERMINATE protocol all function correctly in production.
  
 ## Timeline
- ThreadOperation uploaded: 07/21/2026-7:30AM
- Server uploaded: 07/21/2026-8:26AM
- ServerStart uploaded: 07/21/2026-9:16AM
- Client uploaded: 07/21/2026-12:55PM
- ClientStart uploaded & Testing: 07/22/2026-6:55AM
- Martix txt files uploaded & Testing continued: 07/22/2026-5:20PM
- Test Execution uploaded: 07/22/2026-7:00PM

