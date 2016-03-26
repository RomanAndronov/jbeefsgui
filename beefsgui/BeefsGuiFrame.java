package beefsgui;

/*
   By Roman Andronov
 */

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

/*
   This will execute BeefsGui as a stand-alone
   Java program.

   To execute it as a Java applet consult the
   BeefsGuiApplet class in this package
*/

public
class BeefsGuiFrame
	extends JFrame
{
	public
	BeefsGuiFrame()
	{
		super();

		setTitle( "BEEFS GUI" );
		setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
	}

	public static void
	main( String[] args )
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void
			run()
			{
				BeefsGuiFrame		bgfrm = new BeefsGuiFrame();

				bgfrm.bgpnl = new BeefsGuiPanel( bgfrm );
				bgfrm.pack();
				bgfrm.setLocationRelativeTo( null );
				bgfrm.setVisible( true );
			}
		});

	}

	private BeefsGuiPanel		bgpnl = null;
}
