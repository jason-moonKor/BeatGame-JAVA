package dynamic_v_16;

import java.awt.Color;


import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image JudgeLineImage = new ImageIcon(Main.class.getResource("../images/judgeLine.png")).getImage();
	private Image noteLineImage = new ImageIcon(Main.class.getResource("../images/noteLine.png")).getImage();
	private Image noteWaySImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWayDImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWayFImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWaySpace1Image = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWaySpace2Image = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWayJImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWayKImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image noteWayLImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
	private Image FlareImage;
	private Image judgeImage;
	private Image padSImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padDImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padFImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padSpace1Image = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padSpace2Image = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padJImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padKImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	private Image padLImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}
	
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(noteWaySImage, 228, 30, null);
		g.drawImage(noteWayDImage, 332, 30, null);
		g.drawImage(noteWayFImage, 436, 30, null);
		g.drawImage(noteWaySpace1Image, 540, 30, null);
		g.drawImage(noteWaySpace2Image, 640, 30, null);
		g.drawImage(noteWayJImage, 744, 30, null);
		g.drawImage(noteWayKImage, 848, 30, null);
		g.drawImage(noteWayLImage, 952, 30, null);
		g.drawImage(noteLineImage, 224, 30, null);
		g.drawImage(noteLineImage, 328, 30, null);
		g.drawImage(noteLineImage, 432, 30, null);
		g.drawImage(noteLineImage, 536, 30, null);
		g.drawImage(noteLineImage, 740, 30, null);
		g.drawImage(noteLineImage, 844, 30, null);
		g.drawImage(noteLineImage, 948, 30, null);
		g.drawImage(noteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(JudgeLineImage, 0, 580, null);
		
		for(int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
			}
			if(!note.isProceeded()) {
				noteList.remove(i);
				i--;
			}
			else {
				note.screenDraw(g);
			}
			note.screenDraw(g);
		}
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("SPACE BAR", 570, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("0000000", 565, 702);
		g.drawImage(FlareImage, 320, 430, null);
		g.drawImage(judgeImage, 460, 420, null);
		g.drawImage(padSImage, 228, 580, null);
		g.drawImage(padDImage, 332, 580, null);
		g.drawImage(padFImage, 436, 580, null);
		g.drawImage(padSpace1Image, 540, 580, null);
		g.drawImage(padSpace1Image, 640, 580, null);
		g.drawImage(padJImage, 744, 580, null);
		g.drawImage(padKImage, 848, 580, null);
		g.drawImage(padLImage, 952, 580, null);
	}
	
	public void pressS() {
		judge("S");
		noteWaySImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padSImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseS() {
		noteWaySImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padSImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	
	public void pressD() {
		judge("D");
		noteWayDImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padDImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseD() {
		noteWayDImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padDImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	
	public void pressF() {
		judge("F");
		noteWayFImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padFImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseF() {
		noteWayFImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padFImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	
	public void pressSpace() {
		judge("Space");
		noteWaySpace1Image = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		noteWaySpace2Image = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padSpace1Image = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		padSpace2Image = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS2.mp3", false).start();
	}
	public void releaseSpace() {
		noteWaySpace1Image = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		noteWaySpace2Image = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padSpace1Image = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
		padSpace2Image = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}

	
	public void pressJ() {
		judge("J");
		noteWayJImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padJImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseJ() {
		noteWayJImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padJImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	
	public void pressK() {
		judge("K");
		noteWayKImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padKImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseK() {
		noteWayKImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padKImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	
	public void pressL() {
		judge("L");
		noteWayLImage = new ImageIcon(Main.class.getResource("../images/notePressed.png")).getImage();
		padLImage = new ImageIcon(Main.class.getResource("../images/padpressed.png")).getImage();
		new Music("drumS1.mp3", false).start();
	}
	public void releaseL() {
		noteWayLImage = new ImageIcon(Main.class.getResource("../images/noteWay.png")).getImage();
		padKImage = new ImageIcon(Main.class.getResource("../images/padbasic.png")).getImage();
	}
	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		if(titleName.equals("TEST SONG1") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 10, "L"),
					new Beat(startTime + gap * 16, "J"),
					new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 39, "F"),
					new Beat(startTime + gap * 41, "Space"),
					new Beat(startTime + gap * 44, "S"),
					new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 76, "K"),
					new Beat(startTime + gap * 79, "S"),
					new Beat(startTime + gap * 82, "Space"),
					new Beat(startTime + gap * 85, "J"),
					new Beat(startTime + gap * 96, "S"),
					new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "F"),
					new Beat(startTime + gap * 119, "Space"),
					new Beat(startTime + gap * 122, "Space"),
					new Beat(startTime + gap * 132, "D"),
					new Beat(startTime + gap * 142, "D"),
					new Beat(startTime + gap * 152, "S"),
					new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 169, "L"),
					new Beat(startTime + gap * 172, "J"),
					new Beat(startTime + gap * 172, "K"),
					new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 185, "Space"),
					new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 196, "D"),
					new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 196, "F"),
					new Beat(startTime + gap * 201, "D"),
					new Beat(startTime + gap * 205, "J"),
					new Beat(startTime + gap * 208, "L"),
					new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "Space"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 229, "J"),
					new Beat(startTime + gap * 231, "K"),
					
					
			};
		}
		else if(titleName.equals("TEST SONG1") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 10, "L"),
					new Beat(startTime + gap * 16, "J"),
					new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 39, "F"),
					new Beat(startTime + gap * 41, "Space"),
					new Beat(startTime + gap * 44, "S"),
					new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 76, "K"),
					new Beat(startTime + gap * 79, "S"),
					new Beat(startTime + gap * 82, "Space"),
					new Beat(startTime + gap * 85, "J"),
					new Beat(startTime + gap * 96, "S"),
					new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "F"),
					new Beat(startTime + gap * 119, "Space"),
					new Beat(startTime + gap * 122, "Space"),
					new Beat(startTime + gap * 132, "D"),
					new Beat(startTime + gap * 142, "D"),
					new Beat(startTime + gap * 152, "S"),
					new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 169, "L"),
					new Beat(startTime + gap * 172, "J"),
					new Beat(startTime + gap * 172, "K"),
					new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 185, "Space"),
					new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 196, "D"),
					new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 196, "F"),
					new Beat(startTime + gap * 201, "D"),
					new Beat(startTime + gap * 205, "J"),
					new Beat(startTime + gap * 208, "L"),
					new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "Space"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 229, "J"),
					new Beat(startTime + gap * 231, "K"),
			};
		}
		else if(titleName.equals("TEST SONG2") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] {
					new Beat(startTime, "S"),
					new Beat(startTime + gap * 2, "S"),
					new Beat(startTime + gap * 10, "L"),
					new Beat(startTime + gap * 16, "J"),
					new Beat(startTime + gap * 17, "K"),
					new Beat(startTime + gap * 28, "S"),
					new Beat(startTime + gap * 39, "F"),
					new Beat(startTime + gap * 41, "Space"),
					new Beat(startTime + gap * 44, "S"),
					new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 76, "K"),
					new Beat(startTime + gap * 79, "S"),
					new Beat(startTime + gap * 82, "Space"),
					new Beat(startTime + gap * 85, "J"),
					new Beat(startTime + gap * 96, "S"),
					new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 105, "D"),
					new Beat(startTime + gap * 108, "F"),
					new Beat(startTime + gap * 119, "Space"),
					new Beat(startTime + gap * 122, "Space"),
					new Beat(startTime + gap * 132, "D"),
					new Beat(startTime + gap * 142, "D"),
					new Beat(startTime + gap * 152, "S"),
					new Beat(startTime + gap * 162, "S"),
					new Beat(startTime + gap * 169, "L"),
					new Beat(startTime + gap * 172, "J"),
					new Beat(startTime + gap * 172, "K"),
					new Beat(startTime + gap * 172, "L"),
					new Beat(startTime + gap * 185, "Space"),
					new Beat(startTime + gap * 190, "D"),
					new Beat(startTime + gap * 196, "D"),
					new Beat(startTime + gap * 196, "S"),
					new Beat(startTime + gap * 196, "F"),
					new Beat(startTime + gap * 201, "D"),
					new Beat(startTime + gap * 205, "J"),
					new Beat(startTime + gap * 208, "L"),
					new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 215, "D"),
					new Beat(startTime + gap * 215, "Space"),
					new Beat(startTime + gap * 222, "J"),
					new Beat(startTime + gap * 229, "J"),
					new Beat(startTime + gap * 231, "K"),
			};
		}
		else if(titleName.equals("TEST SONG2") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("TEST SONG3") && difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		else if(titleName.equals("TEST SONG3") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] {
					new Beat(startTime, "Space"),
			};
		}
		int i = 0;
		gameMusic.start();
		while(i < beats.length && !isInterrupted()){
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	
	public void judgeEvent(String judge) {
		if(!judge.equals("None")) {
			FlareImage = new ImageIcon(Main.class.getResource("../images/flare.png")).getImage();
		}
		if(judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/miss.png")).getImage();
		}
		else if(judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
		}
		else if(judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/late.png")).getImage();
		}
		else if(judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/perfect.png")).getImage();
		}
		else if(judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/early.png")).getImage();
		}
		else if(judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/good.png")).getImage();
		}
		
	}
}
