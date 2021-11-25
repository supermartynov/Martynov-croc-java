package ru.croc.task13;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BlackListFilterImplementation implements BlackListFilter{
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator<String> iteratorForComments = comments.iterator();
        while (iteratorForComments.hasNext()) {
            String currentIter = iteratorForComments.next().toLowerCase();
            for (String badWord : blackList) {
                if (currentIter.contains(badWord)) {
                    iteratorForComments.remove();
                    break;
                }
            }
        }
    }
}