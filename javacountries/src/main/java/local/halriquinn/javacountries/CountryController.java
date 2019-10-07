package local.halriquinn.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
public class CountryController
{
    //localhost:8080/names/all
    @RequestMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {
        return new ResponseEntity<>(JavacountriesApplication.myCountryList.countryList,
                HttpStatus.OK);
    }


    //localhost:8080/names/start/s


}
