package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.Order;
import Controller.Proudct;

public class SpacificProudctForm extends JFrame
{
	private JTextField textField;
	private JLabel m_NumberOrder;
	private JLabel m_OrderStatus;
	String[] columnNames = { "Name", "Amount"};
	private JTable table_1;
	private JScrollPane scrollPane ;
	
	public SpacificProudctForm() 
	{
		setResizable(false);
		setBounds(new Rectangle(500, 500, 500, 500));
		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		
		JLabel lblSearchOrder = new JLabel("Search Proudct StorageRoom");
		lblSearchOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearchOrder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSearchOrder.setBounds(73, 13, 264, 25);
		getContentPane().add(lblSearchOrder);
		
		JLabel lblEnterOrderNumber = new JLabel("Enter Product Name :");
		lblEnterOrderNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterOrderNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterOrderNumber.setBounds(12, 71, 162, 16);
		getContentPane().add(lblEnterOrderNumber);
		
		textField = new JTextField();
		textField.setBounds(196, 69, 114, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e)
			{
				if(!textField.getText().equals(""))
				{
					if(ScreenMagment.GetProudct(textField.getText())!=null)
					{	
						Proudct pr = ScreenMagment.GetProudct(textField.getText());
						String data[][] = new String[1][2];
						data[0][0] =  pr.GetName();
						data[0][1] = Integer.toString(pr.GetAmount());
						table_1 = new JTable(data,columnNames);
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setBounds(35, 178, 398, 262);
						getContentPane().add(scrollPane);
						scrollPane.setViewportView(table_1);
						
					}
					else
					{
						textField.setText(null);
						JOptionPane.showMessageDialog(null,"The Proudct is not found");
					}
				}
			}
		});
		btnSearch.setBounds(344, 68, 97, 25);
		getContentPane().add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
			
		});
		btnBack.setBounds(344, 116, 97, 25);
		getContentPane().add(btnBack);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}

}
