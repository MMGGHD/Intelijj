package ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public MyServer() throws IOException{
        // 1. 서버 소켓 (리스너) 생성
        ServerSocket serverSocket = new ServerSocket(10000); //연결하는 객체
        Socket socket = serverSocket.accept(); // 리스너 대기중
        System.out.println("클라이언트가 연결되었습니다");

        // 2. 클라이언트의 메시지를 받기
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
        );
        String msg = reader.readLine(); // 버퍼 비우기
        System.out.println("받은 메시지 : "+msg);
    }

    public static void main(String[] args) {
        try {
            new MyServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
