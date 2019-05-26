package smartBit.Server;

import org.junit.Test;
import smartBit.Client.Client;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class HandleClientTest {

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getClass().getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emil: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "Hello", retVal);

        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}