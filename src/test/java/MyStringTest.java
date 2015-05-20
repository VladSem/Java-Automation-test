import org.junit.Test;

/**
 * Created by vlad on 4/21/15.
 */
public class MyStringTest {

    @Test
    public void csq() {

        String csq_line = "last csq = 22, 99 AT&T (LTE/E-UTRAN) SIM";
        String csq = csq_line.substring(5, csq_line.length()-23);
        System.out.println(csq);

//        String s = "www.mysite.com";
//        String name = s.substring(4, s.length()-4);
//        System.out.println(name); // на консоль выведет "mysite"
//
//        String domain = s.substring(4);
//        System.out.println(domain); // на консоль выведет "mysite.com"
    }
}
