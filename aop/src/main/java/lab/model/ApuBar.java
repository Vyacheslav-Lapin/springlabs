package lab.model;

import org.springframework.stereotype.Service;

@Service
public class ApuBar implements Bar {

	public Squishee sellSquishee(Customer customer)  {
        if (customer.isBroke()){
            throw new CustomerBrokenException();
        }
        System.out.println("Here is your Squishee \n");
        return new Squishee("Usual Squishee");
    }
}