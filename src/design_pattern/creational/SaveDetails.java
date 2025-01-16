package design_pattern.creational;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;

public class SaveDetails implements Serializable, Cloneable {

    private static HashMap<String,User> hashMap = new HashMap<String,User>();
    private volatile static SaveDetails saveDetails;

    private SaveDetails(){
        if(saveDetails != null){
            throw new IllegalArgumentException("object already exists");
        }
    }

    public static SaveDetails getInstance(){
        if(saveDetails == null){
            synchronized (SaveDetails.class){
                if(saveDetails == null){
                    saveDetails = new SaveDetails();
                }
            }
        }
        return saveDetails;
    }

   public void createUser(User user){
        hashMap.put(user.mobileNumber,user);
   }

   public HashMap<String,User> getUsers(){
        return hashMap;
   }

   @Serial
   Object readResolve(){
        return getInstance();
   }

   @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("singleton can't be cloned");
    }
}
