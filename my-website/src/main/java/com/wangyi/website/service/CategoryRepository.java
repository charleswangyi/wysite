package com.wangyi.website.service;

import com.wangyi.website.model.CategoryModel;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by cengruilin on 15/8/5.
 */
public interface CategoryRepository extends
                                          PagingAndSortingRepository<CategoryModel, String> {
    CategoryModel findByCategory(String category);
}
