package shop.mtcoding.test1.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    public int insert(@Param("title") String title, @Param("userid") int userid);

    public List<Board> findAll();

    public Board findById(int id);

    public int updateById(@Param("id") int id, @Param("title") String title, @Param("userid") String userid);

    public int deleteById(int id);
}
