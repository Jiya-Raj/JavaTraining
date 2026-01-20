package q1_FileDownloader;

import java.util.Random;

public class FileDownloader implements Runnable {

	private String fileName;
	private static Random random = new Random();

	public FileDownloader(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " - Starting download: " + fileName);

			// Simulate download time between 200–500ms
			Thread.sleep(200 + random.nextInt(301));

			System.out.println(Thread.currentThread().getName() + " - Completed: " + fileName);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " - Download interrupted for: " + fileName);
		}
	}
}
