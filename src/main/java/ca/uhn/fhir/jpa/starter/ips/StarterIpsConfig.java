package ca.uhn.fhir.jpa.starter.ips;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.api.dao.DaoRegistry;
import ca.uhn.fhir.jpa.ips.api.IIpsGenerationStrategy;
import ca.uhn.fhir.jpa.ips.generator.IIpsGeneratorSvc;
import ca.uhn.fhir.jpa.ips.provider.IpsOperationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;


@Conditional(IpsConfigCondition.class)
public class StarterIpsConfig {
	@Bean 
	IIpsGenerationStrategy IpsGenerationStrategy()
	{
		return new IpsGenerationCbacStrategy();
	}

	@Bean
	public IpsOperationProvider IpsOperationProvider(IIpsGeneratorSvc theIpsGeneratorSvc){
		return new IpsOperationProvider(theIpsGeneratorSvc);
	}

	@Bean
	public IIpsGeneratorSvc IpsGeneratorSvcImpl(FhirContext theFhirContext, IIpsGenerationStrategy theGenerationStrategy, DaoRegistry theDaoRegistry)
	{
		return new IpsGeneratorCbacImpl(theFhirContext, theGenerationStrategy, theDaoRegistry);
	}
	
}
