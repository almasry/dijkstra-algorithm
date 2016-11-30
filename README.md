# Solution of the "Travelling Salesman Problem" 
 

## Solution Algorithm 

This is an implementaion of Dijkstra's algorithm which aims at finding the shortest paths between two nodes in a graph, which may represent, for example, road networks. The mathematical explanation of the algorithm could be found (by MIT professor Sirini Devadas) at : https://youtu.be/2E7MmKv0Y24 .

This implementation is entirely written from scratch and is not using any external libraries or dependent on other implementations. Dijkstra's algorithm also uses a sort of depth-first-search algorithm to discover the graph nodes.

To solve other sub-problems that are not just about the shortest route, I implemeted a filtering mechanism that can be applied to the algorithm to fulfill the requirements of the sub-programs.


## Program design 

Thw design of the soltuion followed best practices through carefully applying SOLID principles. The application architecture is clean, DRY and application layers and modules are loosely coupled through the use of dependency inversion and various levels of abstraction.


## Installation and Use  

Project dependencies and build configuration are managed using Maven (tested using version 3.x), to install the program and its dependencies, from your terminal - please run :

    mvn clean install


To execute the program, please run the following command (no need to CD into the ./target directory):

    java -jar target/directgraph-1.0-SNAPSHOT.jar



If you run into any problems (on platforms other than unix/linux), you may need to add the -cp directive to the java command to point to the path of the main class "com.thoughtworks.trains.Trains" as following :

    java -cp target/directgraph-1.0-SNAPSHOT.jar com.algorithmatics.directedgraph.DirectedGraph


You'll be promoted with a request to enter the path of the file problem. Please enter an absolute path, something like :

    /home/users/alice/problem-file.txt



## Documentation 

The project and its packages are entirely documented, you can generate an HTML version of the javadoc based on the javadoc annotation used to document each package.



## IDE Setup 

I extensively use the features of Java 8, so please make sure that you adjust the language level to (version 8) and the SDK to (version 1.8) . I follow a strict zero warning policy, so in case if you find any warning, you may need to check the IDE/file indexing settings.

A quick tip: (In case if you're using Intellij, you can adjust the language and SDK level from File -> Project Structure - under both project and module tabs). 



## Test coverage 

The problem domain has a coverage of 82% which is quite okay for the scope of this simple task. 
