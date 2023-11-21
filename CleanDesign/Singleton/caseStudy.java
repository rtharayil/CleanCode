/*Kindly review the below code. Can we test OrderProcessor independently? */

public class OrderProcessor {
	public void process(Order order) {
		PricingService service = PricingService.getInstance();
		// use the PricingService object for processing the order
	}
}
