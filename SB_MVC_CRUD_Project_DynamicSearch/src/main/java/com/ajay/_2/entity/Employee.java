package com.ajay._2.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(generator = "gen1", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "gen1", sequenceName = "emp_no", initialValue = 1, allocationSize = 1)
	private Integer empno;
	// @Nonnull
	private String empname;
	// @Nonnull
	private String job;
	// @Nonnull
	private Double sal;
	// @Nonnull
	private Integer deptno;
}
