import com.maveric.sale.models.Customer;
import com.maveric.sale.models.Product;
import com.maveric.sale.service.CustomerService;
import com.maveric.sale.service.ProductService;
import com.maveric.sale.service.impl.CustomerServiceImpl;
import com.maveric.sale.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        CustomerService customerService=new CustomerServiceImpl();
        ProductService productService=new ProductServiceImpl();
        int choice;
        do{
            System.out.println("***************** WELCOME TO MAVERIC STORE *****************");
            System.out.println("1.Register The Product.          2.Find product.");
            System.out.println("3.Register customer.             4.find customer.");
            System.out.println("5.Buy a product.                 6.Get the list of products bought by a customer.");
            System.out.println("7.Show All Customers             8.Show All Products");
            System.out.println("9.Logout");
            System.out.print("Enter Your Choice :");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch (choice){
                case 1:{
                    System.out.print("Enter the Product Name:");
                    String pname=sc.next();
                    System.out.print("Enter the product price:");
                    double price=sc.nextDouble();
                    productService.registerProduct(pname,price);
                    break;
                }
                case 2:{
                    System.out.print("Enter Product Id:");
                    int pid=sc.nextInt();
                    Product product=productService.findProductById(pid);
                    if(product!=null)
                        System.out.println(product);
                    else
                        System.out.println("Product is not available with the Id :"+pid);
                    break;
                }
                case 3:{
                    System.out.print("Enter the Customer First Name:");
                    String fname=sc.next();
                    System.out.print("Enter the Customer Last Name:");
                    String lname=sc.next();
                    System.out.print("Enter the Balance:");
                    double bal=sc.nextDouble();
                    customerService.registerCustomer(fname,lname,bal);
                    break;
                }
                case 4:{
                    System.out.print("Enter Customer Id :");
                    int cid=sc.nextInt();
                    Customer cust=customerService.findCustomerById(cid);
                    if(cust!=null)
                        System.out.println(cust);
                    else
                        System.out.println("Customer is not available with the id : "+cid);
                    break;
                }
                case 5:{
                    System.out.print("Enter Customer Id:");
                    int custId=sc.nextInt();
                    System.out.print("Enter the product Id you want to buy :");
                    int pid=sc.nextInt();
                    customerService.buyProduct(custId,pid);
                    break;
                }
                case 6:{
                    System.out.print("Enter Customer Id:");
                    int custId=sc.nextInt();
                    if(CustomerServiceImpl.authenticateCustomerId(custId)==true) {
                        List<Product> customers = customerService.getProductsBoughtByCustomer(custId);
                        if (customers == null)
                            System.out.println("Oooops... This Customer has not bought any product yet");
                        else
                            customers.stream().forEach(System.out::println);
                    }else
                        System.out.println("*******Invalid Customer Id**********");
                    break;
                }
                case 7:{
                    customerService.getustomers().stream()
                                    .forEach(System.out::println);
                    break;
                }
                case 8:{
                    productService.getProducts().stream()
                            .forEach(System.out::println);
                    break;
                }
                case 9:{
                    System.out.println("******Logged Out******");
                    break;
                }
                default:
                    System.out.println("*******Oooops... Invalid Input*******");
            }
        }while (choice!=9);
    }
}