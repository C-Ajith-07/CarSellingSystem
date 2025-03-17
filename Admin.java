package database_project;

import java.sql.PreparedStatement;

public class Admin extends User implements Methods {

	Data_Manage_Ment addObj = new Data_Manage_Ment();

	Admin() {

	}

	Admin(int userId, String name, String password, String role) {
		super(userId, name, password, role);
	}

	@Override
	public void addDetails(Object obj) {
		if (obj instanceof Seller) {
			addObj.addSeller((Seller) obj);
		} else if (obj instanceof customer) {
			addObj.addCustomer((customer) obj);
		}
		else if(obj instanceof Car) {
			addObj.addCar((Car)obj);
		}
	}

	@Override
	public void viewDetails(int role) {
		if (role == 2) {
			addObj.viewDetails(2);
		} else if (role == 3) {
			addObj.viewDetails(3);
		}
	}
	

	@Override
	public void removeDetails(int userId) {
		try {
			PreparedStatement stm = Connect.getConnection().prepareStatement("DELETE FROM user WHERE userId = ?");
			stm.setInt(1, userId);
			int result = stm.executeUpdate();
			System.out.println(result);
			if (result == 1) {
				System.out.println(Color	.GREEN + "seller remove succsesfully!!!!" + Color.RESET);
			} else {
				System.out.println(Color.RED + "you give wrong Seller name or password" + Color.RESET);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	void viewSellingDetails() {
		addObj.sellingDetails();
	}

	
	
	
	
//    void addCustomer(customer customer1) {
//        addObj.addTOCustomer(customer1);
//        System.out.println(Color.GREEN+"customer added"+Color.RESET);
//    }
//    
//    void addAdmin(Admin admin) {
//    	addObj.addtoAdmin(admin);
//    }

//    void addSeller(Seller seller){
//        addObj.addToTheFile(seller);
//        System.out.println(Color.GREEN+"seller added"+Color.RESET);
//    }

//    void removeSeller(String sellerName, String sellerPassword) {
//    	ArrayList<Seller> list = new ArrayList<Seller>();
//    	try (Scanner input = new Scanner(new FileReader(addObj.ADMIN_FILE_PATH))){
//			while(input.hasNextLine()) {
//				String[] array  = input.nextLine().split(",");
//				list.add(new Seller(array[0],array[1],array[2],array[3],array[4]));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	
//    	for(int i=0; i<list.size(); i++) {
//    		if((list.get(i).userName.equals(sellerName) && list.get(i).password.equals(sellerPassword))) {
//    			list.remove(i);
//    		}
//    	}
//    	addObj.clearTheFile();
//    	for(int i=0; i<list.size(); i++) {
//    		addObj.addToSeller(list.get(i));
//    	}
//    }
//    
//    void dispute() {
//        
//    }

}
