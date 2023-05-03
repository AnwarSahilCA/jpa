package com.ust.aws.resource;



import javax.persistence.*;

import lombok.Data;


@Data
@Entity
 public class Product  {
	

	@Id
	@GeneratedValue
	private long Id;
	private String name;
	private String description;
	private String pos;
	private String faction;
	public   int power;

}
