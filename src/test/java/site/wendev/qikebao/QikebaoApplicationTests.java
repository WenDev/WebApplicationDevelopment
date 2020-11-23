package site.wendev.qikebao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import site.wendev.qikebao.entities.Worksheet;
import site.wendev.qikebao.mapper.WorksheetMapper;

@SpringBootTest
class QikebaoApplicationTests {
    @Autowired
    private WorksheetMapper mapper;

    @Test
    void testInsertWorksheet() {
        Worksheet worksheet = new Worksheet().setTitle("123test");
        mapper.insert(worksheet);
    }
}
