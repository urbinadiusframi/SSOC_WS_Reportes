package co.gov.ssoc.gedess.sgd.model.entity.repository;	

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.gov.ssoc.gedess.sgd.model.entity.OLogSticker;

@Repository
public interface LogStickerRepository extends JpaRepository<OLogSticker, Long> {

	Optional<List<OLogSticker>> findByNumeroRadicado(String radicado);
}