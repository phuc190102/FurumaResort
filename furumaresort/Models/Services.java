package furumaresort.Models;

public abstract class Services {
	public String id;
	public String serviceName;
	public float usedArea;
	public float hireFee;
	public int maxCustomer;
	public String hireType;

	public Services() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public float getHireFee() {
		return hireFee;
	}

	public void setHireFee(float hireFee) {
		this.hireFee = hireFee;
	}

	public int getMaxCustomer() {
		return maxCustomer;
	}

	public void setMaxCustomer(int maxCustomer) {
		this.maxCustomer = maxCustomer;
	}

	public String getHireType() {
		return hireType;
	}

	public void setHireType(String hireType) {
		this.hireType = hireType;
	}

	public float getUsedArea() {
		return usedArea;
	}

	public void setUsedArea(float usedArea) {
		this.usedArea = usedArea;
	}

	public abstract void showInfor();
}
