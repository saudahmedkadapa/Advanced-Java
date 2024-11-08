package com.demo.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
  @Id
  @GeneratedValue
 private int role_id;
 private String role;
}
