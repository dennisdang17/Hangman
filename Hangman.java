/**
 * @author Dennis Dnag
 * @version 1.0
 * @since 2/20/19
 * Hangman.java
 **/
import java.util.*;
import java.lang.*;

public class Hangman
{
  //This is an array of String
  final static String animeList[] = {"Boku No Hero Academia", "Seishun Buta Yarou", "Tokyo Ghoul", "Shokugeki no Souma", "Dororo", "Naruto", "Cowboy Bebop", "Megalobox", "Code Geass", "Death Note", "Re:Zero", "Hunter x Hunter", "Fuullmetal Alchemist" };
  public static void main(String[] args)
  {
    //Sets up play again feature
    boolean play=true;
    boolean playing=true;

    //Initializes random and scanner objects
    Random randGen = new Random();
    Scanner choice = new Scanner(System.in);

    //Prints menu
    System.out.println("---------------------------------------------------------------------");
    System.out.println("Welcome to Hangman!");
    System.out.println("Hangman is a game where you guess the word that the computer chooses. \nIn this case, an anime from a list! ");
    System.out.println("The catch is, you can only guess a letter at a time. If you guess a \nletter not in the anime, then you get a strike.");
    System.out.println("Be careful! you can only get 7 strikes until you lost the game!");
    System.out.println("Last rule is to have fun! Good luck!");
    System.out.println("---------------------------------------------------------------------");
      
    while (play)
    {
      int again = 0;
      int wrong =0; 
      //Picks random anime from anime list and puts it into lowercase
      int randAnime = randGen.nextInt(animeList.length);
      String anime = animeList[randAnime];
      String animeLower = anime.toLowerCase();

      //Uses object to set random anime into string
      StringBuilder currentGuess = new StringBuilder(anime.length());
      currentGuess.append(anime);

      //Makes every letter in the anime into an asterick
      for (int i=0; i < currentGuess.length(); i++)
      {
        char c = currentGuess.charAt(i);
        if (Character.isLetter(c)==true)
        {
          currentGuess.setCharAt(i, '*');
        }
      }
      playing = true;
      System.out.println(anime);
        
      while (playing)
      {
        String guess = null;
        System.out.println(currentGuess);
        System.out.print("What is your guess?: ");
        guess = choice.next();
        guess = guess.toLowerCase();
        char character = guess.charAt(0);

        //Checks to see if letter is in the anime title
        if (animeLower.contains(guess)==true)
        {
          for(int i=0; i <currentGuess.length(); i++)
          {
            //If it is in the title, than replace the astrick with the letter
            if (animeLower.charAt(i) == character)
            {
              //Checks to see if the letter in the anime is uppercase and changes
              //it to be uppercase or keeps its lowercase
              if (Character.isUpperCase(anime.charAt(i)))
              {
                currentGuess.setCharAt(i,Character.toUpperCase(character));
              }
              else
              {
                currentGuess.setCharAt(i, character);
              }
            }
          }
        }


        //If the letter is not in the anime it prints out a try again 
        else if (animeLower.contains(guess)==false)
        {
          System.out.println("The letter "+guess+ " is not in the anime!");
          wrong ++;
          System.out.println("You have gotten "+wrong+" guess(es) incorrect.");
          hangmanImage(wrong);
        }

        //Breaks loop if the user has guessed all the letters
        if (anime.equals(currentGuess.toString()))
        {
          System.out.println("Congratulations, you win! The anime was "+ anime);
          playing = false;
          System.out.print("Enter 1 to play again. Enter any other integer to quit: ");
          again = choice.nextInt();
          if (again==1)
          {
            play = true;
          }
          else
          {
            play = false;
          }
        }
          
        //Makes it so that you only have 7 wrong guesses avaliable
        if (wrong == 7)
        {
          System.out.println("Aww you lose! The anime title was: "+anime);
          //asks the user to play again
          System.out.print("Enter 1 to play again. Enter any other integer to quit: ");
          again = choice.nextInt();
          //sets the booleans for playing again
          if (again==1)
          {
            play = true;
            playing = false;
          }
          else
          {
            play = false;
            playing = false;
          }
        }
      }
    }
    System.out.println("Thanks for playing!");
  }

  //prints out hangman image
  public static void hangmanImage(int wrong) 
  {
    if (wrong == 0)
    {
      System.out.println("   ____________");
      System.out.println("   |          ");
      System.out.println("   |         ");
      System.out.println("   |       ");
      System.out.println("   |       ");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("   |");
      System.out.println("___|___");
    }
    if (wrong == 1) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |                ");
        System.out.println("   |            ");
        System.out.println("   |           ");
        System.out.println("___|___        ");
      }
      if (wrong == 2) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |           |    ");
        System.out.println("   |           |");
        System.out.println("   |           ");
        System.out.println("___|___        ");
      }
      if (wrong == 3) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |       --- |    ");
        System.out.println("   |           |");
        System.out.println("   |           ");
        System.out.println("___|___        ");
      }
      if (wrong == 4) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |       --- | ---");
        System.out.println("   |           |");
        System.out.println("   |           ");
        System.out.println("___|___        ");
      }
      if (wrong == 5) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |       --- | ---");
        System.out.println("   |           |");
        System.out.println("   |          / ");
        System.out.println("___|___      /  ");
      }
      if (wrong == 6) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        |     |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |       --- | ---");
        System.out.println("   |           |");
        System.out.println("   |          / \\");
        System.out.println("___|___      /   \\");
      }
      if (wrong == 7) 
      {
        System.out.println("   ____________");
        System.out.println("   |         _____");
        System.out.println("   |        | x x |");
        System.out.println("   |        |     |");
        System.out.println("   |        |_____|");
        System.out.println("   |       --- | ---");
        System.out.println("   |           |");
        System.out.println("   |          / \\");
        System.out.println("___|___      /   \\");
      }
  }
}