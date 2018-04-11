import java.awt.*;        
import java.awt.event.*; 
import javax.swing.*;    


public class test extends JFrame{
	public static final int GRID_SIZE=9;															//Grundvariablen f�r Sudoku
	public static final int SUBGRID_SIZE=3;
	
	public static final int CELL_SIZE = 60;   
	public static final int CANVAS_WIDTH  = CELL_SIZE * GRID_SIZE;
	public static final int CANVAS_HEIGHT = CELL_SIZE * GRID_SIZE;
	                                             
	public static final Color OPEN_CELL_BGCOLOR = Color.YELLOW;
	public static final Color OPEN_CELL_TEXT_YES = new Color(0, 255, 0);  // RGB
	public static final Color OPEN_CELL_TEXT_NO = Color.RED;
	public static final Color CLOSED_CELL_BGCOLOR = new Color(240, 240, 240); // RGB
	public static final Color CLOSED_CELL_TEXT = Color.BLACK;
	public static final Font FONT_NUMBERS = new Font("Monospaced", Font.BOLD, 20);
	   
	private JTextField[][] tfCells = new JTextField[GRID_SIZE][GRID_SIZE];
	private JButton[][] bCells= new JButton[5][2];
	public int[][] solution;
	


	public test(int mask[][],int puzzle[][]){
		solution = puzzle;
		Container cp = getContentPane();																				//Sudoku-Gitter wird erstellt			
		cp.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE));
		InputListener listener = new InputListener();
		for(int row = 0;row<GRID_SIZE;++row){
			for (int col = 0; col < GRID_SIZE; ++col) {
				tfCells[row][col]= new JTextField();
				tfCells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				
				if((row==2||row ==5)&& (col==2||col ==5) ){
					tfCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 3, Color.BLACK));
				
				}
				else if(row==2||row ==5){
					tfCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 3, 1, Color.BLACK));
				}
				else if(col==2||col ==5){
					tfCells[row][col].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 3, Color.BLACK));
				}
				cp.add(tfCells[row][col]);
				
				if(mask[row][col]==0){																					//Sudoku Gitter wird ausgef�llt				
					tfCells[row][col].setText("");
					tfCells[row][col].setEditable(true);
					tfCells[row][col].setBackground(OPEN_CELL_BGCOLOR);
					tfCells[row][col].addActionListener(listener);
				}else{
					tfCells[row][col].setText(puzzle[row][col]+"");
					tfCells[row][col].setEditable(false);
					tfCells[row][col].setBackground(CLOSED_CELL_BGCOLOR);
					tfCells[row][col].setForeground(CLOSED_CELL_TEXT);
				}
				tfCells[row][col].setHorizontalAlignment(JTextField.CENTER);
				tfCells[row][col].setFont(FONT_NUMBERS);
				
			}

			
		}
		
		
		cp.setPreferredSize(new Dimension(CANVAS_WIDTH,CANVAS_HEIGHT));
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	    setTitle("Sudoku");
	    setVisible(true);
	}
	
	 private class InputListener implements ActionListener {																	//Event schaut, ob Zahlen in das Sudoku eingef�llt werden und f�rbt sie entsprechend
		 
			 
		 
	      
	      public void actionPerformed(ActionEvent e) {
	         int rowSelected = -1;
	         int colSelected = -1;
	 
	         JTextField source = (JTextField)e.getSource();
	       
	         boolean found = false;
	         for (int row = 0; row < GRID_SIZE && !found; ++row) {
	            for (int col = 0; col < GRID_SIZE && !found; ++col) {
	               if (tfCells[row][col] == source) {
	                  rowSelected = row;
	                  colSelected = col;
	                  found = true; 
	               }
	            }
	         }
	         String InputStr = tfCells[rowSelected][colSelected].getText();
	         
	         if(InputStr==""){
	        	 tfCells[rowSelected][colSelected].setForeground(CLOSED_CELL_TEXT);
	         } else{
	        	 Integer InputInt = Integer.parseInt(InputStr);
	        	 if(InputInt == solution[rowSelected][colSelected]){
		        	 tfCells[rowSelected][colSelected].setForeground(OPEN_CELL_TEXT_YES);
		         } else{
		        	 tfCells[rowSelected][colSelected].setForeground(OPEN_CELL_TEXT_NO);
		         }
	        	 
	         }
	        
	         
	         
	      }
	   }
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}