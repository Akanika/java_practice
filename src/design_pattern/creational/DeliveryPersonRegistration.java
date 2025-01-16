package design_pattern.creational;

public class DeliveryPersonRegistration implements Register{

    User user;

    public DeliveryPersonRegistration(User user){
        this.user = user;
    }

    @Override
    public void registerUser(SaveDetails savedDetails) {
        savedDetails.createUser(user);
    }
}
