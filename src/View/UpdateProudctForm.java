package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Controller.ProudctList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.Color;

public class UpdateProudctForm extends JFrame
{
	private JList<String> m_List;
	private JRadioButton veg;
	private JRadioButton drink;
	private JRadioButton food;
	private JLabel m_exitslabel;
	private JTextField textField;
	private JButton m_button;
	private JTable table;
	private JScrollPane scrollPane;
	
	public UpdateProudctForm() 
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblUpdate = new JLabel("Update ");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setHorizontalTextPosition(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdate.setBounds(143, 13, 192, 59);
		getContentPane().add(lblUpdate);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(185, 70, 150, 25);
		getContentPane().add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		btnBack.setBounds(73, 415, 97, 25);
		getContentPane().add(btnBack);
		
		JLabel lblEnterProudctName = new JLabel("Enter Proudct Name:");
		lblEnterProudctName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterProudctName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEnterProudctName.setBounds(12, 72, 137, 16);
		getContentPane().add(lblEnterProudctName);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		JRadioButton m_fp = new JRadioButton("Food Proudct");
		m_fp.setForeground(Color.RED);
		m_fp.setFont(new Font("Tahoma", Font.BOLD, 15));
		m_fp.setContentAreaFilled(false);
		food = m_fp;
		m_fp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0)
			{
				drink.setSelected(false);
				veg.setSelected(false);
				ProudctList proudctlist = ScreenMagment.GetProudctList("Food");
				List<String> lists = proudctlist.GetList(); 
				comboBox.removeAllItems();
			
				for(String x : lists)
				{
					comboBox.addItem(x);
				}
			}
		});
		m_fp.setBounds(12, 160, 127, 25);
		getContentPane().add(m_fp);
		
		JRadioButton m_dp = new JRadioButton("Drink Proudct");
		m_dp.setForeground(Color.BLUE);
		m_dp.setFont(new Font("Tahoma", Font.BOLD, 15));
		m_dp.setContentAreaFilled(false);
		drink = m_dp;
		m_dp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				veg.setSelected(false);
				food.setSelected(false);
				ProudctList proudctlist = ScreenMagment.GetProudctList("Drink");
				List<String> lists = proudctlist.GetList(); 
				comboBox.removeAllItems();
				
				for(String x : lists)
				{
					comboBox.addItem(x);
				}
			}
			
		});
		m_dp.setBounds(153, 160, 138, 25);
		getContentPane().add(m_dp);
		
		JRadioButton m_vp = new JRadioButton("Vegetables Proudct");
		m_vp.setForeground(Color.GREEN);
		m_vp.setFont(new Font("Tahoma", Font.BOLD, 15));
		m_vp.setContentAreaFilled(false);
		m_vp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				m_fp.setSelected(false);
				m_dp.setSelected(false);
				ProudctList proudctlist = ScreenMagment.GetProudctList("Vegetables");
				List<String> lists = proudctlist.GetList(); 
				comboBox.removeAllItems();
				
				for(String x : lists)
				{
					comboBox.addItem(x);
				}
			}
		});
		m_vp.setBounds(295, 160, 174, 25);
		veg = m_vp;
		getContentPane().add(m_vp);
		
		JButton btnEnter = new JButton("Enter");
		m_button = btnEnter;
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(ScreenMagment.IsExitsProudct(comboBox.getSelectedItem().toString()))
				{
					if(Integer.parseInt(textField.getText())>=0)
					{
						ScreenMagment.UpdateExitsProudct(comboBox.getSelectedItem().toString(), Integer.parseInt(textField.getText()));
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"The Value is Invalid");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Proudct not exist is the Storage");
				}
			}
		});
		btnEnter.setBounds(278, 415, 97, 25);
		getContentPane().add(btnEnter);
		
		JLabel lblEnterNewAmount = new JLabel("Enter New Amount:");
		lblEnterNewAmount.setHorizontalTextPosition(SwingConstants.CENTER);
		lblEnterNewAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterNewAmount.setBounds(12, 117, 137, 16);
		getContentPane().add(lblEnterNewAmount);
		
		textField = new JTextField();
		textField.setBounds(185, 116, 150, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		String[][] data = ScreenMagment.DataOfCapacity();
		String[] columnNames = { "Name", "Amount"};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 211, 406, 139);
		getContentPane().add(scrollPane);
		
		table = new JTable(data,columnNames);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
		
		
	}
}
