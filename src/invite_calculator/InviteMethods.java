package invite_calculator;

public class InviteMethods {
	
	private int numOfInvites;
	private double pricePerCard;
		
	public InviteMethods() {
	}
	public int getNumOfInvites() {
		return numOfInvites;
	}
	public void setNumOfInvites(int numOfInvites) {
		this.numOfInvites = numOfInvites;
	}    
	public double getPricePerCard() {
		return pricePerCard;
	}
	public void setPricePerCard(double pricePerCard) {
		this.pricePerCard = pricePerCard;
	}
	
	//invitations   
	public double calcPricePerInvite (int n) {
		
		if (n >= 25 && n < 50){
			getPrice(25, n, 3.50, .20);
		}
		else if (n >= 50 && n < 75){ 
			getPrice(50, n, 2.50, .10);
		}
		else if (n >= 75 && n < 100){
	  		getPrice(75, n, 2.00, .05);
		}
		else if (n >= 100 && n <= 150){
	    	getPrice(100, n, 1.75, .025);
		}
		return pricePerCard;
	}
	//mehndi and response cards
	public double calcPricePerMAndR (int n) {
				
		if (n >= 25 && n < 50){
			getPrice(25, n, 2.00, .12);
		}
		else if (n >= 50 && n < 75){ 
			getPrice(50, n, 1.40, .01);
		}
		else if (n >= 75 && n <= 150){
	  		getPrice(75, n, 1.26, .02);
		}
		return pricePerCard;
	}
	
	public double calcPricePerInfo (int n) {
		
		if (n >= 25 && n < 50){
			getPrice(25, n, 1.82, .11);
		}
		else if (n >= 50 && n < 75){ 
			getPrice(50, n, 1.27, .03);
		}
		else if (n >= 75 && n <= 150){
	  		getPrice(75, n, 1.12, .01);
		}
		return pricePerCard;
	}
		
	public double getPrice(int start, int numOfInvites, double price, double multiplier) {
		
		for (int i = start; i <= numOfInvites; i+=5, price-=multiplier)    
		    	pricePerCard = price;
		return pricePerCard;
		
	}
	
	public double calcTotalInvites(int numOfInvites) {
	    return numOfInvites * calcPricePerInvite(numOfInvites);
	}
	
	public double calcTotalMAndR(int numOfInvites) {
	    return numOfInvites * calcPricePerMAndR(numOfInvites);
	}
	
	public double calcTotalInfo(int numOfInvites) {
	    return numOfInvites * calcPricePerInfo(numOfInvites);
	}
	
	//matting price
	public double calcMatting(int numOfInvites) {
	    return numOfInvites * 0.50;
	}
	
	public double calcTotal(double invitePrice, double matPrice, double responsePrice, double infoPrice, double mehndiPrice) {
		
		//invitePrice = matPrice = responsePrice = infoPrice = mehndiPrice = 0.0;
	    
		invitePrice = calcTotalInvites(numOfInvites);
		matPrice = calcMatting(numOfInvites);
		responsePrice = calcTotalMAndR(numOfInvites);
		infoPrice = calcTotalInfo(numOfInvites);
		mehndiPrice = calcTotalMAndR(numOfInvites);
	    
	    return invitePrice + matPrice + responsePrice + infoPrice + mehndiPrice;
	    
	    
	}

}