package hallym.hashtag.domain.ABook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ABookResponseDto {
    private Long abno;

    private String tag;
}