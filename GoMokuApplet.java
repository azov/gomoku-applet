/**
 * GoMokuApplet.java
 *
 * Copyright (c) 1997, Dmitry Azovtsev, http://www.azovtsev.com
 *
 * This is free software. You are permitted to copy, distribute, or modify
 * it under the terms of the MIT license, see
 * http://www.opensource.org/licenses/mit-license.php
 */
import java.applet.Applet;
import java.awt.*;

public class GoMokuApplet extends Applet 
{
   GoMokuBoard board;
   Label score;

   public void init() 
   {
     setBackground( Color.white );
     setLayout( new FlowLayout() );

     Dimension sz = size();
     int cellSize = Math.min( sz.width, sz.height )/20;

     board = new GoMokuBoard( 20,20,cellSize,cellSize );
     score = new Label( board.getScore() );

     add( board );
     add( new Button( "New game" ) );
     add( new Button( "Swap positions" ) );
     add( score );
   }
   
   public boolean action( Event evt, Object arg )
   {
      if ("New game".equals( arg ))
      {
         board.newGame();
         score.setText( board.getScore() );
         return true;
      }
      else if ("Swap positions".equals( arg ))
      {
         board.swapPositions();
         score.setText( board.getScore() );
         return true;
      }
      return false;
   }

   public String getAppletInfo() 
   {
      return "Go-Moku. (c) 1997 by Dmitry Azovtsev";
   }
}
