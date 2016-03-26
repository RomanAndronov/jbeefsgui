package beefsgui;

/*
   By Roman Andronov
*/

import javax.swing.JApplet;
import javax.swing.SwingUtilities;

public
class BeefsGuiApplet
	extends JApplet
{
	public void
	init()
	{
		SwingUtilities.invokeLater( new Runnable()
		{
			public void
			run()
			{
				createAppletGui();
			}
		});
	}

	private void
	createAppletGui()
	{
		if ( bgpnl == null )
		{
			bgpnl = new BeefsGuiPanel( this );
		}
	}

	private BeefsGuiPanel		bgpnl = null;
}
