package platform.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import platform.entity.Code;
import platform.repository.CodeRepository;

import java.util.List;
import java.util.UUID;

@Service
public class CodeServiceImpl implements CodeService {
    private final CodeRepository codeRepo;

    public CodeServiceImpl(CodeRepository codeRepo) {
        this.codeRepo = codeRepo;
    }

    @Override
    public List<Code> findTop10ByOrderByCreatedAtDesc() {
        return codeRepo.findTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public Code findById(UUID id) {
        return codeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Code with id=%s not found", id)));
    }

    @Override
    public Code findAvailableById(UUID id) {
        return codeRepo.findAvailableById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Code with id=%s not found", id.toString())));
    }

    @Override
    public Code findAvailableAndSaveById(UUID id) {
        Code code = findAvailableById(id);
        decrementCodeViews(code);
        save(code);
        return code;
    }

    @Override
    public List<Code> findAvailableTop10ByOrderByCreatedAtDesc() {
        return codeRepo.findNotRestrictedTop10ByOrderByCreatedAtDesc();
    }

    @Override
    public List<Code> findAvailableAndSaveTop10ByOrderByCreatedAtDesc() {
        List<Code> codes = findAvailableTop10ByOrderByCreatedAtDesc();
        codes.forEach(this::decrementCodeViews);
        saveAll(codes);
        return codes;
    }

    @Override
    public Code save(Code code) {
        return codeRepo.save(code);
    }

    @Override
    public List<Code> saveAll(Iterable<Code> codes) {
        return codeRepo.saveAll(codes);
    }

    private void decrementCodeViews(Code code) {
        code.setViews((code.getViews() == null) ? null : (code.getViews() < 1) ? 0 : code.getViews() - 1);
    }
}
