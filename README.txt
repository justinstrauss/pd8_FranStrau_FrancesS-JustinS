pd8_FranStrau_FrancesS-JustinS
APCS2 Final Project
==============================
Our APCS2 final project is a non airline specific, universal flight reservation system that harnesses the power of Java's object oriented paradigm to analyze and process big data relating to the world's flight routes, airlines, and airports.

User Experience:

First, download our repo and unzip it. Then, in your terminal, find the path to our repo and change the directory to pd8_FranStrau_FrancesS-JustinS. Next, compile by typing javac *.java and run our project by typing java Pilot. The user will be interacting with the terminal and is expected to know the 3 letter airport codes for their origin and destination airports. For example, John F Kennedy International Airport in New York is JFK. The user's goal is to follow the prompts to look up, select, and ultimately reserve a flight.

Topics Incorporated:

- Parsing a .dat file of CSV's (comma separated values) in the ListMaker class was adapted from the parse method of HW29 Scheme.java.
- Using the Scanner class in ListMaker.java to input an external file was adapted from the Maze homework.
- Getting rid of duplicate layover cities in the transfer methods of Route.java made use of the HashSet class's ability to disperses elements properly among buckets with a hash function.
- Try/catch exception handling is implemented throughout.

Limitations of our Database:

The database of all commercial airline flights only lists existing routes with information for the airline, origin airport, and destination airport. Information about actual flight schedules, including times and frequencies, isn't available from a unified source. Therefore, we made the assumption that each airline runs a single flight per day for each of their routes. 

Additionally, the cost of flights can be quite arbitrary, so price is excluded from our algorithm. Instead, we make use of the haversine formula to calculate the distance in kilometers between two airports using their GPS coordinates. This information can then be used to predict the time of flight based on an average crusing speed of 850 km/hr and the type of plane used for long haul versus medium haul versus short haul flights. Likewise, our algorithm calculates the number of days until the flight to produce a model of the number of seats that are still available to be reserved.

Error Handling:

- User input for the 3 character airport code is made uppercase using the String class's toUpperCase() method and any leading or trailing whitespace is ommited using the String.trim() method.
- When the user is supposed to type a number to make a selection, our code makes sure its a number and if it is, it verifies that it's within the appropriate range.
- If the date entered for either the departure flight or the return flight is before today's date, an error message will be printed. Likewise, if the date for the departure flight is after the return flight, the dates will be swapped.
