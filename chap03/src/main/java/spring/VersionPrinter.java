package spring;

public class VersionPrinter {
	private int majorVersion; 
	private int minorVersion;
	
	public VersionPrinter setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
		return this;
	}
	public VersionPrinter setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
		return this;
	} 
	
	public void print() {
		System.out.printf("이 프로그램의 버전은 %d.%d입니다.\n\n",
				majorVersion, minorVersion);
	}
	
}
