package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditForm extends JFrame
{
	public EditForm() {
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblEdit = new JLabel("Edit: ");
		lblEdit.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdit.setBounds(178, 13, 129, 52);
		getContentPane().add(lblEdit);
		
		JButton m_AddProduct = new JButton("Add Food Proudct");
		m_AddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				EditSpacificForm ed = new EditSpacificForm("Food");
				ed.show();
			}
		});
		m_AddProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		m_AddProduct.setBounds(12, 89, 205, 33);
		getContentPane().add(m_AddProduct);
		
		JButton m_AddDrinkProudct = new JButton("Add Drink Proudct");
		m_AddDrinkProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EditSpacificForm ed = new EditSpacificForm("Drink");
				ed.show();
			}
		});
		m_AddDrinkProudct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		m_AddDrinkProudct.setBounds(12, 149, 205, 33);
		getContentPane().add(m_AddDrinkProudct);
		
		JButton m_VegetablesProudct = new JButton("Add Veget Proudct");
		m_VegetablesProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				EditSpacificForm ed = new EditSpacificForm("Vegetables");
				ed.show();
			}
		});
		m_VegetablesProudct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		m_VegetablesProudct.setBounds(12, 212, 205, 33);
		getContentPane().add(m_VegetablesProudct);
		
		JButton btnAddManger = new JButton("Add Manger");
		btnAddManger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EditSpacificForm ed = new EditSpacificForm("Manger");
				ed.InitLine();
				ed.show();
			}
		});
		btnAddManger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddManger.setBounds(12, 278, 205, 33);
		getContentPane().add(btnAddManger);
		
		JButton m_AddEmploye = new JButton("Add Employee");
		m_AddEmploye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				EditSpacificForm ed = new EditSpacificForm("Employe");
				ed.InitLine();
				ed.show();
			}
		});
		m_AddEmploye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		m_AddEmploye.setBounds(12, 339, 205, 33);
		getContentPane().add(m_AddEmploye);
		
		JButton btnRemoveFoodProudct = new JButton("Remove Food Proudct");
		btnRemoveFoodProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				RemoveEditForm rm = new RemoveEditForm("Food");
				rm.show();
			}
		});
		btnRemoveFoodProudct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveFoodProudct.setBounds(277, 89, 205, 33);
		getContentPane().add(btnRemoveFoodProudct);
		
		JButton btnRemoveDrinkProudct = new JButton("Remove Drink Proudct");
		btnRemoveDrinkProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				RemoveEditForm rm = new RemoveEditForm("Drink");
				rm.show();
			}
		});
		btnRemoveDrinkProudct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveDrinkProudct.setBounds(277, 149, 205, 33);
		getContentPane().add(btnRemoveDrinkProudct);
		
		JButton btnRemoveVegetProudct = new JButton("Remove Veget Proudct");
		btnRemoveVegetProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				RemoveEditForm rm = new RemoveEditForm("Vegetables");
				rm.show();
			}
		});
		btnRemoveVegetProudct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveVegetProudct.setBounds(277, 212, 205, 33);
		getContentPane().add(btnRemoveVegetProudct);
		
		JButton btnRemoveManger = new JButton("Remove Manger");
		btnRemoveManger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RemoveEditForm rm = new RemoveEditForm("Manger");
				rm.show();
				rm.InitLine();
			}
		});
		btnRemoveManger.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});
		btnRemoveManger.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveManger.setBounds(277, 278, 205, 33);
		getContentPane().add(btnRemoveManger);
		
		JButton btnRemoveEmploye = new JButton("Remove Employee");
		btnRemoveEmploye.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				RemoveEditForm rm = new RemoveEditForm("Employe");
				rm.show();
				rm.InitLine();
			}
		});
		btnRemoveEmploye.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRemoveEmploye.setBounds(277, 339, 205, 33);
		getContentPane().add(btnRemoveEmploye);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				ScreenMagment.EnableMenu();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(165, 405, 170, 33);
		getContentPane().add(btnBack);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}
}
