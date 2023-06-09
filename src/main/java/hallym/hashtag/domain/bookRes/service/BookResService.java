package hallym.hashtag.domain.bookRes.service;

import hallym.hashtag.domain.bookRes.dto.BookResResponseDto;

import java.util.List;

public interface BookResService {
    BookResResponseDto reserve(Long ano, Long uno);

    String cancel(Long brno);

    List<BookResResponseDto> findByUser(Long uno);
}
