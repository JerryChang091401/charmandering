import components.map.Map;
import components.map.Map1L;

public class Fridge {
    //key question: when i create Fridge fridge = new Fridge()
    private boolean locationToggle;
    private Map<String, Integer> fridgeItems;
    private Map<String, Integer> freezerItems;

    public Fridge() {
        this.locationToggle = true;
        this.fridgeItems = new Map1L<>();
        this.freezerItems = new Map1L<>();
    }

    public void addItem(String item, boolean locationToggle) {
        if (locationToggle) {
            if (this.fridgeItems.hasKey(item)) {
                this.fridgeItems.replaceValue(item,
                        this.fridgeItems.value(item) + 1);
            } else {
                this.fridgeItems.add(item, 1);
            }
        } else {
            if (this.freezerItems.hasKey(item)) {
                this.freezerItems.replaceValue(item,
                        this.freezerItems.value(item) + 1);
            } else {
                this.freezerItems.add(item, 1);
            }
        }
    }

    public void removeItem(String item, boolean isOpen) {
        if (isOpen) {
            if (this.isInFridge(item)) {
                this.fridgeItems.remove(item);
            }
        } else {
            if (this.isInFreezer(item)) {
                this.freezerItems.remove(item);
            }
        }
    }

    public boolean isInFridge(String item) {
        return this.fridgeItems.hasKey(item);
    }

    public boolean isInFreezer(String item) {
        return this.freezerItems.hasKey(item);
    }

    //do all
    public int getNumOfItem(String item, boolean locationToggle) {
        int count = 0;
        if (locationToggle) {
            if (this.fridgeItems.hasKey(item)) {
                count = this.fridgeItems.value(item);
            }
        } else {
            if (this.freezerItems.hasKey(item)) {
                count = this.freezerItems.value(item);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addItem("steak", false);
        fridge.removeItem("steak", false);
    }

}