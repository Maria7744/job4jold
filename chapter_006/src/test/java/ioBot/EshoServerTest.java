package ioBot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;

public class EshoServerTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskExit() throws IOException{
        this.testEchoServer("exit"," ");
    }

    @Test
    public void whenAskHellow() throws IOException{
        this.testEchoServer(
                Joiner.on(LN).join(
                        "hellow",
                        "exit"
                ),
                String.format("http://localhost:9000/?msg=hellow,dear",LN,LN)
        );
    }
    @Test
    public void whenASkWhat() throws IOException{
        this.testEchoServer(
                Joiner.on(LN).join(
                        "What",
                        "exit"
                ),
                String.format("http://localhost:9000/?msg=What...",LN,LN)
        );
    }

    private void testEchoServer(String input,String exepted)throws IOException{
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes()
        );
    }

}
