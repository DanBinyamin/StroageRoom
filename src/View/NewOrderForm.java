package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Controller.ProudctList;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewOrderForm extends JFrame
{
	private JTextField m_Amount;
	private JTextField m_Price;

	
	public NewOrderForm()
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblNewOrder = new JLabel("New Order");
		lblNewOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewOrder.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewOrder.setBounds(170, 13, 133, 29);
		getContentPane().add(lblNewOrder);
		
		JButton m_ButtonFoodOrder = new JButton("Food Order");
		m_ButtonFoodOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowOrderForm("Food");
			}
		});
		
		m_ButtonFoodOrder.setAutoscrolls(true);
		m_ButtonFoodOrder.setBounds(148, 80, 170, 42);
		getContentPane().add(m_ButtonFoodOrder);
		
		JButton m_ButtonVegtOrder = new JButton("Vegt Order");
		m_ButtonVegtOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowOrderForm("Vegetables");
			}
		});
		m_ButtonVegtOrder.setAutoscrolls(true);
		m_ButtonVegtOrder.setBounds(148, 158, 170, 42);
		getContentPane().add(m_ButtonVegtOrder);
		
		JButton m_ButtonDrinkOrder = new JButton("Drink Order");
		m_ButtonDrinkOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowOrderForm("Drink");
			}
		});
		m_ButtonDrinkOrder.setAutoscrolls(true);
		m_ButtonDrinkOrder.setBounds(148, 244, 170, 42);
		getContentPane().add(m_ButtonDrinkOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			 @Override
			public void mouseClicked(MouseEvent e)
			{
				dispose();
				ScreenMagment.EnableMenu();
			}
		});
		btnBack.setAutoscrolls(true);
		btnBack.setBounds(148, 324, 170, 42);
		getContentPane().add(btnBack);
		
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}	
}
