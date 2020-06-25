public class rectangle
{
    public static void maain(String args[]);
    {
    rectangle r1 = new.args rectangle(0, 0, 5, 5);
    r1.show();
    }

}
class rectangle {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
};
    public rectangle(int x1, int x2, int y1, int y2)
    {   this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public void show() {
        System.out.println("현재 위치" + x1 + "," + y1);
        System.out.println("가로 길이" + (x2 - x1));
        System.out.println("세로 길이" + (y2 - y1));
        System.out.println("면적" + (x2 - x1)*(y2 - y1));
    };

