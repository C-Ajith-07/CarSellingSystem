package database_project;

import java.sql.Date;

public class Car {
	String carName;
	String carBrand;
	int prize;
	boolean isAvailable;
	int carId;
	Date manufacture;
	String owner;
//	int lanchYear;
	
	Car(int carId,String carBrand,String carName, int prize, Date manufacture,String owner , boolean isAvailable ){
		this.carName = carName;
		this.carBrand = carBrand;
		this.prize = prize;
		this.manufacture = manufacture;
		this.isAvailable = isAvailable;
		this.carId = carId;
		this.owner = owner;
	}
	
	String getCarName() {
		return carName;
	}

	void setCarName(String carName) {
		this.carName = carName;
	}

	String getCarBrand() {
		return carBrand;
	}

	void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	int getCarRentPrize() {
		return prize;
	}

	void setCarRentPrize(int carRentPrize) {
		this.prize = carRentPrize;
	}

	boolean isAvailable() {
		return isAvailable;
	}

	void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	int getCarId() {
		return carId;
	}

	void setCarId(int carId) {
		this.carId = carId;
	}

	Date getManufacture() {
		return manufacture;
	}

	void setManufacture(Date manufacture) {
		this.manufacture = manufacture;
	}

}