public class CowModel {
    private String id;
    private int ageYears;
    private int ageMonths;
    private int numTeats;

    public CowModel(String id, int ageYears, int ageMonths, int numTeats) {
        this.id = id;
        this.ageYears = ageYears;
        this.ageMonths = ageMonths;
        this.numTeats = numTeats;
    }

    public String getId() {
        return id;
    }

    public int getAgeYears() {
        return ageYears;
    }

    public int getAgeMonths() {
        return ageMonths;
    }

    public int getNumTeats() {
        return numTeats;
    }

    public void setNumTeats(int numTeats) {
        this.numTeats = numTeats;
    }

    // คำนวณจำนวนน้ำนมที่ผลิตได้
    public int calculateMilk() {
        return ageYears + ageMonths;
    }

    // โอกาสที่จำนวนเต้าจะลดลง 5%
    public void reduceTeatChance() {
        if (Math.random() <= 0.05 && numTeats > 3) {
            numTeats--;
        }
    }

    // โอกาสที่จะกลับมาสมบูรณ์เป็น 4 เต้า 20%
    public void regainTeatChance() {
        if (Math.random() <= 0.20 && numTeats == 3) {
            numTeats++;
        }
    }
}
