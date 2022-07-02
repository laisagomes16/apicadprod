package com.api.produtor;

import com.api.produtor.models.LaboratorioModel;
import com.api.produtor.models.PropriedadeModel;
import com.api.produtor.repositories.LaboratorioRepository;
import com.api.produtor.repositories.PropriedadeRepository;
import com.api.produtor.services.LaboratorioService;
import com.api.produtor.services.PropriedadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
@RestController
public class ProdutorApplication implements CommandLineRunner, WebMvcConfigurer {
	@Autowired
	PropriedadeRepository propriedadeRepository;

	@Autowired
	LaboratorioRepository laboratorioRepository;

	public static void main(String[] args) {

		SpringApplication.run(ProdutorApplication.class, args);
	}

	@GetMapping("/")
	public String index(){
		return "Laisa passou!!";
	}

	@Override
	public void run(String... args) throws Exception
	{
		// Inserting the data in the mysql table.
		PropriedadeService propriedadeService = new PropriedadeService(propriedadeRepository);
		if(propriedadeService.findAll().size() == 0){
			PropriedadeModel propriedadeModel = new PropriedadeModel();
			propriedadeModel.setNome("fazenda sao joao 1");
			propriedadeService.save(propriedadeModel);

			PropriedadeModel propriedadeModel2 = new PropriedadeModel();
			propriedadeModel2.setNome("fazenda sao joao 2");
			propriedadeService.save(propriedadeModel2);

			PropriedadeModel propriedadeModel3 = new PropriedadeModel();
			propriedadeModel3.setNome("fazenda sao joao 3");
			propriedadeService.save(propriedadeModel3);
		}

		LaboratorioService laboratorioService = new LaboratorioService(laboratorioRepository);
		if(laboratorioService.findAll().size() == 0){
			LaboratorioModel laboratorioModel = new LaboratorioModel();
			laboratorioModel.setNome("laboratorio 1");
			laboratorioService.save(laboratorioModel);

			LaboratorioModel laboratorioModel2 = new LaboratorioModel();
			laboratorioModel2.setNome("laboratorio 2");
			laboratorioService.save(laboratorioModel2);

			LaboratorioModel laboratorioModel3 = new LaboratorioModel();
			laboratorioModel3.setNome("laboratorio 3");
			laboratorioService.save(laboratorioModel3);
		}



	}

}
