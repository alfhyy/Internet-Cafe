package internet_cafe_refactored;

/**
 * Interface class for defining customer actions
 *
 * This interface provides a contract for classes that handle
 * customer-related actions, particularly food ordering functionality
 *
 * @author alfhy
 * @version 1.0
 */

public interface customerAction {

    /**
     * Records a food order for customer
     *
     * @param item as the item name
     * @param price as the price that customer has to pay
     */
    void orderFood(String item, float price);
}
