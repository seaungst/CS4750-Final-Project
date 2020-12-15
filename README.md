CS4750-Final-Project

Selena Aungst, Sonia Carrillo, Allison Inciong, Camryn Sumabat, & Alysia Wong

Professor Johannsen

CS 4750.01

11 Dec. 2020


Our app, FlixPix, allows users to create an account, sign in, view movies, and view a list of their friends. 
It uses Google Firebase as its user database and it uses The Movie Database (TMDb) as its movie database. 
All users are verified through Firebase in making sure that their passwords are at least 6 characters long, 
and in making sure that their emails are in email address format. When logging in, Firebase verifies that 
the user has inputted correct information before allowing them to enter the app. On the main page of the app, 
the user can choose to search movies, view their watch list, view their friends list, or sign out. The search 
page currently shows a list of popular movies, and movie information is displayed in a new activity when each 
movie poster is clicked. The watch list currently shows all movies, but in theory these movies would be ones 
selected by the user. The friends list currently shows a list of dummy data for friends. Finally, the sign out 
button logs the user out through Firebase and takes them back to the home page where they can choose to login 
or sign up again. 

Currently, our app is not 100% implemented, but we definitely made great progress with it. We were able to create 
the login and sign up page that keeps track of the user’s email and passwords. Then the homepage displays, and we 
were also able to make the buttons functional for these pages: search for movies, watch list, friends list, and 
sign out. Currently, our search for movies page does have both the search bar and the display of movie posters, 
but the search function is not yet functional. Then, after clicking a movie, there is an “Add to Watchlist” button, 
but it is not functional yet either. Therefore, we do not have the watch list implemented just yet, so as a 
placeholder, we are just using the same movie database implementation as the search for movies page. Lastly, our 
friends list also needs more work because we currently have placeholder friends there, but we were not able to have 
time to implement this with all the other functions of our app. Despite these gaps, our app still has a big portion 
of its implementation well researched and completed.

Originally, our app was supposed to allow for searching popular movies, adding movies to a user watch list, adding 
friends to a friends list, and viewing the watch lists of friends. We unfortunately were not able to fully implement 
all of these features in time, but the code we were working on to make them functional can still be seen in our main 
code but commented out. The main roadblock we faced that caused us to be unable to implement these features in time 
was finding a way to add information to Firebase Firestore under a unique userID connected to the email verified users. 
There were very few resources online for how to perform this specific task in Firebase, and even fewer were in Kotlin. 
In the future, we hope to potentially implement these features in the main app if we ever put this app on the app store. 
Some other things we thought about adding were things like a way to sort the movies by genre or alphabetically when 
initially viewing the search page instead of just showing them by popular movies without a way to sort. We also thought 
it would be interesting to allow users to make multiple lists for storing movies. 
