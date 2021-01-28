## CS4750-Final-Project

Selena Aungst, Sonia Carrillo, Allison Inciong, Camryn Sumabat, & Alysia Wong

Professor Johannsen

CS 4750.01 

11 Dec. 2020 

### App Overview
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

### Implementation
Currently, our app is not 100% implemented. The login, sign up, and home pages are all fully functional, as are the
buttons for following pages: search for movies, watch list, friends list, and sign out. Currently, our search for movies 
page has both the search bar and the display of movie posters, but the search feature is not yet functional. Additionally, 
the "add to watchlist" buttons on the movie view pages are not functional. Similarly, we do not have the watch list 
implemented just yet, so as a placeholder, we are just using the same movie database implementation as the search for 
movies page. Lastly, the friends list also needs more work as it currently displays placeholder data, but we did not have 
time to implement these features due to the time constraints of the class. Despite these gaps, a good portion of the app is 
implemented and well researched. 

We unfortunately were not able to fully implement all of these features in time, but the code we were working on to 
make them functional can still be seen in as comments. The main roadblock we faced that caused us to be unable to implement 
these features in time was finding a way to add information to Firebase Firestore under a unique userID connected to the 
email verified users. There were very few resources online for how to perform this specific task in Firebase, and even 
fewer were in Kotlin. In the future, we hope to potentially implement these features in the main app if we ever put this 
app on the app store.
