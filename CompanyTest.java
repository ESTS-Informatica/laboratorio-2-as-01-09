

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
    private User client2;
    private User client3;
    private User seller1;
    private User seller2;
    
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
        assertTrue(company1.registerClient(client2));
    }
    @Test
    public void testRegisterClientDuplicate(){
        assertTrue(company1.registerClient(client3));
        assertFalse(company1.registerClient(client3));
    }
    @Test
    public void testRegisterClientNull(){
        assertEquals(false,company1.registerClient(null));
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
        this.client2 = new User("José Manuel","911111111","zemanel@yahoo.com");
        this.client3 = new User("António Francisco","922222222","tochico@hotmail.com");
        this.seller1 = new User("Fernando Fernandes","966777101","fefe@remax.pt");
        this.seller2 = new User("Rodrigo Rodrigues","966777152","roro@remax.pt");
        this.company1 = new Company();
    }
}
