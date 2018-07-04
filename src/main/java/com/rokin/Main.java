package com.rokin;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println(convertPdfToText("/home/lt88/Desktop/Rokin.pdf"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	public static String convertPdfToText(String filePath) throws IOException {
		File f = new File(filePath);
		String parsedText;
		PDFParser parser = new PDFParser(new RandomAccessFile(f, "r"));
		parser.parse();
		
		COSDocument cosDoc = parser.getDocument();
		PDFTextStripper pdfStripper = new PDFTextStripper();
		PDDocument pdDoc = new PDDocument(cosDoc);
		parsedText = pdfStripper.getText(pdDoc);

		return parsedText;
	}
}
