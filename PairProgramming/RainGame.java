//UIUC CS125 SPRING 2016 MP. File: RainGame.java, CS125 Project: PairProgramming, Version: 2016-02-23T06:01:34-0600.233790614
/**
 * @author zzhan145,xiaojin2
 */
public class RainGame {

	public static void main(String[] args) {
		// To get points type your netids above (CORRECTLY-Please double check your partner correctly spells your netid correctly!!)
		// Your netid is the unique part of your @illinois email address
		// Do not put your name or your UIN. 
		// REMEMBER TO COMMIT this file...
	
		int x=0, y=0, dx=0, dy=0, score = 0, level = 0;
		String text = "";
		long startTime =System.currentTimeMillis();
		
		Zen.setFont("Helvetica-64");
		while (Zen.isRunning()) {

			if (text.length() == 0) {
				level = score / 10;
				
				x = 2 * (int)(Zen.getZenWidth() * Math.random()) / 3;
				y = 2 * (int)(Zen.getZenHeight() * Math.random()) / 3;
				
				dx = 1 + level + level * (int)(2 * Math.random());
				dy = 1 + level + level * (int)(2 * Math.random());
				
				text = "" + (char)('a' + 26 * Math.random()) + (char)('a' + 26 * Math.random()) + (char)('a' + 26 * Math.random());
				long elapsed = System.currentTimeMillis() - startTime;
				startTime = System.currentTimeMillis();
				score = score + (int)(3000 / elapsed);
			}
			
			Zen.setColor(255, 180, 255);
			Zen.fillRect(0, 0, Zen.getZenWidth(), Zen.getZenHeight());
			Zen.setColor(0, 255, 0);
			Zen.drawText(text, x, y);
			
			Zen.drawText("Level: " + level, 10, 60);
			Zen.drawText("Score: " + score, 10, 115);
			
			x += dx;
			y += dy;
			if(x >= Zen.getZenWidth() || y >= Zen.getZenHeight()){
				x = 2 * (int)(Zen.getZenWidth()) / 3;
				y = 2 * (int)(Zen.getZenHeight()) / 3;
			}
			
			
			// Find out what keys the user has been pressing.
			String user = Zen.getEditText();
			// Reset the keyboard input to an empty string
			// So next iteration we will only get the most recently pressed keys.
			Zen.setEditText("");
			
			for(int i=0;i < user.length();i++) {
				char c = user.charAt(i);
				if(c == text.charAt(0))
					text = text.substring(1,text.length()); // all except first character
			}
			
			Zen.sleep(90);// sleep for 90 milliseconds
			Zen.flipBuffer();

		}
	}

}
