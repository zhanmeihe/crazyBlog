package com.test.main;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

 
public class Server {
    private OutputStream out;
    private InputStream in;
    private ServerSocket serverSocket;
    private Socket socket;
    //private int counter = 1;
    private byte[] bos=new byte[2024];
    //private static ByteArrayOutputStream baos;
    private  byte[] bis=new byte[2024];

    public Server() {

        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(9999, 20);
                // 等待连接
                System.out.println("服务端:等待连接");
                socket = serverSocket.accept();
                out = socket.getOutputStream();
                // out.flush();
                System.out.println("服务端：连接成功");
                // 保持通讯
                in = socket.getInputStream();

                TargetDataLine targetDataLine = AudioUtils.getTargetDataLine();

                SourceDataLine sourceDataLine = AudioUtils.getSourceDataLine();
                while (true) {
                    System.out.println("server:");

                    /**
                     * 这里一定要先发再收  不然socket的读取流会阻塞
                     */

                    //获取音频流
                    int writeLen = targetDataLine.read(bos,0,bos.length);
                    //发
                    if (bos != null) {
                        //向对方发送拾音器获取到的音频
                        System.out.println("rerver 发");
                        out.write(bos,0,writeLen);
                    }

                    //收
                    int readLen = in.read(bis);
                    if (bis != null) {
                        //播放对方发送来的音频
                        System.out.println("rerver 收");
                        sourceDataLine.write(bis, 0, readLen);
                    }
                }


        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new Server();
    }

}
 