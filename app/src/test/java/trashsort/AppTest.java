/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package trashsort;

import org.junit.jupiter.api.Test;
//import org.junit.platform.engine.support.discovery.SelectorResolver.Match;
import static trashsort.TrashSort.*;
//import static org.junit.jupiter.api.Assertions.*;

class TrashTest {
    @Test void Difficulty() {
        assert(matchDifficultyText("normal") == 1);
    }
}