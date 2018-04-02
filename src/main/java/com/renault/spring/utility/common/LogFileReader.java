package com.renault.spring.utility.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;

public class LogFileReader {

	private String fileName;

	public LogFileReader() {

	}

	public LogFileReader(String fileName) {
		this.fileName = fileName;
	}

	public void readFile() throws FileNotFoundException {
		if (fileName == null) {
			throw new FileNotFoundException("File name is not provided");
		}

		FileInputStream fileInputStream = new FileInputStream(fileName);
		LineIterator lineIterator = null;
		try {
			lineIterator = IOUtils.lineIterator(fileInputStream, "utf-8");

			while (lineIterator.hasNext()) {
				String line = lineIterator.nextLine();
				System.out.println(line);
			}
			lineIterator.close();
		} catch (Exception e) {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e1) {
					// e1.printStackTrace();
				}
			}
		} finally {
			if (fileInputStream != null) {
				try {
					fileInputStream.close();
				} catch (IOException e1) {
					// e1.printStackTrace();
				}
			}
		}
	}

}
