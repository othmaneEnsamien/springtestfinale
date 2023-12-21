package com.example.stockspring.services;

import com.example.stockspring.dto.MvtStkDto;

import java.math.BigDecimal;
import java.util.List;

public interface MvtStkService {

    BigDecimal stockReelArticle(Integer idArticle);

    List<MvtStkDto> mvtStkArticle(Integer idArticle);

    MvtStkDto entreeStock(MvtStkDto dto);

    MvtStkDto sortieStock(MvtStkDto dto);

    MvtStkDto correctionStockPos(MvtStkDto dto);

    MvtStkDto correctionStockNeg(MvtStkDto dto);

}
