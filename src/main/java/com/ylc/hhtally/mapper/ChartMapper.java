package com.ylc.hhtally.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ChartMapper {
    Double[] getMonthIncome(@Param("year") String year,@Param("month") String month, @Param("userId") int userId);
    Double[] getMonthInfor(@Param("year") String year,@Param("month") String month, @Param("userId") int userId);

    Double[] getDayIncome(@Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("userId") int userId);
    Double[] getDayInfor(@Param("year") String year, @Param("month") String month, @Param("day") String day, @Param("userId") int userId);
}
