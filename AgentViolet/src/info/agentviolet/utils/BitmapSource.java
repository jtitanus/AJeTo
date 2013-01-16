package info.agentviolet.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import javax.imageio.ImageIO;

public class BitmapSource {

	public static String RESOURCE_PATH = "";
	private static BitmapSource instance = null;
	private List<BufferedImage> images = new ArrayList<>();

	public static BitmapSource getInstance() {
		if (instance == null) {
			instance = new BitmapSource();
		}
		return instance;
	}

	private BitmapSource() {
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(new File("ResourceKit.jar"));
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				if (!entry.isDirectory()) {
					if (entry.getName().endsWith(".jpg") 
							|| entry.getName().endsWith(".png") 
							|| entry.getName().endsWith(".jpeg") 
							|| entry.getName().endsWith(".gif")) {
						BufferedImage img = ImageIO.read(zipFile.getInputStream(entry));
						if (img != null) {
							images.add(img);
						}
					}
				}
			}
		} catch (Exception exp) {
			exp.printStackTrace();
		} finally {
			if (zipFile != null) {
				try {
					zipFile.close();
				} catch (Exception e) {
				}
			}
		}
	}

	public BufferedImage getImage(int index) {
		return images.get(index);
	}
}
