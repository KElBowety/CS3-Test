public class StationaryItem extends Item {
    private int size;
    private static int count;

    public StationaryItem(String name, int id, int size) {
        super(name, id);
        this.size = size;
        count++;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        StationaryItem.count = count;
    }

    @Override
    public String toString() {
        return "Item Name: " + super.getName() + "\nItem ID: " + super.getId() + "\nItem Size: " + size;
    }
}
