package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class HtmlTextConverterTest {

    @Test
    public void foo() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        String fileName = file.getAbsolutePath();
        HtmlTextConverter converter = new HtmlTextConverter(fileName);
        assertEquals(fileName, converter.getFilename());
    }

    @Test
    void testConvert() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        String fileName = file.getAbsolutePath();

        HtmlTextConverter converter = new HtmlTextConverter(fileName);
        String html = converter.convertToHtml();
        assertEquals("test<br />abcd<br />", html);
    }

}
