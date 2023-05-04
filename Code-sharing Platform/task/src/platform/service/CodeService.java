package platform.service;

import platform.entity.Code;

import java.util.List;
import java.util.UUID;

public interface CodeService {
    List<Code> findTop10ByOrderByCreatedAtDesc();

    Code findById(UUID id);

    Code findAvailableById(UUID id);

    Code findAvailableAndSaveById(UUID id);

    List<Code> findAvailableTop10ByOrderByCreatedAtDesc();

    List<Code> findAvailableAndSaveTop10ByOrderByCreatedAtDesc();

    Code save(Code code);

    List<Code> saveAll(Iterable<Code> codes);
}
