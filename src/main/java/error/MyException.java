package error;

/**
 * Created by Drareeg on 09.10.16.
 */
public class MyException extends RuntimeException {


    public MyException(Throwable t, String s) {
        super(s);
        t.printStackTrace();
    }
}
