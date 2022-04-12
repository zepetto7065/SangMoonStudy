package jpabook.jpashop;

import jpabook.jpashop.domain.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository2 extends JpaRepository<Item, Long> {
}
