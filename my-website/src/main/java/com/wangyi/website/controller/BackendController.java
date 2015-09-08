package com.wangyi.website.controller;
import com.wangyi.website.model.CategoryModel;
import com.wangyi.website.model.ItemModel;
import com.wangyi.website.model.SubjectModel;
import com.wangyi.website.service.CategoryRepository;
import com.wangyi.website.service.ItemRepository;
import com.wangyi.website.service.SubjectRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by cengruilin on 15/7/31.
 */

@RestController
@RequestMapping("/web")
public class BackendController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private ItemRepository itemRepository;

    @RequestMapping("/getCategories")
    public List<CategoryModel> categories() {
        Iterator<CategoryModel> iterator = categoryRepository.findAll(new Sort("index")).iterator();
        List<CategoryModel> list = new ArrayList<CategoryModel>();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

    @RequestMapping("/{category}/subjects")
    public List<SubjectModel> getSubjects(@PathVariable String category) {
        CategoryModel model = categoryRepository.findByCategory(category);
        List<SubjectModel> list = subjectRepository.findByCategoryModel(model);
        return list;
    }

    @RequestMapping("/{subject}/items")
    public List<ItemModel> getItems(@PathVariable String subject) {
        List<ItemModel> list = new ArrayList<ItemModel>();
        SubjectModel subjectModel = subjectRepository.findOne(subject);
        if (subjectModel!=null){
            list =   itemRepository.findBySubjectModel(subjectModel, new Sort(Sort.Direction.DESC, "time"));
            for(ItemModel model:list){
                model.setContent("");
            }
        }
        return  list;
    }

    @RequestMapping("/{item}/item")
    public Map<String,Object> getItem(@PathVariable String item) {
        //subjectId,subjectName,category,title,author,time,keyword,content
        Map<String,Object> map = new HashMap<String,Object>();
        ItemModel itemModel  = itemRepository.findOne(item);
        map.put("title",itemModel.getTitle());
        map.put("author",itemModel.getAuthor());
        map.put("time",itemModel.getTime());
        map.put("keyword",Arrays.toString(itemModel.getKeyword().toArray()));
        map.put("content",itemModel.getContent());
        map.put("subjectId",itemModel.getSubjectModel().getId());
        map.put("subjectName",itemModel.getSubjectModel().getName());
        map.put("category",itemModel.getSubjectModel().getCategoryModel().getCategory());
        map.put("categoryName",itemModel.getSubjectModel().getCategoryModel().getCategoryName());
        return  map;
    }
}
