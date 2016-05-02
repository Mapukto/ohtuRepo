package statistics.matcher;

import statistics.Player;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Jussi on 28/04/16.
 */
public class HasFewerThan implements Matcher {
    private int value;
    private String fieldName;

    public HasFewerThan(int amount, String category) {
        this.value = amount;
        this.fieldName = "get"+Character.toUpperCase(category.charAt(0))+category.substring(1, category.length());
    }

    @Override
    public boolean matches(Player p) {
        try {
            Method method = p.getClass().getMethod(fieldName);
            int playersValue = (Integer)method.invoke(p);
            return playersValue<value;

        } catch (Exception ex) {
            System.out.println(ex);
            throw new IllegalStateException("Player does not have field "+fieldName.substring(3, fieldName.length()).toLowerCase());
        }

    }




}

