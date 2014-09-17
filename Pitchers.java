import java.util.*;

public class Pitchers { 
	static int n[] = new int[2];
	static int V[] = new int[2];
	public static void main(String[] args) { 
		System.out.println("Hello, World");
		Scanner sc = new Scanner(System.in);
		V[0] = sc.nextInt(); 
		V[1] = sc.nextInt();
		n[0] = n[1] = 0;
		int Vneed = sc.nextInt();
		sc.close();
		int Nmin = 0;
		int Nmax = 0;
		if (V[0] > V[1]) Nmin = 1;
		else Nmax = 1;
		if (Vneed > V[Nmax] || (Vneed != V[0] && V[0] == V[1])) System.out.println("Impassible...");
		else if (Vneed == V[Nmax]) Fill(Nmax);
		else if (Vneed%V[Nmin] == 0) for(int i=0; i < Vneed/V[Nmin]; i++) {
				Fill(Nmin);
				Transfer(Nmin);
			}
		else if (Vneed%(V[Nmax] - V[Nmin]) == 0) {
			while(true) {
				Fill(Nmax);
				Transfer(Nmax);
				if ( n[Nmax] != Vneed) {
					Empty(Nmin);
					Transfer(Nmax);
				}
				else break;
			}			
		}
		else if (Vneed%((V[Nmax]/V[Nmin] +1)*V[Nmin] - V[Nmax]) == 0) {
			while(true) {
				for (int i = 0; i< (V[Nmax]/V[Nmin] +1); i++) {
					Fill(Nmin);
					Transfer(Nmin);
				}
				if (n[Nmin] == Vneed) break;
				Empty(Nmax);
				Transfer(Nmin);
			}
		}
		else System.out.println("Impassible...");
   }
   static void Fill(int num) {
		n[num] = V[num];
		System.out.println("fill #" + (num+1) + ": "+ n[0] +" "+ n[1]);
   }
   static void Transfer(int num) {
		int two_num;
		if (num == 0) two_num =1;
		else two_num = 0;
		
		n[two_num] += n[num];
		if (V[two_num] < n[two_num]) {
			n[num] = n[two_num] - V[two_num];
			n[two_num] = V[two_num];
		}
		else n[num] = 0;
		System.out.println("transfer #" + (num+1) +" -> #"+ (two_num+1) + ": "+ n[0] +" "+ n[1]); 
   }
   static void Empty(int num) {
		n[num] = 0;
		System.out.println("empty #" + (num+1) +": "+ n[0] +" "+ n[1]); 
   }
}