package beefsgui;

/*
   By Roman Andronov
 */

import java.awt.Insets;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.RootPaneContainer;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;

class BeefsGui
{
	BeefsGui( BeefsGuiPanel pnlbg )
	{
		pnlBG = pnlbg;
	}

	void
	init( RootPaneContainer rpc )
	{
		GridBagConstraints	gbc = new GridBagConstraints();

		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = INSETS;

		rpc.getContentPane().setLayout( new GridBagLayout() );

		pnlBG.setLayout( new GridBagLayout() );
		pnlBG.setBorder( BorderFactory.createLineBorder( CLRGRAY ) );
		rpc.getContentPane().add( pnlBG, gbc );

		pnlBG.pnlBoolExpr = mkTxtPnl( "Boolean Expression:", 0 );
		pnlBG.taBoolExpr = mkTA( pnlBG.pnlBoolExpr );

		pnlBG.pnlOutQ = mkTxtPnl( "Output Queue:", 1 );
		pnlBG.taOutQ = mkTA( pnlBG.pnlOutQ );
		pnlBG.taOutQ.setEditable( false );

		pnlBG.pnlPhrase = mkTxtPnl( "Phrase:", 2 );
		pnlBG.taPhrase = mkTA( pnlBG.pnlPhrase );

		pnlBG.pnlResult = mkTxtPnl( "Result:", 3 );
		pnlBG.taResult = mkTA( pnlBG.pnlResult );
		pnlBG.taResult.setEditable( false );

		mkTestPnl();
	}

	private JPanel
	mkTxtPnl( String title, int row )
	{
		JPanel			pnl = null;
		GridBagConstraints	gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = row;
		gbc.gridwidth = 2;
		gbc.insets = INSETS;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTH;

		pnl = new JPanel();
		pnl.setLayout( new GridBagLayout() );
		pnl.setBorder(
			BorderFactory.createTitledBorder( title ) );
		pnlBG.add( pnl, gbc );

		return pnl;
	}

	private JTextArea
	mkTA( JPanel pnl )
	{
		JTextArea		ta = null;
		JScrollPane		sp = null;
		GridBagConstraints	gbc = new GridBagConstraints();

		gbc.gridx = gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.insets = INSETS;
		gbc.weightx = gbc.weighty = 1.0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.NORTH;

		ta = new JTextArea( 5, 60 );
		ta.setMargin( INSETS );
		ta.setLineWrap( true );
		ta.setWrapStyleWord( true );
		ta.setFont( BGFONT );
		sp = new JScrollPane( ta,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
			JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
		pnl.add( sp, gbc );

		return ta;
	}

	private void
	mkTestPnl()
	{
		GridBagConstraints	gbc = new GridBagConstraints();

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.insets = INSETS;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.NORTH;

		pnlBG.pnlTest = new JPanel();
		pnlBG.pnlTest.setLayout( new GridBagLayout() );
		pnlBG.pnlTest.setBorder( BorderFactory.createTitledBorder( "Test:" ) );
		pnlBG.add( pnlBG.pnlTest, gbc );

		gbc.weightx = 0;
		gbc.fill = GridBagConstraints.NONE;

		pnlBG.bgNotation = new ButtonGroup();
		pnlBG.rbPrefix = new JRadioButton( "prefix" );
		pnlBG.rbPrefix.setSelected( true );
		pnlBG.rbPrefix.setMnemonic( KeyEvent.VK_R );
		pnlBG.rbPostfix = new JRadioButton( "postfix" );
		pnlBG.rbPostfix.setMnemonic( KeyEvent.VK_O );
		pnlBG.bgNotation.add( pnlBG.rbPrefix );
		pnlBG.bgNotation.add( pnlBG.rbPostfix );

		gbc.gridx = gbc.gridy = 0;
		pnlBG.pnlTest.add( pnlBG.rbPrefix, gbc );

		gbc.gridx = 1;
		pnlBG.pnlTest.add( pnlBG.rbPostfix, gbc );

		pnlBG.chbCase = new JCheckBox( "case sensitive" );
		pnlBG.chbCase.setMnemonic( KeyEvent.VK_C );
		gbc.gridx = 2;
		pnlBG.pnlTest.add( pnlBG.chbCase, gbc );

		gbc.gridx = 3;
		gbc.weightx = 1.0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		pnlBG.jbTest = new JButton( "Test" );
		pnlBG.jbTest.setMnemonic( KeyEvent.VK_T );
		pnlBG.jbTest.addActionListener( pnlBG );
		pnlBG.pnlTest.add( pnlBG.jbTest, gbc );
	}


	BeefsGuiPanel				pnlBG;

	static final Insets			INSETS = new Insets( 3, 3, 3, 3 );

	static final Color			CLRGRAY = Color.GRAY;
	static final Color			CLRLGRAY = Color.LIGHT_GRAY;
	static final Font			BGFONT = new Font( "Courier", Font.PLAIN, 16 );
}
