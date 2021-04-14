# Elon Musk Chat Bot

## Updates for Ben Keeley's Individual Assignment 
Since Assignment 3 I have added features that make use of Wolfram API and Twitter API to improve the chatbot.
- Implemented a Wolfram Alpha class that queries Wolfram Alpha for inputs.
- Implemented a Twitter API class to retrieve information from Elon Musks twitter page.
- Added responses where the bot directly references Elon's twitter.
- Added responses where the bot answers questions based on Wolfram Alpha's obtained results
- Some extra topics dealing with twitter and Wolfram responses were added
## Updates for Assignment 3
Since Assignment 2 we have added new features and also enhanced some quality of life features to our chatbot. 
Additions include:
- We implemented a GUI to engage our users.
- We implemented Named Entity Recognition from the Stanford Core NLP toolkit.
- We implemented Coreference Resolution from the Stanford Core NLP toolkit.
- We implemented Sentiment analysis tool from the Stanford Core NLP toolkit.
- We added an extra topic on our agents repertoire, being information about Jeff Bezos.
- We added more responses to our bot when a question is out of the scope of our topics.
- We implemented a conversation that can be done through sockets.
- We also implemented testing of various methods from our program

---------------------------------------

## Purpose
- The purpose of this project was for COSC 310 "Software Engineering".
- We created a chatbot that can answer some questions about Elon Musk.
- We used a chain of if else statements that when a word is recognized from a sentence it will get the appropriate response from a 2D array.

---------------------------------------

## Compile And Run
- To be able to run our code you will need to download the stanford core nlp toolkit and put it in the class path of the project. We had to do this because of limiting space on github.
- The same goes for Junit testing
- To compile and run this code clone the repository then you will have a jar file that you can run to open up our application. 

---------------------------------------

## Contributors
- Emiel van der Poel
- Nathan Pelmore
- Garrett Cook
- Benjamin Keeley
- Taylor Regier

---------------------------------------
---------------------------------------
## Code Documentation (Part of Assignment 2)
![image4](https://user-images.githubusercontent.com/75397522/111886188-a06db000-8989-11eb-8a34-b567d3314c41.png)

***Figure 1:*** Main class:

The only purpose of the main class is to instantiate a new Window, which is our chatbot and its functionality.

![image8](https://user-images.githubusercontent.com/75397522/111886198-acf20880-8989-11eb-9156-c3cea4bb7f9c.png)

***Figure 2:*** Importing required packages and creating a graphical user interface (gui):

The purpose of this section of code is to import the required packages to make our gui and its desired settings.

![image3](https://user-images.githubusercontent.com/75397522/111886200-b3808000-8989-11eb-873b-617e488297ee.png)


***Figure 3:*** 2d array of responses:

The purpose of this code is to have a 2d array that acts as a cache to our responses. We will access the specific element in this array by looking at the words sent by the user. 

![image2](https://user-images.githubusercontent.com/75397522/111886205-b7140700-8989-11eb-9d4b-ed6a54d3ca63.png)


***Figure 4:*** Constructor for our Window class:

The purpose of this constructor is to set all parameters of our graphical user interface(gui). We sat its name, size, how it closes, an icon image, set a gif in the gui, set background color, set font, and set desired areas of our gui to function as text areas.

![image6](https://user-images.githubusercontent.com/75397522/111886211-bc715180-8989-11eb-8abe-d2d2f358cfe2.png)


***Figure 5:*** keyPressed method:

The purpose of this method is to look for keys being entered by the user. If the user presses the enter key to submit their question the input text area will deactivate so the user cannot enter any more information. It will then take the input message and send that message to the addText function, which will add it to the main text area where the conversation will occur. We will that detect if the message contained a ‘?’, which then will set a question boolean value to true. If the message sent contains any punctuation the code will replace the punctuation with a space. We then trim the message from the whitespaces at the end and at the beginning. We then make the message lowercase so the case does not affect the outcome. Then send our message and our question boolean to the response method.

![image5](https://user-images.githubusercontent.com/75397522/111886214-c09d6f00-8989-11eb-9692-b70878ea5f9e.png)


***Figure 6:*** keyReleased method:

The purpose of this method is to make the input text area editable again once the enter key was released.

![image7](https://user-images.githubusercontent.com/75397522/111886216-c4c98c80-8989-11eb-8357-26c604e4ceb1.png)


***Figure 7:*** addText method:

The purpose of this method is to take a string and add it to the main conversation text area.

![image1](https://user-images.githubusercontent.com/75397522/111886224-cabf6d80-8989-11eb-9f32-232f33ab6317.png)


***Figure 8:*** response method:

The main purpose of this method is to split the message string into an array of its individual words. It will then check the words contained in this array to grab the correct bot response from the response 2d array shown above. Then we check if the question boolean value was true and we generate a random number to check if it equals a specified number and if both cases are true our bot will tell the user that their question was a good question. If the user sent ‘q’ we sent a message saying that the chat has ended.

## Code Documentation (Individual Project)
![Wolfram_constructor_variables](https://user-images.githubusercontent.com/77421122/114610074-5e681f00-9c54-11eb-8d1e-b8483d32a956.PNG)

***Figure 9:*** WolframAlpha class and constructor:

The purpose of this class is to assist the bot with querying and obtaining results from WolframAlpha API. The Class imports the WolframAlphaJavaLibary. WolframAlpha-1.1.jar must be in the classpath. The various String instance variables are named after possible titles obtained from a WolframAlpha query and hold the corresponding results for these titles. All String instance variables are intialized to null on object creation and should all be set to null before each query. The constructor method of this class also intializes WolframAlphaJavaLibary objects to assist in querying and obtaining results from WolframAlpha. The WolframAlpha object is an intialized variable in Window and the query() method is called for each parsed message received from the user.    

![QueryMethod_WolframAlpha](https://user-images.githubusercontent.com/77421122/114611602-11854800-9c56-11eb-8311-720697e66eb8.PNG)

***Figure 10:*** WolframAlpha query method :

This method queries a String input to WolframAlpha and saves the results in the objects titled variables. The variable topic is set to the first interpreted response obtained from a WolframAlpha query if there is one. 

![getter_setter_wolfram](https://user-images.githubusercontent.com/77421122/114612394-eea76380-9c56-11eb-9f4e-7ff5db4f08e7.PNG)

***Figure 11:*** WolframAlpha getter and setter methods :

All variables intended for use in the Window class have getter and setter methods. 

![TWITTERAPIConstructor](https://user-images.githubusercontent.com/77421122/114613631-7477de80-9c58-11eb-93af-e6ec7f0504df.PNG)

***Figure 12:*** TwitterAPI class and constructor :

The following class uses the twitter4J libary to use Twitter API. The ResponseList<Status> instance variables hold the most recent 20 timeline tweets and favourites from the requested twitter account, which in Window's case is @elonmusk. In the constructor a twitter4J Twitter object is created to read from Twitter and the constructor throws an exception if twitter is down or the lists cannot be created. 

![getRecentTweet](https://user-images.githubusercontent.com/77421122/114615447-91151600-9c5a-11eb-92d0-b702baa21beb.PNG)

***Figure 13:*** getRecentTweet method :

Returns a String of the most recent tweet from the obtained timeline list. 

![getRandomTweet](https://user-images.githubusercontent.com/77421122/114615677-d0dbfd80-9c5a-11eb-8eab-2f4f4fe60c04.PNG)

***Figure 14:*** getRecentTweet method :

Returns a String of a random tweet from the obtained twitter users timeline.

![getRandomFavourite](https://user-images.githubusercontent.com/77421122/114615925-1b5d7a00-9c5b-11eb-93dd-b484dc3c64b6.PNG)

***Figure 15:*** getRandomFavourite method :

Returns a random tweet that the user liked and the twitter user that posted the tweet.

![getRecentFavourite_getSpecificTweet](https://user-images.githubusercontent.com/77421122/114616175-69727d80-9c5b-11eb-8dcd-483ff3545edf.PNG)

***Figure 16:*** getRecentFavourite method and getSpecificTweet method :

getRecentFavourite() returns a String of the most recent liked post of the objects specified twitter user. getSpecificTweet(long a) returns a String of a twitter object based on a specific twitter ID provided. 

---------------------------------------
# Implementations
---------------------------------------

## Named Entity Recognition (*Stanford toolkit*)
---------------------------------------

We implemented Named Entity Recognition so our chat bot would recognize if we are using a name of someone, which he would then remember and could reply using that name. Or you could give him a list of places and he would be able to recognize them. You can see this from the examples below.

![namedEntities](https://user-images.githubusercontent.com/75397522/111888896-03694200-899e-11eb-9e77-4725305d9f89.PNG)


***Figure 17:*** Named Entities Example:

If you introduce yourself with your name and your name is a recognized entity. Elon will say you have a nice name. Grimes response is now triggered if the entity grimes is detected along with others ie Tesla. On the right recognized entities are listed

![places](https://user-images.githubusercontent.com/75397522/111888928-37dcfe00-899e-11eb-9ecc-5623d7bed507.PNG)

***Figure 18:*** Places Visited Example:

You can ask elon where he has been, listing places. Elon will randomly select a recognized entity and then give a general response about it.

---------------------------------------

## Coreference Resolution (*Stanford toolkit*)
---------------------------------------

We implemented Coreference resolutiong so we are able to say a name like "Jeff Bezos" then we can later on in another sentece refer to him as a he and our bot will understand it. This limits redundency in our conversation with our bot.

![image](https://user-images.githubusercontent.com/75397522/112570314-0baced00-8da3-11eb-85fa-f0891707a98e.png)

***Figure 19:*** Sample Chat Output with multiple questions

![image](https://user-images.githubusercontent.com/75397522/112570386-2f703300-8da3-11eb-9ae5-d0540cd914eb.png)

***Figure 20:*** Sample Chat Output with a Name Then Referencing by He/She/Him/Her

---------------------------------------

## Sentiment analysis tools (*Stanford toolkit*)
---------------------------------------
We used Sentiment analysis to see how the user was feeling. Depending on if the user was positive or negative the bot would respond with something referring to his positivity or negativity then he would send the appropriate response from our responses.

![310](https://user-images.githubusercontent.com/75397522/112517084-26f10b80-8d55-11eb-9bae-15dbd5d3ce4d.PNG)

***Figrue 21:*** Sample conversation 

From this sample conversation you can see that Elon detected that the sentence was positive and he gave a response referencing that, then he sent the appropriate response. Below that you can see that the console shows that the sentence was positive, what it sent a variable to, and the sentence it was testing.

---------------------------------------

## Sockets
---------------------------------------
To engage a socket conversation you must type in SocketSTUFF (case sensitive) to prep the bot to receive a connection

![image](https://user-images.githubusercontent.com/75397522/112515502-8cdc9380-8d53-11eb-9f3e-9c495dd69b8e.png)

***Figure 22:*** Sample of Receiving a Connection

![image](https://user-images.githubusercontent.com/75397522/112515676-b5fd2400-8d53-11eb-842c-a849f48aafe2.png)

***Figure 23:*** Sample output of a socket conversation

Client can converse with Elon normally, typing input in the console and receiving Elonbots output. Press q to close communications

![image](https://user-images.githubusercontent.com/75397522/112515840-e1800e80-8d53-11eb-8a5b-1085ac26f9e3.png)

***Figure 24:*** Client Side Socket Code

![image](https://user-images.githubusercontent.com/75397522/112515860-e80e8600-8d53-11eb-98b9-01b70a5f2d8f.png)

***Figure 25:*** Server Side Socket Code

---------------------------------------
# API Features
---------------------------------------

## WolframAlpha (*WolframAlphaJavaLibary*)
------------------------------------------

![WolframMath](https://user-images.githubusercontent.com/77421122/114618747-93796f00-9c5e-11eb-87d7-f3c8dd7d1b89.PNG)

***Figure 26:*** Using Wolfram Alpha to solve math problems

When confronted with a math problem the bot will find an answer using Wolfram Alpha and display it beside the problem in question. The bot is now capable of solving math questions using results obtained from Wolfram Alpha API.

![wolframWikipedia_wolframResult](https://user-images.githubusercontent.com/77421122/114619539-890ba500-9c5f-11eb-8c39-dc40803f6c48.PNG)

***Figure 26:*** Using Wolfram Alpha to answer questions and talk about recognized topics 

The bot can now answer questions it is not hard coded for using Wolfram API. If the question does not trigger any of the previously programmed responses and WolframAlpha API returns a result, the bot will answer accordingly. This can be seen by the bots answer to the question "how old is the earth?". If Wolfram Alpha does not have a direct result to the question, the bot will reference the Wikepedia article on the topic it thinks you are talking about. 

![attila](https://user-images.githubusercontent.com/77421122/114626411-86fa1400-9c68-11eb-8382-5942173aa62d.PNG)

***Figure 27:*** cont... 

Asking about recognized entities or topics will also yield a response where the bot looks up the Wikepedia article using the Wikepedia summary obtained from WolframAlpha API.
The topic is determined by using WolframAlpha's interpreted response. 

## Twitter API (*twitter4J*)
------------------------------------------

![Random_tweets](https://user-images.githubusercontent.com/77421122/114623960-cde60a80-9c64-11eb-9c3d-d4c7a0ab4085.PNG)

***Figure 28:*** Bot references Elons twitter posts

You can ask the bot about Elon Musks twitter and it will respond with a random twitter post from @elonmusk's timeline. Images are outputted as links which can be followed to view the twitter post mentioned, this is seen by the second last response. Using the bots previous features, ElonBot will also randomnly output a message based off the topic of twitter after each response. This includes responses such as: "I am a twitter God", "Tweet, tweet", and "I love twitter".

![lastTwitterPost](https://user-images.githubusercontent.com/77421122/114624584-cc691200-9c65-11eb-99c1-b02224f368b2.PNG)

***Figure 29:*** Elon's last twitter post

You can ask ElonBot about Elon Musk's last or most recent twitter post and it will reference it.

![twitterLikes](https://user-images.githubusercontent.com/77421122/114624796-17832500-9c66-11eb-9269-d722b88662fe.PNG)

***Figure 30:*** Elon's liked twitter posts

You can mention Elon Musk's favourite posts or the twitter posts he likes or has liked, and the bot will return a random twitter post that @elonmusk has liked along with the user that posted it. 

![LastFavourite](https://user-images.githubusercontent.com/77421122/114625172-b3149580-9c66-11eb-8ded-6da196e99d58.PNG)

***Figure 31:*** Elon's most recent liked twitter posts

You can ask about Elon Musks most recent twitter favourite in multiple ways and the bot will mention it. 

![cyberPunk](https://user-images.githubusercontent.com/77421122/114625369-01299900-9c67-11eb-8911-f3d7f44e9cac.PNG)

***Figure 32:*** Referencing a specific tweet

When mentioning CyberPunk the bot will reference a specific tweet that Elon made about it. 







