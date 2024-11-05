import components.standard.Standard;

public interface FridgeKernel extends Standard<Fridge> {
    /**
     * Adds an item to the fridge or freezer.
     *
     * @param item
     *            the name of the item to add
     * @param isFridge
     *            true if the item goes in the fridge, false if in the freezer
     * @ensures item is added to the correct compartment
     */
    public void addItem(String item, boolean isFridge);

    /**
     * Removes an item from the fridge or freezer.
     *
     * @param item
     *            the name of the item to remove
     * @param isFridge
     *            true if the item goes in the fridge, false if in the freezer
     * @ensures the item is removed only if the door is open
     */
    public void removeItem(String item, boolean isFridge);

    /**
     * Checks if the item exists in the fridge.
     *
     * @param item
     *            the name of the item
     * @return true if the item is in the fridge, false otherwise
     * @requires this is an item
     */
    public boolean isInFridge(String item);

}
