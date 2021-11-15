package ru.croc.task13;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface BlackListFilter {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments list of comments; every comment
     *                 is a sequence of words, separated
     *                 by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
     default void filterComments(List<String> comments, Set<String> blackList) {
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


/*
for (String comment : comments) {
        for (String badWord : blackList) {
        if (comment.toLowerCase().contains(badWord)) {
        comments.remove(comment);
        break;
        }
        }
        }
*/
