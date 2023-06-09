package hallym.hashtag.domain.notice.controller;

import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.entity.NoticeImage;
import hallym.hashtag.domain.notice.repository.NoticeImageRepository;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import hallym.hashtag.domain.notice.service.NoticeImageService;
import hallym.hashtag.domain.notice.service.NoticeService;
import hallym.hashtag.global.baseDto.PageRequestDto;
import hallym.hashtag.global.baseDto.PageResponseDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/notice")
public class NoticeController {
    private final NoticeService noticeService;
    private final NoticeImageService noticeImageService;
    private final NoticeRepository noticeRepository;

    @ApiOperation(value = "공지사항 전체 조회", notes = "공지사항 전체 조회 합니다." +
            "중요도와 시간 순으로 정렬하여 조회합니다." +
            "이미지와 페이징이 추가됩니다.")
    @GetMapping("list")
    public PageResponseDto<NoticeResponseDto> noticeFindAll(PageRequestDto pageRequestDto) {
        return noticeService.findAll(pageRequestDto);
    }

    @ApiOperation(value = "공지사항 검색", notes = "공지사항 검색합니다." +
            "이미지와 페이징이 추가됩니다.")
    @GetMapping("search")
    public PageResponseDto<NoticeResponseDto> noticeSearch(@RequestParam(value = "keyword") String keyword, PageRequestDto pageRequestDto){
        return noticeService.search(keyword, pageRequestDto);
    }

    @ApiOperation(value = "중요한 공지사항만 조회", notes = "중요한 공지사항 조회합니다.")
    @GetMapping("important")
    public List<NoticeResponseDto> noticeFindByImportant() {
        return noticeService.findByImportant();
    }

    @GetMapping(value = "image/{nno}" , produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable("nno") Long nno) throws IOException {
        return noticeImageService.findImage(nno);
    }
}
