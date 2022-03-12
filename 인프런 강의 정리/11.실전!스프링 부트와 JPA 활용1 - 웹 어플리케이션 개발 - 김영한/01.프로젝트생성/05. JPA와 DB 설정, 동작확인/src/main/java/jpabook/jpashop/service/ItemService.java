package jpabook.jpashop.service;

import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    @Transactional
    public void updateItem(Long itemId, Book param){
        Item findItem = itemRepository.findOne(itemId);//영속성 객체 찾아옴
        findItem.setPrice(param.getPrice());
        //save도 뭐고 아무것도 호출할 필요없다. 이미 영속상태
        //트랜잭션 커밋에 의해 JPA는 flush를 날린다.
        //변경된 애들? 찾아 찾아 DB에 update쳐버린다.
//        findItem.change(price, name, stockQuantity);
    }

    public List<Item> findItem(){
        return itemRepository.findAll();
    }

    public Item findOne(Long itemId){
        return itemRepository.findOne(itemId);
    }
}
