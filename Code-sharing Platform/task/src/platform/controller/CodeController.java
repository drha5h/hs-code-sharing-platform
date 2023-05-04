package platform.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import platform.dto.CodeConverter;
import platform.entity.Code;
import platform.service.CodeService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(
        value = {"code"},
        produces = {MediaType.TEXT_HTML_VALUE})
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @GetMapping(value = {"new"})
    String codeFormView() {
        return "code-form";
    }

    @GetMapping(value = {"{id}"})
    String codeByIndexView(@PathVariable String id, Model model) {
        model.addAttribute("code",
                CodeConverter.convertCodeToCodeDto(
                        codeService.findAvailableAndSaveById(UUID.fromString(id))));
        return "code";
    }

    @GetMapping(value = {"latest"})
    String latestCodesView(Model model) {
        List<Code> codes = codeService.findAvailableAndSaveTop10ByOrderByCreatedAtDesc();
        model.addAttribute("codes",
                codes.stream()
                        .map(CodeConverter::convertCodeToCodeDto)
                        .toList());
        return "codes";
    }
}
