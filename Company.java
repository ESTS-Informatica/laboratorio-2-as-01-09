
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

/**
 * Manage a company.
 *
 * @author POO
 * @version 03/2024
 */
public class Company {

    // Clients registry
    private ArrayList<User> clients;
    // Sellers registry
    private ArrayList<User> sellers;
    // Properties registry
    private ArrayList<Property> properties;
    // Sells registry
    private ArrayList<Sell> sells;

    /**
     * Constructor of class Company
     */
    public Company() {
        this.clients=new ArrayList<>();
        this.sellers=new ArrayList<>();
        this.properties=new ArrayList<>();
        this.sells=new ArrayList<>();

    }

    /**
     * Get the list of clients.
     *
     * @return This company clients.
     */
    public List<User> getClients() {
        return clients;         // dummy implementation
    }

    /**
     * Get the list of sellers.
     *
     * @return This company sellers.
     */
    public List<User> getSellers() {
        return sellers;         // dummy implementation
    }

    /**
     * Get the list of properties.
     *
     * @return This company's properties.
     */
    public List<Property> getProperties() {
        return properties;         // dummy implementation
    }

    /**
     * Get the list of sells.
     *
     * @return This company sells.
     */
    public List<Sell> getSells() {
        return sells;         // dummy implementation
    }

    /**
     * Register a client.
     *
     * @param client to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerClient(User client) {
            if(!clients.contains(client) && client !=null){
                clients.add(client);
                return true;
            }
            return false;
    }  // dummy implementation
    

    /**
     * Register a seller.
     *
     * @param seller to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSeller(User seller) {
        if(!sellers.contains(seller) && seller !=null){
                sellers.add(seller);
                return true;
            }
            return false;
        // dummy implementation
    }

    /**
     * Register a property.
     *
     * @param property to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerProperty(Property property) {
        if(!properties.contains(property) && property !=null){
                properties.add(property);
                return true;
            }
            return false;
         // dummy implementation
    }

    /**
     * Register a sell.
     *
     * @param sell to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSell(Sell sell) {
            if(!sells.contains(sell) && sell != null){
                sells.add(sell);
                return true;
            }
        return false;         // dummy implementation
    }

    /**
     * Generate a new sell and register that sell.
     *
     * @param client Must be already registered.
     * @param seller Must be already registered.
     * @param property Must be already registered.
     * @return true If the request succeeds, false otherwise.
     */
    public boolean createSell(User client, User seller, Property property) {
        if(clients.contains(client) && sellers.contains(seller) && properties.contains(property) && client != null && seller !=null & property !=null){
            registerSell(new Sell(client,seller,property));
            return true;
        }
        return false;     
    }

    /**
     * Calculates the total number of sells within the provided year.
     *
     * @param year
     * @return The total number of sells in the year.
     */
    public int calculateSellsOfTheYear(int year) {
        int count = 0;
        for(Sell sell : sells){
            LocalDate sells=sell.getDate();
            if( sells.getYear() == year){
                    count++;
            }
        }
        return count;      // dummy implementation
    }

    /**
     * Find the seller with more sells within the provided year.
     *
     * @param year
     * @return The name of the seller of the year.
     */
    
     public String findSellerOfTheYear(int year) {
        User sellerOfTheYear = null;
        int maxSales=0; 
        for(User seller : sellers){
            int salesCount =0;
            for(Sell sell : sells){
                    LocalDate sellDate=sell.getDate();
                    if(sell.getSeller() == seller && sellDate.getYear() == year){
                        salesCount ++;
                    }
                }
            if(salesCount > maxSales){
                    maxSales=salesCount;
                    sellerOfTheYear=seller;
                }
        }
        return sellerOfTheYear.getName(); 
        }
}
        
    
