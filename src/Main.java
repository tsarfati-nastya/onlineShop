import java.util.Scanner;

public class Main {
        private static Scanner scanner;
        private static Shop shop;


        public static void main(String[] args) {
            mainMenu();
    }


    public static void mainMenu(){
        scanner = new Scanner(System.in);
        shop = new Shop();
        int userChoice = 0;
        do {
            System.out.println("choose one of the following options:" +
                    "\n1 - Open new account" + "\n2 - Log in" + "\n3 - Exit");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice){
                case Deff.SIGN_UP:
                    signUp();
                    break;
                case Deff.LOG_IN:
                    logIn();
                    break;
                case Deff.EXIT:
                    break;
            }
        } while (userChoice != Deff.EXIT);
        System.out.println("Hope to see you again next time!");
    }

    public static void signUp(){
        System.out.println("Are you a worker or a customer?" +
                "\n1 -> worker" +
                "\n2 -> customer");
        int signUpChoice = 0;
        do{
            signUpChoice = scanner.nextInt();
            scanner.nextLine();
        }while(signUpChoice < 1 || signUpChoice > 2 );
        shop.createUser(signUpChoice);
    }
public static void logIn(){
            boolean valid = false;
            Customer user = null;
            while(!valid){
                System.out.println("Enter your user name: ");
                String userName = scanner.nextLine();
                System.out.println("Enter your password name: ");
                String password = scanner.nextLine();
                for(Customer customer: shop.getUsers()){
                    if(customer.getUserName().equals(userName) && customer.getPassword().equals(password)){
                        user = customer;
                        valid = true;
                        break;
                    }
                }
                if(!valid) {
                    System.out.println("invalid credentials! do you want to try again? [y/n]: ");
                    char choice = scanner.nextLine().charAt(0);
                    if(choice == 'n' || choice == 'N')
                        return;
                }
            }
            showUserMenu(user);
        }
        public static void showUserMenu(Customer user){
            int workerChoice = 0;
            do {
                if (user instanceof Worker) {
                    Worker worker = (Worker) user;
                    System.out.println(worker);
                    System.out.println("please choose one of the following menu options: ");
                    System.out.println("1 -> print all customers list" +
                            "\n2 -> print club members list" +
                            "\n3 -> print all custom1ers that made at least one purchase" +
                            "\n4 -> print the customer with the highest amount of purchases" +
                            "\n5 -> add new product" +
                            "\n6 -> edit product stock" +
                            "\n7 -> make a purchase" +
                            "\n8 -> exit to main menu");
                    workerChoice = scanner.nextInt();
                    scanner.nextLine();
                    switch (workerChoice) {
                        case Deff.PRINT_ALL_CUSTOMERS:
                            ((Worker) user).allCustomers(shop);
                            break;
                        case Deff.PRINT_ALL_CLUB_MEMBERS:
                            ((Worker) user).allVIP(shop);
                            break;
                        case Deff.PRINT_CLIENT_WITH_AT_LEAST_ONE_PURCHASE:
                            ((Worker) user).printTheBuyerWithAtLeastOnPurchase(shop.users);
                            break;
                        case Deff.MOST_HIGH_BUYER:
                            ((Worker) user).printHighestBuyer(shop.users);
                            break;
                        case Deff.ADD_NEW_PRODUCT:
                            ((Worker) user).enterProduct(shop);
                            break;
                        case Deff.CHANGE_STOCK_STATUS:
                            ((Worker) user).changeProductStatus(shop);
                            break;
                        case Deff.MAKE_PURCHASE:

                            break;
                        case Deff.EXIT_TO_MAIN_MENU:
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + workerChoice);
                    }
                }

                else {
                    Customer customer = (Customer) user;
                    System.out.println(customer);
                    customer.addToCard().purchase(shop, false, null, true);
                }

            } while (workerChoice != Deff.EXIT_TO_MAIN_MENU);
        }

    }

