package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

import Controller.Order;
import Controller.Proudct;
import Controller.eStatusOrder;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JTable;

public class SpacificOrderForm extends JFrame
{
	private JTextField textField;
	private JLabel m_NumberOrder;
	private JLabel m_OrderStatus;
	private String[] columnNames = { "Name", "Amount","Price"};
	private JTable table_1;
	private JButton m_Dayled;
	private JButton m_Supplied;
	private Order m_Order;
	private JScrollPane scrollPane = new JScrollPane();
	
	
	public SpacificOrderForm()
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblSearchOrder = new JLabel("Search Order");
		lblSearchOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchOrder.setBounds(169, 13, 141, 16);
		getContentPane().add(lblSearchOrder);
		
		JLabel lblEnterOrderNumber = new JLabel("Enter Order Number :");
		lblEnterOrderNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterOrderNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOrderNumber.setBounds(12, 71, 162, 16);
		getContentPane().add(lblEnterOrderNumber);
		
		textField = new JTextField();
		textField.setBounds(196, 69, 87, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!textField.getText().equals(""))
				{
					Order order = ScreenMagment.GetOrder(Integer.parseInt(textField.getText()));
					if(order != null)
					{
						m_Dayled.setVisible(true);
						m_Supplied.setVisible(true);
						m_Order = order;
						m_NumberOrder.setText(Integer.toString(order.GetOrderID()));
						m_OrderStatus.setText(order.GetOrderStatus().toString());
						List<Proudct> proudct = order.GetProudct();
						String[][] data = ScreenMagment.GetProudcts(proudct);
					
						table_1 = new JTable(data,columnNames);
						table_1.enable(false);
					
						scrollPane.setViewportView(table_1);
					}
					else
					{
						textField.setText(null);
						JOptionPane.showMessageDialog(null,"The Order is not found");
					}
				}
			}
		});
		btnSearch.setBounds(295, 68, 83, 25);
		getContentPane().add(btnSearch);
		
		

		JLabel m_ID = new JLabel("");
		m_ID.setHorizontalAlignment(SwingConstants.CENTER);
		m_ID.setFont(new Font("Tahoma", Font.BOLD, 18));
		m_ID.setBounds(73, 136, 97, 22);
		m_NumberOrder = m_ID;
		getContentPane().add(m_ID);
		
		JLabel m_Status = new JLabel("");
		m_Status.setHorizontalAlignment(SwingConstants.CENTER);
		m_Status.setFont(new Font("Tahoma", Font.BOLD, 18));
		m_Status.setBounds(182, 136, 141, 22);
		m_OrderStatus = m_Status;
		getContentPane().add(m_Status);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		btnBack.setBounds(295, 98, 84, 25);
		getContentPane().add(btnBack);
		
		JButton dialyed = new JButton("Dilayed");
		dialyed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(m_Order.GetOrderStatus()==eStatusOrder.InProgress)
				{
					JOptionPane.showMessageDialog(null,"Status is Delay");
					m_Order.SetOrderStatus(eStatusOrder.Delay);
					ScreenMagment.EnableSearchForm();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Order must be InProgress");
				}
			}
		});
		dialyed.setVisible(false);
		m_Dayled = dialyed;
		dialyed.setBounds(390, 68, 92, 25);
		getContentPane().add(dialyed);
		
		JButton btnSupplyed = new JButton("Supplied");
		btnSupplyed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(m_Order.GetOrderStatus()!=eStatusOrder.Supplied)
				{
					JOptionPane.showMessageDialog(null,"Supllied");
					m_Order.SetOrderStatus(eStatusOrder.Supplied);
					ScreenMagment.UpdatesOrder(m_Order);
					ScreenMagment.EnableSearchForm();
					dispose();
				}
				else
				{
					JOptionPane.showMessageDialog(null,"The Order already Supllied");
				}
				
			}
		});
		btnSupplyed.setVisible(false);
		m_Supplied = btnSupplyed;
		btnSupplyed.setBounds(391, 98, 91, 25);
		getContentPane().add(btnSupplyed);
		
		
		scrollPane.setBounds(35, 178, 398, 262);
		getContentPane().add(scrollPane);
		scrollPane.setViewportView(table_1);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
		
	}
}



