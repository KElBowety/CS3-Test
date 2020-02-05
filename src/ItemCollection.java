import java.util.HashMap;

public class ItemCollection {
    private HashMap<Integer, Item> itemHashMap = new HashMap<>();
    private static int count;

    public ItemCollection() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        ItemCollection.count = count;
    }

    public void putStationaryItem(StationaryItem item) {
        itemHashMap.put(item.getId(), item);
    }

    public void putLabItem(LabItem item) {
        itemHashMap.put(item.getId(), item);
    }

    @Override
    public String toString() {
        if(itemHashMap.isEmpty()){
            return "NO items are available";
        }
        else {
            String total = "";
            for (Integer key : itemHashMap.keySet()) {
                total += itemHashMap.get(key).toString() + "\n\n";
            }
            return total;
        }
    }
}
