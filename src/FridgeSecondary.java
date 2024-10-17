/**
 * Enhanced functionality of a fridge component.
 */
public interface FridgeSecondary {

    /**
     * Gets the number of items in either the fridge or freezer.
     *
     * @param item
     *            num of that item
     * @param isFridge
     *            True to count fridge items, false for freezer items.
     * @return The number of items in the selected compartment.
     * @ensures The return value is non-negative.
     */
    public int getNumOfItems(String item, boolean isFridge);

    /**
     * Checks if the item exists in the freezer
     *
     * @param item
     *            the name of the item
     * @return true if the item is in the frezer, false otherwise
     * @requires this is an item
     */
    public boolean isInFreezer(String item);

    /**
     * Gets the total number of items in both the fridge and freezer.
     *
     * @return The total number of items.
     * @ensures The return value is non-negative.
     */
    public int totalNumOfItems();
}
