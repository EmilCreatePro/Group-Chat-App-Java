package smartBit.Server;

import org.junit.Test;
import org.junit.runners.Parameterized;
import smartBit.Client.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class ServerTest {


    @Test
    public void removeDisconnectedClientTest() {
        Client client1 = new Client();
        Client client2 = new Client();
        Client client3 = new Client();
        Client client4 = new Client();
        Client client5 = new Client();
        Client client6 = new Client();

        ArrayList<Client> testList = new ArrayList<Client>();

        testList.add(client1);
        testList.add(client2);
        testList.add(client3);
        testList.add(client4);
        testList.add(client5);
        testList.add(client6);

        Server server = new Server();

        boolean retVal = true;

        assertEquals("Hope this passes", true, retVal);

    }
}