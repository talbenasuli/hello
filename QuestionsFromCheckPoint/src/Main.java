
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main 
{

	public static void main(String[] args) 
	{
		//שאלה 1:
		/*System.out.println("Please enter a number\n");
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(fib(num));*/
		
		//שאלה 2:
		/*ArrayList<String> l = new ArrayList();
		l.add("5");
		l.add("5");
		l.add("5");
		l.add("*");
		l.add("3");
		if(chackIfMath(l))
			System.out.println("true");
		else 
			System.out.println("false");*/
		//שאלה 3:
		System.out.println(matMxn(5,5));
	}
	
	//שאלה 1 : קלט - מספר המייצג את האינדקס בסדרת פיבונאצ'י מה שצריך הלחזיר זה את המספר עצמו
	//כלומר מי הוא המספר בסדרה במקום כלשהו.

	private static int fib(int n)
	{
		if (n == 0)
			return 0;
		if (n==1)	
			return 1;
		
		double x;
		double y;
		int ans;
		n = n+1;
		
		x = (double) Math.pow((1+Math.pow(5,0.5))/2,n);
		y = (double) Math.pow((1-Math.pow(5,0.5))/2,n);
		
		ans = (int) ((x - y)/Math.pow(5,0.5));
		return ans;
	}
	
	//שאלה 2 : קלט ליסט ובוא סטרינג 
	//פלט : להגיד האם הסטרינג הוא ביטוי מתממטי תקין או שלא.
	
	private static boolean chackIfMath(List n)
	{
		if (check1(n) == true && check2(n) == true && check3(n) == true && check4(n) == true && check5(n) == true)
			return true;
		return false;
	}

	private static boolean check1( List<String> n) //check if there is aritmerics symbols
	{
		for (String s : n)
		{
			if (s.equals("+")|| s.equals("-") || s.equals("/") || s.equals("*") || s.equals("^"))
				return true;
		}
		return false;
	}
	
	private static boolean check2(List<String> n)// checks that there is no portion with 0
	{
		Iterator i = n.iterator();
		while(i.hasNext())
		{
			if(i.next().equals('/'))
			{
				Iterator s = (Iterator) i.next();
				if (s.equals('0'))
					return false;
			}
		}
		return true;
		
	}
	
	private static boolean check3(List<String> n)// Checking Integrity of the brackets
	{
		Stack<String> s = new Stack<String>();
		
		for (String e : n)
		{
			if (e.equals("(") || e.equals("[") ||  e.equals("{") ) 
			{
				s.push((String)e);
			}	
		}
		
		if(s.isEmpty())
		{
			for (String e : n)
			{
				if (e.equals(")") || e.equals("]") ||  e.equals("}") ) 
				{
					return false;
				}	 
			}
			return true;
		}
		
		for(String e :n)
		{
			if (s.pop().equals("{") && !(e.equals("}")) || s.pop().equals("[") && !(e.equals("]"))|| s.pop().equals("(") && !(e.equals(")")))
			{
				return false;
			}
		}
		
		if (!s.isEmpty()) 
			return false;
		else 
			return true;
	}
	
	private static boolean check4(List<String> n)
	{
		int checkNum;
		int counter = 0;
		for (String s : n)
		{
			try
			{
			checkNum = Integer.parseInt(s);
			}
			catch(NumberFormatException e)
			{
				if(!(s.equals("+")|| s.equals("-") || s.equals("/") || s.equals("*") || s.equals("^")))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean check5(List<String> n)
	{
		String begin = n.get(0);
		String end = n.get(n.size() - 1);
		if (begin.equals("*") || begin.equals("-")|| begin.equals("/")|| begin.equals("+") || begin.equals("^")) 
		{
			return false;
		}
		
		if (end.equals("*") || end.equals("-")|| end.equals("/")|| end.equals("+") || end.equals("^")) 
		{
			return false;
		}
		return true;
	}
	
	//  נתונה מטריצה אם על אן,צריך להחזיר את מספר הדרכים שניתן להגיע מ0,0 לאם,אן.
	private static int matMxn(int n,int m)
	{
		int x = m + n;
		int fx = factorial(x);
		int fm = factorial(m);
		int fn = factorial(n);
		int ans = fx/(fm *fn); 
		return ans;
	}
	
	private static int factorial(int n)
	{
		int sum = 1;
		for (int i = 1; i < n; i++) 
		{
			sum*=(i+1);
		}
		return sum;
	}

}

