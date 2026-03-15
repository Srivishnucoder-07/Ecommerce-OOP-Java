
import java.util.*;

// Base Product class
abstract class Product {

    protected String id;
    protected String name;
    protected double price;

    public Product(String id,String name,double price){
        this.id=id;
        this.name=name;
        this.price=price;
    }

    public abstract double calculateDiscount();

    public double finalPrice(){
        return price - calculateDiscount();
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}

// Electronics product
class ElectronicsProduct extends Product {

    int warranty;

    public ElectronicsProduct(String id,String name,double price,int warranty){
        super(id,name,price);
        this.warranty=warranty;
    }

    public double calculateDiscount(){
        return price * 0.10;
    }
}

// Clothing product
class ClothingProduct extends Product {

    String size;

    public ClothingProduct(String id,String name,double price,String size){
        super(id,name,price);
        this.size=size;
    }

    public double calculateDiscount(){
        return price * 0.20;
    }
}

// Book product
class BookProduct extends Product {

    String author;

    public BookProduct(String id,String name,double price,String author){
        super(id,name,price);
        this.author=author;
    }

    public double calculateDiscount(){
        return price * 0.05;
    }
}

// Shopping cart
class ShoppingCart {

    private Map<Product,Integer> cart = new HashMap<>();

    public void addProduct(Product p,int qty){
        cart.put(p,qty);
        System.out.println("Added to cart: "+p.getName());
    }

    public void viewCart(){

        double total=0;

        System.out.println("\n=== SHOPPING CART ===");

        for(Map.Entry<Product,Integer> item: cart.entrySet()){

            Product p=item.getKey();
            int qty=item.getValue();

            double amount=p.finalPrice()*qty;

            total+=amount;

            System.out.println(p.getId()+" "+p.getName()+" Qty:"+qty+" Total: ₹"+amount);
        }

        System.out.println("---------------------");
        System.out.println("Total Amount: ₹"+total);
    }

    public void updateCart(String id,int qty){

        for(Map.Entry<Product,Integer> item:cart.entrySet()){

            Product p=item.getKey();

            if(p.getId().equals(id)){

                cart.put(p,qty);
                System.out.println("Cart updated!");
                return;
            }
        }

        System.out.println("Product not found in cart");
    }

    public double getTotal(){

        double total=0;

        for(Map.Entry<Product,Integer> item:cart.entrySet()){

            Product p=item.getKey();
            int qty=item.getValue();

            total+=p.finalPrice()*qty;
        }

        return total;
    }
}

// Order class
class Order {

    String orderId;

    public Order(String orderId){
        this.orderId=orderId;
    }

    public void checkout(double subtotal){

        double gst=subtotal*0.18;
        double finalAmount=subtotal+gst;

        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Order ID: "+orderId);

        System.out.println("Subtotal: ₹"+subtotal);
        System.out.println("GST (18%): ₹"+gst);
        System.out.println("Final Amount: ₹"+finalAmount);

        System.out.println("🎉 ORDER CONFIRMED!");
    }
}

// Main class
public class MainApp {

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);

        ElectronicsProduct e=new ElectronicsProduct("E001","Smartphone X",50000,24);
        ClothingProduct c=new ClothingProduct("C001","Cotton T-Shirt",1200,"M");
        BookProduct b=new BookProduct("B001","Java Programming",800,"John Doe");

        ShoppingCart cart=new ShoppingCart();

        while(true){

            System.out.println("\n=== E-COMMERCE SYSTEM ===");
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Update Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice=sc.nextInt();

            switch(choice){

                case 1:

                    System.out.println("\n=== PRODUCTS ===");

                    System.out.println("ID:"+e.getId()+" Name:"+e.getName()+" Final Price:"+e.finalPrice());
                    System.out.println("ID:"+c.getId()+" Name:"+c.getName()+" Final Price:"+c.finalPrice());
                    System.out.println("ID:"+b.getId()+" Name:"+b.getName()+" Final Price:"+b.finalPrice());

                    break;

                case 2:

                    System.out.print("Enter product ID: ");
                    String id=sc.next();

                    System.out.print("Enter quantity: ");
                    int qty=sc.nextInt();

                    if(id.equals("E001"))
                        cart.addProduct(e,qty);

                    else if(id.equals("C001"))
                        cart.addProduct(c,qty);

                    else if(id.equals("B001"))
                        cart.addProduct(b,qty);

                    else
                        System.out.println("Invalid product");

                    break;

                case 3:

                    cart.viewCart();
                    break;

                case 4:

                    System.out.print("Enter product ID: ");
                    String pid=sc.next();

                    System.out.print("Enter new quantity: ");
                    int newQty=sc.nextInt();

                    cart.updateCart(pid,newQty);
                    break;

                case 5:

                    Order order=new Order("ORD1000");
                    order.checkout(cart.getTotal());
                    break;

                case 6:

                    System.out.println("Thank you!");
                    System.exit(0);
            }
        }
    }
}
