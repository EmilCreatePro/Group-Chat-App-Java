package smartBit.Client;

import org.junit.Test;
import smartBit.Server.HandleClient;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class GiveNamePortTest {

    @Test
    /* Use reflection to access private methods */
    public void validateIPTest1() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "123.123.123.123");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", true, retVal);

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
    public void validateIPTest2() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "123.123.123.256");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", false, retVal);

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
    public void validateIPTest3() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "0.0.0.0");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", true, retVal);

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
    public void validateIPTest4() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "255.255.255.255");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", true, retVal);

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
    public void validateIPTest5() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "123.123.123.123.0");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", true, retVal);

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
    public void validateIPTest6() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", false, retVal);

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
    public void validateIPTest7() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "123.123..123.123");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", false, retVal);

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
    public void validateIPTest8() {
        try {
            /*Define a generic class C that will reference the class in your package*/
            Class c = Class.forName("smartBit.Client.GiveNamePort");

            /*Create a new instance of GiveNamePort */
            GiveNamePort giveNamePort = (GiveNamePort)c.newInstance();

            /*Access the method of that instance of the class */
            Method method = c.getDeclaredMethod("validateIP", String.class);

            /*Set it to be accesible from the outside*/
            method.setAccessible(true);

            /*Get the returning object of that method */
            Object getReturn = method.invoke(giveNamePort, "12.45.125");

            /*Convert it to the desired Type */
            boolean retVal = (boolean) getReturn;

            assertEquals("Check if IP is correct.", false, retVal);

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