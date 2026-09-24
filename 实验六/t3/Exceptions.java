package t3;

public class Exceptions {
        public static void main(String[] args) {
            System.out.println("=== Start ===");

            try {
                method1();
                System.out.println("Statement1 in main");
            } catch (Exception e) {
                System.out.println("Caught in main: " + e.getMessage());
            }

            System.out.println("Statement2 in main");
            System.out.println("=== End ===");
        }

        public static void method1() throws Exception {
            System.out.println("Enter method1");

            try {
                method2();
                System.out.println("Statement3 in method1");
            } catch (Exception e) {
                System.out.println("Caught in method1: " + e.getMessage());
            }

            System.out.println("Statement4 in method1");
        }

        public static void method2() throws Exception {
            System.out.println("Enter method2");

            try {
                method3();
                System.out.println("Statement5 in method2");
            } catch (Exception e) {
                System.out.println("Caught in method2: " + e.getMessage());
                throw e;  // rethrow to upper level
            }

            System.out.println("Statement6 in method2");
        }

        public static void method3() throws Exception {
            System.out.println("Enter method3");
            System.out.println("Throw exception in method3");
            throw new Exception("Exception from method3");
        }
}
