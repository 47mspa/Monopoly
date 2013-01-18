import java.util.ArrayList;
import java.util.Collections;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.imageio.*;
import java.io.*;

/**
 * Community chance deck
 */
class CcDeck
{
    ArrayList Deck = new ArrayList ();
    public CcDeck (int players)
    {
	for (int x = 0 ; x < 18 ; x++)
	    Deck.add (x, new CcCard (x, players));
    }

    public int getSize ()
    {
	return Deck.size ();
    }


    public CcCard deal (int p)
    {
	CcCard A = (CcCard) Deck.get (p);
	if (Deck.size () > 0 || p >= 0) //checks if it is within range
	    Deck.remove (p); //removes it
	return A;
    }


    public CcCard deal ()
    {
	CcCard A = this.get (0);
	if (Deck.size () > 0)
	    Deck.remove (0); //removes top card

	return A;
    }


    public CcCard get (int x)
    {
	CcCard card = (CcCard) Deck.get (x);
	return card;
    }


    public void shuffle ()
    {
	Collections.shuffle (Deck);
    }


    public void Sort ()
    {
    }
}
