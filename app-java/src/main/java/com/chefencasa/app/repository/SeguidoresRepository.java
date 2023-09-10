package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.Seguidores;

@Repository("seguidoresRepository")
public interface SeguidoresRepository extends JpaRepository<Seguidores, Serializable> {

	/*public abstract Seguidores findBySeguidores(String seguidos);*/

}
