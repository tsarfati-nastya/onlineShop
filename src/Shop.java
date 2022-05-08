import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Shop {
    LinkedList<Customer> users;
    ArrayList<Product> products;

    public Shop() {
        this.users = new LinkedList<>();
        this.products = new ArrayList<>();

    }

    public LinkedList<Customer> getUsers() {
        return users;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void createWorker(String firstName, String lastName, String userName, String password, boolean clubMember) {
        Scanner scanner = new Scanner(System.in);
        int userDegree;
        Degree degree = Degree.None;
        do {
            System.out.println("what is your work degree?" +
                    "\nthe options are:" +
                    "\n1 -> Regular worker" +
                    "\n2 -> Director" +
                    "\n3 -> Board  member");
            userDegree = scanner.nextInt();
            scanner.nextLine();
            switch (userDegree) {
                case Deff.REGULAR:
                    degree = Degree.RegularWorker;
                    break;
                case Deff.DIRECTOR:
                    degree = Degree.Director;
                    break;
                case Deff.BOARD_MEMBER:
                    degree = Degree.BoardMember;
                    break;
                default:
                    System.out.println("your choice is invalid!");

            }
        } while (userDegree != Deff.REGULAR && userDegree != Deff.DIRECTOR && userDegree != Deff.BOARD_MEMBER);
        Worker worker = new Worker(firstName, lastName, userName, password, clubMember, degree);
        this.users.add(worker);
    }

    public void AddProduct(Product product) {
        products.add(product);
    }

    private void showAllProducts() {
        for (Product product : this.products) {
            System.out.println(product.toString());
        }
    }

    public void createUser(int userType) {
        String userName, password, firstName, lastName;
        boolean clubMember;
        Scanner scanner = new Scanner(System.in);
        firstName = HelperFunctions.doesntContainNumber("What is your first name?");
        lastName = HelperFunctions.doesntContainNumber("What is your last name?");
        boolean userNameTaken;
        do {
            System.out.println("Choose a user name");
            userName = scanner.nextLine();
            userNameTaken = this.doesCustomerExists(userName);
            if (userNameTaken) System.out.println("user name is taken");
        } while (userNameTaken);
        boolean strongPassword;
        do {
            System.out.println("Enter strong password that contains at least 8 numbers");
            password = scanner.nextLine();
            strongPassword = this.checkIfPasswordStrong(password);
        } while (!strongPassword);
        System.out.println("Are you club member?");
        String choice = scanner.next();
        scanner.nextLine();
        while (!choice.equals("no") && !choice.equals("yes")) {
            System.out.println("enter only yes or no!");
            choice = scanner.next();
            scanner.nextLine();
        }
        clubMember = choice.equals("yes");
        if (!clubMember) {
            System.out.println("lets be friends");
        } else System.out.println("yay! we are already friends");

        if (userType == Deff.WORKER) {
            this.createWorker(firstName, lastName, userName, password, clubMember);
        } else {
            Customer customer = new Customer(firstName, lastName, userName, password, clubMember);
            this.users.add(customer);
        }
    }

    public ArrayList<Product> productsInTheStore() {
        ArrayList<Product> availableProducts = new ArrayList<>();
        for (Product product : products)
            if (product.isInStock())
                availableProducts.add(product);
        return availableProducts;
    }

    public Product checkProduct(String check) {
        for (Product product : products) {
            if (check.equals(product.getProductName()))
                return product;
        }
        return null;
    }

    private boolean checkIfPasswordStrong(String password) {
        boolean strongEnough = false;
        if (password.length() >= 6) {
            strongEnough = true;
        }
        return strongEnough;
    }

    private boolean doesCustomerExists(String userToCheck) {
        boolean exists = false;
        for (Customer currentUser : this.users) {
            if (currentUser.getUserName().equals(userToCheck)) {
                exists = true;
                break;
            }
        }
        return exists;
    }


}
