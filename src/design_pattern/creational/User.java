package design_pattern.creational;

public class User {

    //required fields
    String firstName;
    String address;
    String mobileNumber;
    String userType;

    //non required email
    String dob;
    String email;
    String lastName;

    public User(UserBuilder builder) {
        this.address = builder.address;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dob = builder.dob;
        this.mobileNumber = builder.mobileNumber;
        this.email = builder.email;
        this.userType = builder.userType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getDob() {
        return dob;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", address='" + address + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", userType='" + userType + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static class UserBuilder{
        //required fields
        String firstName;
        String address;
        String mobileNumber;
        String userType;

        //non required email
        String dob;
        String email;
        String lastName;

        public UserBuilder(String firstName, String address, String mobileNumber, String userType) {
            this.firstName = firstName;
            this.address = address;
            this.mobileNumber = mobileNumber;
            this.userType = userType;
        }

        public UserBuilder setDob(String dob) {
            this.dob = dob;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }


}
