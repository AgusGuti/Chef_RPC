package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Mensaje;
import com.example.demo.entity.Tipo;
import com.example.demo.entity.Usuario;

@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Long> {

	@Query(value = "from Mensaje m " +
					"inner join fetch m.emisor " +
					"inner join fetch m.receptor "+
					"where m.id = :idMensaje and m.tipoMensaje = :tipo")
	public Mensaje traerMensajeConDependencias(@Param("idMensaje") Long idMensaje, @Param("tipo") Tipo tipo);

	@Query("from Mensaje m "
			+ "left join fetch m.emisor e "
			+ "left join fetch m.receptor r "
			+ "where e=:emisor and r =:receptor and m.respuesta is null")
	public List<Mensaje> mensajesSinContestarEntre(@Param("emisor") Usuario emisor,
			@Param("receptor") Usuario receptor);

	@Query("from Mensaje m "
			+ "left join fetch m.emisor e "
			+ "left join fetch m.receptor r "
			+ "where e=:usuario or r =:usuario")
	public List<Mensaje> mensajesEnLosQueParticipo(@Param("usuario") Usuario participante);
}
