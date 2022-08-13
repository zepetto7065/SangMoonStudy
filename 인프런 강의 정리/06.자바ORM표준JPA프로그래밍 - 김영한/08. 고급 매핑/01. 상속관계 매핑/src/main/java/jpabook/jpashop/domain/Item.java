package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //조인전략
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글테이블 전략
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // abstract 추상 클래스로 만들어줄 것 , 해당 전략은
@DiscriminatorColumn
public abstract class Item {

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
