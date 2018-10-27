/*	Построить треугольник Паскаля для первого положительного числа	*/
public class Task1B16 {
	public static long fact(int val) {
		long result = 1;
		for (int i = 1; i <= val; i++) {
			result *= i;
		}
		
		return result;
	}
	public static void main(String[] args) {
		
		
	    int n = 14 ,sum = 1 ,k=1;
		//n*(n-1)*(n - 2) ...(n-k+1)/1*2*..K
	    //http://scolaire.ru/treugolnik_pascala.php
	    System.out.println( fact(n) + " " + fact(k)+ " " + fact(n-k)) ;
	    System.out.println( fact(n)/(fact(k)*fact(n-k)));
	
	    
	    for (int i = 0; i < n; i++) {
			System.out.println("");	
		  for (int j = 0; j <= i; j++) {
		    sum = (int) (fact(i)/(fact(j)*fact(i-j)));
			System.out.print(sum + " ");
		}
			
		}
		
	}

}
