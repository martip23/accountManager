package accountManager.view;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import accountManager.controller.*;
import accountManager.model.*;

/**
 * Implements the GUI and I/O of GUI. Creates listeners and event 
 * generators to work with Model & Controller.
 * @author martip23
 *
 */
public class AccountManagerView extends JFrameView {
	public static final String TITLE = "Account Manager by Patrick Martinez";
	public static final String EDIT_USD = "Edit account in USD($)";
	public static final String EDIT_JPY = "Edit account in JPY(\u00a5)";
	public static final String EDIT_EUR	= "Edit account in EUR(\u20AC)";
	public static final String SAVE = "Save";
	public static final String EXIT = "Exit";
	public static final String ACCOUNT_LABEL = "Accounts: ";
	private String[] accountData = {"Dummy 100", "Person 025"};
	JComboBox<String> accountList = new JComboBox<String>(accountData);
	
	/**
	 * Creates Account Manager view and registers model & controller.
	 * @param model Model to register with view.
	 * @param controller Controller to register with view.
	 */
	public AccountManagerView(AccountModel model, AccountController controller) {
		super(model, controller);
		
		setResizable(false);
		setTitle(TITLE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 653, 220);

		((JComponent) this.getContentPane()).setBorder(new EmptyBorder(5, 5, 5, 5));
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		setContentPane(this.getContentPane());
		
		JSplitPane splitPane = new JSplitPane();
		this.getContentPane().add(splitPane, BorderLayout.NORTH);
		
		JLabel lblAccount = new JLabel("Account:");
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		splitPane.setLeftComponent(lblAccount);
		
		JComboBox comboBox = new JComboBox();
		splitPane.setRightComponent(comboBox);
		
		JPanel midPanel = new JPanel();
		this.getContentPane().add(midPanel, BorderLayout.CENTER);
		GridBagLayout gbl_midPanel = new GridBagLayout();
		gbl_midPanel.columnWidths = new int[] {145, 129, 121};
		gbl_midPanel.rowHeights = new int[] {35, 0, 0};
		gbl_midPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_midPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		midPanel.setLayout(gbl_midPanel);
		
		JButton dolsButton = new JButton("Edit account in dollars $");
		dolsButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_dolsButton = new GridBagConstraints();
		gbc_dolsButton.anchor = GridBagConstraints.WEST;
		gbc_dolsButton.insets = new Insets(0, 0, 0, 5);
		gbc_dolsButton.gridx = 0;
		gbc_dolsButton.gridy = 1;
		midPanel.add(dolsButton, gbc_dolsButton);
		
		JButton yenButton = new JButton("Edit account in yehn");
		yenButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		yenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_yenButton = new GridBagConstraints();
		gbc_yenButton.anchor = GridBagConstraints.WEST;
		gbc_yenButton.insets = new Insets(0, 0, 0, 5);
		gbc_yenButton.gridx = 1;
		gbc_yenButton.gridy = 1;
		midPanel.add(yenButton, gbc_yenButton);
		
		JButton eurButton = new JButton("Edit account in eur");
		eurButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_eurButton = new GridBagConstraints();
		gbc_eurButton.anchor = GridBagConstraints.WEST;
		gbc_eurButton.gridx = 2;
		gbc_eurButton.gridy = 1;
		midPanel.add(eurButton, gbc_eurButton);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {100, 100};
		gbl_panel.rowHeights = new int[] {50};
		gbl_panel.columnWeights = new double[]{0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panel.setLayout(gbl_panel);
		
		JButton saveButton = new JButton("New button");
		GridBagConstraints gbc_saveButton = new GridBagConstraints();
		gbc_saveButton.insets = new Insets(0, 0, 0, 5);
		gbc_saveButton.gridx = 0;
		gbc_saveButton.gridy = 0;
		panel.add(saveButton, gbc_saveButton);
		
		JButton exitButton = new JButton("New button");
		GridBagConstraints gbc_exitButton = new GridBagConstraints();
		gbc_exitButton.gridx = 1;
		gbc_exitButton.gridy = 0;
		panel.add(exitButton, gbc_exitButton);
		
		//Display the window
		pack();
	}
	 
	@Override
	public void modelChanged(ModelEvent event) {
		// TODO Auto-generated method stub
		
	}
	
	class Handler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
		}
	}
}
