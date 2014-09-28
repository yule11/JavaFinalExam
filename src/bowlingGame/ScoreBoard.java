package bowlingGame;

public class ScoreBoard {
	
	final int FRAME_NUM = 10;
	Frame f [] = new Frame[FRAME_NUM];
	int currentFrame = 1;	
	int currentFrameA = 0;
	int preFrameA = currentFrameA -1;
	int prepreFrameA = currentFrameA -2;
	
	ScoreBoard (int player) { // 1 - N
		
		for(int i=0;i<FRAME_NUM;i++) f[i] = new Frame(i+1,player); // [0] = 1 
	}
	
	void scoreBoardIn(){
		f[currentFrame-1].frameIn();
		workingFrames();
		currentFrame++; currentFrameA++;preFrameA++;prepreFrameA++;
	}
	
	void workingFrames(){
		withPreFrames();
		withPostFrames();
		if(currentFrame == 10) afterLastFrame();
	}
	
	void withPreFrames(){
		System.out.println("helpMe");
		for(int i=prepreFrameA ; i<currentFrameA ; i++){  		
		
			if (i >= 0){
				System.out.println(i+",");			
				if(f[i].score.status == FrameStatus.NOTYET){
					f[i].score.recordScore(3, f[currentFrameA].score.firstScore);}
			
				if(f[i].score.status == FrameStatus.NOTYET){
					if(f[currentFrame-1].secondStrokeIsDone) {
					f[i].score.recordScore(3,f[currentFrameA].score.secondScore);}}
			}
		}
		}
	
	void withPostFrames(){
		
		for(int i=0 ; i<currentFrameA ; i++){ 
			if(f[i].score.status == FrameStatus.STANDBY){
				f[i+1].score.recordScore(0, f[i].score.totalScore);
				for(int j=0;j<10;j++){
					f[i].score.calculateTotalScore();
				}
		}}}
	
	void afterLastFrame(){
		if(f[8].score.status == FrameStatus.NOTYET){
			Frame bonusframe = new Frame(-1,-1);
			bonusframe.frameIn();
			withPreFrames();
		}
	}
}