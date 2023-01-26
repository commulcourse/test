package shop.mtcoding.test1.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BoardRepository {
    // public int insert(@Param("title") String title, @Param("userid") int userid);
    public int insert();

    public List<Board> findAll();

    public Board findById();

    public List<Board> findByUserId(int userId);

    // public int update(@Param("id") int id, @Param("title") String title,
    // @Param("userid") String userid);
    public int update();

    public int delete(int id);
}
