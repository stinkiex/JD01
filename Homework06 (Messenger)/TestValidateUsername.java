import messenger.User;
import messenger.ValidateUser;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Test JUnit: Messenger")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestValidateUsername {

    @DisplayName("Test JUnit: ValidateUser")
    @ParameterizedTest(name = "{index} -> a={0}, b={1}")
    @CsvSource({
            "Sponge Bob, true ",
            "Patrick, true",
            "1Patrick, false",
            "Витя, false",
            "Виктор, false",
            "Guf,, false",
            "Yorick-Yorickus, true"
    })
    public void testValidateUser(String a){
        if (ValidateUser.checkUser(new User(a, "password"))){
            System.out.println("Username correct");
        }else System.out.println("Username is incorrect!");
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
