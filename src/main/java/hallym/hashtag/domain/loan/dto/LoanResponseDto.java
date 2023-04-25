package hallym.hashtag.domain.loan.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoanResponseDto {
    private Long lno;

    private LocalDate creDate;

    private LocalDate retDate;
}