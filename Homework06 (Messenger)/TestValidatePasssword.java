import messenger.User;
import messenger.ValidateUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Test JUnit: Messenger")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestValidatePasssword {

    @DisplayName("Test JUnit: ValidateUserPassword")
    @ParameterizedTest(name = "{index} -> a={0}, b={1}")
    @CsvSource({
            "password, true ",
            "paws1111, true",
            "someletteresssss, false",
            "Витя, false",
            "Виктор, false",
            "Guf, false",
            "Yorick-Yorickus, false"
    })
    public void testValidateUser(String a){
        if (ValidateUser.checkPassword(new User("Sponge Bob", a))){
            System.out.println("Password correct");
        }else System.out.println("Password is incorrect!");
    }


    @AfterEach
    public void afterEach(){
        System.out.println("Test completed");
    }

    @AfterAll
    public void afterAll(){
        System.out.println("All tests completed");
    }

    @BeforeAll
    public void beforeAll(){
        System.out.println("Tests Begin");
    }

}
