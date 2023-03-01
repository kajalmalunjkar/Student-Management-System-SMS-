package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

public class SMS_Operation {

	

	public static <First> void main(String[] args)throws NumberFormatException, IOException, SQLException, ParseException{
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("==============================WELCOME TO STUDENT MANAGEMENT SYSTEM (SMS)=======================================");
		System.out.println("---------------------------------------------------------------------------------------------------------------");
	
	
		System.out.println("1 -> Student Portal");
	    System.out.println("2 -> Admin Portal");
	    System.out.println("---------------------------------------------------------------------------------------------------------------");
    	System.out.println("\t\t Enter Your Choice:");
	    int choice = Integer.parseInt(br.readLine());
	    
	    if(choice==1)
		{
			System.out.println("---------------------------------------------------------------------------------------------------------------");
			System.out.println("1 -> Create New Account");
	        System.out.println("2 -> Login");
		    System.out.println("3 -> Exist");
	    	System.out.println("---------------------------------------------------------------------------------------------------------------");
	    	System.out.println("\t\t Enter Your Choice:");
		    choice = Integer.parseInt(br.readLine());
		    if(choice==1){
	    	System.out.println("================================================Create New Account==============================================");
			 System.out.println("Enter First_Name");
			String First_Name=br.readLine();
			 System.out.println("Enter Last_Name");
			String Last_Name=br.readLine();
			 System.out.println("Enter Phone no");
			String Phoneno=br.readLine();
			 System.out.println("Enter Email Address");
			String Email=br.readLine();
			 System.out.println("Enter User Id");
			 Long Id = Long.parseLong(br.readLine());
			 System.out.println("Enter Password");
			String Password=br.readLine();
			 System.out.println("Enter Age");
			String Age=br.readLine();
			 System.out.println("Enter DOB");
			String DOB=br.readLine();
			 System.out.println("Enter Gender");
				String Gender=br.readLine();
			 System.out.println("Enter Qualication");
			String Qualification=br.readLine();
			 System.out.println("Enter Signature");
				String Signature=br.readLine();
			System.out.println("---------------------------------------------------------------------------------------------------------------");
		
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from account where User Id=?");
			ps.setString(1,First_Name);
			ResultSet result=ps.executeQuery();
			String password=null;
			
			System.out.println("Account Created Successfully!!");
			
			 System.out.println("Do you want to continue??(Y/N)");
			 String status = br.readLine();
			 System.out.println("---------------------------------------------------------------------------------------------------------------");				

		}
		   
	    
	    else if(choice==2)
		{
	    	System.out.println("---------------------------------------------------------------------------------------------------------------");				
			System.out.println("===============================================ENTER LOGIN DETAILS=============================================");
			System.out.println("---------------------------------------------------------------------------------------------------------------");				

			System.out.print("\t\t Enter your username:");
			String userName=br.readLine();
			System.out.print("\t\t Enter your password:");
			String userPassword=br.readLine();
			System.out.println("---------------------------------------------------------------------------------------------------------------");				

			
			
			Connection conn=MysqlConnection.getConnection();
			PreparedStatement ps=conn.prepareStatement("select * from Student where user_Id=?");
			ps.setString(1,userName);
			ResultSet result=ps.executeQuery();
			String password=null;
				
				while(result.next())
				{
					password=result.getString("User_Password");
				}
				
				if(userPassword.equals(password))
				{
							
				System.out.println("You have Successfully login!!");
				
				
				boolean login=true;
				do
				 {
				
				System.out.println("---------------------------------------------------------------------------------------------------------------");				
                System.out.println("======================================== WELCOME " + userName.toUpperCase() + "================================");
                System.out.println("---------------------------------------------------------------------------------------------------------------");				
				System.out.println("1  --->   New Addmission");
				System.out.println("2  --->   Availabe Course");
				System.out.println("3  --->   Enroll Course");
				System.out.println("4  --->   Payment");
				System.out.println("5  --->   Payment status");
				System.out.println("6  --->   Change Password");
				System.out.println("7  --->   Student Details");
				System.out.println("8 --->    Exit / Logout");
				System.out.println("---------------------------------------------------------------------------------------------------------------");				
				System.out.print("\t\t Enter your choice:"); 
				int operationNumber=Integer.parseInt(br.readLine());
				System.out.println("---------------------------------------------------------------------------------------------------------------");				

				
				String status=null;
				
				switch(operationNumber)
				{
					case 1: 
					System.out.println("\t\t New Admission ");
					
					System.out.println("Enter Your S_Id :");
					Long S_Id = Long.parseLong(br.readLine());
					
					System.out.println("Enter Your Full Name :");
					String fullname=br.readLine();
							
					System.out.println("Enter Your Parents Name :");
					String pname=br.readLine();
					
					System.out.println("Enter Your Contact No :");
				    Long mobile=Long.parseLong(br.readLine());
				      
				    System.out.println("Enter Your Email Id :");
					String email=br.readLine();
						
					System.out.println("Enter Your Date Of Birth :");
					String dob=br.readLine();
					
					System.out.println("Enter Your Gender :");
					String gender=br.readLine();
					
					System.out.println("Enter Your Aadhar No :");
					Long aadhar=Long.parseLong(br.readLine());
					
					System.out.println("Enter Your Address :");
					String address=br.readLine();
					
					System.out.println("Enter Your State:");
					String state=br.readLine();
					
					System.out.println("Enter Your Country :");
					String country=br.readLine();
					
					System.out.println("Enter Your Course :");
					String course=br.readLine();
					
					System.out.println("Enter Your Coursefee :");
					String coursefee=br.readLine();
					
					System.out.println("Enter Your Signature :");
					String signature=br.readLine();
				
						
				    conn=MysqlConnection.getConnection();
				    ps=conn.prepareStatement("select * from newadmission where user_Id=?");
					ps.setString(1,userName);
				    result=ps.executeQuery();
					password=null;
				
					
				    
		            PreparedStatement ps1=conn.prepareStatement("insert into newadmission values(?,?,?,?,?,?,?,?,?,?,?,?) ");
		            ps1.setString(1, fullname);
		            ps1.setString(2, pname);
		            ps1.setDouble(3, mobile);
		            ps1.setString(4, email);
		            ps1.setString(5, dob);
		            ps1.setString(6, gender);
		            ps1.setLong(7, aadhar);
		            ps1.setString(8,address);
		            ps1.setString(9, state);
		            ps1.setString(10, course);
		            ps1.setString(11, coursefee);
		            ps1.setString(12, signature);
		            
                     ps.executeUpdate();
					
					
					System.out.println("Record Updated successfully!!");
					
					
				     System.out.println("Do you want to continue??(Y/N)");
					 status=br.readLine();
					 
					 if(status.equals("n") || status.equals("N"))
						{
							login=false;
						}
					 
					 break;
					 
					 
			 case 2:
			 
			    				
                 System.out.println("===================================== WELCOME " + userName.toUpperCase() + "====================================");
                 System.out.println("---------------------------------------------------------------------------------------------------------------");
			  
                 conn=MysqlConnection.getConnection();
		         ps=conn.prepareStatement("select * from Student where user_Id=?");
			   ps.setString(1,userName);
				 result=ps.executeQuery();
				 
			  while(result.next())
				  
			  {
				   
				  System.out.println("Available Courses");
				  System.out.println("---------------------------------------------------------------------------------------------------------------");
                  System.out.println("BE");
                  System.out.println("B.Tech");
                  System.out.println("BSC");
                  System.out.println("BCA");
                  System.out.println("B.Pharm");
                  System.out.println("BCS");
			  }  
			  
			  
			  System.out.println("Do you want to continue??(Y/N)");
			     status=br.readLine();
						 
			    if(status.equals("n") || status.equals("N"))
					 {
						login=false;
					 }
	      break;
                 
                
			 case 3: 
				 
				    System.out.println("---------------------------------------------------------------------------------------------------------------");				
	                System.out.println("=======================================WELCOME " + userName.toUpperCase() + "=====================================");
	                System.out.println("---------------------------------------------------------------------------------------------------------------");
				 
	                conn=MysqlConnection.getConnection();
			         ps=conn.prepareStatement("select * from Student where user_Id=?");
					ps.setString(1,userName);
					 result=ps.executeQuery();
					
					 System.out.print("please enter course name: ");
					 String coursename=br.readLine();
	                
				   if(coursename.equals("BE")||coursename.equals("B.Tech")||coursename.equals("BSC")||coursename.equals("BCA")
						   ||coursename.equals("BFarm")||coursename.equals("BCS"))
				   {
					   System.out.println("Enter Course Is Available.Please Enroll!!!");
				   }
				    
				   
				    else 
				    {
				    	System.out.println("Another Course is not available in our Institute.Please choose available course!!!.");
				    }
				      
				    	 
				          
				     System.out.println("Do you want to continue??(Y/N)");
				     status=br.readLine();
							 
				    if(status.equals("n") || status.equals("N"))
						 {
							login=false;
						 }
		      break;
				     
			  case 4:	
				
				  System.out.println("---------------------------------------------------------------------------------------------------------------");				
	               System.out.println("===================================== WELCOME " + userName.toUpperCase() + "===================================");
	               System.out.println("---------------------------------------------------------------------------------------------------------------");
				   
	               System.out.println(" Do you want to pay for... ");
	               System.out.println("\t                 Registration Fees");
	               System.out.println("\t                 Examination Fees");
	               System.out.println("\t                 Tution Fees ");
	               System.out.println("\t                 Hostel Fees");
	               System.out.println("\t                 NoDues Fees");
	               System.out.println("\t                 others.....?");
	               status=br.readLine();
	               
	               if(status.equals("n") || status.equals("N"))
	               {
	            	   login=false;
	            	   break;
	               }
	               System.out.println("---------------------------------------------------------------------------------------------------------------");
	               System.out.println("\t Name");
	               System.out.println("1  --->  Registration Fees");
	               System.out.println("2  --->  Exmination Fees");
	               System.out.println("3  --->  Tution Fees");
	               System.out.println("4  --->  Hostel Fees");
	               System.out.println("5  --->  NoDues Fees");
	               System.out.println("6  --->  Others");
	               System.out.println("---------------------------------------------------------------------------------------------------------------");
	               System.out.print("\t\t Enter your choice:"); 
				   operationNumber=Integer.parseInt(br.readLine());
				   System.out.println("---------------------------------------------------------------------------------------------------------------");
	              
				   System.out.println("Please Enter Relavent Account Id:");
				   Long accid=Long.parseLong(br.readLine());
				   
				   System.out.println("Please Enter Ammount:");
				   Double ammount=Double.parseDouble(br.readLine());
				   
				   
				   
	               conn=MysqlConnection.getConnection();
			         ps=conn.prepareStatement("select * from Student where user_Id=?");
				   ps.setString(1,userName);
					 result=ps.executeQuery();
					 
					 double balance=0.0;
					 long accId=0;
					 while(result.next())
						{
							balance=result.getDouble("accBalance");
							accId=result.getLong("accId");
						}
						
						System.out.println("Do you want to continue??(Y/N)");
						status=br.readLine();
							
							if(status.equals("n") || status.equals("N"))
							{
								login=false;
							}
							
					break;
					
			  case 5 :
				
				  conn=MysqlConnection.getConnection();
			         ps=conn.prepareStatement("select * from Student where user_Id=?");
				   ps.setString(1,userName);
					 result=ps.executeQuery();
					 
				  while(result.next())
					  
				  {
					  System.out.println("---------------------------------------------------------------------------------------------------------------"); 
					  System.out.println("Payment Details :");
					  System.out.println("---------------------------------------------------------------------------------------------------------------");
					  System.out.println("Account Id:" + result.getLong("accid"));
					  System.out.println("Account Name:" + result.getString("accName"));
					  System.out.println("Account Type:" + result.getLong("accType"));
					  System.out.println("Gender:" + result.getString("Gender"));
					  System.out.println("Date of Birth:" + result.getDate("dob"));
					  System.out.println("Email:" + result.getString("Email"));
					  System.out.println("Phone:" + result.getLong("phone"));
					  System.out.println("---------------------------------------------------------------------------------------------------------------");
				  
					  while(result.next())
						{
						  System.out.println(result.getString("AccountId")+
									"\t"+result.getString("accName")+
									"\t"+result.getString("accType")+
									"\t"+result.getString("Gender")+
									"\t"+result.getDate("dob")+
									"\t"+result.getString("Email")+
									"\t"+result.getLong("phone"));
						}
				  
				 }
				
				     System.out.println("Do you want to continue??(Y/N)");
				     status=br.readLine();
					
					if(status.equals("n") || status.equals("N"))
					{
						login=false;
					}
					
			break;
				   
				  
			  case 6:
				 
				  System.out.println("Please enter the existing password: ");
					String existingPassword=br.readLine();
					
					System.out.println("Set new Password:");
					String newPassword=br.readLine();
					
					System.out.println("Retype new password:");
					String retypePassword=br.readLine();
					
					
					ps=conn.prepareStatement("select userPassword from accounts where userName=?");
					ps.setString(1, userName);
					
					result=ps.executeQuery();
					String accountPassword=null;
					while(result.next())
					{
						accountPassword=result.getString("userPassword");
					}
					
					if(accountPassword.equals(existingPassword))
					{
						if(newPassword.equals(retypePassword))
						{
							ps=conn.prepareStatement("update accounts set userPassword=? where userName=?");
							ps.setString(1, newPassword);
							ps.setString(2, userName);
							
							if(ps.executeUpdate()>0)
							{
								 System.out.println("---------------------------------------------------------------------------------------------------------------");				
								System.out.println("Passowrd Changed!!");
								 System.out.println("---------------------------------------------------------------------------------------------------------------");
							}
							
							else
							{
								System.out.println("---------------------------------------------------------------------------------------------------------------");				
								System.out.println("Error in password change!!");
								 System.out.println("---------------------------------------------------------------------------------------------------------------");				
								
							}
						}
						else
						{
							System.out.println("---------------------------------------------------------------------------------------------------------------");				
							System.out.println("Set new password and retype password must be same!!");
							 System.out.println("---------------------------------------------------------------------------------------------------------------");				
							
						}
					}
					else
					{
						System.out.println("---------------------------------------------------------------------------------------------------------------");				
						System.out.println("Please enter correct existing password!!");
						System.out.println("---------------------------------------------------------------------------------------------------------------");				
						
			
					}
					
					System.out.println("Do you want to continue??(Y/N)");
					status=br.readLine();
					 System.out.println("---------------------------------------------------------------------------------------------------------------");				

					if(status.equals("n") || status.equals("N"))
					{
						login=false;
					}
				  
					break;
					
			  case 7:
				    System.out.println("---------------------------------------------------------------------------------------------------------------");				
					System.out.println("===============================================Student Details=================================================");
				    System.out.println("---------------------------------------------------------------------------------------------------------------");
					System.out.println("Enter Student Full Name :");
					fullname=br.readLine();
							
					System.out.println("Enter Student Parents Name :");
					 pname=br.readLine();
					
					System.out.println("Enter Student Contact No :");
				   mobile=Long.parseLong(br.readLine());
				      
				    System.out.println("Enter StudentEmail Id :");
					email=br.readLine();
						
					System.out.println("Enter Student Date Of Birth :");
				    dob=br.readLine();
					
					System.out.println("Enter Student Gender :");
					gender=br.readLine();
					
					System.out.println("Enter Student Aadhar No :");
					aadhar=Long.parseLong(br.readLine());
					
					System.out.println("Enter Student Address :");
					 address=br.readLine();
					
					System.out.println("Enter Student State:");
					state=br.readLine();
					
					System.out.println("Enter Student Country :");
					country=br.readLine();
					
					System.out.println("Enter Student Course :");
					course=br.readLine();
					
					System.out.println("Enter Student Coursefee :");
				    coursefee=br.readLine();
					
					System.out.println("Enter Student Signature :");
					signature=br.readLine();
				
						
			        conn=MysqlConnection.getConnection();
			         ps=conn.prepareStatement("select * from Student where user_Id=?");
					ps.setString(1,userName);
					 result=ps.executeQuery();
				
					
				    
		            ps1=conn.prepareStatement("insert into newAdmission values(?,?,?,?,?,?,?,?,?,?,?,?) ");
		            ps1.setString(1, fullname);
		            ps1.setString(2, pname);
		            ps1.setDouble(3, mobile);
		            ps1.setString(4, email);
		            ps1.setString(5, dob);
		            ps1.setString(6, gender);
		            ps1.setLong(7, aadhar);
		            ps1.setString(8,address);
		            ps1.setString(9, state);
		            ps1.setString(10, course);
		            ps1.setString(11, coursefee);
		            ps1.setString(12, signature);
		            
                   ps.executeUpdate();
					
					
					System.out.println(" successfully!!");
		            
					 		
					 System.out.println("Do you want to continue??(Y/N)");
					 status=br.readLine();
					 
					 if(status.equals("n") || status.equals("N"))
						{
							login=false;
						}
					 
					 break;
					 
				   
			       case 8:  login=false;
			   	   
			        break;
		
			
				
		           default:System.out.println("Wrong Input!!");		
					

	                  
				}
                   }
	                     while(login);
	                     System.out.println("--------------------------------------------------------------------------------------------------------------");			
	                     System.out.println("Bye.");
          	             System.out.println("Have a nice day!!");
          	           System.out.println("----------------------------------------------------------------------------------------------------------------");			

                      }
				
                     else
                        {
                    	 System.out.println("---------------------------------------------------------------------------------------------------------------");				
	                     System.out.println("Wrong username/password!!");
	                     System.out.println("---------------------------------------------------------------------------------------------------------------");
  
                        }

		}
                      
				 
				 
	
				else if(choice==3)
						 
					        {
						
						     System.out.println("---------------------------------------------------------------------------------------------------------------");
							 System.out.println("=======================================================Exist===================================================");
							 System.out.println("---------------------------------------------------------------------------------------------------------------");
					        }

				
				 
				
				 }
	       else
	             {
	    	
	    	   System.out.println("--------------------------------------------------------------------------------------------------------------");
		                   	System.out.println("===========================================ENTER LOGIN DETAILS===================================");
			                System.out.print("\t\t Enter your username:");
		                  	String userName=br.readLine();
		                 	System.out.print("\t\t Enter your password:");
			                String userPassword=br.readLine();
			                System.out.println("--------------------------------------------------------------------------------------------------------------");
			
			                Connection conn=MysqlConnection.getConnection();
		                   	PreparedStatement ps=conn.prepareStatement("select * from admin where userName=?");
			                ps.setString(1,userName);
			                ResultSet result=ps.executeQuery();
			                String password=null;
				
			             	while(result.next())
			                {
			                   password=result.getString("password");
			               	}
			
			
			                      if(userPassword.equals(password))
			                        
			                       {
			
			                   System.out.println("You have successfully logged in!!");
				
			                   boolean login=true;
			                   do
			                     {
			
			            System.out.println("--------------------------------------------------------------------------------------------------------------");
			            System.out.println("========================================= WELCOME " + userName.toUpperCase() + "==============================");
			            System.out.println("--------------------------------------------------------------------------------------------------------------");
		             	System.out.println("1  --->   Open new Account");
		             	System.out.println("2  --->   Close account");
		             	System.out.println("3  --->   View transactions");
			            System.out.println("4  --->   Exit / Logout");
			            System.out.println("--------------------------------------------------------------------------------------------------------------");				
			            System.out.print("\t\t Enter your choice:"); 
			            int operationNumber=Integer.parseInt(br.readLine());
			            System.out.println("--------------------------------------------------------------------------------------------------------------");
			
			
			            String status=null;
			            		
			            		switch(operationNumber)
			        			{
			        				case 1: System.out.println("Enter Customer full name:");
			        						String name=br.readLine();
			        						
			        						System.out.println("Enter user name");
			        						String uname=br.readLine();
			        						
			        						System.out.println("Enter First name");
			        						String fname=br.readLine();
			        						
			        						System.out.println("Enter Last name");
			        						String lname=br.readLine();
			        						
			        						System.out.println("Enter Qualification");
			        						String qualification=br.readLine();
			        						
			        						
			        						System.out.println("Enter gender:");
			        						String gender=br.readLine();
			        						
			        						System.out.println("Enter date of birth:(dd/MM/YYYY)");
			        						String dob=br.readLine();
			        						
			        						System.out.println("Enter email:");
			        						String email=br.readLine();
			        						
			        						System.out.println("Enter phone number:");
			        						long phone=Long.parseLong(br.readLine());
			        						
			        						
			        						System.out.println("Set account password");
			        						String accPassword=br.readLine();
			        						
			        						System.out.println("Retype password:");
			        						String rePassword=br.readLine();
			        						
			        						System.out.println("Set account Id:");
			        						long accId=Long.parseLong(br.readLine());
			        						
			        						System.out.println("Account type:");
			        						String accType=br.readLine();
			        						
			        						System.out.println("Enter initial balance:");
			        						double balance=Double.parseDouble(br.readLine());
			        						
			        						System.out.println("Enter IFSC code");
			        						String ifsc=br.readLine();
			        						
			        						System.out.println("Enter Age:");
			        						double age=Double.parseDouble(br.readLine());
			        						
			        						ps=conn.prepareStatement("insert into account values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			        						ps.setLong(1, accId);
			        						ps.setString(2,name);
			        						ps.setString(3,fname);
			        						ps.setString(4,lname);
			        						ps.setString(5, accType);
			        						ps.setString(6, uname);
			        						ps.setString(7, accPassword);
			        						ps.setDouble(8, age);
			        						ps.setLong(9, phone);
			        						ps.setString(10, email);
			        						ps.setString(11, ifsc);
			        						ps.setString(12, gender);
			        						ps.setDouble(13, age);
			        						
			        						
			        						SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/YYYY");
			        						java.util.Date utilDate=formatter.parse(dob);
			        					    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			        						ps.setDate(14,sqlDate);
			        						ps.setString(15, qualification);
			        						
			        						
			        						
			        						
			        						
			        						if(ps.executeUpdate()>0)
			        						{
			        							System.out.println("==============================================================================");				
			        							System.out.println("New account created successfully!!");
			        							System.out.println("==============================================================================");				
			        						
			        						}
			        						else
			        						{
			        							System.out.println("--------------------------------------------------------------------------------------------------------------");
			        							System.out.println("Problem in account creation!!");
			        							System.out.println("--------------------------------------------------------------------------------------------------------------");
			        							
			        						}
			        						

			        						System.out.println("Do you want to continue??(Y/N)");
			        						status=br.readLine();
			        						
			        						if(status.equals("n") || status.equals("N"))
			        						{
			        							login=false;
			        						}
			        						
			        						break;   
			        						
			        				case 2: 
			        					
			        				System.out.println("Enter account Id:");	
									accId=Long.parseLong(br.readLine());
									
									ps=conn.prepareStatement("delete from account where accId =?");
									ps.setLong(1, accId);
									
									if(ps.executeUpdate()>0)
									{
										System.out.println("--------------------------------------------------------------------------------------------------------------");
										System.out.println("Account closed successfully!!");
										System.out.println("--------------------------------------------------------------------------------------------------------------");
										
									}
									else
									{
										System.out.println("--------------------------------------------------------------------------------------------------------------");
										System.out.println("Account id does not exist!!");
										System.out.println("--------------------------------------------------------------------------------------------------------------");
										
								
									}
									System.out.println("Do you want to continue??(Y/N)");
									status=br.readLine();
									
									if(status.equals("n") || status.equals("N"))
									{
										login=false;
									}
									
								 break;
			        				case 3:	ps=conn.prepareStatement("select * from transactions");
									result=ps.executeQuery();
									System.out.println("--------------------------------------------------------------------------------------------------------------");
									System.out.println("TransactionId \t Amount \t Date \t Type ");
									System.out.println("--------------------------------------------------------------------------------------------------------------");
										while(result.next())
									{
										System.out.println(result.getString("transactionId")+"\t"+result.getDouble("transactionAmount")+"\t"+result.getDate("transactiondate")+"\t"+result.getString("transactionType"));
									}
										System.out.println("--------------------------------------------------------------------------------------------------------------");
										System.out.println("Do you want to continue??(Y/N)");
									status=br.readLine();
									
									if(status.equals("n") || status.equals("N"))
									{
										login=false;
									}
									break;	
							case 4:	login=false;
							 		break;
				
							default:System.out.println("--------------------------------------------------------------------------------------------------------------");
								 
								    System.out.println("Wrong Input!!");	
								    System.out.println("--------------------------------------------------------------------------------------------------------------");
									System.out.println("Do you want to continue??(Y/N)");
									status=br.readLine();
									
									if(status.equals("n") || status.equals("N"))
									{
										login=false;
									}	
									break;
									
									
						}
						
						
						}
						while(login);
			            System.out.println("--------------------------------------------------------------------------------------------------------------");
			            System.out.println("Bye.");
						System.out.println("Have a nice day!!");
						
					}
					else if(password==null)
					{
						System.out.println("--------------------------------------------------------------------------------------------------------------");
										
						System.out.println("Username does not exist!!");
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						
					}
					else
					{
						System.out.println("--------------------------------------------------------------------------------------------------------------");				
						System.out.println("Wrong password!!");
						System.out.println("--------------------------------------------------------------------------------------------------------------");
						
					}
					
								 
			     
	    	
			
			
	    	
	    
	    	
	    	
	    	
	    	
	    	
	    	
			        			
	    	
	    }
	
	 }

	}
		          
		
				
	
	
	


	

	
	

	   