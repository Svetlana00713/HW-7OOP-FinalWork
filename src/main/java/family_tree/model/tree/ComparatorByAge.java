package family_tree.model.tree;

import java.time.LocalDate;
import java.util.Comparator;

public class ComparatorByAge<T extends TreeNode> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        LocalDate dateO1 = o1.getBirthDate();
        LocalDate dateO2 = o2.getBirthDate();
        int result =  dateO1.getYear() - dateO2.getYear();
        if (result == 0) {
            result = dateO1.getMonthValue() - dateO2.getMonthValue();
            if (result == 0) {
                result = dateO1.getDayOfMonth() - dateO2.getDayOfMonth();
            }
        }
        return result;
    }

    @Override
    public Comparator<T> reversed() {
        return Comparator.super.reversed();
    }

}
