package seleniumTraining;

enum chessobj
{
	
	
	King{
		public void move(int spos,int epos)
		{
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can move one square in any direction");
		}
	},Knight{
		public void move(int spos,int epos)
		{
			System.out.println(this +" moved from " + spos + "position to "+ epos + " position");
			System.out.println(this + " can moves to any of the closest squares that are not on the same rank, file, or diagonal, thus the move forms an L-shape");
		}
	},Bishop{
		public void move(int spos,int epos)
		{
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this + " can move any number of squares diagonally");
		}
	},Queen{
		public void move(int spos,int epos)
		{
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can be move any number of squares along a rank, file, or diagonal");
		}
	},Pawn{
		public void move(int spos,int epos)
		{
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move forward to the unoccupied square immediately ");
		}
	},Rook{
		public void move(int spos,int epos)
		{
			
			System.out.println(this +" moved from " + spos + " position to "+ epos + " position");
			System.out.println(this +" can move any number of squares along any rank or file ");
			
			
		}
	};
	
	public void move(int spos,int epos)
	{
		System.out.println("common move position");
	}

}
	
public class ChessGame 
{
	
	public static void main(String args[])
	{
		chessobj[] obj = chessobj.values();
		
		chessobj.Bishop.move(6, 9);
		chessobj.King.move(9, 45);
		chessobj.Pawn.move(45, 61);
		
		/*for (chessobj obj1: obj)
		{
			obj1.move(9,27);
		}
	   */
	}
	
	
}

