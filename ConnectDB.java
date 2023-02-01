import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

//import com.mysql.jdbc.Statement;
import com.toedter.calendar.JDateChooser;

import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.io.File;
import java.io.IOException;
public class ConnectDB extends JPanel implements ActionListener {
//DB Connection variables
	 static JLabel label0=new JLabel("");
	 static Connection connection= null;
	 static String databaseName="";//leave this as it is
	 static String url= "jdbc:mysql://localhost:3306/"+ databaseName;//leave this as it is
	 static String username="root";//leave this as it is if you haven't changed your user name from root to something else
	 static String password="ansh2814";//password for your connection,e.g 'a' or whatever it is
	 static JComboBox dd1; 
	 static JComboBox dd2;
	 static JComboBox dd3;
	 static JTextField tf1; 
	 static JTextField tf2; 
	 static JFrame frame1=new JFrame();
	 static JButton button=new JButton();
	 static JFrame frame = new JFrame("K.A.R.D.S. Flights");
	 static String[] columnNames = {"Name", "Id", "Grade"};
	 static JTable table;
	 static JTable table2;
	 static JFrame frame2;
	 static JFrame frame3;
	 static	JLabel jl=new JLabel("Enter the option number to check details :");
	 static JTextField jb=new JTextField("",10);
	 static	JLabel jl2=new JLabel("Enter the option number to check details :");
	 static JTextField jb2=new JTextField("Enter 0 if one-way trip",10);
	 static JButton okbtn;
	 static JDatePickerImpl datePicker1;
	 static JDatePickerImpl datePicker2;
	 static JTextField start;
	 static JTextField end;
	 static JButton cal=new JButton();
	 static JButton confi=new JButton("Book");
	 
 public ConnectDB()
 {
	 Image img=new ImageIcon(this.getClass().getResource("/GUI_DBS.jpg")).getImage();
	 Image x=img.getScaledInstance(label0.getWidth(), label0.getHeight(), Image.SCALE_SMOOTH);
     label0.setIcon(new ImageIcon(x));
      
     Image img2=new ImageIcon(this.getClass().getResource("/search-icon.png")).getImage();
     button.setIcon(new ImageIcon(img2));
     button.setFont(new Font("Tamoha",Font.PLAIN,12));
     button.addActionListener(this);
     Image img3=new ImageIcon(this.getClass().getResource("/Calendar-icon.png")).getImage();
     cal.setIcon(new ImageIcon(img3));
     
 }
            
     
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException , NullPointerException {
		
		Class.forName("com.mysql.jdbc.Driver").newInstance();	
	connection=DriverManager.getConnection( url,username,password);
   //Can write query to insert or delete or update values from here directly, format is given below
	//PreparedStatement ps= connection.prepareStatement("");
	//Enter query in brackets, write all your queries in the 2 functions showTableData and showdetails
	//ResultSet rs = ps.executeQuery(); 
	// for executing the query
	
	
	JLabel label81=new JLabel("Total Passengers:");
	label81.setFont(new Font("Tamoha",Font.PLAIN,15));
	
	JPanel panel0 = new JPanel(new CardLayout());  
	JPanel panel1 = new JPanel();  
    panel1.setLayout(new CardLayout());  
    JPanel panel2 = new JPanel(new FlowLayout()); 
    JPanel panel3 = new JPanel(new FlowLayout());  
    JPanel panel4 = new JPanel(new FlowLayout()); 
    JPanel panel5 = new JPanel(new FlowLayout()); 
    JLabel label1 = new JLabel("Flights");
   
    
    
    String dds1[]= {"One way","Round Trip"};
    dd1=new JComboBox(dds1);//drop down for type of trip, don't include multi-trip
    String dds2[]= {"Adult","Children"};
    dd2=new JComboBox(dds2);//drop down for type of passenger
    String dds3[]= {"Economy","Premium Economy","Business","Fisrt Class"};
    dd3=new JComboBox(dds3);//drop down for type of ticket he/she books
    tf1=new JTextField("Adults(12+)",7);
    tf1.setBounds(50,50, 10,15);
    tf2=new JTextField("Children(0-11)",8);
    tf2.setBounds(50,50, 10,15);
    JLabel label2=new JLabel("Options");
    Dimension size = label1.getPreferredSize();
    start=new JTextField("Delhi",15);//default place of departure
    end=new JTextField("Try Florida",15);//default place of arrival
    UtilDateModel model = new UtilDateModel();
    model.setDate(2020, 8, 24);
    UtilDateModel model2 = new UtilDateModel();
    model2.setDate(2020, 8, 24);
    JDatePanelImpl datePanel = new JDatePanelImpl(model);
    JDatePanelImpl datePanel2 = new JDatePanelImpl(model2);
    datePicker1 = new JDatePickerImpl(datePanel);
    datePicker2 = new JDatePickerImpl(datePanel2);
    JLabel label9=new JLabel("From:");
    JLabel label10=new JLabel("To:");
    
    
    label1.setBounds(80, 800, size.width, size.height);
    panel0.setPreferredSize(new Dimension(600, 100));
    panel1.setPreferredSize(new Dimension(600, 80));
    panel2.setPreferredSize(new Dimension(600, 50));
    panel3.setPreferredSize(new Dimension(600, 50));
    panel4.setPreferredSize(new Dimension(600, 50));
    panel5.setPreferredSize(new Dimension(600, 70));
    
    
    frame.setBackground(Color.WHITE);

    label1.setFont(label1.getFont().deriveFont(54.0f));
    label1.setVerticalTextPosition(JLabel.TOP);
    label1.setHorizontalAlignment( JLabel.CENTER );
   
    panel0.add(label0);
    button.setText("Search");
    button.setBounds(300, 340, 15, 15);
    panel1.add(label1);  
    panel5.add(button);
    panel2.add(dd1);
    //panel2.add(dd2);
    panel2.add(label81);
    panel2.add(tf1);
    panel2.add(tf2);
    panel2.add(dd3);
    panel3.add(label9);
    panel3.add(start);
    panel3.add(label10);
    panel3.add(end);
    panel4.add(cal);
    panel4.add(datePicker1);
    panel4.add(datePicker2);
    
    
    frame.add(panel0);
    frame.setLayout(new FlowLayout());
    frame.add(panel1); 
    frame.add(panel2);
    frame.add(panel3);
    frame.add(panel4);
    frame.add(panel5);
    frame.setSize(600, 500);  
    frame.setLocationRelativeTo(null);  
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    frame.setVisible(true);  
    ConnectDB obj=new ConnectDB();
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	
	try {
		if(ae.getSource()==button)
		{
			showTableData();
			okbtn.addActionListener(this);
			
			
		}
		else if(ae.getSource()==okbtn)
		  {showdetails();
		   confi.addActionListener(this);
		  }
		  
		else if(ae.getSource()==confi)
			confirmBook();
		else
		{
			
		}
		
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


	
	}
	public void confirmBook()
	{
		frame3=new JFrame("Confirm Booking");
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.setLayout(new FlowLayout()); 
		JPanel plast=new JPanel(new FlowLayout());
		JLabel llast=new JLabel("Confirmed Booking");
		plast.add(llast);
		frame3.add(plast);
		 frame3.setVisible(true);
			frame3.setSize(100,100);
	}
	
	public void showdetails() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{ 
		
		frame2=new JFrame("Details of Airlines");
	frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame2.setLayout(new GridLayout(5,1)); 
	 String text=jb.getText();
	 String text2=jb2.getText();
	 int itext=Integer.parseInt(text);//which option number he chose for going
	 int itext2=Integer.parseInt(text2);//which option number he chose for return

	 //For Going
	 
	 Class.forName("com.mysql.jdbc.Driver").newInstance();	
		connection=DriverManager.getConnection( url,username,password);
	    PreparedStatement ps= connection.prepareStatement("select*from world.st");//Enter query written in showTableData() in brackets
		ResultSet rs = ps.executeQuery();
		Statement stmt = (Statement)connection.createStatement();
		int i =0;
		String name= "";//variables for storing details,can ignore 
		String id= "";//variables for storing details,can ignore 
		String grade = "";//variables for storing details,can ignore 
		JPanel p0=new JPanel(new FlowLayout());
		JPanel p4=new JPanel(new FlowLayout());
		JPanel p=new JPanel(new FlowLayout());
		JLabel res=new JLabel("");
		String query1="";
		String query2="";
		while(rs.next())
		{ 
		 i++;
		}
		 ps= connection.prepareStatement("select*from world.st");//Enter the same query written above
		 rs = ps.executeQuery();
		 int j=1,flag=0;
	   if((itext<=i)&&(itext>=1)) //for valid entries
		   
	   { 
		   while(rs.next())
	   
		   {
			   if(j==itext)
	   
			   { flag=1;
				   res.setText("Valid Entry for Departure Ticket");
				   JLabel res1=new JLabel(rs.getString("st_name"));//to print details if there is a valid entry,just change the attribute name in brackets
				   JLabel res2=new JLabel(rs.getString("st_id"));//to print details if there is a valid entry,just change the attribute name in brackets
				   JLabel res3=new JLabel(rs.getString("grade"));//to print details if there is a valid entry,just change the attribute name in brackets
				   p0.add(res);
				   p.add(res1);
				   p.add(res2);
				   p.add(res3);
				   
					
			   }
			   
			   j++;
	   }
	   }
	     
	   else//for invalid entries
	   {
	    res.setText("Invalid Entry for Departure Ticket");
	    p0.add(res);
	   }
	
	   if(flag==1)
	   {   //query1= "";//Enter the updation query
		 
		//   stmt.executeUpdate(query1);//to execute update query
	      
	   }
	   
	   
	   //For Return
	   PreparedStatement ps2= connection.prepareStatement("select*from world.st");//Enter query written in showTableData() in brackets
		ResultSet rs2 = ps.executeQuery();
		Statement stmt2 = (Statement)connection.createStatement();
		int i2 =0;
		String name2= "";//variables for storing details,can ignore 
		String id2= "";//variables for storing details,can ignore 
		String grade2 = "";//variables for storing details,can ignore 
		JPanel p2=new JPanel(new FlowLayout());
		JPanel p3=new JPanel(new FlowLayout());
		JLabel res4=new JLabel("");
		while(rs2.next())
		{ 
		 i2++;
		}
		 ps2= connection.prepareStatement("select*from world.st");//Enter the same query written above
		 rs2 = ps2.executeQuery();
		 int j2=1,flag2=0;
	   if((itext2<=i2)&&(itext2>=1)) //for valid entries
		   
	   { 
		   while(rs2.next())
	   
		   {
			   if(j2==itext2)
	   
			   { flag2=1;
				   res4.setText("Valid Entry for Return Ticket");
				   JLabel res5=new JLabel(rs2.getString("st_name"));//to print details if there is a valid entry,just change the attribute name in brackets
				   JLabel res6=new JLabel(rs2.getString("st_id"));//to print details if there is a valid entry,just change the attribute name in brackets
				   JLabel res7=new JLabel(rs2.getString("grade"));//to print details if there is a valid entry,just change the attribute name in brackets
				   p2.add(res4);
				   p3.add(res5);
				   p3.add(res6);
				   p3.add(res7);
				   p4.add(confi);
					
			   }
			   
			   j2++;
	   }
	   }
	   else if(itext==0)
	   {
	   
	   }
	     
	   else//for invalid entries
	   {
	    res4.setText("Invalid Entry for Return Ticket");
	    p2.add(res4);
	   }
	
	   if(flag2==1)
	   {   //query2= "";//Enter the updation query
		 
		   //stmt2.executeUpdate(query2);//to execute update query
	      
	   }
	  
	   frame2.add(p0);
	   frame2.add(p);
	   frame2.add(p2);
	   frame2.add(p3);
	   frame2.add(p4);
	   frame2.setVisible(true);
		frame2.setSize(600,250);
	 
	}
	
	
	public void showTableData() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		
		
	frame1 = new JFrame("Database Search Result");
	frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame1.setLayout(new GridLayout(4,1)); 
	
	DefaultTableModel model = new DefaultTableModel();
	model.setColumnIdentifiers(columnNames);
	table = new JTable();
	table.setModel(model); 
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setFillsViewportHeight(true);
	JScrollPane scroll = new JScrollPane(table);
	
	DefaultTableModel model2 = new DefaultTableModel();
	model2.setColumnIdentifiers(columnNames);
	table2 = new JTable();
	table2.setModel(model2); 
	table2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table2.setFillsViewportHeight(true);
	JScrollPane scroll2 = new JScrollPane(table2);
	
	JPanel p1=new JPanel(new BorderLayout());
    JPanel p2=new JPanel(new FlowLayout());
    JPanel p3=new JPanel(new BorderLayout());
    JPanel p4=new JPanel(new FlowLayout());
    Date d1=new Date();
    Date d2=new Date();
    d1=(Date)datePicker1.getModel().getValue();//day of travel 
    d2=(Date)datePicker2.getModel().getValue();//day of return , ignore if not a round trip
    String sdes=start.getText();
    String edes=end.getText();
    String trip_type=(String) dd1.getSelectedItem();//One way or round trip
    //String pass_type=(String) dd2.getSelectedItem();//Adult or child
    String seat_type=(String) dd3.getSelectedItem();//Economy or any other

	int textvalue = Integer.parseInt(tf1.getText());//number of adult passengers
	int textvalue2 = Integer.parseInt(tf2.getText());//number of infant passengers
	String name= "";
	String id= "";
	String grade = "";
	
	Class.forName("com.mysql.jdbc.Driver").newInstance();	
	connection=DriverManager.getConnection( url,username,password);
    PreparedStatement ps= connection.prepareStatement("select*from world.st");//Enter display query in brackets for going
	ResultSet rs = ps.executeQuery();
	int i =0;
	while(rs.next())//for going
	{
	name = rs.getString("st_name");
	id = rs.getString("st_id");
	grade = rs.getString("grade");
	model.addRow(new Object[]{name,id,grade});
	i++; 
	}
	//String queryf="{}"; // if no return value
	//String queryf="?={}"; // if return value
	//CallableStatement stmt=connection.prepareCall(queryf);//for functions
	//rs=stmt.executeQuery();//for executing functions, pass parameters in executeQuery()
	 PreparedStatement ps2= connection.prepareStatement("select*from world.st");//Enter display query in brackets for return
		ResultSet rs2 = ps2.executeQuery();
		i =0;
		while(rs2.next())//for return
		{
		name = rs2.getString("st_name");
		id = rs2.getString("st_id");
		grade = rs2.getString("grade");
		model2.addRow(new Object[]{name,id,grade});
		i++; 
		}
	
	p1.add(scroll);

	okbtn=new JButton("Confirm");
    p2.add(jl);
	p2.add(jb);
	p3.add(scroll2);
	p4.add(jl2);
    p4.add(jb2);
    p4.add(okbtn);
   
	frame1.add(p1);
	frame1.add(p2);
	frame1.add(p3);
	frame1.add(p4);
	frame1.setVisible(true);
	frame1.setSize(400,700);
	}
	
	
	}

