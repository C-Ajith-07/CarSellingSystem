package database_project;

import java.sql.Date;
import java.util.Scanner;

public class Car_Selling_System {

	public static void main(String[] args) {
		Scanner getInput = new Scanner(System.in);
		Seller sell = new Seller(1, "ajith", "ajith@123", "seller");
		customer obj = new customer(2, "kumar", "kumar@123", "customer");
		Admin admin = new Admin(3, "head", "head@123", "admin");
//		Data_Manage_Ment data = new Data_Manage_Ment();
		Login login = new Login();

		// Running time
		System.out.println(Color.GREEN+ "\t\t====================================================\n\t     ----> WELCOME TO CAR SELLING SYSTEM <----\n\t====================================================\n"+ Color.RESET);
		int role = 0;
		while (role != 4) {
			// this is user login options
			System.out.println(Color.CYAN + "ENTER YOUR ROLE SIR/MAM TO INVOLVE THIS APPLICATION" + Color.RESET
					+ "\n\t1)admin\n\t2)seller\n\t3)customer\n\t4)exit");
			try {
				role = getInput.nextInt();
			} catch (Exception e) {
				System.out.println(Color.RED + "enter the valid option " + Color.RESET);
				getInput.nextLine();
				continue;
			}
			getInput.nextLine();
			if (role == 1) {
				boolean adminCheck = true;
				loop1: while (adminCheck) {
					System.out.println(Color.CYAN + "ENTER THE ADMIN NAME" + Color.RESET);
					String adminName = getInput.nextLine();
					System.out.println(Color.CYAN + "ENTER THE ADMIN PASSWORD" + Color.RESET);
					String adminPassword = getInput.nextLine();
					adminCheck = login.loginChecking(adminName, adminPassword, 1);
//					System.out.println(adminCheck);
					if (adminCheck) {
//						String adminId = login.getId(adminName , adminPassword);
						int choice = -1;
						while (choice != 0) {
							System.out.println(
									"\t1)add the seller \n\t2)view the seller details\n\t3)remove the seller\n\t4)add the customer\n\t5)view the customer\n\t6)view selling details\n\t7)add car\n\t8)view the cars\n\t9)remove the car\n\t0) exit");
							try {
								choice = getInput.nextInt();
							} catch (Exception e) {
								System.out.println(Color.RED + "enter the valid option " + Color.RESET);
								getInput.nextLine();
								continue;
							}
							// TODO: handle exception
							getInput.nextLine();
							if (choice == 1) {
								System.out.println("enter the seller name : ");
								String sellerName = getInput.nextLine();
								System.out.println("enter the seller password");
								String sellerPassword = getInput.nextLine();
								Seller seller = new Seller(3, sellerName, sellerPassword, "Seller");
								admin.addDetails(seller);
							} else if (choice == 2) {
								admin.viewDetails(2);
							} else if (choice == 3) {
								System.out.println("enter the seller id");
								int userId = getInput.nextInt();
								admin.removeDetails(userId);
							} else if (choice == 4) {
								System.out.println("enter the customer name : ");
								String customerName = getInput.nextLine();
								System.out.println("enter the customer password");
								String customerPassword = getInput.nextLine();
								customer customer = new customer(1, customerName, customerPassword, "Customer");
								admin.addDetails(customer);
							} else if (choice == 5) {
								admin.viewDetails(3);
							} else if (choice == 6) {
								admin.viewSellingDetails();
							} else if (choice == 7) {
								System.out.println("enter the car name");
//								getInput.nextLine();
								String carName = getInput.nextLine();
								System.out.println("enter the carBrand");
								String carBrand = getInput.nextLine();
								int carPrize = 0;
								while (true) {
									try {
										System.out.println("enter the car prize");
										carPrize = getInput.nextInt();
										break;
									} catch (Exception e) {
										System.out.println("enter the valid 4 digit number");
										getInput.nextInt();
										continue;
									}
								}
								boolean isAvailable = false;
								while (true) {
									try {

										System.out.println("is car available");
										isAvailable = getInput.nextBoolean();
										break;
									} catch (Exception e) {
										// TODO: handle exception
										System.out.println("enter the valid information");
										getInput.nextLine();
										continue;
									}
								}
								System.out.println("enter the manufacturing date with (yyyy-mm-dd) this format");
								getInput.nextLine();
								String manufaturYear = getInput.nextLine();
								Date year = Date.valueOf(manufaturYear);
								System.out.println(year);
								Car car = new Car(1, carBrand, carName, carPrize, year, adminName, isAvailable);
								admin.addDetails(car);
							} else if (choice == 8) {
								sell.viewCar();
							} else if (choice == 9) {
								System.out.println("enter the car id");
								int id = getInput.nextInt();
								sell.removeDetails(id);
							} else if (choice == 0) {
								break loop1;
							}
						}
					} else {
						System.out.println("enter the valid admin name and password");
					}

				}
			} else if (role == 2) {
				boolean temp = true;
				loop2: while (temp) {
					System.out.println("enter the seller name");
					String sellerName = getInput.nextLine();
					System.out.println("enter the seller password");
					String sellerPassword = getInput.nextLine();
//					System.out.println(sellerName.isEmpty());
					if (sellerName.isEmpty() || sellerPassword.isEmpty()) {
						System.out.println("enter the valid data ");
						continue loop2;
					} else {
						temp = login.loginChecking(sellerName, sellerPassword, 2);
					}
					int option = 0;
					if (temp) {
						while (option != 4) {
							System.out.println(Color.CYAN + "These are all your options" + Color.RESET
									+ "\n\t1)add the car \n\t2)viewcar\n\t3)remove the car\n\t4)exit");
							try {
								option = getInput.nextInt();
							} catch (Exception e) {
								System.out.println(Color.RED + "enter the valid option" + Color.RESET);
								getInput.nextLine();
								continue;
							}
							if (option == 1) {
								System.out.println("enter the car name");
								getInput.nextLine();
								String carName = getInput.nextLine();
								System.out.println("enter the carBrand");
								String carBrand = getInput.nextLine();
								int carPrize = 0;
								while (true) {
									try {
										System.out.println("enter the car prize");
										carPrize = getInput.nextInt();
										break;
									} catch (Exception e) {
										System.out.println("enter the valid prize");
										getInput.nextLine();
										continue;
									}
								}
								boolean isAvailable = false;
								while (true) {
									try {

										System.out.println("is car available");
										isAvailable = getInput.nextBoolean();
										break;
									} catch (Exception e) {
										// TODO: handle exception
										System.out.println("enter the valid information");
										getInput.nextLine();
										continue;
									}
								}
								System.out.println("enter the manufacturing date with (yyyy-mm-dd) this format");
								getInput.nextLine();
								String manufaturYear = getInput.nextLine();
								Date year = Date.valueOf(manufaturYear);
//								System.out.println(year);
								Car car = new Car(1, carBrand, carName, carPrize, year, sellerName, isAvailable);
								sell.addDetails(car);

							} else if (option == 2) {
								sell.viewCar();
							} else if (option == 3) {
								System.out.println("enter the car id");
								int id = getInput.nextInt();
								sell.removeDetails(id);
							} else if (option == 4) {
								break loop2;
							}
						}
					} else {
						System.out.println(Color.RED + "ENTER THE VALID SELLER NAME AND PASSWORD" + Color.RESET);
					}
				}
			} else if (role == 3) {
				boolean temp = true;
				while (temp) {
					System.out.println("enter the customer name");
					String customerName = getInput.nextLine();
					System.out.println("enter the customer password");
					String customerPassword = getInput.nextLine();
					temp = login.loginChecking(customerName, customerPassword, 3);
					if (!temp) {
//						System.out.println("enter the valid customer name and password");
						customer customer = new customer(1, customerName, customerPassword, "Customer");
						admin.addDetails(customer);
					}
					int option = 0;
					while (option != 3) {
						System.out.println("1)viewcar\n2)buy the car\n3)exit");
						option = getInput.nextInt();
						getInput.nextLine();
						if (option == 1) {
							obj.viewCar();
						} else if (option == 2) {
							int id = 0;
							while (true) {
								try {
									System.out.println("enter the car id");
									id = getInput.nextInt();
									break;
								} catch (Exception e) {
									// TODO: handle exception
									System.out.println("enter the valid id");
									getInput.nextLine();
									continue;
								}
							}
							int userid = obj.getId(customerName, customerPassword);
							obj.getCar(id, userid);
						}
					}
					if (option == 3) {
						break;
					}

				}
			}

			else {
				System.out.println("enter the valid number");
			}
		}
		getInput.close();
	}

}
