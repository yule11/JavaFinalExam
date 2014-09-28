package bowlingGame;

public class Score {
	
	int frameNumber;
	int player;	
	
	int pastScore = 0; 		// 0
	int firstScore = 0; 	// 1
	int secondScore = 0; 	// 2
	int bonusScore = 0; 	// 3
	int totalScore = 0; 
	
	int bonusCount = 0;

	FrameStatus status;
	
	Score(int frameNumber, int player){
		this.frameNumber = frameNumber;
		this.player = player;
		status = FrameStatus.NONE;
	}
	
	void recordScore(int order, int fallenPins){
		System.out.println("Score"+order);
		if (order == 0) {
			pastScore = fallenPins;
			//status = FrameStatus.FINISHED;
		}
		if (order == 1) firstScore = fallenPins;
		if (order == 2) secondScore = fallenPins;
		if (order == 3) {
			bonusScore += fallenPins;
			bonusCount--;
			frameFinishCheck();
		}
		totalScore = pastScore + firstScore + secondScore + bonusScore;
	}
		
	void calculateTotalScore(){
		totalScore = pastScore + firstScore + secondScore + bonusScore;
	}
	int displayTotalScore(){
		return totalScore;
	}
	
	void frameFinishCheck(){
		if(bonusCount != 0) status = FrameStatus.NOTYET;
		if(bonusCount == 0) status = FrameStatus.STANDBY;
	}
}
