package local.halriquinn.javacountries;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
@RestController
@RequestMapping("/population")
public class PopulationController
{
    //localhost:2019/population/size/5000000
    @RequestMapping(value = "/size/{people}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesMinPopulation(@PathVariable long people)
    {
        ArrayList<Country> tempCountryList = JavacountriesApplication.myCountryList.findAllCountries(e ->
                e.getPopulation()>= people);

        tempCountryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(tempCountryList,
                HttpStatus.OK);
    }

    //localhost:2019/population/min
    @RequestMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getSmallestCountry()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0),
                HttpStatus.OK);
    }

    //localhost:2019/population/max

    @RequestMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getLargestCountry()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c2.getPopulation() - c1.getPopulation()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0),
                HttpStatus.OK);
    }

    //localhost:2019/median
    @RequestMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianPopulation()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c1.getPopulation() - c2.getPopulation()));
        int medIndex = JavacountriesApplication.myCountryList.countryList.size()/2;
//        System.out.println("List Size "+JavacountriesApplication.myCountryList.countryList.size()
//        +" MI "+medIndex);
        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(medIndex),
                HttpStatus.OK);
    }
}

