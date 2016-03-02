package by.bsuir.kovalchuk.requestservice.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class ImageService {

	private String folder;

	public ImageService() {
	}

	public ImageService(String folder) {
		this.folder = folder;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public String saveImage(MultipartFile mpf) throws Exception {
		String name = mpf.getOriginalFilename();
		try (FileOutputStream fos = new FileOutputStream(folder + name)) {
			fos.write(mpf.getBytes());
		} catch (IOException e) {
			throw new Exception(e);
		}
		return name;
	}

	public byte[] getImage(String path) throws Exception {
		File file = new File(folder + path);
		byte[] imageBytes = null;
		if (file.exists()) {
			try (FileInputStream fileInputStream = new FileInputStream(file)) {
				imageBytes = new byte[(int) file.length()];
				fileInputStream.read(imageBytes);
				return imageBytes;
			} catch (IOException e) {
				throw new Exception();
			}
		}
		return imageBytes;
	}

	public void deleteImage(String path) {
		File image = new File(path);
		if (image.exists()) {
			image.delete();
		}
	}

}
