package cep.resources;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import cep.domain.Cep;

@RestController
public class CepController {

	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
	public Cep getCep(@PathVariable String cep) {
		RestTemplate restTemplate = new RestTemplate();
		Cep objCep = restTemplate.getForObject("https://viacep.com.br/ws/{0}/json/", Cep.class, cep);
		return objCep;
	}
}
