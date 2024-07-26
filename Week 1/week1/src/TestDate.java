public class TestDate {
    public static void main(String[] args) {
        Date dates[] = new Date[10];
        for (int i = 1; i <= 10; i++)
            dates[i-1] = new Date(12, i, 2005);
        for (Date date : dates)
            System.out.println(date);
    }
}