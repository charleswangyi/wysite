package com.wangyi.website.service;

import com.wangyi.website.model.CategoryModel;
import com.wangyi.website.model.ItemModel;
import com.wangyi.website.model.SubjectModel;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by cengruilin on 15/8/5.
 */
public interface ItemRepository extends
                                          PagingAndSortingRepository<ItemModel, String> {
    List<ItemModel> findBySubjectModel(SubjectModel subject,Sort sort);
}
