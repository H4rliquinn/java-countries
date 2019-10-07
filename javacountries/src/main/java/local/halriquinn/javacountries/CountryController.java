package local.halriquinn.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryController
{
    //localhost:2019/names/all
    @RequestMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {

        JavacountriesApplication.myCountryList.countryList.sort((e1, e2) -> e1.getCountryName()
                .compareToIgnoreCase(e2.getCountryName()));
        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList,
                HttpStatus.OK);
    }

    //localhost:2019/names/start/s
    @RequestMapping(value = "/start/{letter}", produces = {"application/json"})
    public ResponseEntity<?> getCountriesByLetter(@PathVariable char letter)
    {
        ArrayList<Country> tempCountryList =JavacountriesApplication.myCountryList.findAllCountries(e->e
                .getCountryName()
                .toUpperCase()
                .charAt(0) == Character.toUpperCase(letter));

        tempCountryList.sort((e1, e2) -> e1.getCountryName()
                .compareToIgnoreCase(e2.getCountryName()));

        return new ResponseEntity<>(tempCountryList,
                HttpStatus.OK);
    }

}
