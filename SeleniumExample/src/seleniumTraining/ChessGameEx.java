package seleniumTraining;


enum player1
{
	
/*	
	King{
		public void move(int spos,int epos)
		{
			//Here first we will check start position shouldn'd be equal to end postion
			//Then only the move will be vaild. We need to validate lot of other conditions as well here 
			//before we move the object but I wrote this as the initial validation
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can move one square in any direction");
		}
	},Knight{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can moves to any of the closest squares that are not on the same rank, file, or diagonal, thus the move forms an L-shape");
		}
	},Bishop{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this + " can move any number of squares diagonally");
		}
	},Queen{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can be move any number of squares along a rank, file, or diagonal");
		}
	},Pawn{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move forward to the unoccupied square immediately ");
		}
	},Rook{
		public void move(int spos,int epos)
		{
			
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move any number of squares along any rank or file ");
			
			
		}
	};
	
	public void move(int spos,int epos)
	{
		System.out.println("common move position");
	}

}

enum player2
{
	
	
	King{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can move one square in any direction");
		}
	},Knight{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can moves to any of the closest squares that are not on the same rank, file, or diagonal, thus the move forms an L-shape");
		}
	},Bishop{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this + " can move any number of squares diagonally");
		}
	},Queen{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can be move any number of squares along a rank, file, or diagonal");
		}
	},Pawn{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			
			//Here first we will check start position shouldn'd be equal to end postion
			//Then only the move will be vaild. We need to validate lot of other conditions as well here 
			//before we move the object but I wrote this as the initial validation
			if(spos != tpos )
			{
			action.moveTo(spos,tpos).perform();
			}
			
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move forward to the unoccupied square immediately ");
		}
	},Rook{
		public void move(int spos,int epos)
		{
			TouchAction action = new TouchAction(ad);
			
			//Here first we will check start position shouldn'd be equal to end postion
			//Then only the move will be vaild. We need to validate lot of other conditions as well here 
			//before we move the object but I wrote this as the initial validation
			if(spos != tpos)
			{
			action.moveTo(spos,tpos).perform();
			}
			
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move any number of squares along any rank or file ");
			
		}
	};
	
	public void move(int spos,int epos)
	{
		System.out.println("common move position");
	}

}

public class ChessGameEx {
	
	AppiumDriver ad;
	@BeforeClass
	public void setup() 
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium-version", "1.0");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "4.4");
		cap.setCapability("app", "\\users\\rallamsetti\\chess.apk");
		ad = new AndroidDriver(new URL("http://ipaddress:port/wd/hub",cap));
		ad.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	@Test
	public void playChess()
	{
		ad.findElement(By.id("btnPlay")).click();
		
		//Each chess board square represents number from 1 to 64 from lower left to 
		// top right
		
		//Player1 will move his pawn from 9 th postion to 27th postion
		player1.Pawn.move(9, 27);
		
		//Player1 will move his pawn from 63rd postion to 45th postion
		player2.Pawn.move(63, 45);
	
	}
*/	
}
