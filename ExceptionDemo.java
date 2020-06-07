import java.io.IOException;
import java.util.Scanner;
public class ExceptionDemo {

    static class Error {
        int data = 0;

        void bad() throws IOException {
            System.out.println("Break me by entering a letter, fix me by entering a number");
            Scanner sc = new Scanner(System.in);
            data = sc.nextInt(); // unchecked exception occurred
            // exception propagated stillBad()
            if (!(data >=0 || data < 0)) {
            throw new IOException("Letter entered, Error");
        }
            }


        void stillBad() throws IOException {
            bad();
            // exception propagated to fix()
        }

        void fix()
        {
            try {
                stillBad(); // exception handled
            }
            catch (Exception i) {
                System.out.println("I caught the problem, you entered a letter!");
                System.out.println("We can continue now\n");
            }
        }

        public static void main(String[] args)
        {
            Error obj = new Error();
            obj.fix();
            System.out.println("Normal flow...");
        }
    }
}
