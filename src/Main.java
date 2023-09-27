import com.maveric.model.Customer;
import com.maveric.model.Products;
import com.maveric.services.CustomerServiceimpl;
import com.maveric.services.ProdServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("welcome to Maveric store");
        ProdServiceImpl proservice=new ProdServiceImpl();
        CustomerServiceimpl customerservice=new CustomerServiceimpl();
        Customer cust=new Customer();
        Products pro=new Products();

        Scanner sc=new Scanner(System.in);
       int i;
        do{
            System.out.println("1.Register Products");
            System.out.println("2.find All productsproduct ");
            System.out.println("3.Register customer");
            System.out.println("4.find customer by id");
            System.out.println("5.findAllCustomer");
            System.out.println("6.customer buyproduct");
            System.out.println("7.find productbyid");
            System.out.println("8.boughtCustomer");
            System.out.println("9.Exit");
            System.out.println("-----------------------------------");
            System.out.print("Enter your choice :");
            i=sc.nextInt();
            switch (i){
                case 1:
                    System.out.println("Product Registration details");
                    proservice.registerProducts(pro);
                    break;
                case 2:
                    proservice.allProduct();
                    break;
                case 3:
                    System.out.println("Customer Registration details");
                    customerservice.registerCustomer(cust);
                    break;
                case 4:{
                    System.out.println("Enter your id");
                    long id=sc.nextInt();
                    customerservice.customerbyid(id);
                    break;
                }
                case 5:
                   customerservice.allCustomers();
                    break;
                case 6:
                    System.out.println("Enter customer id :");
                    long id=sc.nextInt();
                    System.out.println("Enter product id :");
                    long id1=sc.nextInt();
                    customerservice.buyProduct(id,id1);
                    break;
                case 7:
                    System.out.println("enter product id:");
                    long id2=sc.nextInt();
                   proservice.productbyid(id2);
                   break;
                case 8:
                    System.out.println("enter  customer id :");
                    long id3=sc.nextInt();
                    customerservice.customerBought(id3);
                   break;

                default:
                    System.out.println("invalid input");

            }
        }while(i!=9);


    }
}