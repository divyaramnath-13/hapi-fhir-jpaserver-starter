package ca.uhn.fhir.jpa.starter.ips;

import ca.uhn.fhir.jpa.ips.api.SectionRegistry;

public class CbacSectionRegistry extends SectionRegistry {

	@Override
	protected void addSections() {
		this.addSectionProblemList();
		this.addSectionVitalSigns();
	}

}
