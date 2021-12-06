package by.zastr.composite.reader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.zastr.composite.exception.CompositeException;

public class TextReader {
	private static Logger logger= LogManager.getLogger();
	public String readText(String fileName) throws CompositeException {
		if(fileName == null||fileName.isBlank()) {
			throw new CompositeException(String.format("Filename %s is mull or empty ", fileName));
		}
		Path dataFile = Paths.get(fileName);
        String text="";

        try (Stream<String> dataStream = Files.lines(dataFile,Charset.forName("windows-1251"))){
        	text= dataStream.collect(Collectors.joining());
            logger.log(Level.INFO, "Read file {} is successful", dataFile.getFileName());

        } catch (IOException e) {
            throw new CompositeException("Input error during reading file " + dataFile.getFileName(), e);
        }
		return text;
	}

}
