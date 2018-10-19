package utils;

public class StrToNum {
	private static int value = -1;
	
	public static boolean isOk(String s) {
		if(s != null && !s.trim().equals("")) {
			try {
				value = Integer.parseInt(s);
			} catch(Exception e) {
				System.out.println("×Ö·û´®×ª»»Êý×ÖÊ§°Ü£¡");
				return false;
			}
		}		
		return true;
	}
	
	static public int getNum() {
		return value;
	}
}
