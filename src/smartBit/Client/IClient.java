package smartBit.Client;

public interface IClient
{
    public void connectButtonPressed(IClient client);
    public void receiveText(String text);
    public String getClientName();
}
