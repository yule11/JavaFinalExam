package bowlingGame;

public class GameSet {

	ScoreBoard scoreBoard[] ;
	int playerNumber;				//총 플레이어 
	int currentPlayer = 1;			//1
	
	/*
	String strike = "*";
	String spare = "/";
	String none = " ";
	*/
	
	void setPlayerNumber(int playerNumber){
		
		this.playerNumber = playerNumber;
	}
	
	
	void makeScoreBoard(){
		
		scoreBoard = new ScoreBoard[playerNumber];
		
		for(int i=0;i<playerNumber;i++){
			scoreBoard[i] = new ScoreBoard(i+1); // [0] = 1
		}	
	}
	
	
	void gameStart(){

		for(int i=0;i<playerNumber*10;i++){
			
			scoreBoard[currentPlayer-1].scoreBoardIn();			
			showWholeDisplay();
			
			currentPlayer++;
			if(currentPlayer > playerNumber){currentPlayer = 1;};
		}

		System.out.println("게임완료");
	}
	
	
	void showWholeDisplay(){
		
		for(int i=1;i<playerNumber+1;i++){
			for(int j=0;j<10;j++){
				
				System.out.print(j+"past : "+scoreBoard[i-1].f[j].score.pastScore+"/");
				System.out.print(j+"first : "+scoreBoard[i-1].f[j].score.firstScore+"/");
				System.out.print(j+"second : "+scoreBoard[i-1].f[j].score.secondScore+"/");
				System.out.println(j+"bonus : "+scoreBoard[i-1].f[j].score.bonusScore);
				System.out.println(j+"total : "+scoreBoard[i-1].f[j].score.totalScore);
			
				for(int k=0;k<10;k++){
				//	System.out.print(k+":"+scoreBoard[i-1].f[k].score.status+"/");
				}
				System.out.println("");
			}
			
			
		}
		
		/*
		System.out.println(" ---------------------------------------------------------------------------");
		System.out.println("|  P  |   1  |   2  |   3  |   4  |   5  |   6  |   7  |   8  |   9  |  10  |");
		
		for(int i=1;i<playerNumber+1;i++){
			System.out.print("|  "+i+"  |  ");
			
			for(int j=0;j<10;j++){
				
				
				//if(scoreBoard[i-1].f[j].score.status == FrameStatus.FINISHED){
					System.out.print(scoreBoard[i-1].f[j].score.totalSocre+" |   ");
				
				}
			System.out.println("");	
			}
		
		System.out.println("");
		System.out.println(" ---------------------------------------------------------------------------");		
*/
	}
}
