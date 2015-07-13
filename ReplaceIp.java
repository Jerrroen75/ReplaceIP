package org.repip;

public class ReplaceIp {
	public static void main(String[] args) {

		ReplaceText replaceText = new ReplaceText();
		if (args.length != 2 ) {
			System.out.println("Tool to replace IP address in ICE-XS .nof server files");
			System.out.println("v0.1, Jeroen Broers 2015");			System.out.println("Usage: ReplaceIP <input file> <new IP address> ");
			System.exit(0);
		}
		replaceText.setFileName(args[0]);
		replaceText.setReplacement(args[1]);
	
		if (replaceText.replaceIp()) {
			System.out.println("Successfully changed IP-address to "
					+ replaceText.getReplacement() + " in '"
					+ replaceText.getFileName() + "'");
		}

	}

}
