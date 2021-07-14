# Java-design-pattern

## Strategy Pattern

행위를 클래스로 캡슐화해 동적으로 행위를 자유롭게 바꿀 수 있게 해주는 패턴

  같은 문제를 해결하는 여러 알고리즘을 클래스로 캡슐화하여 상황에 맞는 클래스를 상속받아 사용한다.
  
  이름 그대로 전략을 쉽게 바꿀수있는 패턴이다.
  
### example 
  
  ```
  public interface EncodingStrategy {
    String encode(String text);
}
  ```
위 코드에서 볼수있듯이 Encoding 인터페이스를 만들고 이를 상속받아 concrete strategy 를 구현

```
public class Base64Strategy implements EncodingStrategy {
    @Override
    public String encode(String text) {
        return Base64.getEncoder().encodeToString(text.getBytes());
    }
}
```
전략별로 구현한 concrete strategy 를 context를 구현하여 필요에따라 setter 메서드 사용하여 필요에따라 사용한다.

```
public class Encoder {

    private EncodingStrategy encodingStrategy;

    public String getMessage(String message) {
        return this.encodingStrategy.encode(message);
    }

    public void setEncodingStrategy(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
}
```

setEncodingStartegy 에서 위에 구현한 strategy 를 적용시켜 해당 encoder 로 사용하도록 변경


## singleton pattern

생성자가 여러 차례 호출 되더라도 실제로 생성되는 객체는 하나이고 최초 생성 이후에 호출된 생성자는 최초의 생성자가 생성한 객체를 리턴한다. 

이와 같은 디자인 유형을 싱글턴 패턴이라고 한다. 주로 공통된 객체를 여러개 생성해서 사용하는 DBCP(DataBase Connection Pool)와 같은 상황에서 많이 사용된다.


### example

```
public class SocketClient {
    private static SocketClient socketClient = null;

    private SocketClient() {

    }

    public static SocketClient getInstance() {
        if (socketClient == null) {
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
```

위 코드에서 볼수 있듯이 기본 생성자를 private 사용하여 생성을 불가능 하게 하고 getInstance 를 통해 서만 생성 (getInstance 는 내부적으로 생성되지 않았으면 생성 아니면 기존값을 유지 한다)

따라서 코드 전반에 걸쳐 하나의 인스턴스를 유지 한다.

```
public class singleAz {

    private SocketClient socketClient;

    public singleAz() {
        this.socketClient = SocketClient.getInstance();

    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}

public class singleBz {

    private SocketClient socketClient;

    public singleBz() {
        this.socketClient = SocketClient.getInstance();

    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
```

각각 single socketclient 클래스를 만들고 

```
        싱글톤
        singleAz a = new singleAz();
        singleBz b = new singleBz();
        
        SocketClient aclient = a.getSocketClient();
        SocketClient bclient = b.getSocketClient();

        System.out.println("두개는 동일한가");
        System.out.println(aclient.equals(bclient));
```

각각의 인스턴스를 만들어 socket clinet 에 getinstance 로 하여금 인스턴스를 만들고

두개를 비교해보면 다르다는 것을 알수있습니다. 
