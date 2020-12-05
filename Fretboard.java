package fretPkg;

public class Fretboard extends Note {

	private Note fretArr[][] = new Note[6][24];
	
	public void initFrets() {
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 24; j++) {
				fretArr[i][j] = new Note();
			}
		}
	}
	
	public int getFretNote(int row, int col) {
		return (fretArr[row][col].getNote());
	}
	
	public String getFretNote(int indice) {
		return "lol";
	}
	
	public void setString(int indice, int noteVal) {		
		fretArr[indice][0].setNoteValue(noteVal);
		for(int j = 1; j < 24; j++)
        {
            fretArr[indice][j].setNoteValue(((fretArr[indice][j-1].getNote()) + 1));
            if(fretArr[indice][j].getNote() > 11)
            {
                fretArr[indice][j].setNoteValue(0);
            }
        }
	}
	
	public void consoleOut() {
		for(int i = 5; i >= 0; i--) {
			for(int j = 0; j < 24; j++) {
				//table.setValueAt(usrFret.getFretNote(i, j), i, j);
				//table.setValueAt(6, i, j);
				System.out.print(" (");
				System.out.print(this.getFretNote(i, j));
				System.out.print(") ");
			}
			System.out.println();
		}
		System.out.println();
	}


	//public void populateFrets
}
