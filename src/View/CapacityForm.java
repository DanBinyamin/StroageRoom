package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CapacityForm extends JFrame
{
	  JTable j;
	  private JTable table;

	public CapacityForm() 
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblShowCapacity = new JLabel("Show Capacity");
		lblShowCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		lblShowCapacity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblShowCapacity.setBounds(162, 13, 170, 22);
		getContentPane().add(lblShowCapacity);
		
		String[][] data = ScreenMagment.DataOfCapacity();
		String[] columnNames = { "Name", "Amount"};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(12, 45, 470, 321);
		getContentPane().add(scrollPane);
		
		table = new JTable(data,columnNames);
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
				ScreenMagment.EnableMenu();
			}
		});
		btnBack.setBounds(195, 415, 97, 25);
		getContentPane().add(btnBack);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
		
	}
		

}
