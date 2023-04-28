package hallym.hashtag.domain.notice.service;

import hallym.hashtag.domain.admin.entity.Admin;
import hallym.hashtag.domain.admin.repository.AdminRepository;
import hallym.hashtag.domain.notice.dto.NoticeRequestDto;
import hallym.hashtag.domain.notice.dto.NoticeResponseDto;
import hallym.hashtag.domain.notice.entity.Notice;
import hallym.hashtag.domain.notice.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class NoticeServicelmpl implements NoticeService{
    private final NoticeRepository noticeRepository;
    private final AdminRepository adminRepository;

    @Override
    public NoticeResponseDto create(Long ano, NoticeRequestDto noticeRequestDto) {
        Optional<Admin> byAno = adminRepository.findById(ano);
        if(byAno.isEmpty()) return null;
        Notice notice = toEntity(noticeRequestDto);
        notice.setAdmin(byAno.get());
        noticeRepository.save(notice);
        return toDto(notice);
    }

    @Override
    public List<NoticeResponseDto> findAll() {
        List<Notice> noticeList = noticeRepository.findAll();
        return noticeList.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public NoticeResponseDto findByOne(Long nno) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return null;
        Notice notice = byNno.get();
        return toDto(notice);
    }

    @Override
    public NoticeResponseDto update(Long nno, NoticeRequestDto noticeRequestDto) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return null;
        Notice notice = byNno.get();
        notice.update(toEntity(noticeRequestDto));
        noticeRepository.save(notice);
        return toDto(notice);
    }

    @Override
    public String delete(Long nno) {
        Optional<Notice> byNno = noticeRepository.findById(nno);
        if(byNno.isEmpty()) return "ID를 없습니다.";
        noticeRepository.deleteById(nno);
        return "삭제되었습니다.";
    }

    public Notice toEntity(NoticeRequestDto noticeRequestDto) {
        return Notice.builder()
                .nno(noticeRequestDto.getNno())
                .title(noticeRequestDto.getTitle())
                .content(noticeRequestDto.getContent())
                .admin(noticeRequestDto.getAdmin())
                .build();
    }

    public NoticeResponseDto toDto(Notice notice) {
        return NoticeResponseDto.builder()
                .nno(notice.getNno())
                .title(notice.getTitle())
                .content(notice.getContent())
                .regDate(notice.getRegDate())
                .modDate(notice.getModDate())
                .writer(notice.getAdmin().getName()).build();
    }
}
