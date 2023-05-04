package platform.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import platform.dto.CodeConverter;
import platform.dto.CodeDto;
import platform.dto.IdResponse;
import platform.entity.Code;
import platform.service.CodeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = {"/api/code"})
public class CodeResourceController {

    private final CodeService codeService;

    public CodeResourceController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping(
            value = {"new"},
            produces = {MediaType.APPLICATION_JSON_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<IdResponse> addCode(@RequestBody CodeDto codeDto) {
        Code code = CodeConverter.convertCodeDtoToCode(codeDto);
        codeService.save(code);
        return ResponseEntity.ok(new IdResponse(code.getId().toString()));
    }

    @GetMapping(value = {"{id}"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<CodeDto> codeByIndex(@PathVariable String id) {
        return ResponseEntity.ok(
                CodeConverter.convertCodeToCodeDto(
                        codeService.findAvailableAndSaveById(UUID.fromString(id))));
    }

    @GetMapping(value = {"latest"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    List<CodeDto> latestCodes() {
        List<Code> codes = codeService.findAvailableAndSaveTop10ByOrderByCreatedAtDesc();
        return codes.stream()
                .map(CodeConverter::convertCodeToCodeDto)
                .toList();
    }
}
