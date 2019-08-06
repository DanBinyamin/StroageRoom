package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.List;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuForm extends JFrame
{
	private JButton OrderButton = null;
	private JButton EditButton = null;
	
	public MenuForm() 
	{
		setResizable(false);
		getContentPane().setEnabled(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu ");
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblMenu.setBounds(158, 0, 165, 43);
		getContentPane().add(lblMenu);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowUpdateMenu();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(80, 213, 318, 43);
		getContentPane().add(btnNewButton);
		
		JButton m_ButtonSearch = new JButton("Search");
		m_ButtonSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ScreenMagment.ShowSearchForm();
			}
		});
		m_ButtonSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		m_ButtonSearch.setBounds(80, 45, 318, 43);
		getContentPane().add(m_ButtonSearch);
		
		JButton m_NewOrder = new JButton("New Order");
		m_NewOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowNewOrder();
			}
		});
		OrderButton= m_NewOrder;
		OrderButton.enable(false);
		OrderButton.setVisible(false);
		m_NewOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		m_NewOrder.setBounds(80, 330, 318, 43);
		getContentPane().add(m_NewOrder);
		
		JButton Edit = new JButton("Edit");
		Edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowEditForm();
			}
		});
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		EditButton = Edit;
		EditButton.enable(false);
		EditButton.setVisible(false);
		Edit.setBounds(80, 274, 318, 43);
		getContentPane().add(Edit);
		
		JButton btnShowCapacity = new JButton("Show Capacity");
		btnShowCapacity.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				ScreenMagment.ShowCapacity();
			}
		});
		btnShowCapacity.setBounds(80, 157, 318, 43);
		getContentPane().add(btnShowCapacity);
		
		JButton btnShowAllOrder = new JButton("Show All Order");
		btnShowAllOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnShowAllOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				OrderCapacityForm o = new OrderCapacityForm();
				o.show();
			}
		});
		btnShowAllOrder.setBounds(80, 101, 318, 43);
		getContentPane().add(btnShowAllOrder);
		
		JButton LogOut = new JButton("Log Out");
		LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				ScreenMagment.StartLoginForm();
				dispose();
			}
		});
		LogOut.setBounds(80, 386, 318, 43);
		getContentPane().add(LogOut);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}
	
	public void EnableOrder()
	{
		OrderButton.setVisible(true);
		OrderButton.enable(true);
		EditButton.setVisible(true);
		EditButton.enable(true);
	}
	
	public void DisableOrder()
	{
		OrderButton.setVisible(false);
		OrderButton.enable(false);
		EditButton.setVisible(false);
		EditButton.enable(false);
	}
}
