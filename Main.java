import java.util.Scanner;

public class Main 
{
	static Scanner sc = new Scanner (System.in);
	
	public static void main(String[] args) 
	{		
		start();
	}
	
	public static void start ()
	{
		int izbor;
		
		System.out.println("Dobrodošli u biblioteku!\n\nIzaberite željenu opciju: \n");
		System.out.println("1) Kreiranje raèuna\n2) Kreiranje knjige\n3) Podizanje knjiga\n4) Detalji raèuna\n5) Vraæanje knjiga");
		
		izbor = sc.nextInt();
		
		if (izbor < 1 || izbor > 5)
		{
			izbor = 1;
		}
		
		router (izbor);
	}
	
	public static void router (int izbor)
	{
		if (izbor == 1)
		{	
			String ime;
			int brojRacuna;
			int brojKnjiga;
			
			System.out.println("Unesite svoje ime: ");
			ime = sc.next();
			
			System.out.println("Unesite broj raèuna: ");
			brojRacuna = sc.nextInt();
			
			System.out.println("Unesite broj posuðenih knjiga: ");
			brojKnjiga = sc.nextInt();
			
			Korisnik user = new Korisnik (brojRacuna , ime , brojKnjiga, null);
			
			if (user.kreiranjeRacuna() == true)
			{
				System.out.println("Raèun uspješno kreiran!");
				start();
			}
		}
			
		else if (izbor == 2)
		{
			int brojKnjige;
			boolean statusKnjige;
			String imeKnjige;
			int izbor1;
			
			System.out.println("Unesite ime knjige: ");
			imeKnjige = sc.next();
			
			System.out.println("Unesite broj knjige: ");
			brojKnjige = sc.nextInt();
			
			System.out.println("Unesite status knjige (1 za dostupna , bilo koji drugi broj za nedostupna) :");
			izbor1 = sc.nextInt();
			
			if (izbor1 == 1)
			{
				statusKnjige = true;
			}
			
			else
			{
				statusKnjige = false;
			}
			
			Knjiga knjiga = new Knjiga (imeKnjige , brojKnjige , statusKnjige);
			
			if (knjiga.kreiranjeKnjige() == true)
			{
				System.out.println("Knjiga uspješno kreirana!");
				start();
			}
			
			start();
		}
		
		else if (izbor == 3)
		{
			int brojKnjige;
			int brojRacuna;
			String datum;
			
			System.out.println("Unesite broj knjige: ");
			brojKnjige = sc.nextInt();
			
			System.out.println("Unesite broj raèuna: ");
			brojRacuna = sc.nextInt();
			
			System.out.println("Unesite datum izdavanja (dd/mm/yyyy) :");
			datum = sc.next();
			
			if (Knjiga.provjeraBrojaKnjige(brojKnjige, datum) == true)
			{
				if (Korisnik.provjeraBrojaRacuna(brojRacuna , brojKnjige) == true)
				{	
					System.out.println("Knjiga uspjesno podignuta!");
					start();
				}
				
				else
				{
					System.out.println("Raèun æe prekoraèiti dozvoljeni broj podignutih knjiga!");
					start();
				}
			}
			
			else
			{
				System.out.println("Knjiga s tim brojem je veæ izdata!");
				start();
			}
		}
		
		else if (izbor == 4)
		{	
			int izbor2;
			int brojKnjige;
			int brojRacuna;
			
			System.out.println("Izaberite željenu opciju: ");
			System.out.println("1) Pretraživanje po broju knjige\n2) Ispis detalja za odreðeni broj raèuna\n3) Ispis log file-a");
			
			izbor2 = sc.nextInt();
			
			if (izbor2 < 1 && izbor2 > 4)
			{
				izbor2 = 4;
			}
			
			else if (izbor2 == 1)
			{
				System.out.println("Unesite broj knjige: ");
				brojKnjige = sc.nextInt();
				
				System.out.println("Broj raèuna koji je podigao ovu knjigu je " + Korisnik.getLog1(brojKnjige));
				start();
			}
			
			else if (izbor2 == 2)
			{
				System.out.println("Unesite broj raèuna: ");
				brojRacuna = sc.nextInt();
				
				Korisnik.pretraga(brojRacuna);
				start();
			}
			
			else if (izbor2 == 3)
			{
				Korisnik.logIspis();
				start();
			}
		}
		
		else if (izbor == 5)
		{
			int brojKnjige;
			int brojRacuna;
			String datum;
			
			System.out.println("Unesite broj knjige: ");
			brojKnjige = sc.nextInt();
			
			System.out.println("Unesite broj racuna: ");
			brojRacuna = sc.nextInt();
			
			System.out.println("Unesite datum vraæanja (dd/mm/yyyy) :");
			datum = sc.next();
			
			if (Knjiga.provjeraBrojaKnjige1(brojKnjige, datum) == true)
			{
				if (Korisnik.provjeraBrojaRacuna1(brojRacuna , brojKnjige) == true)
				{	
					System.out.println("Knjiga uspjesno vraæena!");
					start();
				}
				
				else
				{
					System.out.println("Raèun æe prekoraèiti dozvoljeni broj podignutih knjiga!");
					start();
				}
			}
			
			else
			{
				System.out.println("Knjiga s tim brojem je veæ izdata!");
				start();
			}
		}
	}
}
