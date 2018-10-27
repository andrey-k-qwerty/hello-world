
public class DigPow {

	public static long digPow(int n, int p) {
		int _p = p;
		int sum = 0;
		char[] len = Integer.toString(n).toCharArray();
		for (int i = 0; i < len.length; i++) 
		{
			sum += Math.pow(Integer.parseInt(String.valueOf(len[i])), _p++);
		}
		return  sum % n == 0 ? sum / n : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(digPow(695, 2));
		System.out.println(digPow(89, 1));
		System.out.println(digPow(92, 1));

		System.out.println(digPow(46288, 3));
	}

}
