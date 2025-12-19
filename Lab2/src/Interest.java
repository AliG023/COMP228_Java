package Lab2_AG_F2025;

public class Interest {
	
	public double principal;
	public double rate;
	public double time;
	
	public Interest(double principal, double rate, double time) {
		if(principal <=0 || rate <=0 || time <= 0) {
			throw new IllegalArgumentException("Principal, Rate and Time must not be a valid");
		}
		this.principal = principal;
		this.rate = rate;
		this.time = time;
	}
	
	public double calculateSimpleInterest(double principal, double rate, double time ) {
		return principal * rate * time / 100;
	}
	
	
	public double calculateCompoundInterest(double principal, double rate, double time) {
        return principal * Math.pow(1 + rate / 100, time) - principal;
    }

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}


}
