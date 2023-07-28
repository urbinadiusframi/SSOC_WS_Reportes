package org.springframework.samples.petclinic.visits.web;

import static co.gov.ssoc.gedess.sgd.model.entity.OSerie.builder;
import static org.mockito.BDDMockito.given;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import co.gov.ssoc.gedess.sgd.model.entity.repository.SerieRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
class VisitResourceTest {

	@Autowired
	MockMvc mvc;

	@MockBean
	SerieRepository visitRepository;

	@Test
	void shouldFetchVisits() throws Exception {
		given(visitRepository.findByCodigo(0)).willReturn(Optional.ofNullable(builder().nombre("NA").build()));
	}
}
