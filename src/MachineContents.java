import java.util.HashMap;

/**
 * Created by eniakel on 06/08/2015.
 */
public class MachineContents {
    HashMap<Item, Integer> items = new HashMap<>();

    public HashMap<Item, Integer> getItems() {
        return items;
    }

    public void addItem(Item item, int number) {
        this.items.put(item, number);
    }

}
