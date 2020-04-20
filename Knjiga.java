import java.util.ArrayList;

public class Knjiga
{
	static private ArrayList <Knjiga> knjige = new ArrayList <Knjiga> ();
	private String imeKnjige;
	private int brojKnjige;
	private boolean statusKnjige;
	private String datum;
	
	public Knjiga(String imeKnjige, int brojKnjige, boolean statusKnjige) 
	{
		this.imeKnjige = imeKnjige;
		this.brojKnjige = brojKnjige;
		this.statusKnjige = statusKnjige;
	}
	
	public boolean kreiranjeKnjige ()
	{
		setImeKnjige(imeKnjige);
		setBrojKnjige(brojKnjige);
		setStatusKnjige(statusKnjige);
		knjige.add(this);
		
		return true;	
	}

	public String getImeKnjige () 
	{
		return imeKnjige;
	}

	public void setImeKnjige(String imeKnjige) 
	{	
		this.imeKnjige = imeKnjige;
	}

	public int getBrojKnjige () 
	{
		return brojKnjige;
	}

	public void setBrojKnjige (int brojKnjige) 
	{
		if (brojKnjige < 0)
		{
			System.out.println("Pogrešan unos!");
			Main.router(2);
		}
		
		for (int i = 0; i < knjige.size(); i++)
		{
			if (brojKnjige == knjige.get(i).getBrojKnjige())
			{
				System.out.println("Knjiga s tim brojem veæ postoji!");
				Main.start();
			}
		}
		
		this.brojKnjige = brojKnjige;
	}

	public boolean isStatusKnjige () 
	{
		return statusKnjige;
	}

	public void setStatusKnjige (boolean statusKnjige) 
	{
		this.statusKnjige = statusKnjige;
	}
	
	public static boolean provjeraBrojaKnjige (int brojKnjige , String datum)
	{
		for (int i = 0; i < knjige.size(); i++)
		{
			if (knjige.get(i).getBrojKnjige() == brojKnjige && knjige.get(i).isStatusKnjige() == true)
			{
				knjige.get(i).setDatum(datum);
				knjige.get(i).setStatusKnjige(false);
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean provjeraBrojaKnjige1 (int brojKnjige , String datum)
	{
		for (int i = 0; i < knjige.size(); i++)
		{
			if (knjige.get(i).getBrojKnjige() == brojKnjige && knjige.get(i).isStatusKnjige() == false)
			{
				knjige.get(i).setStatusKnjige(true);
				return true;
			}
		}
		
		return false;
	}

	public String getDatum() 
	{
		return datum;
	}

	public void setDatum(String datum) 
	{
		this.datum = datum;
	}	
}