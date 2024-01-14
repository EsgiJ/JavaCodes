package oguzhanesgiyusufo_lab4;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Staff> staffList = FileUtility.readStaffFromFile("Staff.txt");

            SalaryIncreaseThread thread = new SalaryIncreaseThread(staffList, 10.0);
            Thread t = new Thread(thread);
            t.start();
            t.join();

            FileUtility.writeStaffToFile(staffList, "updated_staff.txt");

            System.out.println("Ä°ÅŸlem tamamlandÄ±. GÃ¼ncellenen personel bilgileri dosyaya yazÄ±ldÄ±.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
