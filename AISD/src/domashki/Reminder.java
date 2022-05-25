package domashki;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.time.Instant;

public class Reminder {
    @Test
    void checkSave(){
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));

        Assertion.assertEquals(2, repository.getAll().size());
        repository.deleteAll();
    }

    @Test
    void checkGetId(){
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), false));

        Assertion.assertEquals("Test2", repository.getById().getText());
        repository.deleteAll();
    }

    @Test
    void checkUndonable(){
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), true));

        Assertion.assertEquals(2, repository.getUndoneByDate(Instant.ofEpochSecond(1648190891)).size());
        repository.deleteAll();
    }

    @Test
    void checkRremoveIP(){
        repository.save(new Note("Test1", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test2", Instant.ofEpochSecond(1648190891), true));
        repository.save(new Note("Test3", Instant.ofEpochSecond(1648190891), false));
        repository.save(new Note("Test4", Instant.ofEpochSecond(1648190891), true));

        repository.delete(2);
        NotePersistenceException thrown = Assertions.assertThrows(NotePersistenceException.clss, () -> {
            reository.getById(2);
        });

        Assertions.assertEquals("Note with idd 2 not found", thrown.getMessage());
        reposistory.deleteAll();
    }
}
