package hallym.hashtag.domain.roomRes.service;

import hallym.hashtag.domain.roomRes.dto.RoomResResponseDto;
import hallym.hashtag.domain.roomRes.entity.Time;

public interface RoomResService {
    RoomResResponseDto reserve(Long sno, String roomName, Time time);
}