package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // abstract 추상 클래스로 만들어줄 것 , 해당 전략은



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //단일 테이블 전략
public  class Item {

  @Id
  @GeneratedValue
  private Long id;

  private String name;
  private int price;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

}
