package q1_FileDownloader;

public class MainDownloader {

	public static void main(String[] args) {

		String[] files = new String[25];
		for (int i = 1; i <= 25; i++) {
			files[i - 1] = "photo" + i + ".jpg";
		}

		for (int i = 0; i < files.length; i++) {
			FileDownloader downloader = new FileDownloader(files[i]);
			Thread thread = new Thread(downloader, "Thread-" + (i + 1));
			thread.start();
		}
	}
}
