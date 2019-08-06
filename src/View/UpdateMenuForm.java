package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UpdateMenuForm extends JFrame 
{
	public UpdateMenuForm() {
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblUpdateMenu = new JLabel("Update Menu :");
		lblUpdateMenu.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblUpdateMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateMenu.setBounds(169, 13, 150, 29);
		getContentPane().add(lblUpdateMenu);
		
		JButton btnUpdateProudct = new JButton("Update Proudct");
		btnUpdateProudct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				UpdateProudctForm updateform = new UpdateProudctForm();
				updateform.show();
			}
		});
		btnUpdateProudct.setBounds(182, 93, 132, 25);
		getContentPane().add(btnUpdateProudct);
		
		JButton btnUpdateOrder = new JButton("Update Order");
		btnUpdateOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ScreenMagment.ShowSpacificOrder();
			}
		});
		btnUpdateOrder.setBounds(182, 143, 132, 25);
		getContentPane().add(btnUpdateOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				ScreenMagment.EnableMenu();
				dispose();
			}
		});
		btnBack.setBounds(182, 404, 132, 25);
		getContentPane().add(btnBack);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}

}
