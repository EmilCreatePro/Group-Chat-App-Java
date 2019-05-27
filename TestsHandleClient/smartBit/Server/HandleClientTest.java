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
    public void returnNameTest1() {



        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Server.HandleClient");

            /*Create a new instance of HandleClient */
            HandleClient hc = (HandleClient)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("returnName", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(hc, "Emil: Hello");

            /*Convert it to the desired Type */
            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "Emil", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest2() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emil Chirila: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "Emil Chirila", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest3() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emil123_02: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "Emil123_02", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest4() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "_xXx_Emil_xXx_123AlabamaChildrenDon'tVacciinateTheirKidsAndNothing: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "_xXx_Emil_xXx_123AlabamaChildrenDon'tVacciinateTheirKidsAndNothing", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest5() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, ": Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest6() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "a: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "a", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnNameTest7() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnName", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest1() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emil: Hello");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", ": Hello", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest2() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emil: ");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", ": ", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest3() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, ": ");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", ": ", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest4() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, ": ");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", ": ", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest5() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", "", retVal);

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

    @Test
    /* Use reflection to access private methods */
    public void returnActualMessageTest6() {



        try {
            Class c = Class.forName("smartBit.Server.HandleClient");

            HandleClient hc = (HandleClient)c.newInstance();

            Class[] cArg = new Class[1];
            cArg[0] = String.class;

            Method method = c.getDeclaredMethod("returnActualMessage", String.class);
            method.setAccessible(true);

            Object getReturn = method.invoke(hc, "Emilion:Ce plm faceti mao bajetii ::: ::: ::: mei ca eu va tai craca de sub pivioare!.A2316931'.'asdDragnea 3 ani ouscarie baaa, coale");

            String retVal = (String) getReturn;

            assertEquals("Is the string correct", ":Ce plm faceti mao bajetii ::: ::: ::: mei ca eu va tai craca de sub pivioare!.A2316931'.'asdDragnea 3 ani ouscarie baaa, coale", retVal);

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