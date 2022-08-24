package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "prod_tab")
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid")
	private Integer sid;
	
	@Column(name = "snm")
	private String snm;
	
	@Column(name = "sstd")
	private String sstd;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Sub_tab",
						joinColumns = @JoinColumn(name = "sid"))
	@Column(name = "ssub")
	private Set<String> ssub;
}
