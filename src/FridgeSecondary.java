import components.map.Map;
import components.map.Map1L;

public abstract class FridgeSecondary
        implements FridgeKernel, FridgeSecondaryInterface {
    private Map<String, Integer> fridgeItems;
    private Map<String, Integer> freezerItems;

    public FridgeSecondary() {
        this.fridgeItems = new Map1L<>();
        this.freezerItems = new Map1L<>();
    }

    @Override
    public int getNumOfItems(String item, boolean isFridge) {
        int count = 0;
        if (isFridge) {
            count = this.fridgeItems.hasKey(item) ? this.fridgeItems.value(item)
                    : 0;
        } else {
            count = this.freezerItems.hasKey(item)
                    ? this.freezerItems.value(item)
                    : 0;
        }
        return count;
    }

    @Override
    public boolean isInFreezer(String item) {
        return this.freezerItems.hasKey(item);
    }

    @Override
    public int totalNumOfItems() {
        int total = 0;
        for (Map.Pair<String, Integer> pair : this.fridgeItems) {
            total += pair.value();
        }
        for (Map.Pair<String, Integer> pair : this.freezerItems) {
            total += pair.value();
        }
        return total;
    }

    // Optional Object methods
    @Override
    public String toString() {
        return "Fridge [fridgeItems=" + this.fridgeItems + ", freezerItems="
                + this.freezerItems + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FridgeSecondary)) {
            return false;
        }
        FridgeSecondary other = (FridgeSecondary) obj;
        return this.fridgeItems.equals(other.fridgeItems)
                && this.freezerItems.equals(other.freezerItems);
    }

    @Override
    public int hashCode() {
        return this.fridgeItems.hashCode() + this.freezerItems.hashCode();
    }
}
