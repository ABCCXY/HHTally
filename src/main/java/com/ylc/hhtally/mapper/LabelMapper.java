package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.Label;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMapper {
    List<Label> getAll(int userId);
    int add(Label label);
    int remove(@Param("labelId") int labelId,@Param("userId") int userId);
    int addReturn(String labelName);
}
