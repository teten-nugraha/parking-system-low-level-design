package model;

import java.util.HashMap;
import java.util.Map;

/**
 * Package: model
 * <p>
 * User: TetenNugraha
 * Date: 7/26/2021
 * Time: 3:33 PM
 * <p>
 * Created with IntelliJ IDEA
 * To change this template use File | Settings | File Templates.
 */
public enum SlotSize {
    TWO_WHEELER(1), MINI(3), MICRO(4), PREMIUM(5);

    private static final Map<Integer, SlotSize> _map = new HashMap<Integer, SlotSize>();

    static {
        for (SlotSize slotSize : SlotSize.values())
            _map.put(slotSize.size, slotSize);
    }

    int size;

    SlotSize(int size) {
        this.size = size;
    }

    public static SlotSize getSLot(int value) {
        return _map.get(value);
    }
}
