package jpabook.jpashop.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Category {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @ManyToOne
  @JoinColumn(name="PARENT_ID")
  private Category parent;

  @OneToMany(mappedBy = "parent")
  private List<Category> child = new ArrayList<>();

  @ManyToMany
  @JoinTable(name="CATEGORY_ITEM",
          joinColumns = @JoinColumn(name="CATEGORY_ID"),  //내가 조인
        inverseJoinColumns = @JoinColumn(name="ITEM_ID")  //반대편이 조인
  )
  private List<Item> items = new ArrayList<>();

}
