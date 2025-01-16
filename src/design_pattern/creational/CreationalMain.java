package design_pattern.creational;

public class CreationalMain {

    public static void main(String[] args) {

        SaveDetails saveDetails = SaveDetails.getInstance();
        Register customerUser = new CustomerRegistration(new User.UserBuilder("Ritu","Ghaziabad","1111111111","Customer").build());
        Register deliveryUser = new DeliveryPersonRegistration(new User.UserBuilder("Aman","Noida","1221111111","Delivery").build());

        customerUser.registerUser(saveDetails);
        deliveryUser.registerUser(saveDetails);

        System.out.println(saveDetails.getUsers());
    }
}
