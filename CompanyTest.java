

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste CompanyTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class CompanyTest
{
    
    private Company company1;
    private User client1,client2;
    private User seller1,seller2;
    private Sell sell1,sell2;
    private Property property1,property2;
    
    /**
     * Construtor default para a classe de teste CompanyTest
     */
    public CompanyTest()
    {
    }
    @Test
    public void testContructor(){
        assertNotNull(company1.getClients());
        assertNotNull(company1.getSellers());
    }
    @Test
    public void testRegisterClient(){
        assertTrue(company1.registerClient(client1));
    }
    @Test
    public void testRegisterClientDuplicate(){
        assertTrue(company1.registerClient(client1));
        assertFalse(company1.registerClient(client1));
    }
    @Test
    public void testRegisterClientNull(){
        assertEquals(false,company1.registerClient(null));
    }
    /*@Test
    public void testCreateSell(){
        company1.register
        assertTrue(company1.createSell(client1,seller1,property1));
    }*/
    
    @Test
    public void testRegisterSeller(){
        assertTrue(company1.registerSeller(seller1));
    }
    @Test
    public void testRegisterSellerNull(){
        assertFalse(company1.registerSeller(null));
    }
    
    @Test
    public void testRegisterProperty(){
        assertTrue(company1.registerProperty(property1));
    }
    @Test
    public void testRegisterPropertyNull(){
        assertFalse(company1.registerProperty(null));
    }
    
    @Test
    public void testCreateSell(){
        company1.registerClient(client1);
        company1.registerSeller(seller1);
        company1.registerProperty(property1);
        assertTrue(company1.createSell(client1,seller1,property1));
    }
    @Test
    public void testCalculateSellsOfTheYear(){
        company1.registerClient(client1);
        company1.registerSeller(seller1);
        company1.registerProperty(property1);
        company1.registerClient(client2);
        company1.registerSeller(seller2);
        company1.registerProperty(property2);
        company1.createSell(client1,seller1,property1);
        company1.createSell(client2,seller2,property2);
        assertEquals(2,company1.calculateSellsOfTheYear(2024));
    }
    @Test
    public void testFindSellerOfTheYear(){
        company1.registerClient(client1);
        company1.registerSeller(seller1);
        company1.registerProperty(property1);
        company1.registerClient(client2);
        company1.registerSeller(seller2);
        company1.registerProperty(property2);
        company1.createSell(client1,seller1,property1);
        company1.createSell(client2,seller1,property2);

        assertEquals("Fernando Fernandes",company1.findSellerOfTheYear(2024));

    }
    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp(){
        this.client1 = new User("José Manuel","911111111","zemanel@yahoo.com");
        this.client2 = new User("António Francisco","922222222","tochico@hotmail.com");
        this.seller1 = new User("Fernando Fernandes","966777101","fefe@remax.pt");
        this.seller2 = new User("Rodrigo Rodrigues","966777152","roro@remax.pt");
        this.company1 = new Company();
        this.property1 = new Property("T3 Monte Belo",150000.0);
        this.property2 = new Property(" T5 Bela Vista", 300000.0);
        this.sell1 = new Sell(client1,seller1,property1);
        this.sell2 = new Sell(client2,seller2,property2);
    }
}
