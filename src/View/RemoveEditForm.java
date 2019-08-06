package View;

import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RemoveEditForm extends JFrame
{
	private JTextField name;
	private JTextField number;
	private JLabel m_numberlabel;
	
	public RemoveEditForm(String i_Name) 
	{
		setBounds(new Rectangle(500, 500, 500, 500));
		setResizable(false);
		this.setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblAddremove = new JLabel("Remove "+i_Name);
		lblAddremove.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddremove.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAddremove.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddremove.setBounds(125, 13, 242, 29);
		getContentPane().add(lblAddremove);
		
		name = new JTextField();
		name.setBounds(240, 106, 242, 22);
		getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblEnterName = new JLabel("Enter Name of "+i_Name+" :");
		lblEnterName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnterName.setBounds(27, 109, 201, 19);
		getContentPane().add(lblEnterName);
		
		JButton btnAdd = new JButton("Remove");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(!name.getText().equals(""))
				{
					if(i_Name.contentEquals("Food"))
					{
						if(ScreenMagment.IsExitsInList(name.getText(), i_Name))
						{
							ScreenMagment.RemoveProudctToList(name.getText(), i_Name);
							JOptionPane.showMessageDialog(null,"Edit success");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"InVaild");
							dispose();
						}
					}
					else if(i_Name.contentEquals("Drink"))
					{
						if(ScreenMagment.IsExitsInList(name.getText(), i_Name))
						{
							ScreenMagment.RemoveProudctToList(name.getText(), i_Name);
							JOptionPane.showMessageDialog(null,"Edit success");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"InVaild");
							dispose();
						}
					}
					else if(i_Name.contentEquals("Vegetables"))
					{
						if(ScreenMagment.IsExitsInList(name.getText(), i_Name))
						{
							ScreenMagment.RemoveProudctToList(name.getText(), i_Name);
							JOptionPane.showMessageDialog(null,"Edit success");
							dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(null,"InVaild");
							dispose();
						}
					}
					else if(!number.getText().equals(""))
					{
						if(ScreenMagment.IsExitsEmploye(number.getText()))
						{
							if(i_Name.contentEquals("Manger"))
							{
								ScreenMagment.RemoveEmploye(number.getText());
								JOptionPane.showMessageDialog(null,"Edit success");
								dispose();
							}
							else if(i_Name.contentEquals("Employe"))
							{
								ScreenMagment.RemoveEmploye(number.getText());
								JOptionPane.showMessageDialog(null,"Edit success");
								dispose();
							}
						}
						else
						{
							JOptionPane.showMessageDialog(null,"InVaild");
							dispose();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"InVaild");
						dispose();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"InVaild");
					dispose();
				}
			}
			
		});
		btnAdd.setBounds(189, 343, 97, 25);
		getContentPane().add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				dispose();
			}
		});
		btnBack.setBounds(189, 393, 97, 25);
		getContentPane().add(btnBack);
		
		JLabel label = new JLabel("Enter ID number ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		m_numberlabel = label;
		m_numberlabel.setVisible(false);
		label.setBounds(27, 149, 201, 19);
		getContentPane().add(label);
		
		number = new JTextField();
		number.setVisible(false);
		number.setColumns(10);
		number.setBounds(240, 146, 242, 22);
		getContentPane().add(number);
		
		Image img = new ImageIcon(this.getClass().getResource("/woodenMenu.png")).getImage();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(img));
		lblNewLabel_1.setBounds(0, 0, 494, 465);
		getContentPane().add(lblNewLabel_1);
	}
	
	public void InitLine()
	{
		m_numberlabel.setVisible(true);
		number.setVisible(true);
	}
}