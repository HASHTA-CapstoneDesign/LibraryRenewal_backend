package hallym.hashtag.domain.notice.repository;

import hallym.hashtag.domain.notice.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {

    @Query("select n from Notice n order by n.important desc, n.nno desc")
    List<Notice> findByAll();
    List<Notice> findByTitleContainingOrContentContaining(String title, String Content);
}
