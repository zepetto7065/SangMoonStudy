package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
//단독으로 테이블 만들일이 없으면 추상클래스
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //싱글테이블 전략
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
