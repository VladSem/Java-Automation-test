import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by vlad on 4/27/15.
 */
public class PythonTest {

    @Test
    public void ssh() {

        try {
            Process p = Runtime.getRuntime().exec("python /var/www/html/five_modems/apn_and_phone/ssh.py");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String sn = (in.readLine());
            System.out.println(sn);

        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(p);


    }
}
