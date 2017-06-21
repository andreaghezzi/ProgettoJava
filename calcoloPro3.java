package progetto2017;

import java.util.Scanner;
public class calcoloPro3 {
	
	public static double arrotonda( double numero, int nCifreDecimali ){
	    return Math.round( numero * Math.pow( 10, nCifreDecimali ) )/Math.pow( 10, nCifreDecimali );
	}
	public static double max(double m, double a, double p, double s){
		double m1=m;
		double arr[]={m,a,p,s};
		for (double t:arr){
			if(t>m1)
				m1=t;
		}
		//System.out.println(m1);
		return m1;
	}
	public static double maxCamb(double g1,double g2){
		double m;
		if(g1>g2){
			m=g1-g2;
		}
		else{
			m=g2-g1;
		}
		return m;
	}

	public static void main(String[] args) {
		int av=15;
		int bv=20;
		int cv=3;
		
		double m=10;
		double a=10;
		double p=10;
		double s=10 ;
		Scanner input = new Scanner(System.in);
		
		double pm=0,ap=0,sm=0,sa=0;
		
		while(true){
			int w=input.nextInt();
			double m1=m;double a1=a;double p1=p;double s1=s;
			for(int i=0;i<max(m,a,p,s);i++){
				if(p1>0 && m1>0){
					pm++;
					p1--;
					m1--;
				}
				if(s1>0 && m1>0){
					sm++;
					s1--;
					m1--;
				}
				if(s1>0 && a1>0){
					sa++;
					s1--;
					a1--;
				}
			}
			double k=m+a;
			double k2=p+s;
			double gm=2*(p/k2)+5*(s/k2);
			double ga=15*(s/k2);
			double gp=2*(m/k);
			double gs=5*(m/k)-5*(a/k);
			gp=arrotonda(gp,1);
			gs=arrotonda(gs,1);
			gm=arrotonda(gm,1);
			ga=arrotonda(ga,1);
			System.out.println("Guadagno M:"+gm+"  Guadagno A:"+ga+"  Guadagno P:"+gp+"  Guadagno S:"+gs);
			//cambio strategia
			if(gm!=ga){   //gm!=ga   maxCamb(gm,ga)>=0.35
				if(gm>ga){
					//vuol dire che gli avventurieri cambiano
					m=m+(a-a1);
					a=a-(a-a1);
				}
				else{
					//vuol dire che i morig cambiano
					a=a+(m-m1);
					m=m-(m-m1);
				}
			}
			if(gp!=gs){    //gp!=gs     maxCamb(gp,gs)>=0.35
				if(gp>gs){
					//vuol di che le spregiudicata cambiano
					p=p+(s-s1);
					s=s-(s-s1);		
				}
				else{
					//vuol di che le prudente cambiano
					s=s+(p-p1);
					p=p-(p-p1);
				}
			}
			//if(maxCamb(gm,ga)<=0.35 && maxCamb(gp,gs)<=0.35){
				//System.out.println("stabile ");
			//}
			//sommare i figli  pm sm sa
			m+=(pm/2)*3;
			p+=(pm/2)*4;
			s+=(sm/2)*5;
			m+=(sm/2)*5;
			s+=(sa/2)*0.5;
			a+=(sa/2)*0.5;
			
			System.out.println("num mor:"+m+"  num avv:"+a);
			System.out.println("num prud:"+p+"  num spre:"+s);
			System.out.println(m/(m+a)+" "+p/(p+s)+" "+a/(m+a)+" "+s/(p+s));
		}

	}

}