package local.halriquinn.javacountries;

public class Country
{
    private String countryName;
    private long population;
    private long landmassSize;
    private long medianAge;

    public Country(String countryName, long population, long landmassSize, long medianAge)
    {
        this.countryName = countryName;
        this.population = population;
        this.landmassSize = landmassSize;
        this.medianAge = medianAge;
    }

    public String getCountryName()
    {
        return countryName;
    }

    public void setCountryName(String countryName)
    {
        this.countryName = countryName;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getLandmassSize()
    {
        return landmassSize;
    }

    public void setLandmassSize(long landmassSize)
    {
        this.landmassSize = landmassSize;
    }

    public long getMedianAge()
    {
        return medianAge;
    }

    public void setMedianAge(long medianAge)
    {
        this.medianAge = medianAge;
    }

    @Override
    public String toString()
    {
        return "Country{" +
                "countryName='" + countryName + '\'' +
                ", population=" + population +
                ", landmassSize=" + landmassSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
