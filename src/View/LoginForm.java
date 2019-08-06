package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JProgressBar;
import javax.swing.JPasswordField;
import java.awt.Scrollbar;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame
{
	private JTextField m_TextField;
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	public LoginForm() 
	{
		setResizable(false);
		setLocationByPlatform(true);
		setBounds(new Rectangle(500, 500, 500, 500));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(159, 13, 137, 40);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		getContentPane().add(lblNewLabel);
		
		m_TextField = new JTextField();
		m_TextField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		m_TextField.setBounds(224, 150, 220, 28);
		getContentPane().add(m_TextField);
		m_TextField.setColumns(10);
		
		JLabel lblIdnumber = new JLabel("ID-number : ");
		lblIdnumber.setBounds(0, 142, 211, 40);
		lblIdnumber.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblIdnumber.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblIdnumber);
		
		table = new JTable();
		table.setBounds(300, 433, 144, -151);
		getContentPane().add(table);
		
		JButton m_ButtonLogin = new JButton("Login");
		m_ButtonLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(ScreenMagment.IsEmploye(m_TextField.getText()))
				{
					ScreenMagment.ShowMenuForm(m_TextField.getText());
				}
				else
				{
					JOptionPane.showMessageDialog(null,"ID number is InVaild");
				}
				
				m_TextField.setText(null);
			}
		});
		m_ButtonLogin.setBounds(128, 328, 220, 40);
		getContentPane().add(m_ButtonLogin);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
		
	}
}
