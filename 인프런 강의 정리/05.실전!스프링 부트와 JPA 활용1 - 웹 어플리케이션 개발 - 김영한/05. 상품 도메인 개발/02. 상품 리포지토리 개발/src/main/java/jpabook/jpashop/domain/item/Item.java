package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //부분클래스 전략, 한 테이블에 다 넣는것
@DiscriminatorColumn(name="dtype")
@Getter 
public abstract class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items",fetch = FetchType.LAZY)
    private List<Category> categories = new ArrayList<>();

    //====비지니스로직====// setter로 값을 변경하는 것이 아니라, 이안에서 핵심 메서드로 값을 컨트롤 (객체 지향적)
    //stock 증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    //stock 감소
    public void removeStock(int quantity){
        final int restStock = this.stockQuantity - quantity;
        if(restStock<0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }




}
