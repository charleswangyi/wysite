package com.wangyi.website.service;

import com.wangyi.website.model.CategoryModel;
import com.wangyi.website.model.SubjectModel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by cengruilin on 15/8/5.
 */
public interface SubjectRepository extends
                                          PagingAndSortingRepository<SubjectModel, String> {
    List<SubjectModel> findByCategoryModel( CategoryModel category);
}
