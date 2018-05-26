package direct;

public class CheckException {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		CheckException chkException = new CheckException();
		chkException.chkException();
		chkException.uncheckException();
	}
	public void chkException() throws InterruptedException{
		System.out.println("Checked Exception");
	}
	
	public void uncheckException(){
		System.out.println("Unchecked Exception");
	}

}
