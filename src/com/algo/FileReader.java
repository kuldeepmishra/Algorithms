package com.algo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

	private static final String pathname = "/Users/z002wpv/Documents/Redmi_K20_Pro/CameraCopy/Camera5";

	public static void main(String[] args) throws IOException {
		//moveFiles();
		deleteFiles();
	}

	private static void deleteFiles() throws IOException {
		List<String> photoNames = Files.lines(Paths.get("/Users/z002wpv/Documents/Redmi_K20_Pro/photo_name.txt")).collect(Collectors.toList());

		File file = new File(pathname);
		for (File photos : file.listFiles()) {
			if(photos.isFile()) {
				if(!photoNames.contains(photos.getName())) {
					System.out.println(photos.getName()); 
				} else {
					photos.delete();
				}
			}
		}
	}

	private static void moveFiles() {
		File file = new File(pathname);

		int counter = 0;
		int i=1;
		for (File photos : file.listFiles()) {
			if(photos.isFile()) {

				File dest = new File("/Users/z002wpv/Documents/Redmi_K20_Pro/CameraCopy/Camera"+i);
				dest.mkdirs();

				if(photos.renameTo(new File(dest.getAbsolutePath()+"/"+photos.getName())))
					counter++;
			}

			if(counter == 200) {
				counter = 0;
				i++;
			}
		}
	}

}
