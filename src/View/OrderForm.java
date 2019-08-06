package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.Order;
import Controller.OrderFactory;
import Controller.ProudctList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class OrderForm extends JFrame
{
	private JList<String> m_List;
	private JTextField m_Amount;
	private JTextField m_Price;
	private Order m_Order;
	private JButton m_buttonOrder;
	private static int numberOrder = ScreenMagment.GetNumberOfCurentOrder()+1;
	
	public OrderForm(String i_String) 
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		m_Order = OrderFactory.CreateOrder(i_String);
		
		JLabel lblNewLabel = new JLabel(i_String);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(75, 18, 110, 22);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSelectProudct = new JLabel("Select Proudct :");
		lblSelectProudct.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSelectProudct.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectProudct.setBounds(12, 79, 167, 38);
		getContentPane().add(lblSelectProudct);
		
		DefaultListModel<String> model = new DefaultListModel<>();
		
		JLabel lblEnterAmount = new JLabel("Enter Amount :");
		lblEnterAmount.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAmount.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterAmount.setBounds(12, 158, 167, 38);
		getContentPane().add(lblEnterAmount);
		
		m_Amount = new JTextField();
		m_Amount.setFont(new Font("Tahoma", Font.BOLD, 18));
		m_Amount.setBounds(213, 168, 211, 22);
		getContentPane().add(m_Amount);
		m_Amount.setColumns(10);
		
		JLabel lblEnterPrice = new JLabel("Enter Price :");
		lblEnterPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterPrice.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblEnterPrice.setBounds(0, 242, 167, 38);
		getContentPane().add(lblEnterPrice);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(213, 89, 211, 22);
		getContentPane().add(comboBox);
		
		m_Price = new JTextField();
		m_Price.setFont(new Font("Tahoma", Font.BOLD, 18));
		m_Price.setColumns(10);
		m_Price.setBounds(213, 252, 211, 22);
		getContentPane().add(m_Price);
		
		JButton m_Enter = new JButton(" Enter to Cart");
		m_Enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(Integer.parseInt(m_Amount.getText())>0&&Float.parseFloat(m_Price.getText())>0)
				{
					m_Order.AddProudct(comboBox.getSelectedItem().toString(),Integer.parseInt(m_Amount.getText()),Float.parseFloat(m_Price.getText()));
					m_buttonOrder.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Value is valid");
				}
				m_Amount.setText(null);
				m_Price.setText(null);
			}
		});
		m_Enter.setBounds(44, 353, 167, 25);
		getContentPane().add(m_Enter);
		
		JButton btnOrder = new JButton("Order Now!");
		btnOrder.setVisible(false);
		m_buttonOrder = btnOrder;
		
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				m_Order.SetOrderID(numberOrder++);
				ScreenMagment.AddOrderToList(m_Order);
				dispose();
				ScreenMagment.EnableMenu();
			}
		});
		btnOrder.setBounds(270, 353, 167, 25);
		getContentPane().add(btnOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				ScreenMagment.EnableNewOrderForm();
				
			}
		});
		btnBack.setBounds(147, 415, 167, 25);
		getContentPane().add(btnBack);
		
		JLabel Number = new JLabel("Order Number : "+Integer.toString(numberOrder));
		Number.setHorizontalAlignment(SwingConstants.CENTER);
		Number.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Number.setBounds(260, 18, 164, 22);
		getContentPane().add(Number);
		
		ProudctList proudctlist = ScreenMagment.GetProudctList(i_String);
		List<String> lists = proudctlist.GetList(); 
		
		for(String x : lists)
		{
			comboBox.addItem(x);
		}
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
		
	}

}
