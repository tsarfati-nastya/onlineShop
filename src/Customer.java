import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private final String name;
    private final String lastName;
    private final String userName;
    private final String password;
    private final boolean clubMember;
    private int purchases;
    private ShoppingCart myCard = new ShoppingCart();


    public Customer(String name, String lastName, String userName, String password, boolean clubMember) {
        this.name = name;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.clubMember = clubMember;
    }


    public String getName() {
        return name;
    }


    public String getLastName() {
        return lastName;
    }


    public String getUserName() {
        return userName;
    }


    public String getPassword() {
        return password;
    }


    public boolean isClubMember() {
        return clubMember;
    }

    public double getPurchases() {
        return purchases;
    }
    public ShoppingCart addToCard(){
        return myCard;
    }

    public String toString(){
        return "Hello " + this.name + " " + this.lastName + " " + (this.clubMember ? "(VIP!)" : "" ) ;
    }


}
