package com.test.main;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.TargetDataLine;

import org.apache.log4j.Logger;
import org.jdom.input.SAXBuilder;

public class Client {
    private OutputStream out;
    private InputStream in;
    private Socket socket;
    private byte[] bos=new byte[2024];
    //private static ByteArrayOutputStream baos;
    private static byte[] bis=new byte[2024];

    public Client() {
        startClient();
    }

    private void startClient() {
    	SAXBuilder sx = new SAXBuilder();
    	 
    
        try {
            //这里需要根据自己的ip修改
            socket = new Socket("192.168.9.117", 9999);
            
            out = socket.getOutputStream();
            System.out.println("客户端:连接成功");
            // 保持通讯
            in = socket.getInputStream();

            TargetDataLine targetDataLine = AudioUtils.getTargetDataLine();

            SourceDataLine sourceDataLine = AudioUtils.getSourceDataLine();
            while (true) {
                System.out.println("Client:");
               
                    //获取音频流
                    int writeLen = targetDataLine.read(bos,0,bos.length);
                    //发
                    if (bos != null) {
                        //向对方发送拾音器获取到的音频
                        System.out.println("Client 发");
                        out.write(bos,0,writeLen);
                    }
                    //收
                    int readLen = in.read(bis);
                    if (bis != null) {
                        //播放对方发送来的音频
                        System.out.println("Client 收");
                        sourceDataLine.write(bis, 0, readLen);
                    }

            }

        } catch (Exception ex) {
           // Logger.getLogger(Client.class.getName())
             //       .log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String args[]) {
        new Client();
    }
}
 