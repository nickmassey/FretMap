package fretPkg;

public class Chord extends Fretboard {

	private final int[] maj = {0, 4, 7};
	private final int[] maj7 = {0, 4, 7, 11};
	private final int[] min = {0, 3, 7};
	private final int[] min7 = {0, 3, 7, 10};
	private int[] usrCho = new int[4];
	private int root;
	
	
	public void majCho (){
		for(int i = 0; i < maj.length; i++)
		{
			usrCho[i] = maj[i] + root;
			if(usrCho[i] > 11) {
				usrCho[i] = usrCho[i] - 12;
			}
		}		
	}
	
	public void maj7Cho (){
		for(int i = 0; i < maj7.length; i++)
		{
			usrCho[i] = maj7[i] + root;
			if(usrCho[i] > 11) {
				usrCho[i] = usrCho[i] - 12;
			}
		}		
	}
	
	public void minCho (){
		for(int i = 0; i < min.length; i++)
		{
			usrCho[i] = min[i] + root;
			if(usrCho[i] > 11) {
				usrCho[i] = usrCho[i] - 12;
			}
		}		
	}
	
	public void min7Cho (){
		for(int i = 0; i < min7.length; i++)
		{
			usrCho[i] = min7[i] + root;
			if(usrCho[i] > 11) {
				usrCho[i] = usrCho[i] - 12;
			}
		}		
	}
	
	public int[] getCho() {
		return usrCho;
	}
	
	public void setRoot(int indice) {
		root = indice;
	}
	
	public int getRoot() {
		return root;
	}
	
	public void printChord() {
		for(int i = 0; i < usrCho.length; i++) {
			System.out.println(usrCho[i]);
		}
	}
}