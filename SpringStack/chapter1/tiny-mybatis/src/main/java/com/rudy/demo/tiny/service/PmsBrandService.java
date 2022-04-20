package com.rudy.demo.tiny.service;

import com.rudy.demo.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * PmsBrandService
 * @author heyahui
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
