public class LabItem extends Item {
    private String type;
    private static int count;

    public LabItem(String name, int id, String type) {
        super(name, id);
        this.type = type;
        count++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        LabItem.count = count;
    }

    @Override
    public String toString() {
        return "Item Name: " + super.getName() + "\nItem ID: " + super.getId() + "\nItem Type: " + type;
    }
}
