import java.util.InputMismatchException;
import java.util.Scanner; 
import java.util.concurrent.ThreadLocalRandom;












//Genau gleich wie sudoku.java in Java Project: Sudoku generiert aber nur Sudokus und gibt sie in einem GUI aus
// In Zeile 141 wird das GUI erstellt und test.java aufgerufen



























public class sudoku
{
   private static int count =0;
   public static void main(String[] args)
   {
	
	int[][] A = new int[9][9];
	/*A[0][0] = 3;A[0][1] = 0;A[0][2] = 0;    A[0][3] = 2;A[0][4] = 4;A[0][5] = 0;    A[0][6] = 0;A[0][7] = 6;A[0][8] = 0;
	A[1][0] = 0;A[1][1] = 4;A[1][2] = 0;    A[1][3] = 0;A[1][4] = 0;A[1][5] = 0;    A[1][6] = 0;A[1][7] = 5;A[1][8] = 3;
	A[2][0] = 1;A[2][1] = 8;A[2][2] = 9;    A[2][3] = 6;A[2][4] = 3;A[2][5] = 5;    A[2][6] = 4;A[2][7] = 0;A[2][8] = 0;

	A[3][0] = 0;A[3][1] = 0;A[3][2] = 0;    A[3][3] = 0;A[3][4] = 8;A[3][5] = 0;    A[3][6] = 2;A[3][7] = 0;A[3][8] = 0;
	A[4][0] = 0;A[4][1] = 0;A[4][2] = 7;    A[4][3] = 4;A[4][4] = 9;A[4][5] = 6;    A[4][6] = 8;A[4][7] = 0;A[4][8] = 1;
	A[5][0] = 8;A[5][1] = 9;A[5][2] = 3;    A[5][3] = 1;A[5][4] = 5;A[5][5] = 0;    A[5][6] = 6;A[5][7] = 0;A[5][8] = 4;

	A[6][0] = 0;A[6][1] = 0;A[6][2] = 1;    A[6][3] = 9;A[6][4] = 2;A[6][5] = 0;    A[6][6] = 5;A[6][7] = 0;A[6][8] = 0;
	A[7][0] = 2;A[7][1] = 0;A[7][2] = 0;    A[7][3] = 3;A[7][4] = 0;A[7][5] = 0;    A[7][6] = 7;A[7][7] = 4;A[7][8] = 0;
	A[8][0] = 9;A[8][1] = 6;A[8][2] = 0;    A[8][3] = 5;A[8][4] = 0;A[8][5] = 0;    A[8][6] = 3;A[8][7] = 0;A[8][8] = 2;*/
	
	/*A[0][0] = 0;A[0][1] = 0;A[0][2] = 0;    A[0][3] = 0;A[0][4] = 0;A[0][5] = 0;    A[0][6] = 0;A[0][7] = 0;A[0][8] = 0;
	A[1][0] = 0;A[1][1] = 0;A[1][2] = 0;    A[1][3] = 0;A[1][4] = 0;A[1][5] = 0;    A[1][6] = 0;A[1][7] = 0;A[1][8] = 0;
	A[2][0] = 0;A[2][1] = 0;A[2][2] = 0;    A[2][3] = 3;A[2][4] = 0;A[2][5] = 0;    A[2][6] = 0;A[2][7] = 6;A[2][8] = 0;

	A[3][0] = 0;A[3][1] = 0;A[3][2] = 0;    A[3][3] = 0;A[3][4] = 0;A[3][5] = 0;    A[3][6] = 0;A[3][7] = 0;A[3][8] = 3;
	A[4][0] = 0;A[4][1] = 0;A[4][2] = 0;    A[4][3] = 0;A[4][4] = 0;A[4][5] = 0;    A[4][6] = 0;A[4][7] = 0;A[4][8] = 1;
	A[5][0] = 0;A[5][1] = 0;A[5][2] = 0;    A[5][3] = 0;A[5][4] = 5;A[5][5] = 0;    A[5][6] = 0;A[5][7] = 0;A[5][8] = 6;

	A[6][0] = 0;A[6][1] = 0;A[6][2] = 0;    A[6][3] = 0;A[6][4] = 0;A[6][5] = 0;    A[6][6] = 2;A[6][7] = 8;A[6][8] = 0;
	A[7][0] = 0;A[7][1] = 0;A[7][2] = 0;    A[7][3] = 4;A[7][4] = 1;A[7][5] = 9;    A[7][6] = 0;A[7][7] = 0;A[7][8] = 5;
	A[8][0] = 0;A[8][1] = 0;A[8][2] = 0;    A[8][3] = 0;A[8][4] = 8;A[8][5] = 0;    A[8][6] = 0;A[8][7] = 7;A[8][8] = 9;*/
	
	A[0][0] = 0;A[0][1] = 2;A[0][2] = 1;    A[0][3] = 0;A[0][4] = 0;A[0][5] = 4;    A[0][6] = 3;A[0][7] = 0;A[0][8] = 6;
	A[1][0] = 3;A[1][1] = 7;A[1][2] = 6;    A[1][3] = 5;A[1][4] = 0;A[1][5] = 0;    A[1][6] = 4;A[1][7] = 8;A[1][8] = 9;
	A[2][0] = 0;A[2][1] = 4;A[2][2] = 0;    A[2][3] = 6;A[2][4] = 3;A[2][5] = 0;    A[2][6] = 1;A[2][7] = 0;A[2][8] = 0;

	A[3][0] = 0;A[3][1] = 6;A[3][2] = 9;    A[3][3] = 0;A[3][4] = 7;A[3][5] = 3;    A[3][6] = 8;A[3][7] = 4;A[3][8] = 5;
	A[4][0] = 2;A[4][1] = 0;A[4][2] = 0;    A[4][3] = 9;A[4][4] = 0;A[4][5] = 0;    A[4][6] = 6;A[4][7] = 1;A[4][8] = 0;
	A[5][0] = 0;A[5][1] = 5;A[5][2] = 0;    A[5][3] = 4;A[5][4] = 0;A[5][5] = 0;    A[5][6] = 0;A[5][7] = 0;A[5][8] = 3;

	A[6][0] = 0;A[6][1] = 0;A[6][2] = 0;    A[6][3] = 0;A[6][4] = 0;A[6][5] = 0;    A[6][6] = 0;A[6][7] = 0;A[6][8] = 0;
	A[7][0] = 0;A[7][1] = 1;A[7][2] = 5;    A[7][3] = 0;A[7][4] = 4;A[7][5] = 6;    A[7][6] = 2;A[7][7] = 9;A[7][8] = 0;
	A[8][0] = 0;A[8][1] = 0;A[8][2] = 0;    A[8][3] = 7;A[8][4] = 0;A[8][5] = 9;    A[8][6] = 0;A[8][7] = 6;A[8][8] = 0;

	
	Generate();
	
	
	
	
   }
   public static void Generate(){
	   int[][] B = new int[9][9];
	   generate(0,0,B);
	   int[][] A=new int[9][9];
	   while(true){
		   
			  for(int i=0;i<B.length;i++){
				  for(int j=0;j<B[i].length;j++){
					  A[i][j]=B[i][j];
				  }
			  }
		   int y = ThreadLocalRandom.current().nextInt(0,9);
		   int x = ThreadLocalRandom.current().nextInt(0,9);
		   if(A[y][x]!=0){
			   A[y][x]=0;
		   }
		  int[][] C=new int[9][9];
		  for(int i=0;i<A.length;i++){
			  for(int j=0;j<A[i].length;j++){
				  C[i][j]=A[i][j];
			  }
		  }
		   	int nextposx= 0;
	   		int nextposy= 0; 
	   		nextpos:{
			for(int g = 0;g<9;g++){
				for(int h = 0;h<9;h++){
					if(A[g][h]== 0){
						nextposx = h;
						nextposy = g;
						break nextpos;
					}
				}
			}
	   		}
	   		count=0;
		   if(test(nextposy,nextposx,A)){
			   break;
		   }
		   for(int i=0;i<C.length;i++){
				  for(int j=0;j<C[i].length;j++){
					  B[i][j]=C[i][j];
				  }
		   }
	   }
		   
	   test d = new test(B,A);
	   
   }
   
  
	public static boolean generate(int i, int j,int[][] A){
		int nextposx= 0;
		int nextposy= 0;
		boolean end=false;
		int S[] = {1,2,3,4,5,6,7,8,9};
		shuffle(S);
		
		for(int x = 0;x<=8;x++){
			A[i][j]= S[x];
			nextpos:{
				for(int g = i;g<9;g++){
					int b=0;
					if(g==i){
						b = j;
					}
					for(int h = b;h<9;h++){
						if(A[g][h]== 0){
							nextposx = h;
							nextposy = g;
							break nextpos;
						}
					}
				}
				end = true;
			}
			if(checker(S[x],i,j,A)== true){
				if(end){
						
						return true;
				}else if(generate(nextposy,nextposx,A) == true){
					return true;						
				}
			}	
		}
		A[i][j]= 0;
		return false;	
		
	}
	public static boolean test(int i, int j,int[][] A){
		int nextposx= 0;
		int nextposy= 0;
		boolean end=false;
		
		for(int x = 1;x<=9;x++){
			A[i][j]= x;
			nextpos:{
				for(int g = i;g<9;g++){
					int b=0;
					if(g==i){
						b = j;
					}
					for(int h = b;h<9;h++){
						if(A[g][h]== 0){
							nextposx = h;
							nextposy = g;
							break nextpos;
						}
					}
				}
				end = true;
			}
			if(checker(x,i,j,A)== true){
				if(end){
						if(count >= 1){
							return true;
						}
						count++;
						end = false;
						return false;
				}else if(test(nextposy,nextposx,A) == true){
					return true;						
				}
			}	
		}
		A[i][j]= 0;
		return false;	
		
	}

	public static void shuffle(int S[]) {
		int l = S.length;
		for(int i = 0;i<l;i++){
			int random = i+ ThreadLocalRandom.current().nextInt(0,l-i);
			int Number = S[random];
			S[random] = S[i];
            S[i] = Number;
		}
		
		
		}
	
	public static boolean checker(int x,int i,int j,int[][] A){
		int c=0;
		int b= 0;
		for(int k = 8;k>=0 ;k--){
			if(k !=j){
				if(x == A[i][k]){
					return false;
				}
			}
		}
		for(int l = 8;l>=0 ;l--){
			if(l !=i){
				if(x == A[l][j]){
					return false;
				}
			}
		}
		if(j/3 == 0){
			c=2;
		}else if(j/3 == 1){
			c=5;
		}else{
			c=8;
		}
		if(i/3 == 0){
			b=2;
		}else if(i/3 == 1){
			b=5;
		}else{
			b=8;
		}
		for(int l = b;l>=(b-2) ;l--){
			for(int k = c;k>=(c-2) ;k--){
				if(x == A[l][k]&&k!=j&&l!=i){
					return false;
				}
			}
		}
		return true;
	}
	
	public static void Ausgabe(int[][] A){
		for(int i = 0;i< 9;i++){
			if(i% 3== 0  && i != 0){
				System.out.println("------------");
				}
			for(int j=0;j<9;j++){
				if(j% 3== 0 && j != 0){
				System.out.print("|");
				}
				if(A[i][j]==0){
					System.out.print(" ");
				}else{
					System.out.print(A[i][j]);
				}
			}
			System.out.println();
			
			
		}
	}


   	
}
