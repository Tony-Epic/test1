import java.util.ArrayList;
import java.util.HashMap;

public class Korisnik 
{
	static private ArrayList <Korisnik> useri = new ArrayList <Korisnik> ();
	static private HashMap <Integer , Integer> log1 = new HashMap <Integer , Integer> ();
	private String podKnjige;
	private int brojRacuna;
	private String ime;
	private int brojKnjiga;
		
	public Korisnik (int brojRacuna, String ime, int brojKnjiga, String podKnjige) 
	{
		this.brojRacuna = brojRacuna;
		this.ime = ime;
		this.brojKnjiga = brojKnjiga;
		this.podKnjige = "";
	}
	
	
	public static void logIspis ()
	{
		for (int i = 0; i < log1.size(); i++)
		{
			System.out.println(log1);
		}
	}
	
	public boolean kreiranjeRacuna ()
	{
		setBrojRacuna(brojRacuna);
		setBrojKnjiga(brojKnjiga);
		setIme(ime);
		useri.add(this);
		
		return true;
	}

	public int getBrojRacuna () 
	{
		return brojRacuna;
	}

	public void setBrojRacuna (int brojRacuna) 
	{
		for (int i = 0; i < useri.size() - 1; i++)
		{
			if (useri.get(i).getBrojRacuna() == brojRacuna)
			{
				System.out.println("Raèun s tim brojem veæ postoji!");
				Main.start();
			}
		}
		
		if (brojRacuna > 0)
		{
			this.brojRacuna = brojRacuna;
		}
			
		else
		{
			System.out.println("Pogrešan unos!");
			Main.start();
		}		
	}

	public String getIme () 
	{
		return ime;
	}

	public void setIme (String ime) 
	{
		this.ime = ime;
	}

	public int getBrojKnjiga () 
	{
		return brojKnjiga;
	}

	public void setBrojKnjiga (int brojKnjiga) 
	{
		if (brojKnjiga > -1)
		{
			this.brojKnjiga = brojKnjiga;
		}
		
		else
		{
			Main.start();
		}	
	}
	
	public static boolean provjeraBrojaRacuna (int brojRacuna , int brojKnjige)
	{
		for (int i = 0; i < useri.size(); i++)
		{
			if (useri.get(i).getBrojRacuna() == brojRacuna && useri.get(i).getBrojKnjiga() < 3)
			{
				useri.get(i).setBrojKnjiga(useri.get(i).getBrojKnjiga() + 1);
				dodaj(brojKnjige , i);
				log1.put(brojKnjige , useri.get(i).getBrojRacuna());
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean provjeraBrojaRacuna1 (int brojRacuna , int brojKnjige)
	{
		for (int i = 0; i < useri.size(); i++)
		{
			if (useri.get(i).getBrojRacuna() == brojRacuna)
			{
				useri.get(i).setBrojKnjiga(useri.get(i).getBrojKnjiga() - 1);
				log1.remove(brojKnjige);
				return true;
			}
		}
		
		return false;
	}

	public static void dodaj (int brojKnjige , int i)
	{
		useri.get(i).podKnjige += " ," + brojKnjige;
	}
	
	public static int getLog1 (int brojKnjige) 
	{
		int racun = log1.get(brojKnjige);
		return racun;
	}
	
	public static void pretraga (int brojRacuna)
	{
		for (int i = 0; i < useri.size(); i++)
		{
			if (useri.get(i).getBrojRacuna() == brojRacuna)
			{
				System.out.println("Ime: " + useri.get(i).ime);
				System.out.println("Broj podignutih knjiga: " + useri.get(i).brojKnjiga);
				System.out.println("Podignute knjige: " + useri.get(i).podKnjige.toString());
				return;
			}
		}
	}
}