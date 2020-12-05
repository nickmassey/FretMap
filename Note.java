package fretPkg;

public class Note {
	
	private int noteVal;
	private int octVal;
	private String[] notes = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
	
	public void setNoteValue(int note, int octave) {
		noteVal = note;
		octVal = octave;
	}
	
	public void setNoteValue(int note) {
		noteVal = note;
	}
	
	public int getNote() {
		return noteVal;
	}
	
	public int getOct() {
		return octVal;
	}
	
	public String getNoteName(int indice) {
		return (notes[(indice+1)]);
	}
}
