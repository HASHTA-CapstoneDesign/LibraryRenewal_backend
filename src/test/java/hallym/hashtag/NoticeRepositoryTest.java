package hallym.hashtag;

import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.entity.NoticeImage;
import hallym.hashtag.domain.notice.repository.NoticeImageRepository;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.user.entity.User;
import hallym.hashtag.domain.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class NoticeRepositoryTest {
    @Autowired
    NoticeRepository noticeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    NoticeImageRepository noticeImageRepository;

    @Test
    public void testSave() {
        Optional<User> user = userRepository.findById(1L);
        Notice notice = Notice.builder().title("gg").content("gg").user(user.get())
                .important(Boolean.TRUE).build();
        noticeRepository.save(notice);
    }

    @Test
    public void testImageSave() {
        Optional<Notice> byNno = noticeRepository.findById(1L);
        NoticeImage noticeImage = NoticeImage.builder().fileName("1.jpg").notice(byNno.get()).build();
        noticeImageRepository.save(noticeImage);

    }
}
