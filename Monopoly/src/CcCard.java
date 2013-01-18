import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

/**
 * Community chance card
 */
class CcCard
{
    int fee = 0;
    int id = 0;
    String name = "";
    String info = "";
    BufferedImage img;

    public CcCard (int num, int players)
    {
	id = num;
	int m = 1;
	String line = get (num);
	String[] parts = line.split ("/");
	String s_fee = parts [0];
	if (num == 5 || num == 6)
	{
	    m = players;
	}
	fee = ((int) Integer.parseInt (s_fee)) * m;
	if (num == 5 || num == 6)
	    fee = fee * players;
	info = parts [1];
	try //tries to load images
	{
	    img = loadImg ("CCPICS/CC" + id + ".png");
	}
	catch (IOException e)
	{
	    e.printStackTrace ();
	}
    }


    private BufferedImage loadImg (String name) throws IOException //Loads the image
    {
        InputStream m = this.getClass().getResourceAsStream(name);

        return ImageIO.read (m); //In Deck folder
    }


    public BufferedImage getImg ()
    {
	return img;
    }


    public String get (int num)
    {
	String[] lines = read ("CcCards.txt");
	String line = lines [num];
	return line;
    }


    public String getInfo ()
    {
	return info;
    }


    public int getFee ()
    {
	return fee;
    }


    public String getName ()
    {
	return name;
    }


    public int getid ()
    {
	return id;
    }


    public String[] read (String fname)   //read text file
    {
        InputStream m = this.getClass().getResourceAsStream(fname);
	String[] place;
	place = new String [40]; //new array of size 2
	try
	{
        BufferedReader input = new BufferedReader (new InputStreamReader(m, "UTF-8"));
//	    BufferedReader input = new BufferedReader (new FileReader (fname));
	    for (int x = 0 ; x < place.length ; x++) //loop to fill array
	    {
		place [x] = input.readLine (); //read line of file
	    }
	    input.close (); //close stream
	}


	catch (Exception e)
	{
	    System.out.println (e);
	    System.out.println ("Couldn't Find: " + fname);
	    for (int x = 0 ; x < place.length ; x++) //loop to fill array
	    {
		place [x] = ""; //read line of file
	    }
	}
	return place;
    }
}
