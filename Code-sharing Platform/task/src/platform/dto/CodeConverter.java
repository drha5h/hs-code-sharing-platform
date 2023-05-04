package platform.dto;

import platform.entity.Code;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class CodeConverter {

    public static CodeDto convertCodeToCodeDto(Code code) {
        CodeDto dto = new CodeDto();
        dto.setCode(code.getCode());
        dto.setDate(code.getCreatedAt().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
        if (code.getViews() != null) {
            dto.setViewsRestricted(true);
            dto.setViews(code.getViews());
        } else {
            dto.setViews(0L);
        }
        if (code.getTime() != null) {
            dto.setTimeRestricted(true);
            Long duration = Duration.between(LocalDateTime.now(), code.getTime()).getSeconds();
            dto.setTime((duration < 0) ? 0 : duration);
        } else {
            dto.setTime(0L);
        }
        return dto;
    }

    public static Code convertCodeDtoToCode(CodeDto codeDto) {
        LocalDateTime now = LocalDateTime.now();
        Code code = new Code();
        code.setCode(codeDto.getCode());
        code.setCreatedAt(now);
        code.setViews(codeDto.getViews() > 0 ? codeDto.getViews() : null);
        code.setTime(codeDto.getTime() > 0 ? now.plusSeconds(codeDto.getTime()) : null);
        return code;
    }
}