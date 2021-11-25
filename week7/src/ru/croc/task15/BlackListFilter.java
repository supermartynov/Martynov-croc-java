package ru.croc.task15;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public interface BlackListFilter {

    default <T> List<T> filterComments(Iterable<T> comments, Predicate<T> checkBadWords) {
        List<T> resultList = new ArrayList<>();
        Iterator<T> iteratorForComments = comments.iterator();
        while (iteratorForComments.hasNext()) {
            T currentIter = iteratorForComments.next();
            if (checkBadWords.test(currentIter)) { //если true - запроетных слов не обнаружено
                resultList.add(currentIter);
            }
        }
        return resultList;
    }
}

