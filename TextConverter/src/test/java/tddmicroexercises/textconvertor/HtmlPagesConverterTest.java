package tddmicroexercises.textconvertor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;

public class HtmlPagesConverterTest {

    @Test
    public void foo() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        String fileName = file.getAbsolutePath();

        HtmlPagesConverter converter = new HtmlPagesConverter(fileName);
        assertEquals(fileName, converter.getFilename());
    }

    @Test
    void testConvertHtml() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.txt").getFile());
        String fileName = file.getAbsolutePath();

        HtmlPagesConverter converter = new HtmlPagesConverter(fileName);

        String page = converter.getHtmlPage(0);

        assertEquals("test<br />abcd<br />", page);
    }

}
