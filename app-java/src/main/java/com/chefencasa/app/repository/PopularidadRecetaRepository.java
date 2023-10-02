package com.chefencasa.app.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chefencasa.app.entities.PopularidadReceta;


@Repository("popularidadRecetaRepository")
public interface PopularidadRecetaRepository extends JpaRepository<PopularidadReceta, Serializable> {



}