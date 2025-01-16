package design_pattern.creational;

public class CustomerRegistration implements Register {

    User user;

    public CustomerRegistration(User user){
       this.user = user;
    }

    @Override
    public void registerUser(SaveDetails savedDetails) {
        savedDetails.createUser(user);
    }
}
