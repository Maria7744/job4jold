package ioBot;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.mockito.Mockito.mock;

public class EshoServerNewTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenAskExit() throws IOException{
        this.testEchoServer("exit"," ");
    }

    @Test
    public void whenAskHellow() throws IOException{
        this.testEchoServer(
                Joiner.on(LN).join(
                        "Hello",
                        "exit"
                ),
                String.format("http://localhost:9000/?msg=Hellow",LN,LN)
        );
    }
    @Test
    public void whenASkWhat() throws IOException{
        this.testEchoServer(
                Joiner.on(LN).join(
                        "Any",
                        "exit"
                ),
                String.format("http://localhost:9000/?msg=Any...",LN,LN)
        );
    }

    private void testEchoServer(String input,String exepted)throws IOException{
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes()
        );
    }
}
