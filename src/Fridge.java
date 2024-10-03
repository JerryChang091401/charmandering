import components.map.Map;
import components.map.Map1L;

public class Fridge {
    private boolean isOpen;
    private static Map<String, Integer> fridgeItems;
    private Map<String, Integer> freezerItems;

    public Fridge() {
        this.isOpen = false;
        this.fridgeItems = new Map1L<>();
        this.freezerItems = new Map1L<>();
    }

    public void addOneItem(String item, boolean isOpen,
            Map<String, Integer> location) {
        if (!isOpen) {
            if (location.hasKey(item)) {
                location.replaceValue(item, location.value(item) + 1);
            } else {
                location.add(item, 1);
            }
        }
    }

    public void removeOneItem(String item, boolean isOpen,
            Map<String, Integer> location) {
        if (!isOpen) {
            location.remove(item);
        }
    }

    public boolean inFridge(String item) {
        return this.fridgeItems.hasKey(item);
    }

    public boolean inFreezer(String item) {
        return this.freezerItems.hasKey(item);
    }

    public int numOfItem(String item) {
        int count = 0;
        if (fridgeItems.hasKey(item)) {
            count = fridgeItems.value(item);
        } else if (this.freezerItems.hasKey(item)) {
            count = this.freezerItems.value(item);
        }
        return count;
    }

    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addOneItem("steak", false, null);
        fridge.removeOneItem("steak", false, fridgeItems);
    }

}