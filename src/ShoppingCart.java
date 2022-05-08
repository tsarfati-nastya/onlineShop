import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCart {
private static final ArrayList<Product> productsPurchased = new ArrayList<>();
private static final Scanner scanner = new Scanner(System.in);

public void purchase(Shop shop, boolean worker, Degree degree, boolean isClubMember){
    ArrayList<Product> productsInTheStore = shop.productsInTheStore();
        for (int i = 0; i < productsInTheStore.size(); i++){
            System.out.println(i +1 + "-> " + productsInTheStore.get(i));
        }
    System.out.println("enter the number of the product you would like to add to the card" + "\n[-1] if you want to exit");
        int userChoice = 0, quantity;
        try {
            userChoice = scanner.nextInt();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Let's try again");
            scanner.nextLine();
            purchase(shop, worker, degree, isClubMember);
            return;
        }

        if (productsInTheStore.size() == 0){
            System.out.println("sorry! we ont have this item");
            Main.mainMenu();
        }
        if (userChoice == -1){
            shoppingCart(worker, degree, isClubMember);
            Main.mainMenu();
            return;
        }
        while (userChoice < 1 || userChoice > productsInTheStore.size()){
            System.out.println("let's try again! please choose from the list!");
            userChoice = scanner.nextInt();
            scanner.nextLine();
        }
    System.out.println("how many products do you want to add to the card?");
        quantity = scanner.nextInt();
        scanner.nextLine();
        Product product = productsInTheStore.get(userChoice - 1);
        for (int i = 0; i < quantity; i++){
            addToCard(product);
        }
        product.buyProduct(quantity);
        shoppingCart(worker, degree, isClubMember);
        purchase(shop, worker, degree, isClubMember);
}
public  void shoppingCart(boolean worker, Degree degree, boolean isClubMember){
    double sum = 0;
    for (Product product: productsPurchased){
        if (!worker && isClubMember){
            sum += product.getPrice() * product.getDiscount();
        }
        else if (worker){
            sum += finalPrice(degree, product);
        }
        else
            sum += product.getPrice();
            System.out.println("\n   ");
            System.out.println(product);
    }
    System.out.println("The amount to be paid is: " + sum);
}


    public double finalPrice(Degree degree, Product product) {
        double discount = (double) (degree.ordinal() +1) /10.0;
        double price = product.getPrice() - (product.getPrice() * discount);
        return price;
    }

    public void addToCard(Product product){
    productsPurchased.add(product);
    }
}
