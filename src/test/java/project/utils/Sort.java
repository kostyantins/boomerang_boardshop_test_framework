package project.utils;

import com.google.common.collect.Ordering;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import project.enums.OrderLine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static project.enums.OrderLine.DESCENDANT;

public final class Sort {

    private Sort() {
    }

    public static final boolean isListSorted(final List<WebElement> elementsList, final OrderLine order) {

        final List<String> gridsColumnValues = elementsList
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        if (order == DESCENDANT) {
            return Ordering
                    .natural()
                    .reverse()
                    .isOrdered(gridsColumnValues);
        } else {
            return Ordering
                    .natural()
                    .isOrdered(gridsColumnValues);
        }
    }


    public final static boolean isDoubleListSorted(final List<WebElement> elementsList, final OrderLine order) {

        final ArrayList<Double> gridsColumnDoubleValues = elementsList
                .stream()
                .map(WebElement::getText)
                .map(Double::parseDouble)
                .collect(Collectors.toCollection(ArrayList::new));

        if (order == DESCENDANT) {
            return Ordering
                    .natural()
                    .reverse()
                    .isOrdered(gridsColumnDoubleValues);
        } else {
            return Ordering
                    .natural()
                    .isOrdered(gridsColumnDoubleValues);
        }
    }
}
