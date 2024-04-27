package hello.advanced.trace;

import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class TraceId {
    private String id;
    private Integer level;

    public TraceId() {
        this.id = createdId();
        this.level = 0;
        log.info("{}", this.id);

    }

    private TraceId(String id, Integer level) {
        this.id = id;
        this.level = level;
    }

    private String createdId() {

        String id = UUID.randomUUID().toString().substring(0, 8);
        log.info("id = {}", id);
        return id;
    }

    public TraceId createNextId() {
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId() {
        return new TraceId(this.id, this.level - 1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }
}
