
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Worker extends Customer {

    private final Degree degree;

    public Worker(String name, String lastName, String userName, String password, boolean clubMember, Degree degree) {
        super(name, lastName, userName, password, clubMember);
        this.degree = degree;
    }

    public void allCustomers(Shop shop) {
        for (Customer user : shop.getUsers()) {
            System.out.println(user);
        }
    }

    public void allVIP(Shop shop) {
        for (Customer user : shop.getUsers()) {
            if (user.isClubMember())
            System.out.println(user);
        }
    }

    public void enterProduct(Shop shop){
        Scanner scanner = new Scanner(System.in);
        String nameOfProduct, description;
        double price;
        int discount;
        System.out.println("Enter the product name: ");
        nameOfProduct = scanner.nextLine();
        System.out.println("Enter the product description:");
        description = scanner.nextLine();
        System.out.println("Enter the product price:");
        price = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("what discount would you like to enter?:");
        discount = scanner.nextInt();
        scanner.nextLine();
        Product product = new Product(nameOfProduct,description, price, discount);
        shop.AddProduct(product);
    }

    public String toString(){
        return ("Hello " + getName() + " " + getLastName() + " " + this.degree); }


        public void printHighestBuyer(LinkedList<Customer> customers){
        double max = 0;
        Customer maxCustomer = null;
         for (Customer customer : customers){
         if (customer.getPurchases() >= max){
             max = customer.getPurchases();
             maxCustomer = customer;
            }
         }
            System.out.println("Our most buying customer is: ");
            System.out.println(maxCustomer);
    }
    public void printTheBuyerWithAtLeastOnPurchase(LinkedList<Customer> customers){
        for (Customer customer : customers){
            if (customer.getPurchases() > 0){
                System.out.println(customer);
            }
        }
    }

    public void changeProductStatus(Shop shop){
        Scanner scanner = new Scanner(System.in);
        ArrayList <Product> products = shop.getProducts();
        for (Product product : products) {
            System.out.println(product);
        }
        System.out.println("which product do you want to change? " );
        String userString = scanner.next();
        scanner.nextLine();
        Product product = shop.checkProduct(userString);
        if (product == null) {
            System.out.println("there is no such product! lets try again!");
            return;
        }
        product.changeStatusOfProduct();
    }

}
