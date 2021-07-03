package com.company;

import com.company.adapter.*;
import com.company.decorate.*;
import com.company.facade.Ftp;
import com.company.facade.Reader;
import com.company.facade.SftpClient;
import com.company.facade.Writer;
import com.company.observer.Button;
import com.company.observer.IButtonListener;
import com.company.strategy.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        싱글톤
//        singleAz a = new singleAz();
//        singleBz b = new singleBz();
//
//        SocketClient aclient = a.getSocketClient();
//        SocketClient bclient = b.getSocketClient();
//
//        System.out.println("두개는 동일한가");
//        System.out.println(aclient.equals(bclient));


//        어댑터 패턴
//        HairDryer hairDryer = new HairDryer();
//        connect(hairDryer);
//
//        Cleaner cleaner = new Cleaner();
//        Electronic110v adapter = new SocketAdapter(cleaner);
//        connect(adapter);
//
//        AirCondition airCondition = new AirCondition();
//        Electronic110v airAdapter = new SocketAdapter(airCondition);
//        connect(airAdapter);

//        프록시 패턴
//        Browser browser = new Browser("www.naver.com");
//        browser.show();
//        browser.show();
//        browser.show();
//        browser.show();
//        IBroswer broswer = new BrowserProxy("www.naver.com");
//        broswer.show();
//        broswer.show();
//        broswer.show();

//        Aop패턴
//        AtomicLong start = new AtomicLong();
//        AtomicLong end = new AtomicLong();
//        IBroswer aopBrowser = new AopBrowser("www.naver.com",
//                () -> {
//                    System.out.println("before");
//                    start.set(System.currentTimeMillis());
//
//                },
//                () -> {
//                    long now = System.currentTimeMillis();
//                    end.set(now - start.get());
//                }
//        );
//        aopBrowser.show();
//        System.out.println("loading time "+end.get());
//
//        aopBrowser.show();
//        System.out.println("loading time "+end.get());
//
        //데코레이터 패턴
//        ICar audi = new Audi(1000);
//        audi.showPrice();
//
//        //a3
//        ICar audi3 = new A3(audi, "A3");
//        audi3.showPrice();
//
//
//        //a4
//        ICar audi4 = new A4(audi, "A4");
//        audi4.showPrice();
//
//
//        //a5
//        ICar audi5 = new A5(audi, "A5");
//        audi5.showPrice();

        //observer 패턴
//        Button button = new Button("버튼");
//
//        button.addListener(new IButtonListener() {
//            @Override
//            public void clickEvent(String event) {
//                System.out.println(event);
//            }
//        });
//
//        button.click("메세지 전달 click1");
//        button.click("메세지 전달 click2");
//        button.click("메세지 전달 click3");
//        button.click("메세지 전달 click4");

        //facade 패턴
//        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "home/bin");
//        ftpClient.connect();
//        ftpClient.moveDirectory();
//
//        Reader reader = new Reader("test.tmp");
//        reader.fileConnect();
//        reader.fileRead();
//
//        Writer writer = new Writer("test.tmp");
//        writer.fileconnect();
//        writer.write();
//
//        ftpClient.disConnect();
//        writer.fileDisconnect();
//        reader.fileDisconnect();

//        SftpClient sftpClient = new SftpClient("www.naver.com", 22, "/home/bin", "text.tmp");
//        sftpClient.connect();
//        sftpClient.write();
//        sftpClient.read();
//        sftpClient.disconnect();

        Encoder encoder = new Encoder();

        EncodingStrategy base64 = new Base64Strategy();

        EncodingStrategy normal = new NomalStrategy();

        EncodingStrategy append = new AppendStrategy();

        String message = "Hello java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(append);
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);

    }

}
