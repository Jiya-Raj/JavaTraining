package q1_q2_CharAndByteStream;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		String filePath = "src\\q1_q2_CharAndByteStream\\dta";
		String charCopy = "src\\q1_q2_CharAndByteStream\\charCopy";
		String byteCopy = "src\\q1_q2_CharAndByteStream\\byteCopy";

		String bufferedCharCopy = "src\\q1_q2_CharAndByteStream\\bufferedCharCopy";
		String bufferedByteCopy = "src\\q1_q2_CharAndByteStream\\bufferedByteCopy";

		// generate copies
		// non-buffered
		long start = System.currentTimeMillis();
		charStream(filePath, charCopy);
		long charTime = System.currentTimeMillis() - start;

		start = System.currentTimeMillis();
		byteStream(filePath, byteCopy);
		long byteTime = System.currentTimeMillis() - start;

		// buffered copy
		start = System.currentTimeMillis();
		bufferedCharStream(filePath, bufferedCharCopy);
		long bufferedCharTime = System.currentTimeMillis() - start;

		start = System.currentTimeMillis();
		bufferedByteStream(filePath, bufferedByteCopy);
		long bufferedByteTime = System.currentTimeMillis() - start;

		File original = new File(filePath);

		System.out.println("\n--- File Size Comparison ---");
		System.out.println("Original file length : " + original.length());
		System.out.println("Character Copy length : " + new File(charCopy).length());
		System.out.println("Byte Copy length : " + new File(byteCopy).length());
		System.out.println("Buffered Character Copy length : " + new File(bufferedCharCopy).length());
		System.out.println("Buffered Byte Copy length : " + new File(bufferedByteCopy).length());

		System.out.println("\n--- Performance Comparison ---");
		System.out.println("Char Stream (No Buffer) : " + charTime + " ms");
		System.out.println("Byte Stream (No Buffer) : " + byteTime + " ms");
		System.out.println("Buffered Char Stream : " + bufferedCharTime + " ms");
		System.out.println("Buffered Byte Stream : " + bufferedByteTime + " ms");
	}

	public static void charStream(String filePath, String destination) {

		try {
			FileReader fr = new FileReader(filePath);
			FileWriter fw = new FileWriter(destination);

			int ch;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}

			fw.flush();// FileWriter uses an internal buffer.
//			Data stays in memory until it is flushed or closed.
//			When you called flush(), Java was forced to write buffered data to the file immediately.
			System.out.println("Char stream copy generated");
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error (Char Stream): " + e.getMessage());
		}
	}

	public static void byteStream(String filePath, String destination) {

		try {
			FileInputStream fr = new FileInputStream(filePath);
			FileOutputStream fw = new FileOutputStream(destination);

			int ch;
			while ((ch = fr.read()) != -1) {
				fw.write(ch);
			}

			System.out.println("Byte stream copy generated");
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + e.getMessage());
		} catch (IOException e) {
			System.out.println("Error (byte Stream): " + e.getMessage());
		}
	}

	public static void bufferedCharStream(String source, String dest) {
		try (BufferedReader br = new BufferedReader(new FileReader(source));
				BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {

			int ch;
			while ((ch = br.read()) != -1) {
				bw.write(ch);
			}
			bw.flush();
			System.out.println("Buffered Character Stream copy generated");
		} catch (IOException e) {
			System.out.println("Error (Buffered Char Stream): " + e.getMessage());
		}
	}

	public static void bufferedByteStream(String source, String dest) {
		try (BufferedInputStream br = new BufferedInputStream(new FileInputStream(source));
				BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream(dest))) {

			int ch;
			while ((ch = br.read()) != -1) {
				bw.write(ch);
			}
			bw.flush();
			System.out.println("Buffered Character Stream copy generated");
		} catch (IOException e) {
			System.out.println("Error (Buffered byte Stream): " + e.getMessage());
		}
	}

}
