package org.repip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ReplaceText {

	private String fileName;
	private String replacement;

	// constructor
	public ReplaceText() {
		fileName = "Unknown file name";

	}

	// getters and setters
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		}

	public String getReplacement() {
		return replacement;
	}

	public void setReplacement(String replacement) {
	    
		this.replacement = replacement;
	}

	// methods
	public boolean replaceIp() {

		String line = null;

		try {
			File originalFile = new File(fileName);

			FileReader fileReader = new FileReader(originalFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			File tempFile = new File("tempfile.txt");
			PrintStream printStream = new PrintStream(tempFile);

			while ((line = bufferedReader.readLine()) != null) {
				if (line.contains("AUTHZADDR")) {
					line = line.replaceAll(
							"\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}",
							replacement); // replace IP-address
				}
				printStream.println(line);
			}
			bufferedReader.close();
			printStream.close();

			// Delete the original file
			if (!originalFile.delete()) {
				System.out.println("Could not delete file");
				return false;
			}

			// Rename the new file to the filename the original file had.
			if (!tempFile.renameTo(originalFile)) {
				System.out.println("Could not rename file");
				return false;
			}

		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
			return false;
		}

		catch (IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
			return false;
		}

		return true;
	}

}
