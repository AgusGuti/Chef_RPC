package com.chefencasa.app.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.util.DigestUtils;



import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "seguidos")
@Data @NoArgsConstructor
public class Seguidos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private User user_id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "seguido_id", nullable = false)
	private User seguido_id;

	
	public Seguidos(User user_id, User seguido_id) {
		this.user_id = user_id;
		this.seguido_id = seguido_id;
	}


	public Seguidos(int id) {		
		
		this.id = id;		
	}
	
	
	public Seguidos(int id, User user_id, User seguido_id) {		
		
		this.id = id;
		this.user_id = user_id;
		this.seguido_id = seguido_id;	
	}
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


    
}