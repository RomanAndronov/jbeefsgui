package beefsgui;

/*
   By Roman Andronov
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.RootPaneContainer;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

import beefs.*;

class BeefsGuiPanel
	extends JPanel
	implements ActionListener
{
	BeefsGuiPanel( RootPaneContainer rpc )
	{
		super();
		init( rpc );
	}

	public void
	actionPerformed( ActionEvent ae )
	{
		JButton	btn = ( JButton )ae.getSource();

		if ( btn == jbTest )
		{
			test();
		}
	}

	private void
	init( RootPaneContainer rpc )
	{
		beefs = new Beefs();
		sb = new StringBuilder();
		ui = new BeefsGui( this );
		ui.init( rpc );
	}

	private void
	test()
	{
		boolean		cs = false;
		int		notation = Beefs.PREFIX;
		String		be = taBoolExpr.getText();
		String		phr = taPhrase.getText();

		if ( be.length() == 0 )
		{
			taResult.setText( ERR_EBE );
			taBoolExpr.requestFocusInWindow();
			return;
		}

		if ( phr.length() == 0 )
		{
			taResult.setText( ERR_ETF );
			taPhrase.requestFocusInWindow();
			return;
		}

		taOutQ.setText( "" );
		taResult.setText( "" );

		if ( rbPostfix.isSelected() == true )
		{
			notation = Beefs.POSTFIX;
		}

		if ( chbCase.isSelected() == true )
		{
			cs = true;
		}

		if ( beefs.infixTo( be, notation ) != true )
		{
			taResult.setText( beefs.err() );
			return;
		}

		sb.setLength( 0 );
		beefs.mkOutputExpression( sb );
		taOutQ.setText( sb.toString() );

		if ( beefs.compute( phr, cs ) == true )
		{
			taResult.setText( "" + beefs.result() );
		}
		else
		{
			taResult.setText( beefs.err() );
		}
	}

	private void
	error( String es )
	{
		taResult.setText( es );
	}


	Beefs				beefs = null;
	StringBuilder			sb = null;
	BeefsGui			ui = null;

	JPanel				pnlBoolExpr = null;
	JTextArea			taBoolExpr = null;

	JPanel				pnlOutQ = null;
	JTextArea			taOutQ = null;

	JPanel				pnlPhrase = null;
	JTextArea			taPhrase = null;

	JPanel				pnlTest = null;
	ButtonGroup			bgNotation = null;
	JRadioButton			rbPrefix = null;
	JRadioButton			rbPostfix = null;
	JCheckBox			chbCase = null;
	JButton				jbTest = null;

	JPanel				pnlResult = null;
	JTextArea			taResult = null;

	static final String		ERR_EBE = "Please enter a valid Boolean expression";
	static final String		ERR_ETF = "Please enter a phrase to test";
}
