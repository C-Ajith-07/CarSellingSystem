package database_project;

public class Seller extends User implements Methods{
	Data_Manage_Ment  addCar= new Data_Manage_Ment();
	int carSellingCount =0;
	Seller( int userId,String name, String password , String role){
		super(userId, name , password , role);
	}
	Seller(){
		
	}
	@Override
	public void addDetails(Object obj) {
		if(obj instanceof Car) {
			addCar.addCar((Car)obj);
		}
		else {
			throw new IllegalAccessError();
		}
	}
	@Override
	public void viewDetails(int role) {
		
	}
	@Override
	public void removeDetails(int carId) {
		addCar.removeCar(carId);
	}
	
//	void addCar(Car obj) {
////			addCar.addToTheCar(obj);
//	}
//	
	void viewCar() {
		addCar.viewCar();
	}
	
//	void removeCar(int id ) {
//	  	ArrayList<Car> list = new ArrayList<Car>();
//    	try (Scanner input = new Scanner(new FileReader(addCar.CAR_FILE_PATH_STRING))){
//			while(input.hasNextLine()) {
//				String[] array  = input.nextLine().split(",");
////				if(!(array[1].equals(sellerName) && array[2].equals(sellerPassword))) {
////					addObj.
////				}
//				
//				list.add(new Car(array[0],array[1],Integer.parseInt(array[2]),Integer.parseInt(array[3]),Boolean.parseBoolean(array[4])));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//    	
//    	for(int i=0; i<list.size(); i++) {
//    		if((list.get(i).carId == id)) {
//    			list.remove(i);
//    		}
//    	}
//    	addCar.clearCar();
//    	for(int i=0; i<list.size(); i++) {
//    		addCar.addToCar(list.get(i));
//    	}
//	}
}
