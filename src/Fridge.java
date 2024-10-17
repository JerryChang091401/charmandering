import components.map.Map;
import components.map.Map1L;

public class Fridge implements FridgeKernel, FridgeSecondary {
    //key question: when i create Fridge fridge = new Fridge()
    /**
     * Set up for fridge conditions/compartments.
     */
    private boolean isFridge;
    /**
     * Set up for fridge conditions/compartments.
     */
    private Map<String, Integer> fridgeItems;
    /**
     * Set up for fridge conditions/compartments.
     */
    private Map<String, Integer> freezerItems;

    /**
     * Constructor.
     */
    public Fridge() {
        this.isFridge = true;
        this.fridgeItems = new Map1L<>();
        this.freezerItems = new Map1L<>();
    }

    @Override
    public void addItem(String item, boolean isFridge) {
        if (isFridge) {
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

    @Override
    public void removeItem(String item, boolean isFridge) {
        if (isFridge) {
            if (this.isInFridge(item)) {
                this.fridgeItems.remove(item);
            }
        } else {
            if (this.isInFreezer(item)) {
                this.freezerItems.remove(item);
            }
        }
    }

    @Override
    public boolean isInFridge(String item) {
        return this.fridgeItems.hasKey(item);
    }

    @Override
    public boolean isInFreezer(String item) {
        return this.freezerItems.hasKey(item);
    }

    @Override
    public int getNumOfItems(String item, boolean isFridge) {
        int count = 0;
        if (isFridge) {
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

    @Override
    public int totalNumOfItems() {
        return this.fridgeItems.size() + this.freezerItems.size();
    }

    @Override
    public Fridge newInstance() {
        return new Fridge();
    }

    @Override
    public void clear() {
        this.fridgeItems.clear();
        this.freezerItems.clear();
    }

    @Override
    public void transferFrom(Fridge fridge) {
        this.fridgeItems.transferFrom(fridge.fridgeItems);
        this.freezerItems.transferFrom(fridge.freezerItems);
    }

    public static void main(String[] args) {
        Fridge fridge = new Fridge();
        fridge.addItem("steak", false);
        fridge.removeItem("steak", false);
    }

}