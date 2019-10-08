public class TestMain {

    public static void main(String[] args) {
        System.out.println("test begin:");
        TestConsumerKafka test = new TestConsumerKafka();
        test.read();
    }
}