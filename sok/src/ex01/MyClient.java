package ex01;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

public class MyClient {
    public MyClient() throws IOException {
        // 1. 서버 연결 (127.0.0.1 은 내 ip = local host = loop back host)
        // local host 는 os를 빠져나가지 않음
        // ipconfig로 확인한 내 ip == 192.168.200.124 이건 공유기까지 갔다옴
        Socket socket = new Socket("127.0.0.1", 10000);

        // 2. 서버쪽으로 메시지 전송
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(socket.getOutputStream())
        );
        writer.write("Hello");
        writer.write("\n");
        writer.flush();


    }

    public static void main(String[] args) {
    try{new MyClient();
    }catch (Exception e ){
        e.printStackTrace();
    }
    }
}
