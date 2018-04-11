import java.util.InputMismatchException;			//Import der Input Mismatch Exception. Wichtig f�r das Men�
import java.util.Scanner; 							//Import eines Scanners. Wichtig f�r das Men�
import java.util.concurrent.ThreadLocalRandom;		// Import von ThreadLocalRandom. Wird genutzt um Zufallszaheln zu generieren


public class sudoku
{
   private static int count =0;						//Die Variable count z�hlt im Velauf des Programms die Anzahl m�glicher L�sungen f�r ein Sudoku
   public static void main(String[] args)
   {
	
	Scanner in = new Scanner(System.in);
	int Number = 0;									//Diese Variable dient zur Auswahl, ob eine Sudoku generiert oder gel�st werden soll
	int[][] A = new int[9][9];						// Hier wird das Array A erstellt. Das Sudoku welches in dieses Array eingegeben wird kann mit dem Programm gel�st werden.						
	
	A[0][0] = 0;A[0][1] = 2;A[0][2] = 1;    A[0][3] = 0;A[0][4] = 0;A[0][5] = 4;    A[0][6] = 3;A[0][7] = 0;A[0][8] = 6;
	A[1][0] = 3;A[1][1] = 7;A[1][2] = 6;    A[1][3] = 5;A[1][4] = 0;A[1][5] = 0;    A[1][6] = 4;A[1][7] = 8;A[1][8] = 9;
	A[2][0] = 0;A[2][1] = 4;A[2][2] = 0;    A[2][3] = 6;A[2][4] = 3;A[2][5] = 0;    A[2][6] = 1;A[2][7] = 0;A[2][8] = 0;

	A[3][0] = 0;A[3][1] = 6;A[3][2] = 9;    A[3][3] = 0;A[3][4] = 7;A[3][5] = 3;    A[3][6] = 8;A[3][7] = 4;A[3][8] = 5;
	A[4][0] = 2;A[4][1] = 0;A[4][2] = 0;    A[4][3] = 9;A[4][4] = 0;A[4][5] = 0;    A[4][6] = 6;A[4][7] = 1;A[4][8] = 0;
	A[5][0] = 0;A[5][1] = 5;A[5][2] = 0;    A[5][3] = 4;A[5][4] = 0;A[5][5] = 0;    A[5][6] = 0;A[5][7] = 0;A[5][8] = 3;

	A[6][0] = 0;A[6][1] = 0;A[6][2] = 0;    A[6][3] = 0;A[6][4] = 0;A[6][5] = 0;    A[6][6] = 0;A[6][7] = 0;A[6][8] = 0;
	A[7][0] = 0;A[7][1] = 1;A[7][2] = 5;    A[7][3] = 0;A[7][4] = 4;A[7][5] = 6;    A[7][6] = 2;A[7][7] = 9;A[7][8] = 0;
	A[8][0] = 0;A[8][1] = 0;A[8][2] = 0;    A[8][3] = 7;A[8][4] = 0;A[8][5] = 9;    A[8][6] = 0;A[8][7] = 6;A[8][8] = 0;

	System.out.println("                                                             ");													//Men� des Sudokus
	System.out.println("                   .oPYo.             8        8             ");
	System.out.println("                   8                  8        8             ");
	System.out.println("                   `Yooo. o    o .oPYo8 .oPYo. 8  .o  o    o ");
	System.out.println("                       `8 8    8 8    8 8    8 8oP'   8    8 ");
	System.out.println("                        8 8    8 8    8 8    8 8 `b.  8    8 ");
	System.out.println("                   `YooP' `YooP' `YooP' `YooP' 8  `o. `YooP' ");
	System.out.println("                   :.....::.....::.....::.....:..::...:.....:");
	System.out.println("                   ::::::::::::::::::::::::::::::::::::::::::");
	System.out.println("                   ::::::::::::::::::::::::::::::::::::::::::");
	System.out.println("");
	System.out.println("");
	System.out.println("Um ein neues Sudoku zu generieren gebe die 1 ein und best�tige mit enter");        	
	System.out.println("Um ein Sudoku zu l�sen gebe die 2 ein und best�tige mit enter");   
	while(true){
			try{
				Number = in.nextInt();																							
				if(Number == 1){																							// Wenn man 1 eingibt wird die Funktion Generate aufgerufen
					System.out.println("Aye Aye Sir. Sudoku wird generiert:");
					Generate();
					break;
				}else if(Number == 2){																						// Wenn man 2 eingibt wird die Funktion Solve aufgerufen
					Solve(A);
					break;
				}else{																										// Wenn man Integer eingibt, aber nicht 1 oder 2, wird der Benutzer erneut aufgeforder 1 oder 2 einzugeben
					System.out.println("Bitte gebe eine 1 oder eine 2 ein");
				}
			}
			catch (InputMismatchException ex )																				// Wenn man kein Integer eingibt wird der Benutzer erneut aufgeforder 1 oder 2 einzugeben
				{ 
					System.out.println("Bitte gebe eine 1 oder eine 2 ein");
					String flush = in.next();   //L�scht Falsche-Eingabe, um Wiederholungen zu vermeiden.
				} 
	}
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("Press any Key to close the Window");
	in.next();
	in.close();
	
	
	
   }
   public static void Generate(){																	//Funktion generiet das Sudoku
	   int[][] B = new int[9][9];
	   generate(0,0,B);																				//1. Ein vollst�ndig ausgef�lltes Sudokufeld wird in der generate-Funktion erstellt			
	   
	   while(true){
		   int[][] A=new int[9][9];																	//2.zuf�llige Zahlen werden aus dem Sudoku entfernt
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
		   if(test(nextposy,nextposx,A)){															//3. testet wie viele L�sungen das SUdoku hat. Bricht ab wenn es nur noch eine gibz
			   break;
		   }
		   for(int i=0;i<C.length;i++){
				  for(int j=0;j<C[i].length;j++){
					  B[i][j]=C[i][j];
				  }
		   }
	   }
		   
	   Ausgabe(B);																					//4. Das generierte Sudoku wir ausgegeben
   }
   
   	public static void Solve(int[][] A){															//Diese Funktion l�st das Sudoku in Array A
   		int nextposx= 0;
   		int nextposy= 0; 																			//n�chste freie Stelle wird gesucht			
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
	System.out.println("Ohne L�sung sieht es so aus:");												// ungel�stes Sudoku wird ausgegeben				
	Ausgabe(A);
	
	backtrack(nextposy,nextposx,A);																	// Sudoku wird gel�st
	if(count>0){
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("Das Sudoku hat: "+ count + " L�sungen");									// Anzahl der m�glichen L�sungen wird ausgegeben	
	}else{
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println("Das Sudoku hat keine L�sung");
	}
   	}
	public static boolean backtrack(int i, int j,int[][] A){
		int nextposx= 0;
		int nextposy= 0;
		boolean end=false;
		
		for(int x = 1;x<=9;x++){
			A[i][j]= x;																				//Zahlen 1-9 werden in die freien Felder eingesetzt
			nextpos:{																				// n�chstes freies Feld wird gesucht				
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
				end = true;																			//Ende des Sudokus wurde erreicht, keine freine Felder mehr �brig
			}
			if(checker(x,i,j,A)== true){															//test ob die Zahl legetim ist
				if(end){																			//test ob das Ende des Sudokus erreicht wurde
						count++;
						System.out.println();
						System.out.println();
						System.out.println("Eine L�sung w�re:");
						Ausgabe(A);																	//Ausgabe der L�sung
						end = false;
						return false;
				}else if(backtrack(nextposy,nextposx,A) == true){									//Rekursion		
					return true;						
				}
			}	
		}
		A[i][j]= 0;
		return false;	
		
	}
	public static boolean generate(int i, int j,int[][] A){											// wie Backtrack
		int nextposx= 0;
		int nextposy= 0;
		boolean end=false;
		int S[] = {1,2,3,4,5,6,7,8,9};
		shuffle(S);																					//Array wird gemischt um zuf�llige Sudokus zu generieren
		
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
	public static boolean test(int i, int j,int[][] A){												// auch wie backtrack, bricht aber bei mehr als einer L�sung ab
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

	public static void shuffle(int S[]) {																//Diese Funktion mischt ein Array mit Hilfe des Fisher-Yates Shuffle
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
		for(int k = 8;k>=0 ;k--){																		//testet ob Zahl in der x-Reihe schon vorkommt
			if(k !=j){
				if(x == A[i][k]){
					return false;
				}
			}
		}
		for(int l = 8;l>=0 ;l--){																		//testet ob Zahl in der y-Reihe schon vorkommt
			if(l !=i){
				if(x == A[l][j]){
					return false;
				}
			}
		}
		if(j/3 == 0){																					//testet ob Zahl im 3x3 Feld vorkommt
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
	
	public static void Ausgabe(int[][] A){													//Diese Funktion gibt das Sudoku Array aus und f�gt noch ein Gitternetz ein.
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
