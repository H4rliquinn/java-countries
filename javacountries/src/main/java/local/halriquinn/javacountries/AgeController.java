package local.halriquinn.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/age")
public class AgeController
{
    //localhost:2019/age/age/25
    @RequestMapping(value = "/age/{age}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesHigherMeanAge(@PathVariable long age)
    {
        ArrayList<Country> tempCountryList = JavacountriesApplication.myCountryList.findAllCountries(e ->
                e.getMedianAge()>= age);

        tempCountryList.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));

        return new ResponseEntity<>(tempCountryList,
                HttpStatus.OK);
    }

    //localhost:2019/age/min
    @RequestMapping(value = "/min", produces = {"application/json"})
    public ResponseEntity<?> getLowestMedianAge()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0),
                HttpStatus.OK);
    }

    //localhost:2019/age/max
    @RequestMapping(value = "/max", produces = {"application/json"})
    public ResponseEntity<?> getHighestMedianAge()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c2.getMedianAge() - c1.getMedianAge()));

        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(0),
                HttpStatus.OK);
    }

    //localhost:2019/age/median
    @RequestMapping(value = "/median", produces = {"application/json"})
    public ResponseEntity<?> getMedianAge()
    {
        JavacountriesApplication.myCountryList.countryList.sort((c1, c2) -> (int)(c1.getMedianAge() - c2.getMedianAge()));
        int medIndex = JavacountriesApplication.myCountryList.countryList.size()/2;
//        System.out.println("List Size "+JavacountriesApplication.myCountryList.countryList.size()
//                +" MI "+medIndex);
        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList.get(medIndex),
                HttpStatus.OK);
    }
}
