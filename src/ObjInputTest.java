public class ObjInputTest {
        public static void main(String[] args) {
            SafeInputObj input = new SafeInputObj();

            String name = input.getNonZeroLenString("Enter your name");
            System.out.println("You entered: " + name);

            int age = input.getRangedInt("Enter your age", 1, 100);
            System.out.println("You entered: " + age);

            double salary = input.getDouble("Enter your salary");
            System.out.println("You entered: " + salary);

            boolean confirm = input.getYNConfirm("Are you done");
            System.out.println("Confirmation: " + confirm);
        }
    }




