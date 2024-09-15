import java.util.ArrayList;

public class FarmApp {
    public static void main(String[] args) {
        // สร้างข้อมูลวัวและแพะ
        ArrayList<CowModel> cows = new ArrayList<>();
        cows.add(new CowModel("10000001", 3, 6, 4));
        cows.add(new CowModel("10000002", 5, 8, 3));
        cows.add(new CowModel("10000003", 3, 9, 4));
        cows.add(new CowModel("10000004", 4, 7, 3));
        cows.add(new CowModel("10000005", 3, 8, 4));
        cows.add(new CowModel("10000006", 2, 4, 3));
        cows.add(new CowModel("10000007", 4, 8, 4));
        cows.add(new CowModel("10000008", 5, 5, 3));
        cows.add(new CowModel("10000009", 7, 6, 4));
        cows.add(new CowModel("10000010", 8, 8, 3));
        cows.add(new CowModel("10000011", 9, 1, 4));
        cows.add(new CowModel("10000012", 6, 3, 3));
        cows.add(new CowModel("10000013", 3, 2, 4));
        cows.add(new CowModel("10000014", 4, 4, 3));
        cows.add(new CowModel("10000015", 10, 0, 4));
        cows.add(new CowModel("11111111", 0, 0, 0));//แพะ
        cows.add(new CowModel("11111112", 0, 0, 0));//แพะ
        
        // สร้าง View และ Controller
        FarmView view = new FarmView();
        FarmController controller = new FarmController(view, cows);

        // แสดงหน้าต่าง
        view.setVisible(true);
    }
}
