package org.jvnet.jaxb2_commons.plugin.simplify.tests01;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Gh5Test {

	private JAXBContext context;

	@Before
	public void setUp() throws Exception {
		context = JAXBContext.newInstance(getClass().getPackage().getName());
	}

	@Test
	public void compiles() {
		final SimplifyReferencesPropertyAsReferencePropertyType item = new SimplifyReferencesPropertyAsReferencePropertyType();
		item.getBase();
		item.getBaseElement();
	}

	@Test
	public void unmarshalls() throws Exception {

		@SuppressWarnings("unchecked")
		SimplifyReferencesPropertyAsReferencePropertyType value = ((JAXBElement<SimplifyReferencesPropertyAsReferencePropertyType>) context
				.createUnmarshaller()
				.unmarshal(
						getClass()
								.getResourceAsStream(
										"simplifyReferencesPropertyAsReferenceProperty.xml")))
				.getValue();

		Assert.assertEquals(3, value.getBase().size());
		Assert.assertEquals(3, value.getBaseElement().size());
	}
}
