package bowlingGame;

public class WholeDisplay {
	
	int playerNumber;
	
	WholeDisplay(int playerNumber){
		this.playerNumber = playerNumber;
	}
	
	void showWholeDisplay(){
		System.out.println(" ---------------------------------------------------------------------------");
		System.out.println("|  P  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |  10  |");
		for(int i=1;i<playerNumber+1;i++){
		System.out.println("|  "+i+"  |   0 *|   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |");
		System.out.println("|  "+i+"  |   0 /|   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |   0  |");
		}
		System.out.println(" ---------------------------------------------------------------------------");		
	}
	
}
